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

}
