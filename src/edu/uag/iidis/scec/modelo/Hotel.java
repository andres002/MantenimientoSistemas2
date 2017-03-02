package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 *
 *
 *
 * <p><a href="Estado.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Hotel extends ClaseBase
        implements Serializable {

    private Long id;
    private String nombre;
    private String descripcion;
    private String precio;
    private String horario;
    private String telefono;
    private String direccion;

    public Hotel() {
    }

    public Hotel(Long id){
        this.id = id;
    }

    public Hotel(String nombre, String descripcion,String precio,String horario,String telefono, String direccion){
        this.nombre=nombre;
        this.descripcion=descripcion;
    		this.precio=precio;
    		this.horario=horario;
    		this.telefono=telefono;
        this.direccion=direccion;
    }

    /**
     * Regresa el id del Hotel.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id del Hotel.
     * @return void
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre del Hotel.
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }
	public String getDescripcion() {
        return this.descripcion;
    }
	public String getPrecio() {
        return this.precio;
    }
	public String getHorario() {
        return this.horario;
    }
	public String getTelefono() {
        return this.telefono;
    }
     public String getDireccion() {
        return this.direccion;
    }
    /**
     * Establece el nombre del Hotel.
     * @return void
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
	public void setPrecio(String precio) {
        this.precio = precio;
    }
	public void setHorario(String horario) {
        this.horario = horario;
    }
	public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Regresa la descripción del Hotel.
     * @return String
     */


    /**
     * Establece la descripción del Hotel.
     * @return void
     */



}
