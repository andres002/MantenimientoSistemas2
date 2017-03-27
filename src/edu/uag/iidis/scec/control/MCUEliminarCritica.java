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

/*
*Esta clase nos permite eliminar las criticas
*contiene métodos que conectan al manejador Criticaes y la forma eliminarCritica
*
*@author Luis Andres Max
*/


public final class MCUEliminarCritica
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);


    public ActionForward procesarEliminarCritica(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarEliminarCritica");
        }

        FormaEliminarCritica forma = (FormaEliminarCritica)form;
        ManejadorCriticaes mr = new ManejadorCriticaes();
        mr.eliminarCritica(forma.getId());
        return (mapping.findForward("exito"));
    }
}
