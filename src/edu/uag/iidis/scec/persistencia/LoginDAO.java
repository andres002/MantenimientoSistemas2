package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;

import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;

/**
*Esta clase contiene las configuraciones para la persistencia del login
*tiene acceso directo a Hibernate
*
*@author Luis Andres Max
*@version 1.0
*/

public class LoginDAO {

    private Log log = LogFactory.getLog(LoginDAO.class);

    public LoginDAO() {
    }

    /**
    *Busca un usuario y una contraseña valida para el logeo de la aplicación
    *Tiene comunicación directa con Hibernate para realizar la transacción
    *
    *@param nombreLogin nombre del Login
    *@param password password del Login
    *@return Collection una colección con los resultados del usuario buscado
    *@throws ExcepcionInfraestructura si surge algun error en la transaccion
    */
    public Collection buscarLogin(String nombreLogin, String password)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
 
            String hql = "from Usuario where credencial.nombreUsuario= '"+nombreLogin+"' and credencial.claveAcceso = '"+password+"'";
            
             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreLogin);
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