package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el logeo de usuarios
 *
 * @author Farelo Andres Max
 */
public final class FormaLogin
        extends ValidatorForm {

    private String user;
    private String password;


    /**
    *regresa el usuario
    *
    *@return user usuario
    */
    public String getUser(){
        return(this.user);
    }

    /**
    *establece el usuario
    *
    *@param user usuario
    */
    public void setUser(String user){
         this.user = user;
    }

    /**
    *regresa la contraseña del usuario
    *
    *@return password contraseña del usuario
    */
    public String getPassword(){
        return (this.password);
    }

    /**
    *establece la contraseña del usuario
    *
    *@param password contraseña usuario
    */
    public void setPassword(String password){
        this.password = password;
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
