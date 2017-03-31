package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Hotel;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.HotelDAO;
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
public class ManejadorHoteles {
    private Log log = LogFactory.getLog(ManejadorHoteles.class);
    private HotelDAO hotelDAO;


    /**
    *Constructor de los hoteles
    *Asigna el DAO corrspondiente
    *
    */
    public ManejadorHoteles() {
        hotelDAO = new HotelDAO();
    }

    /**
    *Lista todos los hoteles
    *hace uso de las transacciones con HotelDAO
    *
    *@return collection devuelve una colección con todos los hoteles
    */
    public Collection listarHoteles() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = hotelDAO.buscarTodos();
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
    *ordena los hoteles por un atributo
    *hace uso de las transacciones con hotelDAO
    *
    *@param attribute atributo por el que serán ordenadas los hoteles
    *@return collection devuelve una colección con todos los hoteles ordenadas por el atributo
    */
    public Collection ordenarHotelesPor(String attribute) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = hotelDAO.ordenarHotelesPor(attribute);
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
      *Lista los hoteles de acuerdo al nombre
      *hace uso de las transacciones con hotelDAO
      *
      *@param nombre nombre por el que serán ordenados los hoteles
      *@return collection devuelve una colección con los hoteles ordenadas por el atributo
      */
  public Collection listarHotelesPorNombre(String nombre) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = hotelDAO.buscarHotel(nombre);
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
      *busca el estado de un hotel
      *hace uso de las transacciones con hotelDAO
      *
      *@param nombre nombre del estado
      *@return collection devuelve una colección con los hoteles
      */
    public Collection buscaEstado(String nombre) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = hotelDAO.buscarEstado(nombre);
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
    *elimina un hotel
    *hace uso de las transacciones con hotelDAO
    *
    *@param id id del hotel a eliminar
    */
    public void eliminarHotel(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarHotel(hotel)");
        }
        try {
            HibernateUtil.beginTransaction();
            Hotel hotel = hotelDAO.buscarPorId(id, true);
            if (hotel != null) {
              hotelDAO.hazTransitorio(hotel);
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
      *busca la imagen de un hotel
      *hace uso de las transacciones con hotelDAO
      *
      *@param nombre nombre del hotel
      *@return collection devuelve una colección con las imagenes
      */
    public Collection buscaImagen(String nombre) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = hotelDAO.buscarImagen(nombre);
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public Collection getService(String pais,String path) {
        Collection<DataService> resultado=null;
        ArrayList<DataService> b =  new ArrayList<>();
        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }
        String a = getCurrencyByCountry("Mexico");
        log.error(path);

        DataService d = new DataService(getData(a,path));
        b.add(d);
        resultado = b;
        return resultado;
    }

    /**
    *Crea un hotel
    *hace uso de las transacciones con hotelDAO
    *
    *@param hotel hotel a agregar
    *@return int  0.Creada correctamente 1.el nombre ya existe 2.-Error infraestructura
    */

    public int crearHotel(Hotel hotel) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarHotel(hotel)");
        }

        try {
            HibernateUtil.beginTransaction();

            if (hotelDAO.existeHotel(hotel.getNombre())) {
               resultado = 1; // Excepción. El nombre de ciudad ya existe
            } else {

               hotelDAO.hazPersistente(hotel);

               resultado = 0; // Exito. El ciudad se creo satisfactoriamente.
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


    private static String getCurrencyByCountry(java.lang.String countryName) {
        Country service = new net.webservicex.Country();
        CountrySoap port = service.getCountrySoap();
        return port.getCurrencyByCountry(countryName);
    }

    /**
     *modifica un hotel
     *hace uso de las transacciones con hotelDAO
     *
     *@param hotel hotel a modificar
     *@return boolean  true éxitoso, false sin éxito
     */
    public boolean modificarHotel(Hotel hotel) {

        boolean toReturn = false;

        if (this.log.isDebugEnabled()) {

            this.log.debug(">guardarEstado(estado)");

        }

        try {

            HibernateUtil.beginTransaction();

//            Estado estadoByID = this.estadoDAO.buscarPorId(estado.getId(), true);
//
//            estadoByID.setNombre(estado.getNombre());
//            estadoByID.setDescripcion(estado.getDescripcion());

            //toReturn = this.estadoDAO.modificar(estado);
            toReturn = this.hotelDAO.modificar( hotel );

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



    public String getData(String cities,String path){
        String service ="";
        try {


            File fXmlFile = new File(path+"input.xml");
            FileWriter w = new FileWriter(fXmlFile);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write(cities);
            wr.close();
            bw.close();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);
            NodeList nList = doc.getElementsByTagName("Table");

            int temp = 0;
            org.w3c.dom.Node nNode = nList.item(temp);
            service += nNode.getTextContent();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return service;
    }

}
