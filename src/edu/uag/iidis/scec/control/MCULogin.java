package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;

import java.util.Collection;
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
*Esta clase nos permite tener acceso al login de la aplicación
*contiene métodos que conectan al manejador login y la FormaLogin
*
*@author Luis Andres Max
*@version 1.0
*/

public final class MCULogin
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCULogin.class);

    /**
    *Nos permite obtener el usuario y la contraseña del login
    *hace un cast del form recibido a algo legible
    *Luego del Cast manda al manejador a realizar el método de buscarLogin()
    *
    *@param mapping información de mapeo de acción
    *@param form datos mandados por la vista
    *@param request provee la información requerida por HTTP servlets.
    *@param response Servlet que se encarga de enviar una respuesta
    *@return forward puede ser exitoso a fracaso
    **@throws Exception si surge algun error en la transaccion
    */
    public ActionForward solicitarLogin(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {
		ActionMessages errores = new ActionMessages();
		//String username = loginForm.getUsername();
        if (log.isDebugEnabled()) {
            log.debug(">solicitarLogin");
        }
        FormaLogin forma = (FormaLogin) form;
        ManejadorLogin mr = new ManejadorLogin();

        Collection resultado = mr.buscarLogin(forma.getUser(),forma.getPassword());
		//User user = new User("Victor", "1234");
// simulamos que no se autentico
	   //request.getSession().setAttribute("user", user);
        User user = null;
        if (resultado.size() != 0) {
            if ( resultado.isEmpty()) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            }
            user = new User(forma.getUser(), forma.getPassword());
            request.getSession().setAttribute("user", user);
            return (mapping.findForward("exito"));
        } else {
            log.error("El usuario no existe");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.NoExisteUsuario"));
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso"));
        }

    }


}
