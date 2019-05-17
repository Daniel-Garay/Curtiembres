
package edu.curtiembres.modelo;

public class Permisos {
    
    private String id;
    private String permiso;

    public Permisos() {
    }

    public Permisos(String id, String permiso) {
        this.id = id;
        this.permiso = permiso;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
     
    
}
