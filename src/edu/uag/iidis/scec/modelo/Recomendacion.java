package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;
import java.util.Date;

/**
 *
 *  Esta clase nos ofrece las Recomendaciones y sus atributos
 *id, nombre, estado, usuario, fecha, comentario, calificacion.
 *
 * <p><a href="calificacion.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Recomendacion extends ClaseBase
        implements Serializable {

    private Long id;
    private String nombre;
    private String estado;
    private String usuario;
  	private String fecha;
  	private String comentario;
  	private Long calificacion;


    public Recomendacion() {
    }

    /**
     * Constructor que establece el id de la recomendacion.
     * @param id id de la recomendacion
     */
    public Recomendacion(Long id){
        this.id = id;
    }

    /**
     * Constructor que establece todos los atributos de la recomendacion excepto id.
     * @param nombre nombre de la recomendacion
     *@param estado estado de la recomendacion
     *@param usuario usuario de la recomendacion
     *@param fecha fecha de la recomendacion
     *@param comentario comentario de la recomendacion
     *@param calificacion calificacion de la recomendacion
     */
    public Recomendacion(String nombre,String estado, String usuario,String fecha,String comentario,Long calificacion){
        this.nombre=nombre;
        this.estado=estado;
        this.usuario=usuario;
    		this.fecha=fecha;
    		this.comentario=comentario;
    		this.calificacion=calificacion;
    }

    /**
     * Regresa el id de la Recomendacion.
     * @return Long id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id de la recomendacion.
     * @param id id de la recomendacion
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre de la Recomendacion.
     * @return String nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Regresa el estado de la recomendacion.
     * @return String estado
     */
    public String getEstado() {
        return this.estado;
    }

    /**
     * Regresa el usuario de la recomendacion.
     * @return String usuario
     */
	public String getUsuario() {
        return this.usuario;
    }

    /**
     * Regresa la fecha de la recomendacion.
     * @return String fecha
     */
	public String getFecha() {
        return this.fecha;
    }

    /**
     * Regresa el comentario de la recomendacion.
     * @return String comentario
     */
	public String getComentario() {
        return this.comentario;
    }

    /**
     * Regresa la calificacion de la recomendacion.
     * @return String calificacion
     */
	public Long getCalificacion() {
        return this.calificacion;
    }

    /**
     * Establece el nombre de la Recomendacion.
     * @param nombre nombre de la descripcion
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el estado de la Recomendacion.
     * @param estado estado de la descripcion
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Establece el usuario de la Recomendacion.
     * @param usuario usuario de la descripcion
     */
	public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Establece la fecha de la Recomendacion.
     * @param fecha fecha de la descripcion
     */
	public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece el comentario de la Recomendacion.
     * @param comentario comentario de la descripcion
     */
	public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Establece la calificacion de la Recomendacion.
     * @param calificacion calificacion de la descripcion
     */
	public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
    }



}
