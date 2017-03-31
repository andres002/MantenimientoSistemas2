package edu.uag.iidis.scec.vista;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para la eliminación de un usuario
 *
 * @author Farelo Andres Max
 */
public final class FormaEliminarUsuario
        extends ValidatorForm {

    private Long id;

    /**
    *establece el id del usuario
    *@param id id del usuario
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    *regresa el id del usuario
    *@return id id del usuario
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
