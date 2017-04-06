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
        Hotel vehiculo = new Hotel("FOHJ960414HMCLRV09","automovil","2002","FORD","AHI98G","ROJO");

        HibernateUtil.beginTransaction();
        try {
            dao.hazPersistente(vehiculo);
            HibernateUtil.commitTransaction();

            assertTrue(vehiculo.getId() != null);
            assertTrue(vehiculo.getCurp().equals("FOHJ960414HMCLRV09"));
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
        Hotel vehiculo = new Hotel("FOHJ960414HMCLRV09","automovil","2002","FORD","AHI98G","ROJO");

        HibernateUtil.beginTransaction();
        try {
            dao.hazPersistente(vehiculo);
            HibernateUtil.commitTransaction();

            assertTrue(vehiculo.getId() != null);
            assertTrue(vehiculo.getCurp().equals("FOHJ960414HMCLRV09"));
        } catch (Exception e) {
            fail("El vehiculo ya se encuentra registrado");
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    @Test
    public void testActualizarHotelE() throws Exception {
        HotelDAO dao = new HotelDAO();
        Hotel vehiculo = new Hotel("SHJO960414HTCLRV08","automovil","2015","FORD","HOI89H","Azul");
        HibernateUtil.beginTransaction();
        try {
             dao.hazPersistenteP(vehiculo);
             Hotel vehiculoB = dao.buscarHotelsPlaca("HOI89H");
            HibernateUtil.commitTransaction();

            assertTrue(vehiculoB.getId() != null);
            assertTrue(vehiculoB.getColor().equals("Azul"));

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
        Hotel vehiculo = new Hotel("FOHJ960414HMCLRV09","automovil","2015","DODGE","AEH82J","Azul");
        HibernateUtil.beginTransaction();
        try {
             dao.hazPersistenteP(vehiculo);
             Hotel vehiculoB = dao.buscarHotelsPlaca("AEH82J");
            HibernateUtil.commitTransaction();

            assertTrue(vehiculoB.getId() != null);
            assertTrue(vehiculoB.getColor().equals("Azul"));

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
            //dao.hazPersistente(vehiculo);
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
        //Hotel vehiculo = new Hotel("ABHY991214JOYHRV09","automovil","1999","FORD","QWER82","Rojo");

        HibernateUtil.beginTransaction();
        try {
           // dao.hazPersistente(vehiculo);
            Boolean existe =  dao.existeHotel("QWER89091");
            HibernateUtil.commitTransaction();

            assertTrue("El vehiculo no se encuentra registrado",existe);

        } catch (Exception e) {
            fail("El vehiculo no se encuentra registrado");
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
            Hotel vehiculoB = dao.buscarHotelsPlaca("Y7U7IN");
            HibernateUtil.commitTransaction();

            assertTrue(vehiculoB == null);

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
            Hotel vehiculoB = dao.buscarHotelsPlaca("ajuaolaja");
            HibernateUtil.commitTransaction();

            assertTrue(vehiculoB == null);

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
        Hotel vehiculo = new Hotel("Aaaa00000","automovil","1999","Peugeut","OIUP2U3","Blanco");
        HibernateUtil.beginTransaction();
        try {
             dao.hazPersistente(vehiculo);
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
        //Hotel vehiculo = new Hotel("Aaaa00000","automovil","1999","Peugeut","OIUP2U3","Blanco");
        HibernateUtil.beginTransaction();
        try {
//             dao.hazPersistente(vehiculo);
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
