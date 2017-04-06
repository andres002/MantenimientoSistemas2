package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Acceso;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;

/**
*Esta clase contiene las configuraciones para la persistencia del Acceso
*tiene acceso directo a Hibernate
*
*@author Luis Andres Max
*@version 1.0
*/

public class AccesoDAO {

    private Log log = LogFactory.getLog(AccesoDAO.class);

    public AccesoDAO() {
    }

    /**
    *Busca por id los accesos
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param idAcceso id del acceso
    *@param bloquear verdadero o falso
    *@return Acceso devuelve el acceso buscado
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public Acceso buscarPorId(Long idAcceso, boolean bloquear)
            throws ExcepcionInfraestructura {

        Acceso acceso = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idAcceso + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                acceso = (Acceso)HibernateUtil.getSession()
                                                .load(Acceso.class,
                                                      idAcceso,
                                                      LockMode.UPGRADE);
            } else {
                acceso = (Acceso)HibernateUtil.getSession()
                                                .load(Acceso.class,
                                                      idAcceso);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return acceso;
    }


    /**
    *Busca y ordena los accesos por un atributo
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param attribute atributo a usar para ordenar
    *@return Collection devuelve una colección de los accesos ordenados
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public Collection ordenarAccesosPor( String attribute )
            throws ExcepcionInfraestructura {

        Collection accesos;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
          String hql = "from Acceso ORDER BY " + attribute;

           if (log.isDebugEnabled()) {
               log.debug(hql );
          }

         accesos = HibernateUtil.getSession()
                                      .createQuery(hql).list();
          if (log.isDebugEnabled()) {
               log.debug("<<<<<<<<< create query ok " );
          }
            /*accesos = HibernateUtil.getSession()
                                    .createCriteria(Acceso.class)
                                    .list();*/

              log.debug(">buscarTodos() ---- list   " + accesos.size());
			log.debug(">buscarTodos() ---- contenido   " + accesos);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return accesos;
    }



    /**
    *Busca todos los accesos
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@return Collection devuelve una colección de todos los accesos
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection accesos;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            accesos = HibernateUtil.getSession()
                                    .createCriteria(Acceso.class)
                                    .list();

              log.debug(">buscarTodos() ---- list   " + accesos.size());
			log.debug(">buscarTodos() ---- contenido   " + accesos);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return accesos;
    }


    /**
    *Busca un acceso
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param acceso Acceso a buscar
    *@return Collection devuelve una colección de todos los accesos
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public Collection buscarPorEjemplo(Acceso acceso)
            throws ExcepcionInfraestructura {


        Collection accesos;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Acceso.class);
            accesos = criteria.add(Example.create(acceso)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return accesos;
    }


    /**
    *Asigna permisos
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param acceso Acceso a guardar
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public void hazPersistente(Acceso acceso)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(acceso)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(acceso);
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
    *@param acceso Acceso a terminar sesión
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public void hazTransitorio(Acceso acceso)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(acceso)");
        }

        try {
            HibernateUtil.getSession().delete(acceso);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    /**
    *Verifica si el nombre del acceso (usuario) existe
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param nombreAcceso nombre del acceso
    *@return boolean true si existe, false si no existe
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public boolean existeAcceso(String nombreAcceso)
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

            String hql = "select nombre from Acceso where nombre = :nombre";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreAcceso);
            }

            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            query.setParameter("nombre", nombreAcceso);
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
    *Verifica si el nombre del acceso (usuario) existe
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param acceso nombre del acceso
    *@return boolean true si existe, false si no existe
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public boolean modificar( Acceso acceso ) throws ExcepcionInfraestructura {

        boolean toReturn = false;

        if (this.log.isDebugEnabled()) {

            this.log.debug(">modificar(estado)");

        }

        try {

            System.out.println(acceso.toString());

            HibernateUtil.getSession().saveOrUpdate(acceso);

            toReturn = true;

        } catch (HibernateException ex) {

            if (this.log.isWarnEnabled()) {

                this.log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }

        return toReturn;
    }

    /**
    *Busca una imagen del acceso
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param nombreAcceso nombre del acceso
    *@return collection regresa una colección con las imagenes
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public Collection buscarImagen(String nombreAcceso)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Acceso where nombre = '"+nombreAcceso+"'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreAcceso);
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

    /**
    *Busca un acceso específico 
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param nombreAcceso nombre del acceso
    *@return Collection una colección con los resultados del acceso buscado
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
	public Collection buscarAcceso(String nombreAcceso)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Acceso where nombre like '"+nombreAcceso+"%'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreAcceso);
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

    /**
    *Busca los estados de un acceso
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param nombreAcceso nombre del acceso
    *@return Collection devuelve una colección con los datos.
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public Collection buscarEstado(String nombreAcceso)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Acceso where nombre = '"+nombreAcceso+"'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreAcceso);
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
