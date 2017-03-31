package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el listado de criticas
 *
 * @author Farelo Andres Max
 */
public final class FormaListadoCriticaes
        extends ValidatorForm {

    private Collection criticaes;
    private int contador;
	private String nombre;

    /**
    *establece las criticas en el Collection
    *@param criticaes collection de criticas
    */
    public void setCriticaes(Collection criticaes) {
        this.criticaes = criticaes;
        if (criticaes != null) {
          this.contador = criticaes.size();
        } else
          this.contador = -1;
    }

    /**
    *regresa el collection de las criticas
    *
    *@return criticaes collection de criticas
    */
    public Collection getCriticaes() {
        return (this.criticaes);
    }

    /**
    *regresa el numero de criticas
    *
    *@return size numero de criticas
    */
    public int getContador() {
        return (this.contador);
    }

    /**
    *regresa el nombre
    *
    *@return nombre nombre
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
    *elimina todas las criticas
    *
    *@param mapping acciones
    *@param request informacion
    */
    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        criticaes =null;
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
