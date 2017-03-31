package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Critica;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


/**
*Esta clase contiene las configuraciones para la persistencia de las criticas
*tiene acceso directo a Hibernate
*
*@author Luis Andres Max
*@version 1.0
*/

public class CriticaDAO {

    private Log log = LogFactory.getLog(CriticaDAO.class);

    public CriticaDAO() {
    }


    /**
    *Busca por id las criticas
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param idCritica id de la critica
    *@param bloquear verdadero o falso
    *@return Critica devuelve la critica buscada
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public Critica buscarPorId(Long idCritica, boolean bloquear)
            throws ExcepcionInfraestructura {

        Critica critica = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idCritica + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                critica = (Critica)HibernateUtil.getSession()
                                                .load(Critica.class,
                                                      idCritica,
                                                      LockMode.UPGRADE);
            } else {
                critica = (Critica)HibernateUtil.getSession()
                                                .load(Critica.class,
                                                      idCritica);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return critica;
    }

        /**
        *Busca y ordena las Criticas por un atributo
        *Tiene comunicación directa con Hibernate para realizar la transacción
        *
        *@param attribute atributo a usar para ordenar
        *@return Collection devuelve una colección de las criticas ordenadas
        *@throws ExcepcionInfraestructura si surge algun error en la transacción
        */
        public Collection ordenarCriticaesPor( String attribute )
            throws ExcepcionInfraestructura {

        Collection criticaes;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
          String hql = "from Critica ORDER BY " + attribute;

           if (log.isDebugEnabled()) {
               log.debug(hql );
          }

         criticaes = HibernateUtil.getSession()
                                      .createQuery(hql).list();
          if (log.isDebugEnabled()) {
               log.debug("<<<<<<<<< create query ok " );
          }
            /*criticaes = HibernateUtil.getSession()
                                    .createCriteria(Critica.class)
                                    .list();*/

              log.debug(">buscarTodos() ---- list   " + criticaes.size());
			log.debug(">buscarTodos() ---- contenido   " + criticaes);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return criticaes;
    }



    /**
    *Busca todas las criticas
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@return Collection devuelve una colección de todas las ciudades
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection criticaes;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            criticaes = HibernateUtil.getSession()
                                    .createCriteria(Critica.class)
                                    .list();

              log.debug(">buscarTodos() ---- list   " + criticaes.size());
			log.debug(">buscarTodos() ---- contenido   " + criticaes);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return criticaes;
    }

    /**
    *Busca una critica
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param critica critica a buscar
    *@return Collection devuelve una colección de todas las criticas
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public Collection buscarPorEjemplo(Critica critica)
            throws ExcepcionInfraestructura {


        Collection criticaes;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Critica.class);
            criticaes = criteria.add(Example.create(critica)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return criticaes;
    }


    /**
    *Asigna permisos
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param critica critica a guardar
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public void hazPersistente(Critica critica)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(critica)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(critica);
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
    *@param critica crítica a terminar sesión
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public void hazTransitorio(Critica critica)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(critica)");
        }

        try {
            HibernateUtil.getSession().delete(critica);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    /**
    *Verifica si el nombre de la Crítica existe
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param nombreCritica nombre de la crítica
    *@return boolean true si existe, false si no existe
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public boolean existeCritica(String nombreCritica)
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

            String hql = "select nombre from Critica where nombre = :nombre";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreCritica);
            }

            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            query.setParameter("nombre", nombreCritica);
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
    *Verifica si el nombre de la crítica existe
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param critica nombre de la crítica
    *@return boolean true si existe, false si no existe
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public boolean modificar( Critica critica ) throws ExcepcionInfraestructura {

        boolean toReturn = false;

        if (this.log.isDebugEnabled()) {

            this.log.debug(">modificar(critica)");

        }

        try {

            System.out.println(critica.toString());

            HibernateUtil.getSession().saveOrUpdate(critica);

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
    *Busca una crítica específico 
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param nombreCritica nombre de la Crítica
    *@return Collection una colección con los resultados de la crítica buscado
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
	public Collection buscarCritica(String nombreCritica)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Critica where nombre like '"+nombreCritica+"%'";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreCritica);
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
