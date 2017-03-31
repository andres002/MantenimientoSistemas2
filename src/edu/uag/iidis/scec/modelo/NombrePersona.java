package edu.uag.iidis.scec.modelo;

import java.io.Serializable;

/**
 *
 *Esta clase nos permite tener los atributos de una persona
 *prefijo, nombre, apellidoPaterno, apellidoMaterno, posfijo, iniciales
 *
 *
 * @author Luis Andrés Max
 * @version 1.0
 */

public class NombrePersona
        implements Serializable {

    private String prefijo;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String posfijo;
    private String iniciales;

    public NombrePersona() {}


      /**
       * Constructor que establece los atributos del nombre de la persona
       *
       *@param prefijo prefijo del nombre
       * @param nombre nombre de la persona
       * @param apellidoPaterno apellido Paterno de la persona
       * @param apellidoMaterno apellido materno de la persona
       * @param posfijo posfijo del nombre de la persona
       * @param iniciales iniciales del nombre de la persona
       */
    public NombrePersona(String prefijo,
                         String nombre,
                         String apellidoPaterno,
                         String apellidoMaterno,
                         String posfijo,
                         String iniciales) {
        this.prefijo = prefijo;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.posfijo = posfijo;
        this.iniciales = iniciales;
    }

    /**
     * Regresa el prefijo del nombre de la persona.
     * @return String prefijo
     */
    public String getPrefijo() {
        return prefijo;
    }

    /**
     * metodo que establece el prefijo del nombre de la persona.
     * @param prefijo prefijo del nombre de la persona
     */
    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    /**
     * Regresa el nombre del nombre de la persona.
     * @return String nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo que establece el nombre del nombre de la persona.
     * @param nombre nombre del nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el apellido paterno del nombre de la persona.
     * @return String apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * metodo que establece el apellido paterno del nombre de la persona.
     * @param apellidoPaterno apellido paterno del nombre de la persona
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Regresa el apellido materno del nombre de la persona.
     * @return String apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * metodo que establece el apellido materno del nombre de la persona.
     * @param apellidoMaterno apellido materno del nombre de la persona
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Regresa las iniciales del nombre de la persona.
     * @return String iniciales
     */
    public String getIniciales() {
        return iniciales;
    }

    /**
     * metodo que establece las iniciales del nombre de la persona.
     * @param iniciales iniciales del nombre de la persona
     */
    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }

    /**
     * Regresa el posfijo del nombre de la persona.
     * @return String posfijo
     */
    public String getPosfijo() {
        return posfijo;
    }

    /**
     * metodo que establece el posfijo del nombre de la persona.
     * @param posfijo posfijo del nombre de la persona
     */
    public void setPosfijo(String posfijo) {
        this.posfijo = posfijo;
    }

    /**
     * Regresa el nombre completo de la persona.
     * @return String nombreCompleto
     */
    public String getNombreCompleto() {

        return (nombre + " " +
               apellidoPaterno + " " +
               apellidoMaterno);
    }

}
