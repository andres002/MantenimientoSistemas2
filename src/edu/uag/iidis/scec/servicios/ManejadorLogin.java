package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.LoginDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

/**
*Esta clase facilita las transacciones con la persistencia
*
*@author Luis Andres Max
*@version 1.0
*/
public class ManejadorLogin {
    private Log log = LogFactory.getLog(ManejadorLogin.class);
    private LoginDAO dao;

    /**
    *Constructor del login
    *Asigna el DAO correspondiente
    *
    */
    public ManejadorLogin() {
        dao = new LoginDAO();
    }

      /**
      *busca un login (usuario y contrseña)
      *hace uso de las transacciones con LoginDAO
      *
      *@param nombre nombre del usuario
      *@param password password del acceso
      *@return collection devuelve una colección los usuarios validos
      */
    public Collection buscarLogin(String nombre, String password) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarLogin(nombre,password);
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }




}
