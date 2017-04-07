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

public class CriticaDAOTest extends TestCase{

    
    public void testCrearCriticaE() throws Exception {
        CriticaDAO dao = new CriticaDAO();

        Critica Critica = new Critica(
            "001", 
            "001",
            "001",
            "001"
        );

        HibernateUtil.beginTransaction();
        try {
            dao.hazPersistente(Critica);
            HibernateUtil.commitTransaction();

            assertTrue(Critica.getId() != null);
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    
    public void testCrearCriticaF() throws Exception {
        //Falla porque la placa esta en BD
        CriticaDAO dao = new CriticaDAO();
        Critica Critica = new Critica(
            "001", 
            "001",
            "001",
            "001"
        );

        HibernateUtil.beginTransaction();
        try {
            dao.hazPersistente(Critica);
            HibernateUtil.commitTransaction();

            assertTrue(Critica.getId() != null);
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    
    public void testActualizarCriticaE() throws Exception {
        CriticaDAO dao = new CriticaDAO();
        Critica Critica = new Critica(
            "001", 
            "001",
            "001",
            "001"
        );
        HibernateUtil.beginTransaction();
        try {
             dao.hazPersistente(Critica);
             Critica CriticaB = dao.buscarPorId(Long.valueOf(1), true);
            HibernateUtil.commitTransaction();

            assertTrue(CriticaB.getId() != null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testActualizarCriticaF() throws Exception {
        //Falla porque la placa no se puede actualizar
        CriticaDAO dao = new CriticaDAO();
        Critica Critica = new Critica(
            "001", 
            "001",
            "001",
            "001"
        );
        HibernateUtil.beginTransaction();
        try {
             dao.hazPersistente(Critica);
             Critica CriticaB = dao.buscarPorId(Long.valueOf(1), true);
            HibernateUtil.commitTransaction();

            assertTrue(CriticaB.getId() != null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    
    public void testBuscarTodosE() throws Exception {

        CriticaDAO dao = new CriticaDAO();

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

        CriticaDAO dao = new CriticaDAO();

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


    
    public void testExisteCriticaE() throws Exception {

        CriticaDAO dao = new CriticaDAO();

        HibernateUtil.beginTransaction();
        try {
            //dao.hazPersistente(Critica);
            Boolean existe =  dao.existeCritica("001");
            HibernateUtil.commitTransaction();

            assertTrue(existe);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testExisteCriticaF() throws Exception {

        CriticaDAO dao = new CriticaDAO();
        HibernateUtil.beginTransaction();
        try {
            Boolean existe =  dao.existeCritica("002");
            HibernateUtil.commitTransaction();

            assertTrue("El Critica no se encuentra registrado",existe);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testEliminarCriticaE() throws Exception {

        CriticaDAO dao = new CriticaDAO();
        Critica CriticaB = dao.buscarPorId(Long.valueOf(1), true);

        HibernateUtil.beginTransaction();
        try {
             dao.hazTransitorio(CriticaB);
            CriticaB = dao.buscarPorId(Long.valueOf(1), true);

            HibernateUtil.commitTransaction();

            assertTrue(CriticaB == null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testEliminarCriticaF() throws Exception {

        CriticaDAO dao = new CriticaDAO();
        Critica CriticaB = dao.buscarPorId(Long.valueOf(1), true);

        HibernateUtil.beginTransaction();
        try {
             dao.hazTransitorio(CriticaB);
            CriticaB = dao.buscarPorId(Long.valueOf(1), true);
            HibernateUtil.commitTransaction();

            assertTrue(CriticaB == null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testordenarCriticaesPorE() throws Exception {

        CriticaDAO dao = new CriticaDAO();
        Critica Critica = new Critica(
            "001", 
            "001",
            "001",
            "001"
        );
        HibernateUtil.beginTransaction();
        try {
             dao.hazPersistente(Critica);
            Collection resultado = dao.ordenarCriticaesPor("nombre");
            HibernateUtil.commitTransaction();
            Critica aux = (Critica)resultado.iterator().next();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testordenarCriticaesPorF() throws Exception {

        CriticaDAO dao = new CriticaDAO();
        //Critica Critica = new Critica("Aaaa00000","automovil","1999","Peugeut","OIUP2U3","Blanco");
        HibernateUtil.beginTransaction();
        try {
//             dao.hazPersistente(Critica);
            Collection resultado = dao.ordenarCriticaesPor("nombre");
            HibernateUtil.commitTransaction();
            Critica aux = (Critica)resultado.iterator().next();

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
