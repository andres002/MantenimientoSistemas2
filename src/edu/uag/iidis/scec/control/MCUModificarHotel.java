package edu.uag.iidis.scec.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import edu.uag.iidis.scec.servicios.*;
import edu.uag.iidis.scec.modelo.Hotel;
import edu.uag.iidis.scec.vista.FormaModificarHotel;

/**
*Esta clase nos permite modificar un Hotel
*contiene métodos que conectan al manejador Hoteles y la FormaModificarHotel
*
*@author Luis Andres Max
*@version 1.0
*/
public class MCUModificarHotel extends MappingDispatchAction {

    private final Log log = LogFactory.getLog(MCURegistrarUsuario.class);



    /**
    *Solicita una modificación de un Hotel
    *
    *@param mapping información de mapeo de acción
    *@param form datos mandados por la vista
    *@param request provee la información requerida por HTTP servlets.
    *@param response Servlet que se encarga de enviar una respuesta
    *@return forward puede ser exitoso a fracaso
    **@throws Exception si surge algun error en la transaccion
    */
    public ActionForward solicitarModificarHotel(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (this.log.isDebugEnabled()) {

            this.log.debug(">solicitarModificarEstado");

        }

        return mapping.findForward("exito");

    }

    /**
    *Modifica un Hotel
    *hace un cast del form recibido a un Hotel
    *Luego del Cast manda al manejador a realizar el método de modificarHotel()
    *
    *@param mapping información de mapeo de acción
    *@param form datos mandados por la vista
    *@param request provee la información requerida por HTTP servlets.
    *@param response Servlet que se encarga de enviar una respuesta
    *@return forward puede ser exitoso a fracaso
    **@throws Exception si surge algun error en la transaccion
    */
    public ActionForward procesarModificarHotel(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("Im here");

        if (this.log.isDebugEnabled()) {

            this.log.debug("> procesarModificarEstado");

        }

        FormaModificarHotel formaModificarHotel = (FormaModificarHotel) form;

        System.out.println(formaModificarHotel);
        //Hotel(String nombre, String descripcion,String precio,String horario,String estado, String imagen, String pais, String direccion);
        Hotel hotel = new Hotel(
                formaModificarHotel.getNombre(),
                formaModificarHotel.getDescripcion(),
                formaModificarHotel.getPrecio(),
                formaModificarHotel.getHorario(),
                formaModificarHotel.getEstado(),
                formaModificarHotel.getImagen(),
                formaModificarHotel.getPais(),
                formaModificarHotel.getDireccion()
        );

        hotel.setId(formaModificarHotel.getId());

        //ManejadorEstados manejadorEstados = new ManejadorEstados();
        ManejadorHoteles manejadorHoteles = new ManejadorHoteles();

        //manejadorEstados.modificarEstado(estado);
        manejadorHoteles.modificarHotel( hotel );
        ActionMessages errores = new ActionMessages();

        return mapping.findForward("exito");

    }
}
