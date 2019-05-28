
package edu.curtiembres.modelo;

public class Inventario {
    
    private int codigoProducto;
    private String descripcion;
    private int cantidadDisponible;
    private boolean activo;

    public Inventario() {
    }

    public Inventario(int codigoProducto, String descripcion, int cantidadDisponible, boolean activo) {
        this.codigoProducto = codigoProducto;
        this.descripcion = descripcion;
        this.cantidadDisponible = cantidadDisponible;
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivodescripion(boolean activo) {
        this.activo = activo;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    
    
    
    
}
