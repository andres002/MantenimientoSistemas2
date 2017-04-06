package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar estados
 *
 * <p><a href="Estado.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Estado extends ClaseBase
        implements Serializable {

    private Long id;
    private String nombre;
    private String descripcion;


    public Estado() {
    }
    /**
     * Constructor que establece el id del estado.
     * @param id id del Estado
     */
    public Estado(Long id){
        this.id = id;
    }

    /**
     * Constructor que establece el id del estado.
     * @param nombre nombre del estado
     * @param  descripcion descripcion del estado
     */
    public Estado(String nombre, String descripcion){
        this.nombre=nombre;
        this.descripcion=descripcion;
    }

    /**
     * Regresa el id del estado.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id del estado.
     * @param id id del estado
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre del estado.
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del estado.
     * @param nombre nombre del estado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * Regresa la descripción del estado.
     * @return String descripcion del estado
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Establece la descripción del estado.
     * @param descripcion descripcion del estado
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
