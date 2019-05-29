package hechos;

import java.util.ArrayList;

public class BaseHechos{
  private ArrayList<Hecho> hechos;
  private static BaseHechos baseHechos;

  public BaseHechos(){
    hechos = new ArrayList<Hecho>();
  }

  public static BaseHechos getInstance(){
    if(baseHechos == null)  baseHechos = new BaseHechos();
    return baseHechos;
  }

  //Agregar un hecho al ArrayList de hechos
  public void addHecho(Hecho hecho){
    this.hechos.add(hecho);
  }
  //Agregar un hecho al ArrayList pero recibiendo como parametro una cadena! Primero crea el hecho y despues agerga dicho hecho creado!
  public void addHecho(String cad){
    this.hechos.add(new Hecho(cad));
  }

  //Realiza la busqueda de un hecho en la lista de hechos y si existe lo devuelve, de lo contrario devuelve un null
  public Hecho getHecho(String nombre){
    for(Hecho h: this.hechos){
      if(h.getNombre().equals(nombre)) return h;
    }
    return null;
  }

  //Imprimir los hechos
  public void printHechos(){
    for(Hecho h:this.hechos) System.out.println(h);
  }

  //Obtener toda la lista de hechos
  public ArrayList<Hecho> getHechos(){
    return this.hechos;
  }

}
