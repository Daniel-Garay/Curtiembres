
package edu.curtiembres.modelo;

public class Producto {
    
    private int codigo;	
    private String descripcion;	
    private boolean activo;	
    private String codUnidadMedida;

    public Producto() {
    }

    public Producto(int codigo, String descripcion, boolean activo, String codUnidadMedida) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.activo = activo;
        this.codUnidadMedida = codUnidadMedida;
    }

    public String getCodUnidadMedida() {
        return codUnidadMedida;
    }

    public void setCodUnidadMedida(String codUnidadMedida) {
        this.codUnidadMedida = codUnidadMedida;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
