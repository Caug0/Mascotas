package com.ciclo_3.Peliculas;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas")
public class Peliculas {
     // ATRIBUTOS
  @Id
  private int id;
  private String titulo;
  private int anno;
  private String director;
  private String protagonista;
  private String genero;
  private String critica;
  private int usuario_Id;

  // CONSTRUCTORES
  public Peliculas() {
  }

  public Peliculas(String titulo, String director, int anno, String genero, String protagonista, String critica, int usuario_Id) {
    this.titulo = titulo;
    this.director = director;
    this.anno= anno;
    this.genero= genero;
    this.protagonista = protagonista;
    this.critica = critica;
    this.usuario_Id= usuario_Id;
  }

  @Override
  public String toString() {
    String info = "----------------------------\n";
    info += "Id: " + id;
    info += "\nNombre: " + titulo;
    info += "\nDirector: " + director;
    info += "\nAnno: " + anno;  
    info += "\nGenero: " + genero;
    info += "\nProtagonista: " + protagonista;
    info += "\nCrítica: " + critica;
    info += "\nusuario_id: " + usuario_Id;

    info += "\n----------------------------\n";

    return info;
  }

  // CONSULTORES // GETTERS

  public String gettitulo() {
    return titulo;
  }

  public int getId() {
    return id;
  }
  public int getusuario_Id() {
    return usuario_Id;
  }

  public int getAnno() {
    return anno;
  }

  public String getGenero() {
    return genero;
  }

  public String getProtagonista() {
    return protagonista;
  }

  public String getCritica() {
    return critica;
  }

  public String getDirector() {
    return director;
  }

 

  // MODIFICADORES // SETTERS

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public void setAnno(int anno) {
    this.anno = anno;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public void setProtagonista(String protagonista) {
    this.protagonista = protagonista;
  }

  public void setCritica(String critica) {
    this.critica = critica;
  }


 
}
