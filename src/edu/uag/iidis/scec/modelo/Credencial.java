package edu.uag.iidis.scec.modelo;

import java.io.Serializable;

/**
 *Esta clase implementa lo necesario para obtener el acceso (clave acceso y nombre usuario)
 * @author Victor Ramos
 */
public class Credencial
        implements Serializable {

    private String nombreUsuario;
    private String claveAcceso;

    public Credencial() {}

      /**
      *Constructor que establece el nombre de ususario y la clave de acceso
      *@param nombreUsuario Nombre de Usuario
      *@param claveAcceso contraseña del usuario
      */

    public Credencial(String nombreUsuario,
                      String claveAcceso) {
        this.nombreUsuario = nombreUsuario;
        this.claveAcceso = claveAcceso;
    }

    /**
    *metodo que devuelve el nombre de usuario
    *@return nombreUsuario Nombre de Usuario
    */

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
    *metodo que establece el nombre de usuario
    *@param nombreUsuario Nombre de Usuario
    */

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
    *método que retorna la clave de acceso
    *@return claveAcceso retorna la clave de acceso
    */

    public String getClaveAcceso() {
        return claveAcceso;
    }

    /**
    *método que establece la clave de acceso
    *@param claveAcceso establece la clave de acceso
    */
    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

}
