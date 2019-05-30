import conocimientos.*;
import hechos.*;

public class Main{

  public static void main(String[]args) throws Exception{

    String ruta = "datos-motor.txt";

    Analizador.analizadorArchivo(ruta);

    if(SistemaProduccion.getInstance().getMetodo().equals("ENCADENAMIENTO HACIA ADELANTE")){
      if(SistemaProduccion.getInstance().encadenamientoAdelante()) System.out.println("Exitoooooooooooooooooooo");
      else System.out.println("Tremendo errooooooooooooooooooor!");
    }else if(SistemaProduccion.getInstance().getMetodo().equals("ENCADENAMIENTO HACIA ATRAS")){
      System.out.println("Sorry for the inconvenience, this site  is being build :v");
    }





  }//Cierre main
}
