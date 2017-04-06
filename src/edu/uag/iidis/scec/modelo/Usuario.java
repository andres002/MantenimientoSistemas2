package edu.uag.iidis.scec.modelo;

import java.util.ArrayList;
import java.util.List;


/**
 * Esta clase es usada para representar a un usuario de la
 * aplicación.
 *
 * <p>
 * <a href="Usuario.java.html"><i>Ver código fuente</i></a>
 * </p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Usuario extends Persona {

    protected Credencial credencial;
    protected List roles = new ArrayList();


    public Usuario(){
    }


    /**
     * Constructor que establece todos los atributos del usuario excepto id.
     * @param nombre nombre del usuario
     *@param credencial descripcion del usuario
     */
    public Usuario(NombrePersona nombre,
                   Credencial credencial) {
        super(nombre);
        this.credencial=credencial;
    }


    /**
     * Regresa el identificador del usuario.
     * @return Long
     */
    public Credencial getCredencial() {
        return credencial;
    }

    /**
     * Establece la credencial del usuario.
     * @param credencial credencial del usuario
     */
    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }


    /**
     * Regresa los roles a los que pertenece el usuario.
     * @return List
     */
    public List getRoles() {
        return roles;
    }


    /**
     * Establece los roles del usuario
     * @param roles Lista de los roles del usuario
     */
    public void setRoles(List roles) {
        this.roles = roles;
    }


    /**
     * Agrega un rol para el usuario
     * @param rol rol asignado a un usuario
     */
    public void addRol(Rol rol) {
        if (roles.indexOf(rol) < 0) {
            roles.add(rol);
            rol.getUsuarios().add(this);
        }
    }


    /**
     * quita un rol para el usuario
     * @param rol rol removido a un usuario
     */
    public void removeRol(Rol rol) {
        roles.remove(rol);
        rol.getUsuarios().remove(this);
    }

}
