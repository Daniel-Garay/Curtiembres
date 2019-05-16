package edu.curtiembres.controlador;

import edu.curtiembres.modelo.ManejoArchivos;
import edu.curtiembres.modelo.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

@Named(value = "usuarioSesion")
@SessionScoped
public class UsuarioSesion implements Serializable {

    private Usuario objUsuario;
    ManejoArchivos objArchivos = new ManejoArchivos();

    private String nombre = "";
    private String contrasena = "";

    public UsuarioSesion() {

    }

    public void VerificarUsuario() {
        objUsuario = objArchivos.VerificaUsuario(nombre, contrasena);
        if (objUsuario == null) // No encontro el usuario
        {

        } else // Si encontro el usuario
        {

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

}
