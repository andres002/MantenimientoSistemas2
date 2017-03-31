package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Estado;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;

/**
*Esta clase contiene las configuraciones para la persistencia de los estados
*tiene acceso directo a Hibernate
*
*@author Luis Andres Max
*@version 1.0
*/

public class EstadoDAO {

    private Log log = LogFactory.getLog(EstadoDAO.class);

    public EstadoDAO() {
    }

    /**
    *Busca por id los estados
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param idEstado id del Estado
    *@param bloquear verdadero o falso
    *@return Estado devuelve el estado buscado
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public Estado buscarPorId(Long idEstado, boolean bloquear)
            throws ExcepcionInfraestructura {

        Estado estado = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idEstado + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                estado = (Estado)HibernateUtil.getSession()
                                                .load(Estado.class, 
                                                      idEstado, 
                                                      LockMode.UPGRADE);
            } else {
                estado = (Estado)HibernateUtil.getSession()
                                                .load(Estado.class,
                                                      idEstado);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return estado;
    }

    /**
    *Busca todos los estados
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@return Collection devuelve una colección de todos los estados
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection estados;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            estados = HibernateUtil.getSession()
                                    .createCriteria(Estado.class)
                                    .list();
                                    
              log.debug(">buscarTodos() ---- list " + estados);                                 
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return estados;
    }


    /**
    *Busca un estado
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param estado Estado a buscar
    *@return Collection devuelve una colección de todos los estados
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */

    public Collection buscarPorEjemplo(Estado estado)
            throws ExcepcionInfraestructura {


        Collection estados;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Estado.class);
            estados = criteria.add(Example.create(estado)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return estados;
    }

    /**
    *Asigna permisos
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param estado Estado a guardar
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public void hazPersistente(Estado estado)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(estado)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(estado);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    /**
    *termina una sesión
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param estado Estado a terminar sesión
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public void hazTransitorio(Estado estado)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(estado)");
        }

        try {
            HibernateUtil.getSession().delete(estado);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    /**
    *Verifica si el nombre del estado existe
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param nombreEstado nombre del estado
    *@return boolean true si existe, false si no existe
    *@throws ExcepcionInfraestructura si surge algun error en la transacción
    */
    public boolean existeEstado(String nombreEstado)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
            
            
//            String consultaCuentaRoles =
//            "select count(*) from Ciudad r where r.nombre=?";
//
 //           int resultado =
 //           ((Integer) HibernateUtil.getSession()
 //                          .find(consultaCuentaRoles, 
 //                                nombreRol,
 //                                StringType.INSTANCE)
 //                          .iterator()
 //                          .next()).intValue();
// de acuerdo al nuevo formato
 
            String hql = "select nombre from Estado where nombre = :nombre";
            
             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreEstado);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }
			query.setParameter("Nombre", nombreEstado);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            List results = query.list();
            int resultado = results.size();
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< Result size " + resultado);
            }
            if (resultado == 0) {
               return false;
            }
            
            return true;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }
	
    /**
    *Busca un estado específico 
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param nombreEstado nombre del estado
    *@return Collection una colección con los resultados del estado buscado
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public Collection buscaEstado(String nombreEstado)
            throws ExcepcionInfraestructura {
				
		if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
            String hql = "from Estado where nombre like '"+nombreEstado+"%'";
            
             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreEstado);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            List results = query.list();
            int resultado = results.size();
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< Result size " + resultado);
            }
            if (resultado == 0) {
               return results;
            }
            
            return results;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

}
