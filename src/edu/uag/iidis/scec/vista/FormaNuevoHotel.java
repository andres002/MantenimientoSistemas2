package edu.uag.iidis.scec.vista;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;
import org.apache.struts.upload.FormFile;

/**
 * Form bean para el registro de un nuevo hotel.
 *
 * @author Farelo Andres Max
 */
public final class FormaNuevoHotel
        extends ValidatorForm {

    private String nombre;
    private String descripcion;
	private String precio;
	private String horario;
	private String estado;
    private String pais;
    private String direccion;
	Collection estados;
    private FormFile imagen;


    /**
    *regresa el nombre del hotel
    *@return nombre nombre del hotel
    */
    public String getNombre() {
        return (this.nombre);
    }

    /**
    *regresa la imagen del hotel
    *@return imagen imagen del hotel
    */
    public FormFile getImagen() {
        return (this.imagen);
    }

    /**
    *regresa la descripcion del hotel
    *@return descripcion descripcion del hotel
    */
    public String getDescripcion() {
        return (this.descripcion);
    }

    /**
    *regresa el precio del hotel
    *@return precio precio del hotel
    */
	public String getPrecio() {
        return (this.precio);
    }

    /**
    *regresa el horario del hotel
    *@return horario horario del hotel
    */
	public String getHorario() {
        return (this.horario);
    }

    /**
    *regresa el estado del hotel
    *@return estado estado del hotel
    */
	public String getEstado() {
        return (this.estado);
    }

    /**
    *regresa el pais del hotel
    *@return pais pais del hotel
    */
    public String getPais() {
        return (this.pais);
    }

    /**
    *regresa la direccion del hotel
    *@return direccion direccion del hotel
    */
    public String getDireccion() {
        return (this.direccion);
    }

    /**
    *regresa un collection con los estados
    *@return estados estados
    */
	public Collection getEstados(){
		return (this.estados);
	}

  /**
  *establece los estados
  *@param estados estados Collection
  */
	public void setEstados(Collection estados) {
        this.estados = estados;
    }

    /**
    *establece el nombre del hotel
    *@param nombre nombre del hotel
    */
	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
    *establece la descripcion del hotel
    *@param descripcion descripcion del hotel
    */
	public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
    *establece la imagen del hotel
    *@param imagen imagen del hotel
    */
	public void setImagen(FormFile imagen) {
        this.imagen = imagen;
    }

    /**
    *establece el precio del hotel
    *@param precio precio del hotel
    */
	public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
    *establece el horario del hotel
    *@param horario horario del hotel
    */
	public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
    *establece el estado del hotel
    *@param estado estado del hotel
    */
	public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
    *establece el pais del hotel
    *@param pais pais del hotel
    */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
    *establece la direccion del hotel
    *@param direccion direccion del hotel
    */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
