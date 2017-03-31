package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 *
 *
 *
 * <p><a href="Critica.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author Luis Andres Max
 * @version 1.0
 */
public class Critica extends ClaseBase
        implements Serializable {

    private Long id;
    private String nombre;
    private String descripcion;
	private String hotel;
	private String nivel;

    public Critica() {
    }

    public Critica(Long id){
        this.id = id;
    }

    public Critica(String nombre, String descripcion,String hotel,String nivel){
        this.nombre=nombre;
        this.descripcion=descripcion;
		this.hotel=hotel;
		this.nivel=nivel;
    }

    /**
     * Regresa el id del Critica.
     * @return Long id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id del Critica.
     * @param id id de la critica
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre de la Critica.
     * @return String nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Regresa la descripcion.
     * @return String descripcion
     */
	public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Regresa el nombre del hotel.
     * @return String hotel
     */
	public String getHotel() {
        return this.hotel;
    }

    /**
     * Regresa el nombre el nivel de importancia.
     * @return String nivel de importancia
     */
	public String getNivel() {
        return this.nivel;
    }

    /**
     * Establece el nombre de quien realiza la critica.
     * @param nombre nombre de quien realiza la critica
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la descripcion de la critica.
     * @param descripcion descripcion de la critica
     */

	public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece el hotel de la critica.
     * @param hotel hotel de la critica
     */


	public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    /**
     * Establece el nivel de la critica.
     * @param nivel nivel de importancia de la critica
     */

	public void setNivel(String nivel) {
        this.nivel = nivel;
    }

}
