package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


/**
*Esta clase nos permite Registrar un rol
*contiene métodos que conectan al manejador Roles y la FormaNuevoRol
*
*@author Luis Andres Max
*@version 1.0
*/

public final class MCURegistrarRol
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);



    /**
    *solicita el registro de una Recomendacion
    *
    *@param mapping información de mapeo de acción
    *@param form datos mandados por la vista
    *@param request provee la información requerida por HTTP servlets.
    *@param response Servlet que se encarga de enviar una respuesta
    *@return forward puede ser exitoso a fracaso
    *@throws Exception si surge algun error en la transaccion
    */
    public ActionForward solicitarRegistroRol(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroRol");
        }

        return (mapping.findForward("exito"));
    }


    /**
    *Registra una Recomendacion
    *hace un cast del form recibido a una Recomendacion
    *Luego del Cast manda al manejador a realizar el método de crearRecomendacion()
    *
    *@param mapping información de mapeo de acción
    *@param form datos mandados por la vista
    *@param request provee la información requerida por HTTP servlets.
    *@param response Servlet que se encarga de enviar una respuesta
    *@return forward puede ser exitoso a fracaso
    **@throws Exception si surge algun error en la transaccion
    */
    public ActionForward procesarRegistroRol(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistroRol");
        }

        // Verifica si la acci�n fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acci�n fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }


        // Se obtienen los datos para procesar el registro
        FormaNuevoRol forma = (FormaNuevoRol)form;

        Rol rol = new Rol(forma.getNombre(),
                          forma.getDescripcion());

        ManejadorRoles mr = new ManejadorRoles();
        int resultado = mr.crearRol(rol);

        ActionMessages errores = new ActionMessages();
        switch (resultado) {
            case 0:
                return (mapping.findForward("exito"));

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.nombreRolYaExiste",
                                               forma.getNombre()));
                saveErrors(request, errores);
                return (mapping.getInputForward());

            case 3:
                log.error("Ocurri� un error de infraestructura");
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
