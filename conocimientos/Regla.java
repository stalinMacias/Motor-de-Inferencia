package conocimientos;

import hechos.*;

public class Regla{
  private String condicion;
  private String accion;
  private boolean disparada;
  private int numeroRegla;
  private static int cont;

  /**
    @param cadena --> Recibe una regla de la Base de Conocimientos y se encarga de separarla en condicion y accion.
                      *La condicion se refiere al conjunto de hechos que se deben de cumplir para que la accion pueda ser disparada
                      ** Ejemplo :
                                  *** A and C or D --> F
                                  *** A and C or D viene a ser la condicion y F es la acción que se dipararía si la condicion se puede cumplir!
  */
  public Regla(String cadena){
    String separacion[] = cadena.split("-->");
    this.condicion = separacion[0].trim();
    this.accion = separacion[1].trim();
    this.disparada = false;
    this.numeroRegla = ++cont;
  }

  //Metodo toString para devolver la regla con la siguiente estructura:
  //Ejemplo
  //R1: A and C --> X
  @Override
  public String toString(){
    return "R"+getNumeroRegla()+": "+getCondicion()+" --> "+getAccion();
  }

  public static boolean analizarRegla(String condicion){
    java.util.Scanner s = new java.util.Scanner(condicion); //Meter en un Scanner el String de la condicion para poder manipularla!

    boolean existeToken1 = BaseHechos.getInstance().getHecho(s.next()) == null ? false : true;

    //Revisar si la condicion tiene mas hechos!
    if(!s.hasNext()) return existeToken1;

    String operador = s.next();

    boolean existeToken2 = BaseHechos.getInstance().getHecho(s.next()) == null ? false : true;

    //Determinar si se obtiene un true o false con cada 2 hechos y su respectivo operador!
    boolean resultado = false;

    switch(operador.toUpperCase()){
      case "AND":
        resultado = existeToken1 && existeToken2;
        break;
      case "OR":
        resultado = existeToken1 || existeToken2;
        break;
    }

    //Recursividad por si el la condicion tiene mas de 2 hechos
    if(s.hasNext()) resultado = analizarRegla(resultado + " " + s.nextLine());  //Con s.nextLine() el Scanner continua analizando donde se quedo!

    return resultado;
  }//Cierre metodo analizarRegla

  public String getCondicion(){
    return this.condicion;
  }
  public void setCondicion(String condicion){
    this.condicion = condicion;
  }

  public String getAccion(){
    return this.accion;
  }
  public void setAccion(String accion){
    this.accion = accion;
  }

  public boolean getDisparada(){
    return this.disparada;
  }
  public void setDisparada(boolean disparada){
    this.disparada = disparada;
  }

  public int getNumeroRegla(){
    return this.numeroRegla;
  }

}
