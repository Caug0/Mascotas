package com.ciclo_3.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ciclo_3.Peliculas.Peliculas;
import com.ciclo_3.Servicios.PeliculasServicios;




@RestController
@RequestMapping("/peliculas")
public class controlador {
    
    private PeliculasServicios servicio;

    public controlador() {
      this.servicio = new PeliculasServicios();
    }
  
    @GetMapping
    @CrossOrigin("*")
    public List<Peliculas> getList() {
      List<Peliculas> peliculas = new ArrayList<>();
      try {
        peliculas = servicio.getList();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return peliculas;
    }
  
    @GetMapping("/{id}")
    @CrossOrigin("*")
    public Peliculas readById(@PathVariable(name = "id") int id) {
      Peliculas pelicula = new Peliculas();
      try {
        pelicula = servicio.readById(id);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return pelicula;
    }
  
    @GetMapping("/fullname")
    @CrossOrigin("*")
    public List<Peliculas> getusuario_Id(@RequestParam int usuario_Id) {
      List<Peliculas> peliculas = new ArrayList<>();
      try {
        peliculas = servicio.getusuario_Id(usuario_Id);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return peliculas;
    }


  
    @PostMapping
    @CrossOrigin("*")
    public String create(@RequestBody Peliculas pelicula) {
      return servicio.create(pelicula);
    }
  
    @PutMapping
    @CrossOrigin("*")
    public String update(@RequestBody Peliculas pelicula) {
      String message = "";
      try {
        servicio.update(pelicula);
        message = "Critica actualizada con éxito";
      } catch (Exception e) {
        message = e.getMessage();
      }
      return message;
    }
  
    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    public String delete(@PathVariable(name = "id") int id) {
      return servicio.delete(id);
    }
  
  }
