package edu.navegacion.controlador;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

@Named(value = "navegacionRequest")
@Dependent
public class NavegacionRequest {

    public NavegacionRequest() {
    }

    private String redireccionTrue = "?faces-redirect=true";

    public String moverPagIndex() {
        return "index.xhtml" + redireccionTrue;
    }

    public String moverPagNosotros() {
        return "nosotros.xhtml" + redireccionTrue;
    }

    public String moverPagRegistroUsuario() {
        return "registroUsuario.xhtml" + redireccionTrue;
    }
    
    public String moverGrillaProductos(){
    return "Productos/ProductoG.xhtml" + redireccionTrue;
    }
    
    public String moverGrillaInventario(){
    return "Inventario/inventario.xhtml" + redireccionTrue;
    }
}
