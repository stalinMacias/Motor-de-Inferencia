package conocimientos;

import java.util.ArrayList;

public class BaseConocimientos{

  private ArrayList<Regla> reglas;
  private static BaseConocimientos baseConocimientos;

  public BaseConocimientos(){
    reglas = new ArrayList<Regla>();
  }

  public static BaseConocimientos getInstance(){
    if(baseConocimientos == null) baseConocimientos= new BaseConocimientos();
    return baseConocimientos;
  }

  public void addRegla(Regla regla){
    baseConocimientos.reglas.add(regla);
  }

  public void addRegla(String cad){
    baseConocimientos.reglas.add(new Regla(cad));
  }

  public void printReglas(){
    for(Regla r:this.reglas) System.out.println(r);
  }

  public ArrayList<Regla> getReglas(){
    return this.reglas;
  }

}
