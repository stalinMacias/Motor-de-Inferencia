import java.io.*;
import java.util.Scanner;

import conocimientos.BaseConocimientos;   //Importar la clase Base Conocimientos del paquete baseConocimientos
import hechos.BaseHechos;                 //Importar la clase Base Hechos del paquete baseHechos


public class Analizador{

  public static void analizadorArchivo(String ruta) throws IOException {
    BufferedReader bf;
    try {
      bf = new BufferedReader(new FileReader(new File(ruta)));
    } catch(Exception e) {
      return;
    }

    String st;
    Scanner s;
    while ((st = bf.readLine()) != null) {
        if(st.trim().length() == 0) continue;
        if(st.contains("#")) continue; // '#'Comentarios en el archivo de texto!

        s = new Scanner(st); // Analiza la linea actual del archivo

        String aux = "";
        switch (s.next()) {
          case "REGLAS": // Analiza todas las reglas del archivo hasta que encuentra el } de cierre!
            while (((st = bf.readLine()) != null) && (!st.equals("}")) ) {
              if(st.contains("#")) continue; // '#'Comentarios en el archivo de texto!
              aux += st;
            }
            for (String regla: aux.split(",")) { // Agrega las Reglas a la Base de Conocimientos
              BaseConocimientos.getInstance().addRegla(regla);
            }
            break;

          case "HECHOS": // Analiza todas las reglas del archivo hasta que encuentra el } de cierre!
            while (((st = bf.readLine()) != null) && (!st.equals("}")) ) {
              if(st.contains("#")) continue; // '#'Comentarios en el archivo de texto!
              aux += st;
            }
            for (String hecho: aux.split(",")) { // Agrega los Hechos a la Base de Hechos
              BaseHechos.getInstance().addHecho(hecho);
            }
            break;

          case "META": //Analiza la meta del archivo hasta que encuentra el } de cierre!
            while (((st = bf.readLine()) != null) && (!st.equals("}")) ) {
              if(st.contains("#")) continue; // '#'Comentarios en el archivo de texto!
              aux += st;
            }
            SistemaProduccion.getInstance().setMeta(aux);
            break;

          case "METODO": //Analiza el metodo por el cual trabajara el motor de inferencia
            while (((st = bf.readLine()) != null) && (!st.equals("}")) ) {
              if(st.contains("#")) continue; // '#'Comentarios en el archivo de texto!
              aux += st;
            }
            SistemaProduccion.getInstance().setMetodo(aux);
            break;
        }
    }
  }//Cierre metodo analizadorArchivo

}
