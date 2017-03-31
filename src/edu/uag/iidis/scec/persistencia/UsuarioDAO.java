package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.criterion.Example;
import org.hibernate.type.*;
import org.hibernate.classic.*;

import edu.uag.iidis.scec.modelo.Usuario;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

/**
*Esta clase contiene las configuraciones para la persistencia del login
*tiene acceso directo a Hibernate
*
*@author Luis Andres Max
*@version 1.0
*/

public class UsuarioDAO {

    private Log log = LogFactory.getLog(UsuarioDAO.class);


    public UsuarioDAO() {
    }

    /**
    *Busca por id los usuarios
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param idUsuario id del usuario
    *@param bloquear verdadero o falso
    *@return Usuario devuelve el usuario buscado
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public Usuario buscarPorId(Long idUsuario, boolean bloquear)
            throws ExcepcionInfraestructura {

        Usuario usuario = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idUsuario + ", " + bloquear + ")");
        }


        try {
            if (bloquear) {
                usuario = (Usuario)HibernateUtil.getSession()
                                                .load(Usuario.class, 
                                                      idUsuario, 
                                                      LockMode.UPGRADE);
            } else {
                usuario = (Usuario)HibernateUtil.getSession()
                                                .load(Usuario.class,
                                                      idUsuario);
            }
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }

        return usuario;
    }

    /**
    *Busca un usuario por nombre de usuario
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param nombreUsuario nombre del usuario a buscar
    *@return Usuario devuelve un usuario
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public Usuario buscarPorNombreUsuario(String nombreUsuario)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorNombreUsuario(" + nombreUsuario + ")");
        }

        Usuario usuario = null;
        try {
            List usuarios = HibernateUtil.getSession()
                    .createQuery("from Usuario u where u.credencial.nombreUsuario=:nombreUsuario")
                    .setString("nombreUsuario", nombreUsuario)
                    .list();

            if ((usuarios != null) && (usuarios.size() > 0)) {
                usuario = (Usuario)usuarios.get(0);
            }

            if (usuario == null) {
                if (log.isDebugEnabled()) {
                    log.debug(">buscarPorNombreUsuario(" + nombreUsuario + ")");
                }
            }
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }

        return usuario;
    }


    /**
    *Busca todos los usuarios
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@return Collection devuelve una colección de todos los usuarios
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection usuarios;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            usuarios = HibernateUtil.getSession()
                                    .createCriteria(Usuario.class)
                                    .list();
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
        return usuarios;
    }



    /**
    *Busca un usuario
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param usuarioEjemplo Usuario a buscar
    *@return Collection devuelve una colección de todos los usuarios
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public List buscarPorEjemplo(Usuario usuarioEjemplo)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        List usuarios;
        try {
            usuarios = HibernateUtil.getSession()
                                    .createCriteria(Usuario.class)
                                    .add(Example.create(usuarioEjemplo))
                                    .list();
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
        return usuarios;
    }


    /**
    *Verifica si el nombre del usuario existe
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param nombreUsuario nombre del usuario
    *@return boolean true si existe, false si no existe
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public boolean existeUsuario(String nombreUsuario)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeUsuario(nombreUsuario)");
        }

        try {
//            String consultaCuentaUsuarios =
//            "select count(*) from Usuario u where u.credencial.nombreUsuario=?";
//
//            int resultado =
//            ((Integer) HibernateUtil.getSession()
//                           .find(consultaCuentaUsuarios, 
//                                 nombreUsuario,
//                                 StringType.INSTANCE)
//                           .iterator()
//                           .next()).intValue();

			String hql = "select u.credencial.nombreUsuario from Usuario u where u.credencial.nombreUsuario =:nombreUsuario";
			Query query = HibernateUtil.getSession().createQuery(hql);
			query.setParameter("nombreUsuario",nombreUsuario);
			List results = query.list();
			int resultado = results.size();


            if (resultado == 0) {
               return false;
            }
            
            return true;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }


    /**
    *Asigna permisos
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param usuario Usuario a guardar
    *@throws ExcepcionInfraestructura si surge algún error en la transacción
    */
    public void hazPersistente(Usuario usuario)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(usuario)");
        }

        try {

            HibernateUtil.getSession()
                         .saveOrUpdate(usuario);

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }


    /**
    *termina una sesión
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param usuario Usuario a terminar sesión
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public void hazTransitorio(Usuario usuario)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(usuario)");
        }

        try {
            HibernateUtil.getSession().delete(usuario);
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

}
