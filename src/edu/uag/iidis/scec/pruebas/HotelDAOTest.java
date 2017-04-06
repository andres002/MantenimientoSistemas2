package edu.uag.iidis.scec.pruebas;


import org.junit.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.persistencia.*;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;

import java.util.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HotelDAOTest{

    @Test
    public void testCrearHotelE() throws Exception {
        HotelDAO dao = new HotelDAO();
        Hotel hotel = new Hotel("FOHJ960414HMCLRV09","automovil","2002","FORD","AHI98G","ROJO");

        HibernateUtil.beginTransaction();
        try {
            dao.hazPersistente(hotel);
            HibernateUtil.commitTransaction();

            assertTrue(hotel.getId() != null);
            assertTrue(hotel.getCurp().equals("FOHJ960414HMCLRV09"));
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    @Test
    public void testCrearHotelF() throws Exception {
        //Falla porque la placa esta en BD
        HotelDAO dao = new HotelDAO();
        Hotel hotel = new Hotel("FOHJ960414HMCLRV09","automovil","2002","FORD","AHI98G","ROJO");

        HibernateUtil.beginTransaction();
        try {
            dao.hazPersistente(hotel);
            HibernateUtil.commitTransaction();

            assertTrue(hotel.getId() != null);
            assertTrue(hotel.getCurp().equals("FOHJ960414HMCLRV09"));
        } catch (Exception e) {
            fail("El hotel ya se encuentra registrado");
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    @Test
    public void testActualizarHotelE() throws Exception {
        HotelDAO dao = new HotelDAO();
        Hotel hotel = new Hotel("SHJO960414HTCLRV08","automovil","2015","FORD","HOI89H","Azul");
        HibernateUtil.beginTransaction();
        try {
             dao.hazPersistenteP(hotel);
             Hotel hotelB = dao.buscarHotelsPlaca("HOI89H");
            HibernateUtil.commitTransaction();

            assertTrue(hotelB.getId() != null);
            assertTrue(hotelB.getColor().equals("Azul"));

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    @Test
    public void testActualizarHotelF() throws Exception {
        //Falla porque la placa no se puede actualizar
        HotelDAO dao = new HotelDAO();
        Hotel hotel = new Hotel("FOHJ960414HMCLRV09","automovil","2015","DODGE","AEH82J","Azul");
        HibernateUtil.beginTransaction();
        try {
             dao.hazPersistenteP(hotel);
             Hotel hotelB = dao.buscarHotelsPlaca("AEH82J");
            HibernateUtil.commitTransaction();

            assertTrue(hotelB.getId() != null);
            assertTrue(hotelB.getColor().equals("Azul"));

        } catch (Exception e) {
            fail("La placa ya esta registrada");
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    @Test
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
    @Test
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


    @Test
    public void testExisteHotelE() throws Exception {

        HotelDAO dao = new HotelDAO();

        HibernateUtil.beginTransaction();
        try {
            //dao.hazPersistente(hotel);
            Boolean existe =  dao.existeHotel("123abc");
            HibernateUtil.commitTransaction();

            assertTrue(existe);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    @Test
    public void testExisteHotelF() throws Exception {

        HotelDAO dao = new HotelDAO();
        //Hotel hotel = new Hotel("ABHY991214JOYHRV09","automovil","1999","FORD","QWER82","Rojo");

        HibernateUtil.beginTransaction();
        try {
           // dao.hazPersistente(hotel);
            Boolean existe =  dao.existeHotel("QWER89091");
            HibernateUtil.commitTransaction();

            assertTrue("El hotel no se encuentra registrado",existe);

        } catch (Exception e) {
            fail("El hotel no se encuentra registrado");
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    @Test
    public void testEliminarHotelE() throws Exception {

        HotelDAO dao = new HotelDAO();

        HibernateUtil.beginTransaction();
        try {
             dao.hazTransitorio("Y7U7IN");
            Hotel hotelB = dao.buscarHotelsPlaca("Y7U7IN");
            HibernateUtil.commitTransaction();

            assertTrue(hotelB == null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    @Test
    public void testEliminarHotelF() throws Exception {

        HotelDAO dao = new HotelDAO();

        HibernateUtil.beginTransaction();
        try {
             dao.hazTransitorio("ajuaolaja");
            Hotel hotelB = dao.buscarHotelsPlaca("ajuaolaja");
            HibernateUtil.commitTransaction();

            assertTrue(hotelB == null);

        } catch (Exception e) {
             fail("No se encontro el dato a eliminar");
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    @Test
    public void testOrdenarHotelsPorE() throws Exception {

        HotelDAO dao = new HotelDAO();
        Hotel hotel = new Hotel("Aaaa00000","automovil","1999","Peugeut","OIUP2U3","Blanco");
        HibernateUtil.beginTransaction();
        try {
             dao.hazPersistente(hotel);
            Collection resultado = dao.ordenarHotelsPor("curp","");
            HibernateUtil.commitTransaction();
            Hotel aux = (Hotel)resultado.iterator().next();
            assertTrue(aux.getCurp().equals("Aaaa00000"));

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
     @Test
    public void testOrdenarHotelsPorF() throws Exception {

        HotelDAO dao = new HotelDAO();
        //Hotel hotel = new Hotel("Aaaa00000","automovil","1999","Peugeut","OIUP2U3","Blanco");
        HibernateUtil.beginTransaction();
        try {
//             dao.hazPersistente(hotel);
            Collection resultado = dao.ordenarHotelsPor("auto","");
            HibernateUtil.commitTransaction();
            Hotel aux = (Hotel)resultado.iterator().next();
            assertTrue(aux.getCurp().equals("Aaaa00000"));

        } catch (Exception e) {
            fail("No se pudo ordenar porque la columna no existe");
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }






}
