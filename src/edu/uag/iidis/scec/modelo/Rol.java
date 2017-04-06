package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar un rol de un
 * usuario.
 *contiene atributos del usuario como:
 *id, nombre y descripcion.
 *
 * <p><a href="Rol.java.html"><i>Ver c�digo fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Rol extends ClaseBase
        implements Serializable {

    private Long id;
    private String nombre;
    private String descripcion;
    private List usuarios = new ArrayList();

    public Rol() {
    }

    /**
     * Constructor que establece el id del Rol.
     * @param id id del Rol
     */
    public Rol(Long id){
        this.id = id;
    }

    /**
     * Constructor que establece todos los atributos del rol excepto id.
     * @param nombre nombre del rol
     *@param descripcion descripcion del rol
     */
    public Rol(String nombre, String descripcion){
        this.nombre=nombre;
        this.descripcion=descripcion;
    }

    /**
     * Regresa el id del rol.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id del rol.
     * @param id id del rol
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre del rol.
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del rol.
     * @param nombre nombre del rol
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * Regresa la descripción del rol.
     * @return String
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Establece la descripcion del rol.
     * @param descripcion descripcion del rol
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Regresa los usuarios del rol.
     * @return List usuarios
     */
    public List getUsuarios() {
        return this.usuarios;
    }

    /**
     * Establece Lista de usuarios
     * @param usuarios Lista de usuarios
     */
    public void setUsuarios(List usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Establece un usuario a la lista .
     * @param usuario usuario
     */
    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
        usuario.getRoles().add(this);
    }

}
