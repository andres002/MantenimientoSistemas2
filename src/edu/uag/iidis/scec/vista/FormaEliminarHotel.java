package edu.uag.iidis.scec.vista;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para la eliminación de un hotel
 *
 * @author Farelo Andres Max
 */
public final class FormaEliminarHotel
        extends ValidatorForm {

    private Long id;

    /**
    *establece el id del hotel
    *@param id id del hotel
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    *regresa el id del hotel
    *@return id id del hotel
    */
    public Long getId() {
        return (this.id);
    }

    /**
    *vuelve el id = 0
    *
    *@param mapping acciones
    *@param request informacion
    */
    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        id= new Long(0);
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
