package com.ciclo_3.Peliculas;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario") 
public class Usuario {
    @Id
    private int Id;
    private String user;
    private String nombre;
    private String password;


//Constructor
public Usuario() {
}

public Usuario (String user, String nombre, String password){
    this.user = user;
    this.nombre = nombre;
    this.password = password;    
    }

@Override
  public String toString() {
    String info = "----------------------------\n";
    info += "Id: " + Id;
    info += "\nUsuario: " + user;
    info += "\nNombre: " + nombre;
    info += "\nContraseña: " + password;
    info += "\n----------------------------\n";

    return info;
  }


    public int getId(){
    return Id;
    }

   public String getUser() {
    return user;
}

public String getNombre() {
    return nombre;
}

public String getPassword() {
    return password;
}


public void setUser(String user) {
    this.user = user;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}
public void setPassword(String password) {
    this.password = password;
}


}
