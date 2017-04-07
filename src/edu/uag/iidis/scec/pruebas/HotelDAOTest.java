package edu.uag.iidis.scec.pruebas;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.extensions.TestSetup;
import junit.textui.TestRunner;

import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.persistencia.*;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;

import java.util.*;

public class HotelDAOTest extends TestCase{

    
    public void testCrearHotelE() throws Exception {
        HotelDAO dao = new HotelDAO();

        Hotel hotel = new Hotel(
            "001", 
            "001",
            "001",
            "001",
            "001", 
            "001", 
            "001", 
            "001"
        );

        HibernateUtil.beginTransaction();
        try {
            dao.hazPersistente(hotel);
            HibernateUtil.commitTransaction();
            assertTrue(hotel.getId() != null);
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    
    public void testCrearHotelF() throws Exception {
        //Falla porque la placa esta en BD
        HotelDAO dao = new HotelDAO();
        Hotel hotel = new Hotel(
            "001", 
            "001",
            "001",
            "001",
            "001", 
            "001", 
            "001", 
            "001"
        );

        HibernateUtil.beginTransaction();
        try {
            dao.hazPersistente(hotel);
            HibernateUtil.commitTransaction();

            assertTrue(hotel.getId() != null);
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    
    public void testActualizarHotelE() throws Exception {
        HotelDAO dao = new HotelDAO();
        Hotel hotel = new Hotel(
            "001", 
            "001",
            "001",
            "001",
            "001", 
            "001", 
            "001", 
            "001"
        );
        HibernateUtil.beginTransaction();
        try {
             dao.hazPersistente(hotel);
             Hotel hotelB = dao.buscarPorId(Long.valueOf(1), true);
            HibernateUtil.commitTransaction();

            assertTrue(hotelB.getId() != null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testActualizarHotelF() throws Exception {
        //Falla porque la placa no se puede actualizar
        HotelDAO dao = new HotelDAO();
        Hotel hotel = new Hotel(
            "001", 
            "001",
            "001",
            "001",
            "001", 
            "001", 
            "001", 
            "001"
        );
        HibernateUtil.beginTransaction();
        try {
             dao.hazPersistente(hotel);
             Hotel hotelB = dao.buscarPorId(Long.valueOf(1), true);
            HibernateUtil.commitTransaction();

            assertTrue(hotelB.getId() != null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    
    public void testBuscarTodosE() throws Exception {

        HotelDAO dao = new HotelDAO();

        HibernateUtil.beginTransaction();
        try {
            Collection resultado = dao.buscarTodos();
            HibernateUtil.commitTransaction();

            assertTrue(resultado != null);
            assertTrue(!resultado.isEmpty());
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testBuscarTodosF() throws Exception {

        HotelDAO dao = new HotelDAO();

        HibernateUtil.beginTransaction();
        try {
            Collection resultado = dao.buscarTodos();
            HibernateUtil.commitTransaction();

            assertTrue(resultado != null);
            assertTrue("La busqueda fallo",resultado.isEmpty());
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }


    
    public void testExisteHotelE() throws Exception {

        HotelDAO dao = new HotelDAO();

        HibernateUtil.beginTransaction();
        try {
            //dao.hazPersistente(hotel);
            Boolean existe =  dao.existeHotel("001");
            HibernateUtil.commitTransaction();

            assertTrue(existe);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testExisteHotelF() throws Exception {

        HotelDAO dao = new HotelDAO();
        HibernateUtil.beginTransaction();
        try {
            Boolean existe =  dao.existeHotel("002");
            HibernateUtil.commitTransaction();

            assertTrue("El hotel no se encuentra registrado",existe);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testEliminarHotelE() throws Exception {

        HotelDAO dao = new HotelDAO();
        Hotel hotelB = dao.buscarPorId(Long.valueOf(1), true);

        HibernateUtil.beginTransaction();
        try {
             dao.hazTransitorio(hotelB);
            hotelB = dao.buscarPorId(Long.valueOf(1), true);

            HibernateUtil.commitTransaction();

            assertTrue(hotelB == null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testEliminarHotelF() throws Exception {

        HotelDAO dao = new HotelDAO();
        Hotel hotelB = dao.buscarPorId(Long.valueOf(1), true);

        HibernateUtil.beginTransaction();
        try {
             dao.hazTransitorio(hotelB);
            hotelB = dao.buscarPorId(Long.valueOf(1), true);
            HibernateUtil.commitTransaction();

            assertTrue(hotelB == null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testordenarHotelesPorE() throws Exception {

        HotelDAO dao = new HotelDAO();
        Hotel hotel = new Hotel(
            "001", 
            "001",
            "001",
            "001",
            "001", 
            "001", 
            "001", 
            "001"
        );
        HibernateUtil.beginTransaction();
        try {
             dao.hazPersistente(hotel);
            Collection resultado = dao.ordenarHotelesPor("nombre");
            HibernateUtil.commitTransaction();
            Hotel aux = (Hotel)resultado.iterator().next();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testordenarHotelesPorF() throws Exception {

        HotelDAO dao = new HotelDAO();
        //Hotel hotel = new Hotel("Aaaa00000","automovil","1999","Peugeut","OIUP2U3","Blanco");
        HibernateUtil.beginTransaction();
        try {
//             dao.hazPersistente(hotel);
            Collection resultado = dao.ordenarHotelesPor("nombre");
            HibernateUtil.commitTransaction();
            Hotel aux = (Hotel)resultado.iterator().next();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public static Test suite() {

       TestSetup suite = new TestSetup(new TestSuite(UsuarioDAOTest.class)) {

            protected void setUp(  ) throws Exception {
                // Se ejecuta al inicio de la suite

                //SchemaExport ddlExport = new SchemaExport(HibernateUtil.getConfiguration());
                //ddlExport.create(false, true);

                //dao = new UsuarioDAO();
                //rolDAO = new RolDAO();
            }

            protected void tearDown(  ) throws Exception {
                // se ejecuta al final de la suite
                //dao = null;
                //rolDAO = null;
            }
        };

        return suite;
    }

    public static void main(String[] args) throws Exception {
        TestRunner.run( suite() );
    }





}
