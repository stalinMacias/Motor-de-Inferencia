package hechos;

public class Hecho{
  private String nombre;

  public Hecho(String nombre){
      this.nombre = nombre.trim();
  }

  public void setNombre(String nombre){
    this.nombre = nombre.trim();
  }
  public String getNombre(){
    return this.nombre;
  }

}
