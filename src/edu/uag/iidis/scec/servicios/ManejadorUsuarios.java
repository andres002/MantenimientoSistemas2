package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Usuario;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.UsuarioDAO;
import edu.uag.iidis.scec.persistencia.AccesoDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

/**
*Esta clase facilita las transacciones con la persistencia
*
*@author Luis Andres Max
*@version 1.0
*/
public class ManejadorUsuarios {
    private Log log = LogFactory.getLog(ManejadorUsuarios.class);
    private UsuarioDAO dao;


    /**
    *Constructor de los usuarios
    *Asigna el DAO correspondiente
    *
    */
    public ManejadorUsuarios() {
        dao = new UsuarioDAO();
    }

    /**
    *obtiene un usuario
    *hace uso de las transacciones con usuarioDAO
    *
    *@param nombreUsuario nombre del usuario a buscar
    *@return Usuario devuelve el usuario solicitado
    */
    public Usuario obtenerUsuario(String nombreUsuario)
            throws ExcepcionServicio {

        if (log.isDebugEnabled()) {
            log.debug(">obtenerUsuario(" + nombreUsuario + ")");
        }

        try {
            return dao.buscarPorNombreUsuario(nombreUsuario);
        } catch (ExcepcionInfraestructura e) {
            log.error("<ExcepcionInfraestructura");
            throw new ExcepcionServicio(e.getMessage(), e);
        }
    }

    public Collection listarUsuarios() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarTodos();
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }


    /**
    *obtiene a todos los usuarios
    *hace uso de las transacciones con usuarioDAO
    *
    *@param usuario usuario
    *@return collection devuelve una colección con todos los usuarios
    */
    public Collection obtenerUsuarios(Usuario usuario) {

        if (log.isDebugEnabled()) {
            log.debug(">obtenerUsuarios(usuario)");
        }

        return dao.buscarTodos();
    }

    /**
    *Crea un usuario
    *hace uso de las transacciones con usuarioDAO
    *
    *@param usuario usuario a agregar
    *@return int  0.Creada correctamente 1.el nombre ya existe 2.-Error infraestructura
    */

    public int crearUsuario(Usuario usuario) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();

            if (dao.existeUsuario(usuario.getCredencial()
                                         .getNombreUsuario())) {
               resultado = 1; // Excepci�n. El nombre de usuario ya existe
            } else {

               dao.hazPersistente(usuario);

               resultado = 0; // Exito. El usuario se creo satisfactoriamente.
            }

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepci�n. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }


    /**
    *elimina un usuario
    *hace uso de las transacciones con usuarioDAO
    *
    *@param id id del usuario a eliminar
    */
    public void eliminarUsuario(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarUsuario(id)");
        }
        try {
            HibernateUtil.beginTransaction();
            Usuario usuario = dao.buscarPorId(id, true);
            if (usuario != null) {
              dao.hazTransitorio(usuario);
            }
            HibernateUtil.commitTransaction();
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
        } finally {
            HibernateUtil.closeSession();
        }

    }


/*
    public void eliminarUsuario(String nombreUsuario)
            throws ExcepcionServicio {

        if (log.isDebugEnabled()) {
            log.debug(">eliminarUsuario(" + nombreUsuario + ")");
        }

        try {
            dao.hazTransitorio(nombreUsuario);
        } catch (ExcepcionInfraestructura e) {
            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            throw new ExcepcionServicio(e.getMessage(), e);
        }
    }

*/
}
