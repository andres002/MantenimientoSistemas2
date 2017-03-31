package edu.uag.iidis.scec.vista;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;
import org.apache.struts.upload.FormFile;

/**
 * Form bean para el registro de una nueva critica.
 *
 * @author Farelo Andres Max
 */
public final class FormaNuevoCritica
        extends ValidatorForm {

    private String nombre;
    private String descripcion;
	private String hotel;
	private String nivel;


  /**
  *regresa el nombre de la critica
  *
  *@return nombre nombre de la critica
  */
    public String getNombre() {
        return (this.nombre);
    }

    /**
    *regresa la descripcion de la critica
    *
    *@return descripcion descripcion de la critica
    */
    public String getDescripcion() {
        return (this.descripcion);
    }

    /**
    *regresa el hotel de la critica
    *
    *@return hotel hotel de la critica
    */
	public String getHotel() {
        return (this.hotel);
    }

    /**
    *regresa el nivel de la critica
    *
    *@return nivel nivel de la critica
    */
	public String getNivel() {
        return (this.nivel);
    }

    /**
    *establece el nombre de la critica
    *@param nombre nombre de la crítica
    */
	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
    *establece la descripcion de la critica
    *@param descripcion descripcion de la crítica
    */
	public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
    *establece el hotel de la critica
    *@param hotel hotel de la crítica
    */
	public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    /**
    *establece el nivel de la critica
    *@param nivel nivel de la crítica
    */
	public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
    *vuelve los valores nulos
    *
    *@param mapping acciones
    *@param request informacion
    */
    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        nombre=null;
        descripcion=null;
    }


    /**
    *realiza las validaciones proporcionadas por Struts-Validator
    *
    *@param mapping acciones
    *@param request informacion
    *@return ActionErrors erroresde la acccion
    */
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
