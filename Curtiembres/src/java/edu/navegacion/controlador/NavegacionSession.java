/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.navegacion.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Daniel
 */
@Named(value = "navegacionSession")
@SessionScoped
public class NavegacionSession implements Serializable {

    /**
     * Creates a new instance of NavegacionSession
     */
    public NavegacionSession() {
    }
    
    private String redireccionTrue = "?faces-redirect=true";
    //String ruta=FacesContext.getCurrentInstance().getExternalContext().getRealPath("");

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
    return "/Producto/producto.xhtml" + redireccionTrue;
    }
    
    public String moverGrillaInventario(){
    return "/Inventario/inventario.xhtml" + redireccionTrue;
    }
    
}
