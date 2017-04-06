package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


/**
*Esta clase nos permite Registrar un usuario
*contiene métodos que conectan al manejador usuarios y la FormaNuevaPersona
*
*@author Luis Andres Max
*@version 1.0
*/
public final class MCURegistrarUsuario
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);

    /**
    *solicita el registro de un usuario
    *
    *@param mapping información de mapeo de acción
    *@param form datos mandados por la vista
    *@param request provee la información requerida por HTTP servlets.
    *@param response Servlet que se encarga de enviar una respuesta
    *@return forward puede ser exitoso a fracaso
    *@throws Exception si surge algun error en la transaccion
    */
    public ActionForward solicitarRegistro(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistro");
        }


		/* incluir ciudades      */
		FormaNuevaPersona forma = (FormaNuevaPersona)form;
		ManejadorCiudades mr = new ManejadorCiudades();
        Collection resultado = mr.listarCiudades();

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
				log.error(">>>>> asignando ciudades a formanuevapersona");
                forma.setCiudades ( resultado );
            }
        } else {
            log.error("Ocurri� un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));
            saveErrors(request, errores);
        }


	/* incluir ciudades      */


        return (mapping.findForward("exito"));
    }


    /**
    *Registra un usuario
    *hace un cast del form recibido a un Usuario
    *Luego del Cast manda al manejador a realizar el método de crearUsuario()
    *
    *@param mapping información de mapeo de acción
    *@param form datos mandados por la vista
    *@param request provee la información requerida por HTTP servlets.
    *@param response Servlet que se encarga de enviar una respuesta
    *@return forward puede ser exitoso a fracaso
    **@throws Exception si surge algun error en la transaccion
    */
    public ActionForward procesarRegistro(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistro");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }


        // Se obtienen los datos para procesar el registro
        FormaNuevaPersona forma = (FormaNuevaPersona)form;

        NombrePersona nombrePersona = new NombrePersona(forma.getPrefijo(),
                                                        forma.getNombre(),
                                                        forma.getApellidoPaterno(),
                                                        forma.getApellidoMaterno(),
                                                        forma.getPosfijo(),
                                                        forma.getIniciales());

        Credencial credencial = new Credencial (forma.getNombreUsuario(),
                                                forma.getClaveAcceso());

        Usuario usuario = new Usuario(nombrePersona, credencial);

        ManejadorUsuarios mu = new ManejadorUsuarios();
        int resultado = mu.crearUsuario(usuario);

        ActionMessages errores = new ActionMessages();
        switch (resultado) {
            case 0:
                return (mapping.findForward("exito"));

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.nombreUsuarioYaExiste",
                                               forma.getNombreUsuario()));
                saveErrors(request, errores);
                return (mapping.getInputForward());

            case 3:
                log.error("Ocurrió un error de infraestructura");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));
                saveErrors(request, errores);
                return (mapping.getInputForward());

            default:
                log.warn("ManejadorUsuario.crearUsuario regres� reultado inesperado");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));
                saveErrors(request, errores);
                return (mapping.getInputForward());
        }
    }

}
