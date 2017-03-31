package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase nos da acceso al país y sus atributos
 *id, nombre, descripcion.
 *
 * <p><a href="Pais.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Pais extends ClaseBase
        implements Serializable {

    private Long id;
    private String nombre;
    private String descripcion;


    public Pais() {
    }

    /**
     * Constructor que establece el id del País.
     * @param id id del país
     */
    public Pais(Long id){
        this.id = id;
    }

    /**
     * Constructor que establece todos los atributos del País excepto id.
     * @param nombre nombre del País
     *@param descripcion descripcion del País
     *
     */
    public Pais(String nombre, String descripcion){
        this.nombre=nombre;
        this.descripcion=descripcion;
    }

    /**
     * Regresa el id del Pais.
     * @return Long id
     */
    public Long getId() {
        return this.id;
    }


     /**
      * Establece el id del País.
      * @param id id del País
      */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre del Pais.
     * @return String nombre
     */
    public String getNombre() {
        return this.nombre;
    }


     /**
      * Establece el nombre del País.
      * @param nombre nombre del País
      */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * Regresa la descripción del Pais.
     * @return String descripción
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Establece la descripción del País.
     * @param descripcion descripcion del País
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
