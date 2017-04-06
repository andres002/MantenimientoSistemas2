package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 *
 *
 *En esta clase de cuentas con los atributos de lugar
 *id, nombre, descripcion, poblacion, coordenadas, estado, imagen, pais, moneda.
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Lugar extends ClaseBase
        implements Serializable {

    private Long id;
    private String nombre;
    private String descripcion;
  	private Long poblacion;
  	private String coordenadas;
  	private String estado;
    private String imagen;
    private String pais;
    private String moneda;

    public Lugar() {
    }

    public Lugar(Long id){
        this.id = id;
    }
    /**
     * Constructor que establece los atributos del lugar excepto el id.
     * @param nombre nombre del lugar
     * @param descripcion descripcion del lugar
     * @param poblacion poblacion del lugar
     * @param coordenadas coordenadas del lugar
     * @param estado estado del lugar
     * @param imagen imagen del lugar
     * @param pais pais del lugar
     * @param moneda moneda del lugar
     */
    public Lugar(String nombre, String descripcion,Long poblacion,String coordenadas,String estado, String imagen, String pais, String moneda){
        this.nombre=nombre;
        this.descripcion=descripcion;
    		this.poblacion=poblacion;
    		this.coordenadas=coordenadas;
    		this.estado=estado;
        this.imagen=imagen;
        this.pais = pais;
        this.moneda = moneda;
    }

    /**
     * metodo que regresa el id del Lugar.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * metodo que establece el id del lugar.
     * @param id pais del lugar
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre del lugar.
     * @return String nombre del lugar
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Regresa la descripcion del lugar.
     * @return String descripcion del lugar
     */
	public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Regresa la población del lugar.
     * @return Long población del lugar
     */
	public Long getPoblacion() {
        return this.poblacion;
    }

    /**
     * Regresa las coordenadas del lugar.
     * @return String coordenadas del lugar
     */
	public String getCoordenadas() {
        return this.coordenadas;
    }

    /**
     * Regresa el estado del lugar.
     * @return String estado del lugar
     */
	public String getEstado() {
        return this.estado;
    }

    /**
     * Regresa la dirección de la imagen del lugar.
     * @return String imagen del lugar
     */
     public String getImagen() {
        return this.imagen;
    }

    /**
     * Regresa el pais del lugar.
     * @return String pais del lugar
     */
         public String getPais() {
        return this.pais;
    }

    /**
     * Regresa la moneda del lugar.
     * @return String moneda del lugar
     */
         public String getMoneda() {
        return this.moneda;
    }


    /**
     * Establece el nombre del lugar.
     * @param nombre nombre del lugar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la descripcion del lugar.
     * @param descripcion descripcion del lugar
     */
	public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece la poblacion del lugar.
     * @param poblacion poblacion del lugar
     */
	public void setPoblacion(Long poblacion) {
        this.poblacion = poblacion;
    }

    /**
     * Establece las coordenadas del lugar.
     * @param coordenadas coordenadas del lugar
     */
	public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    /**
     * Establece el estado del lugar.
     * @param estado estado del lugar
     */
	public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Establece la imagen del lugar.
     * @param imagen imagen del lugar
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Establece el país del lugar.
     * @param pais país del lugar
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Establece la moneda del lugar.
     * @param moneda moneda del lugar
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

}
