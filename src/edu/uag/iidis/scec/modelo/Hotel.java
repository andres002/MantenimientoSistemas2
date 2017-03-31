package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 *
 *Esta clase nos permite tener los atributos de un Hotel
 *id, descripcion, nombre, precio,horario,estado,imagen,pais, direccion
 *
 *
 * @author Luis Andrés Max
 * @version 1.0
 */
public class Hotel extends ClaseBase
        implements Serializable {

    private Long id;
    private String nombre;
    private String descripcion;
	private String precio;
	private String horario;
	private String estado;
    private String imagen;
    private String pais;
    private String direccion;

    public Hotel() {
    }

    /**
     * Constructor que establece el id del Hotel.
     * @param id id del Hotel
     */
    public Hotel(Long id){
        this.id = id;
    }

    /**
     * Constructor que establece todos los atributos del hotel excepto id.
     * @param nombre nombre del hotel
     *@param descripcion descripcion del hotel
     *@param precio precio del hotel
     *@param horario horario del hotel
     *@param estado estado del hotel
     *@param imagen imagen del hotel
     *@param pais pais del hotel
     *@param direccion direccion del hotel
     */
    public Hotel(String nombre, String descripcion,String precio,String horario,String estado, String imagen, String pais, String direccion){
        this.nombre=nombre;
        this.descripcion=descripcion;
    		this.precio=precio;
    		this.horario=horario;
    		this.estado=estado;
        this.imagen=imagen;
        this.pais = pais;
        this.direccion = direccion;
    }

    /**
     * Regresa el id del Hotel.
     * @return Long id del hotel
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id del Hotel.
     * @param id id del hotel
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre del hotel.
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Regresa la descripcion del hotel.
     * @return String
     */
	public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Regresa el precio del hotel.
     * @return String
     */
	public String getPrecio() {
        return this.precio;
    }

    /**
     * Regresa el horario del hotel.
     * @return String
     */
	public String getHorario() {
        return this.horario;
    }

    /**
     * Regresa el estado del hotel.
     * @return String
     */
	public String getEstado() {
        return this.estado;
    }

    /**
     * Regresa la dirección de la imagen del hotel.
     * @return String
     */
     public String getImagen() {
        return this.imagen;
    }

    /**
     * Regresa el pais del hotel.
     * @return String
     */
         public String getPais() {
        return this.pais;
    }

    /**
     * Regresa la dirección del hotel.
     * @return String
     */
         public String getDireccion() {
        return this.direccion;
    }

    /**
     * Establece el nombre del hotel.
     * @param nombre nombre del hotel
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la descripcion del hotel.
     * @param descripcion descripcion del hotel
     */
	public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece el precio del hotel.
     * @param precio precio del hotel
     */
	public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * Establece el horario del hotel.
     * @param horario horario del hotel
     */
	public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * Establece el estado del hotel.
     * @param estado estado del hotel
     */
	public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Establece la direccion de la imagen del hotel.
     * @param imagen direccion de la imagen del hotel
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Establece el pais del hotel.
     * @param pais pais del hotel
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Establece la direccion del hotel.
     * @param direccion direccion del hotel
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
