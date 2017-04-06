package edu.uag.iidis.scec.vista;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el registro de una nueva persona.
 *
 * @author Farelo Andres Max
 */
public final class FormaNuevaPersona
        extends ValidatorForm {

          public Long id;

          private String prefijo;
          private String nombre;
          private String apellidoPaterno;
          private String apellidoMaterno;
          private String posfijo;
          private String iniciales;
          private String nombreUsuario;
          private String claveAcceso;
          private String claveAccesoConfirmacion;
      	private Collection ciudades;
      	private int contador;


    /**
    *establece el id de la persona
    *@param id id de la persona
    */
  public void setId(Long id) {
      this.id = id;
  }

  public Long getId() {
      return (this.id);
  }



  /**
  *establece el prefijo de la persona
  *@param prefijo prefijo de la persona
  */
    public void setPrefijo(String prefijo) {
        this.prefijo=prefijo;
    }

    public String getPrefijo() {
        return (this.prefijo);
    }


    /**
    *establece las ciudades de la persona
    *@param ciudades ciudades de la persona
    */
    public void setCiudades(Collection ciudades) {
        this.ciudades = ciudades;
        if (ciudades != null) {
          this.contador = ciudades.size();
        } else
          this.contador = -1;
    }

    public Collection getCiudades() {
        return (this.ciudades);
    }

    /**
    *regresa el contador
    *
    *@return contador contador
    */
    public int getContador() {
        return (this.contador);
    }

    /**
    *establece el nombre de la persona
    *@param nombre nombre de la persona
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
    *regresa el nombre de la persona
    *
    *@return nombre nombre persona
    */
    public String getNombre() {
        return (this.nombre);
    }

    /**
    *establece el apellido paterno de la persona
    *@param apellidoPaterno apellido paterno de la persona
    */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
    *regresa el apellido paterno de la persona
    *
    *@return apellidoPaterno apellido paterno de la persona
    */
    public String getApellidoPaterno() {
        return (this.apellidoPaterno);
    }


    /**
    *establece el apellido materno de la persona
    *
    *@param apellidoMaterno apellido materno de la persona
    */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
    *regresa el apellido materno de la persona
    *
    *@return apellidoMaterno apellido materno de la persona
    */
    public String getApellidoMaterno() {
        return (this.apellidoMaterno);
    }

    /**
    *establece el posfijo de la persona
    *
    *@param posfijo posfijo de la persona
    */
    public void setPostfijo(String posfijo) {
        this.posfijo = posfijo;
    }

    /**
    *regresa el posfijo de la persona
    *
    *@return posfijo posfijo de la persona
    */
    public String getPosfijo() {
        return (this.posfijo);
    }


    /**
    *establece las iniciales de la persona
    *
    *@param iniciales iniciales de la persona
    */
    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }

    /**
    *regresa las iniciales de la persona
    *
    *@return iniciales iniciales de la persona
    */
    public String getIniciales() {
        return (this.iniciales);
    }

    /**
    *establece el nombre de usuario de la persona
    *
    *@param nombreUsuario nombre de usuario de la persona
    */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
    *regresa el nombre de usuario de la persona
    *
    *@return nombreUsuario nombre de usuario de la persona
    */
    public String getNombreUsuario() {
        return (this.nombreUsuario);
    }

    /**
    *establece la clave de acceso de la persona
    *
    *@param claveAcceso clave de acceso de usuario de la persona
    */
    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso=claveAcceso;
    }


    /**
    *regresa la clave de acceso de la persona
    *
    *@return claveAcceso clave de acceso de la persona
    */
    public String getClaveAcceso() {
        return (this.claveAcceso);
    }

    /**
    *establece la clave de confirmacion de la persona
    *
    *@param claveAccesoConfirmacion clave de confirmacion de la persona
    */
    public void setClaveAccesoConfirmacion(String claveAccesoConfirmacion) {
        this.claveAccesoConfirmacion=claveAccesoConfirmacion;
    }

    /**
    *regresa la clave de confirmacion de la persona
    *
    *@return claveAccesoConfirmacion clave de confirmacion de la persona
    */
    public String getClaveAccesoConfirmacion() {
        return (this.claveAccesoConfirmacion);
    }

    /**
    *vuelve todos los valores nulos
    *
    *@param mapping acciones
    *@param request informacion
    */
    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
                        id= new Long(0);
	prefijo=null;
        nombre=null;
        apellidoPaterno=null;
        apellidoMaterno=null;
        posfijo=null;
        iniciales=null;
        nombreUsuario=null;
        claveAcceso=null;
        claveAccesoConfirmacion=null;
    }


    /**
    *realiza las validaciones proporcionadas por Struts-Validator
    *
    *@param mapping acciones
    *@param request informacion
    *@return ActionErrors errores de la acccion
    */

    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
