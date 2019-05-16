package edu.navegacion.controlador;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "navigationRequest")
@RequestScoped

public class NavigationRequest {

    private String redireccionTrue = "?faces-redirect=true";
    
    public NavigationRequest() {
    }

    public String moverPagIndex(){
    return "index.xhtml" + redireccionTrue;
    }
    
    public String moverPagNosotros(){
    return "nosotros.xhtml" + redireccionTrue;
    }
    
    public String moverPagRegistroUsuario(){
    return "registroUsuario.xhtml" + redireccionTrue;
    }
    
   
}
