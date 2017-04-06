package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;

/**
 * Esta clase es usada para representar a un usuario de la
 * aplicación, unicamente los atributos de acceso como:
 *username y id.
 *
 * <p>
 * <a href="Usuario.java.html"><i>Ver código fuente</i></a>
 * </p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */

public class User extends ClaseBase
        implements Serializable {

	private String username;
	private String userid;

	public User() {

	}

  /**
   * Constructor que establece el username del usuario.
   * @param username username del usuario
   */
	public User(String username) {
		this.username = username;
	}

  /**
   * Constructor que establece todos los atributos del usuario.
   *@param username username del usuario
   *@param userid id del usuario
   */
	public User(String username, String userid) {
		this.username = username;
		this.userid = userid;
	}


  /**
  *metodo que devuelve el nombre de usuario
  *@return username Nombre de Usuario
  */
	public String getUsername() {
		return this.username;
	}

  /**
  *metodo que establece el nombre de usuario
  *@param username Nombre de Usuario
  */
  public void setUsername(String username) {
		this.username = username;
	}

  /**
  *metodo que devuelve el id de usuario
  *@return userid id de Usuario
  */
  public String getUserid() {
		return this.userid;
	}

  /**
  *metodo que establece el id de usuario
  *@param userid id de Usuario
  */
  public void setUserid(String userid) {
		this.userid = userid;
	}


}
