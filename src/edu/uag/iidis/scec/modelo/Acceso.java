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
public class Acceso extends ClaseBase
        implements Serializable {

    private Long id;
    private String nombre;
    private String nombrePrefijo;
	private String apellidoMaterno;
	private String apellidoPaterno;
	private String nombreUsuario;
    private String claveAcceso;


    public Acceso() {
    }

    public Acceso(Long id){
        this.id = id;
    }

    public Acceso(String nombre, String nombrePrefijo,String apellidoMaterno,String apellidoPaterno,String nombreUsuario, String claveAcceso){
        this.nombre=nombre;
        this.nombrePrefijo=nombrePrefijo;
		this.apellidoMaterno=apellidoMaterno;
		this.apellidoPaterno=apellidoPaterno;
		this.nombreUsuario=nombreUsuario;
        this.claveAcceso=claveAcceso;

    }

    /**
     * Regresa el id del Acceso.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id del Acceso.
     * @param id define el id de acceso
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre del Acceso.
     * @return String nombre de acceso
     */
    public String getNombre() {
        return this.nombre;
    }
    /**
     * Regresa el prefijo.
     * @return String nombrePrefijo
     */
	public String getNombrePrefijo() {
        return this.nombrePrefijo;
    }

    /**
     * Regresa el apellido Materno.
     * @return String apellidoMaterno
     */

	public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }

    /**
     * Regresa el apellido Materno.
     * @return String apellidoPaterno
     */

	public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }

    /**
     * Regresa el nombre del Usuario.
     * @return String nombreUsuario
     */

	public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    /**
     * Regresa la clave de Acceso.
     * @return String claveAcceso
     */
     public String getClaveAcceso() {
        return this.claveAcceso;
    }


    /**
     * Establece el nombre de Acceso.
     * @param nombre define el id de acceso
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el Prefijo.
     * @param nombrePrefijo  String prefijo de Usuario
     */

	public void setNombrePrefijo(String nombrePrefijo) {
        this.nombrePrefijo = nombrePrefijo;
    }

    /**
     * Establece el apellido Materno.
     * @param apellidoMaterno Apellido Materno de usuario
     */

	public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Establece el apellido Paterno.
     * @param apellidoPaterno Apellido Paterno de usuario
     */

	public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Establece el nombre de usuario.
     * @param nombreUsuario nombre de usuario
     */

	public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Establece la clave de Acceso.
     * @param claveAcceso Apellido Materno de usuario
     */

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }




}
