package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el listado de usuarios
 *
 * @author Farelo Andres Max
 */
public final class FormaListadoUsuarios
        extends ValidatorForm {

    private Collection usuarios;
    private int contador;
	  private String nombre;
    private String pais;
    private String nombrePrefijo;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombreUsuario;
    private String claveAcceso;


    /**
    *establece los usuarios en el Collection
    *@param usuarios collection de usuarios
    */
    public void setUsuarios(Collection usuarios) {
        this.usuarios = usuarios;
        if (usuarios != null) {
          this.contador = usuarios.size();
        } else
          this.contador = -1;
    }

    /**
    *regresa el collection de los usuarios
    *
    *@return usuarios collection de usuarios
    */
    public Collection getUsuarios() {
        return (this.usuarios);
    }

    /**
    *regresa el numero de usuarios
    *
    *@return size numero de usuarios
    */
    public int getContador() {
        return (this.contador);
    }

    /**
    *regresa el nombre del usuario
    *
    *@return nombre nombre usuario
    */
	public String getNombre(){
        return(this.nombre);
    }

    /**
    *establece el nombre
    *
    *@param nombre nombre
    */
	public void setNombre(String nombre){
         this.nombre = nombre;
    }

    /**
    *regresa el pais del usuario
    *
    *@return pais pais del usuario
    */
    public String getPais(){
        return(this.nombre);
    }

    /**
    *establece el pais del usuario
    *
    *@param pais pais del usuario
    */
    public void setPais(String pais){
         this.pais = pais;
    }

    /**
    *regresa el prefijo del usuario
    *
    *@return prefijo prefijo del usuario
    */
    public String getnombrePrefijo(){
        return(this.nombrePrefijo);
    }

    /**
    *establece el prefijo del usuario
    *
    *@param nombrePrefijo prefijo del usuario
    */
    public void setnombrePrefijo(String nombrePrefijo){
         this.nombrePrefijo = nombrePrefijo;
    }

    /**
    *regresa el apellido paterno del usuario
    *
    *@return apellidoPaterno apellido paterno del usuario
    */
    public String getapellidoPaterno(){
        return(this.apellidoPaterno);
    }

    /**
    *establece el apellido paterno del usuario
    *
    *@param apellidoPaterno apellido paterno del usuario
    */
    public void setapellidoPaterno(String apellidoPaterno){
         this.apellidoPaterno = apellidoPaterno;
    }

    /**
    *regresa el apellido materno del usuario
    *
    *@return apellidoMaterno apellido materno del usuario
    */
    public String getapellidoMaterno(){
        return(this.apellidoMaterno);
    }

    /**
    *establece el apellido materno del usuario
    *
    *@param apellidoMaterno apellido materno del usuario
    */
    public void setapellidoMaterno(String apellidoMaterno){
         this.apellidoMaterno = apellidoMaterno;
    }

    /**
    *regresa el nombre de usuario del usuario
    *
    *@return nombreUsuario nombre de usuario del usuario
    */
    public String getnombreUsuario(){
        return(this.nombreUsuario);
    }

    /**
    *establece el nombre de usuario del usuario
    *
    *@param nombreUsuario nobre de usuario del usuario
    */
    public void setnombreUsuario(String nombreUsuario){
         this.nombreUsuario = nombreUsuario;
    }

    /**
    *regresa la clave de acceso del usuario
    *
    *@return claveAcceso clave de acceso del usuario
    */
    public String getclaveAcceso(){
        return(this.claveAcceso);
    }

    /**
    *establece la clave de acceso del usuario
    *
    *@param claveAcceso clave de acceso del usuario
    */
    public void setclaveAcceso(String claveAcceso){
         this.claveAcceso = claveAcceso;
    }

    /**
    *elimina todos los usuarios
    *
    *@param mapping acciones
    *@param request informacion
    */
    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        usuarios =null;
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
