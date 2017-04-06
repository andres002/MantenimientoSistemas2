package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el listado de hoteles
 *
 * @author Farelo Andres Max
 */
public final class FormaListadoHoteles
        extends ValidatorForm {

    private Collection hoteles;
    private int contador;
	private String nombre;
    private String pais;

    /**
    *establece los hoteles en el Collection
    *@param hoteles collection de hoteles
    */
    public void setHoteles(Collection hoteles) {
        this.hoteles = hoteles;
        if (hoteles != null) {
          this.contador = hoteles.size();
        } else
          this.contador = -1;
    }

    /**
    *regresa el collection de los hoteles
    *
    *@return hoteles collection de hoteles
    */
    public Collection getHoteles() {
        return (this.hoteles);
    }

    /**
    *regresa el numero de hoteles
    *
    *@return size numero de hoteles
    */
    public int getContador() {
        return (this.contador);
    }


    /**
    *regresa el nombre del hotel
    *
    *@return nombre nombre hotel
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
    *regresa el pais del hotel
    *
    *@return pais pais del hotel
    */
    public String getPais(){
        return(this.nombre);
    }

    /**
    *establece el pais del hotel
    *
    *@param pais pais del hotel
    */
    public void setPais(String pais){
         this.pais = pais;
    }

    /**
    *elimina todos los hoteles
    *
    *@param mapping acciones
    *@param request informacion
    */
    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        hoteles =null;
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
