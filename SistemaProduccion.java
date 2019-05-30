import conocimientos.*;
import hechos.*;
import java.util.ArrayList;

public class SistemaProduccion{
  private String meta;
  private String metodo;
  private static SistemaProduccion sistemaProduccion;

  public SistemaProduccion(){}

  public static SistemaProduccion getInstance(){
    if(sistemaProduccion == null) sistemaProduccion = new SistemaProduccion();
    return sistemaProduccion;
  }

  public String getMeta(){
    return this.meta;
  }
  public void setMeta(String meta){
    this.meta = meta.replaceAll("^\\s*","");
  }

  public String getMetodo(){
    return this.metodo;
  }
  public void setMetodo(String metodo){
    this.metodo = metodo.replaceAll("^\\s*","");
  }


  public boolean encadenamientoAdelante(){

    imprimirCabeceraEncadenamientoAdelante();

    ArrayList<Regla> CC = new ArrayList<Regla>();  //Conjunto Conflicto!
    CC = equipararAdelante(CC);

    while((BaseHechos.getInstance().getHecho(meta) == null) && (!CC.isEmpty())){

      tableCell(iterationCC(CC), 19);
      tableCell(iterationBH(), 21);

      CC = resolverAdelante(CC);

      tableCell(meta, 6);
      System.out.println("|");

      if(BaseHechos.getInstance().getHecho(meta) == null) CC.addAll(equipararAdelante(CC)); //Todas las nuevas reglas que se agregen al CC se agregaran despues de las que ya contiene actualmente!
      else {
        finTabla();
        return true;
      }
    }
    //Si el metodo devuleve un false es que no se pudo llegar a la meta!
    return false;
  }


  public ArrayList<Regla> equipararAdelante(ArrayList<Regla> CC){
    ArrayList<Regla> auxEquiparamiento = new ArrayList<Regla>();

    for(Regla r: BaseConocimientos.getInstance().getReglas()){
      if(!CC.contains(r) && !r.getDisparada()) {
        if(r.analizarRegla(r.getCondicion())) auxEquiparamiento.add(r);
      }
    }

    return auxEquiparamiento;
  }//Cierre equipararAdelante


  public ArrayList<Regla> resolverAdelante(ArrayList<Regla> CC){
    Regla reglaParaDisparar = CC.get(0);
    BaseHechos.getInstance().addHecho(reglaParaDisparar.getAccion()); //Agregar el NH a la BH...
    reglaParaDisparar.setDisparada(true);
    tableCell("R"+reglaParaDisparar.getNumeroRegla(),6);
    tableCell(reglaParaDisparar.getAccion(),7);

    CC.remove(0);

    return CC;
  }//Cierre resolverAdelante

  private void imprimirCabeceraEncadenamientoAdelante(){
    System.out.println("\nSe utilizara el metodo: Encadenamiento Hacia Adelante");

    System.out.println("\n    Base de Conocimientos   ");
    for(Regla r:BaseConocimientos.getInstance().getReglas())  System.out.println(r.toString());

    System.out.println("\n    Base de Hechos Inicial   ");
    System.out.print("{");
    for(Hecho h:BaseHechos.getInstance().getHechos()) System.out.print(h.getNombre()+",");
    System.out.print("}");

    System.out.println();
    System.out.println("\nLa meta es: "+meta);

    System.out.println(" ------------------------------------------------------------");
    System.out.println("| CC                | BH                  | R    | NH    | META |");
    System.out.println(" ------------------------------------------------------------");
  }

  private void tableCell(String cad, int w) {
    System.out.print("| ");
    while(cad.length() < w-1) {
      cad += " ";
    }
    System.out.print(cad);
  }

  private String iterationCC(ArrayList<Regla> CC) {
    String ret = "{";
    for (Regla r: CC) {
      ret += "R"+r.getNumeroRegla()+", ";
    }
    return ret.substring(0, ret.length()-2) + "}";
  }

  private String iterationBH() {
    String ret = "{";
    for (Hecho f: BaseHechos.getInstance().getHechos()) {
      ret += f.getNombre()+", ";
    }
    return ret.substring(0, ret.length()-2) + "}";
  }

  private void finTabla(){
    System.out.println(" ------------------------------------------------------------");
  }

}
