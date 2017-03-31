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
*Esta clase nos permite eliminar las criticas
*contiene métodos que conectan al manejador Criticaes y la forma eliminarCritica
*
*@author Luis Andres Max
*@version 1.0
*/


public final class MCUEliminarHotel
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);


    /**
    *Elimina una critica
    *hace un cast del form recibido a una critica
    *Luego del Cast manda al manejador a realizar el método de eliminarCritica()
    *
    *@param mapping información de mapeo de acción
    *@param form datos mandados por la vista
    *@param request provee la información requerida por HTTP servlets.
    *@param response Servlet que se encarga de enviar una respuesta
    *@return forward puede ser exitoso a fracaso
    *@throws Exception si surge algun error en la transaccion
    */
    public ActionForward procesarEliminarHotel(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarEliminarHotel");
        }

        FormaEliminarHotel forma = (FormaEliminarHotel)form;
        ManejadorHoteles mr = new ManejadorHoteles();
        mr.eliminarHotel(forma.getId());
        return (mapping.findForward("exito"));
    }
}
