import conocimientos.*;
import hechos.*;

public class Main{

  public static void main(String[]args) throws Exception{

    String ruta = "datos-motor.txt";

    Analizador.analizadorArchivo(ruta);

    System.out.println("\nSe utilizara el metodo: "+SistemaProduccion.getInstance().getMetodo());

    System.out.println("\nBase de Conocimientos");
    for(Regla r:BaseConocimientos.getInstance().getReglas())  System.out.println(r.toString());

    System.out.println("\nBase de Hechos");
    for(Hecho h:BaseHechos.getInstance().getHechos()) System.out.print(h.getNombre()+",");
    
    System.out.print("\n");
    System.out.println("\nLa meta es: "+SistemaProduccion.getInstance().getMeta());

    if(SistemaProduccion.getInstance().getMetodo().equals("ENCADENAMIENTO HACIA ADELANTE")){
      System.out.println("Si jala esta madre");
    }else if(SistemaProduccion.getInstance().getMetodo().equals("ENCADENAMIENTO HACIA ATRAS")){
      System.out.println("Tambien esta otra xD!");
    }





  }//Cierre main
}
