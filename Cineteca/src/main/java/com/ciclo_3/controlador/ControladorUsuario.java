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

import com.ciclo_3.Peliculas.Usuario;
import com.ciclo_3.Servicios.UsuarioServicio;




@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {
    
  private UsuarioServicio servicio;

  public  ControladorUsuario (){
    this.servicio= new UsuarioServicio();
  }

    @GetMapping
    @CrossOrigin("*")
    public List<Usuario> getList() {
      List<Usuario> Usuario = new ArrayList<>();
      try {
        Usuario = servicio.getList();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return Usuario;
    }
  
    @GetMapping("/{id}")
    @CrossOrigin("*")
    public Usuario readById(@PathVariable(name = "id") int id) {
      Usuario Usuario = new Usuario();
      try {
        Usuario = servicio.readById(id);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return Usuario;
    }
  
    @GetMapping("/fullname")
    @CrossOrigin("*")
    public List<Usuario> getByLastname(@RequestParam String nombre) {
      List<Usuario> Usuario = new ArrayList<>();
      try {
        Usuario = servicio.getByname(nombre);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return Usuario;
    }
  
    @PostMapping
    @CrossOrigin("*")
    public String create(@RequestBody Usuario usuario) {
      return servicio.create(usuario);
    }
  
    @PutMapping
    @CrossOrigin("*")
    public String update(@RequestBody Usuario Usuario) {
      String message = "";
      try {
        servicio.update(Usuario);
        message = "usuario actualizada con éxito";
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

