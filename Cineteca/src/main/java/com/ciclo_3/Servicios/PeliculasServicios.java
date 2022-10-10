package com.ciclo_3.Servicios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ciclo_3.Peliculas.Peliculas;


public class PeliculasServicios {
// ATRIBUTOS
SessionFactory factory;

public PeliculasServicios() {
  // Crear objeto fabricante de sesiones
  factory = new Configuration()
      .configure("cfg.xml")
      .addAnnotatedClass(Peliculas.class)
      .buildSessionFactory();
}

public Session createSession() {
  Session session = factory.openSession();
  session.beginTransaction();
  return session;
}

public List<Peliculas> getList() throws Exception {
  Session session = createSession();
  List<Peliculas> Peliculas = session.createQuery("from Peliculas", Peliculas.class).list();
  session.close();
  return Peliculas;
}

public Peliculas readById(int id) throws Exception {
  Session session = createSession();
  Peliculas Peliculas = session.find(Peliculas.class, id);
  session.close();
  return Peliculas;
}

public List<Peliculas> getusuario_Id(int usuario_Id) throws Exception {
  Session session = createSession();
  List<Peliculas> objPelicula = session.createQuery("from Peliculas where usuario_Id = :n", Peliculas.class)
      .setParameter("n", usuario_Id)
      .list();
  session.close();

  return objPelicula;
}

public String create(Peliculas Pelicula) {
  String message = "";
  Session session = createSession();
  try {
    session.persist(Pelicula);
    session.getTransaction().commit();
    message = "Critica de pelicula creada con éxito";
  } catch (Exception e) {
    message = e.getMessage();
  }
  session.close();
  return message;
}

public void update(Peliculas Pelicula) throws Exception {
  Session session = createSession();
  // Realziar actualización en la BD
  session.merge(Pelicula);
  session.getTransaction().commit();
  session.close();
}

public String delete(int id) {
  Session session = createSession();
  Peliculas Pelicula = session.find(Peliculas.class, id);
  deleteService(Pelicula);
  return "Critica eliminada con éxito";
}

public List<String> objToString(List<Peliculas> objPeliculas) {
  List<String> Peliculas = new ArrayList<>();
  for (int i = 0; i < objPeliculas.size(); i++) {
    Peliculas.add(objPeliculas.get(i).toString());
  }
  return Peliculas;
}

public void deleteService(Peliculas Pelicula) {
  Session session = createSession();
  // Eliminar
  session.remove(Pelicula);
  session.getTransaction().commit();
}
}    

