package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Critica;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.CriticaDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;
import net.webservicex.*;
import java.util.ArrayList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;

/**
*Esta clase facilita las transacciones con la persistencia
*
*@author Luis Andres Max
*@version 1.0
*/
public class ManejadorCriticaes {
    private Log log = LogFactory.getLog(ManejadorCriticaes.class);
    private CriticaDAO criticaDAO;

    /**
    *Constructor de las criticas
    *Asigna el DAO correspondiente
    *
    */
    public ManejadorCriticaes() {
        criticaDAO = new CriticaDAO();
    }

    /**
    *Lista las criticas
    *hace uso de las transacciones con criticaDAO
    *
    *@return collection devuelve una colección con todas las criticas
    */
    public Collection listarCriticaes() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = criticaDAO.buscarTodos();
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
    *ordena las Críticas por un atributo
    *hace uso de las transacciones con criticaDAO
    *
    *@param attribute atributo por el que serán ordenadas las críticas
    *@return collection devuelve una colección con todas las criticas ordenadas por el atributo
    */
    public Collection ordenarCriticaesPor(String attribute) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = criticaDAO.ordenarCriticaesPor(attribute);
            if (log.isDebugEnabled()) {
                log.debug(">ret4rn h6te3");
            }
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
    *Lista crítica de acuerdo al nombre
    *hace uso de las transacciones con criticaDAO
    *
    *@param nombre nombre por el que serán ordenadas las críticas
    *@return collection devuelve una colección con todas las criticas ordenadas por el atributo
    */
    public Collection listarCriticaesPorNombre(String nombre) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = criticaDAO.buscarCritica(nombre);
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
    *elimina una crítica
    *hace uso de las transacciones con criticaDAO
    *
    *@param id id de la crítica a eliminar
    */
    public void eliminarCritica(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarCritica(critica)");
        }
        try {
            HibernateUtil.beginTransaction();
            Critica critica = criticaDAO.buscarPorId(id, true);
            if (critica != null) {
              criticaDAO.hazTransitorio(critica);
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


    /**
    *Crea una crítica
    *hace uso de las transacciones con criticaDAO
    *
    *@param critica critica a agregar
    *@return int  0.Creada correctamente 1.el nombre ya existe 2.-Error infraestructura
    */
    public int crearCritica(Critica critica) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarCritica(critica)");
        }

        try {
            HibernateUtil.beginTransaction();

            if (criticaDAO.existeCritica(critica.getNombre())) {
               resultado = 1; // Excepción. El nombre de critica ya existe
            } else {

               criticaDAO.hazPersistente(critica);

               resultado = 0; // Exito. la critica se creo satisfactoriamente.
            }

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepción. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }


    // private static String getCurrencyByCountry(java.lang.String countryName) {
    //     Country service = new net.webservicex.Country();
    //     CountrySoap port = service.getCountrySoap();
    //     return port.getCurrencyByCountry(countryName);
    // }

   /**
    *modifica una crítica
    *hace uso de las transacciones con criticaDAO
    *
    *@param critica critica a modificar
    *@return boolean  true éxitoso, false sin éxito
    */
    public boolean modificarCritica(Critica critica) {

        boolean toReturn = false;

        if (this.log.isDebugEnabled()) {

            this.log.debug(">guardarCritica(critica)");

        }

        try {

            HibernateUtil.beginTransaction();
            toReturn = this.criticaDAO.modificar( critica );

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura ex) {

            HibernateUtil.rollbackTransaction();

            if (this.log.isWarnEnabled()) {

                this.log.warn("< ExcepcionInfraestructura");

            }

        } finally {

            HibernateUtil.closeSession();

        }

        return toReturn;
    }



   //          File fXmlFile = new File(path+"input.xml");
   //          FileWriter w = new FileWriter(fXmlFile);
   //          BufferedWriter bw = new BufferedWriter(w);
   //          PrintWriter wr = new PrintWriter(bw);
   //          wr.write(cities);
   //          wr.close();
   //          bw.close();
   //          DocumentBuilderFactory dbFactory = DocumentBuilderFactory
   //                  .newInstance();
   //          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
   //          org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);
   //          NodeList nList = doc.getElementsByTagName("Table");

   //          int temp = 0;
   //          org.w3c.dom.Node nNode = nList.item(temp);
   //          service += nNode.getTextContent();


   //      } catch (Exception e) {
   //          e.printStackTrace();
   //      }
   //      return service;
   //  }

}
