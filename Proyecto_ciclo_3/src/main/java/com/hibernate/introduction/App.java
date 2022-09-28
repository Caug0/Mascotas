package com.hibernate.introduction;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.introduction.modelo.Mascota;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //crear  objeto  frabicante de sesiones
        SessionFactory factory = new Configuration().configure("cfg.xml").addAnnotatedClass(Mascota.class).buildSessionFactory();
 
        //Abrir sesion
        Session sesssion= factory.openSession();

        //preparar la sesion para realizar  transaccion
        sesssion.beginTransaction();

        //generar transaccion
        try     {
            //CRUD

            //create
            Mascota mascota= new Mascota("leo", "garcia", "gato", "persa", 2, "ninguna");
            //guarda lo creado
            sesssion.persist(mascota);
            //hacer el commit
            sesssion.getTransaction().commit();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }


        //cerrar sesion
        sesssion.close();
    }
}
