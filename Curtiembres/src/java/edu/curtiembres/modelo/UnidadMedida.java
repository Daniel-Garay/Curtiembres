
package edu.curtiembres.modelo;

public class UnidadMedida {
    
   private String Codigo;
   private String Descripcion;	
   private boolean Disponible;

    public UnidadMedida() {
    }

    public UnidadMedida(String Codigo, String Descripcion, boolean Disponible) {
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;
        this.Disponible = Disponible;
    }

    public boolean isDisponible() {
        return Disponible;
    }

    public void setDisponible(boolean Disponible) {
        this.Disponible = Disponible;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
   
   
    
}
