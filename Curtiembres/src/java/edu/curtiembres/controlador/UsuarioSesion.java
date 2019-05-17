package edu.curtiembres.controlador;

import edu.curtiembres.modelo.ManejoArchivos;
import edu.curtiembres.modelo.Permisos;
import edu.curtiembres.modelo.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

@Named(value = "usuarioSesion")
@SessionScoped
public class UsuarioSesion implements Serializable {

    private Usuario objUsuario;
    ManejoArchivos objArchivos = new ManejoArchivos();

    private String nombre = "";
    private String contrasena = "";
    private List<Permisos> lstPermiso = new ArrayList<>();

    public UsuarioSesion() {

    }

    public String VerificarUsuario() {
        objUsuario = objArchivos.VerificaUsuario(nombre, contrasena);
        if (objUsuario == null) // No encontro el usuario
        {
            return "";
        } else // Si encontro el usuario
        {
            lstPermiso = objArchivos.VerificarPermiso(objUsuario.getRol());
            return "nosotros.xhtml?faces-redirect=true";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Permisos> getLstPermiso() {
        return lstPermiso;
    }

    public void setLstPermiso(List<Permisos> lstPermiso) {
        this.lstPermiso = lstPermiso;
    }

    public Usuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(Usuario objUsuario) {
        this.objUsuario = objUsuario;
    }

    
}
