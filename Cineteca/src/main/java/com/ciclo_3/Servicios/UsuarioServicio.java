package com.ciclo_3.Servicios;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ciclo_3.Peliculas.Usuario;

public class UsuarioServicio {
    //Atributos
    SessionFactory factory;
    
    public UsuarioServicio(){
        //CrearUsuario
    factory = new Configuration()
      .configure("cfg.xml")
      .addAnnotatedClass(Usuario.class)
      .buildSessionFactory();
    }

    public Session createSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }
        
    public List<Usuario> getList() throws Exception {
        Session session = createSession();
        List<Usuario> Usuario = session.createQuery("from Usuario", Usuario.class).list();
        session.close();
        return Usuario;
        }
    
    public Usuario readById(int id) throws Exception {
        Session session = createSession();
        Usuario Usuario = session.find(Usuario.class, id);
        session.close();
        return Usuario;
          }
    
    public List<Usuario> getByname(String nombre) throws Exception {
        Session session = createSession();
        List<Usuario> objusuario = session.createQuery("from usuario where nombre = :n", Usuario.class)
            .setParameter("n", nombre)
            .list();
        session.close();
        return objusuario;
          }
             
    
    public String create(Usuario Usuario) {
        String message = "";
        Session session = createSession();
        try {
            session.persist(Usuario);
            session.getTransaction().commit();
            message = "Usuario creada con éxito";
            } catch (Exception e) {
            message = e.getMessage();
            }
            session.close();
            return message;
        }
          
    public void update(Usuario usuario) throws Exception {
        Session session = createSession();
        // Realziar actualización en la BD
        session.merge(usuario);
        session.getTransaction().commit();
        session.close();
        }
          
    public String delete(int id) {
        Session session = createSession();
        Usuario usuario = session.find(Usuario.class, id);
        deleteService(usuario);
            return "Critica eliminada con éxito";
          }
          
    public List<String> objToString(List<Usuario> objusuario) {
           List<String> usuario = new ArrayList<>();
           for (int i = 0; i < objusuario.size(); i++) {
            usuario.add(objusuario.get(i).toString());
            }
            return usuario;
          }
          
    public void deleteService(Usuario usuario) {
        Session session = createSession();
        // Eliminar
        session.remove(usuario);
        session.getTransaction().commit();
          }
  }    
          

