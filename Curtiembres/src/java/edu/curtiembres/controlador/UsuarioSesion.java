package edu.curtiembres.controlador;

import edu.curtiembres.conexionsql.UsuarioDAL;
import edu.curtiembres.modelo.ManejoArchivos;
import edu.curtiembres.modelo.Permisos;
import edu.curtiembres.modelo.RespuestaSP;
import edu.curtiembres.modelo.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "usuarioSesion")
@SessionScoped
public class UsuarioSesion implements Serializable {

    private Usuario objUsuarioLogueado;
    ManejoArchivos objArchivos = new ManejoArchivos();

    private String correo = "";
    private String contrasena = "";
    private List<Permisos> lstPermiso = new ArrayList<>();
    private UsuarioDAL objUsuarioDAL = new UsuarioDAL();
    RespuestaSP objRespuestaSP = new RespuestaSP();

    public UsuarioSesion() {

    }

    public UsuarioDAL getObjUsuarioDAL() {
        return objUsuarioDAL;
    }

    public void setObjUsuarioDAL(UsuarioDAL objUsuarioDAL) {
        this.objUsuarioDAL = objUsuarioDAL;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

       public Usuario getObjUsuarioLogueado() {
        return objUsuarioLogueado;
    }

    public void setObjUsuarioLogueado(Usuario objUsuarioLogueado) {
        this.objUsuarioLogueado = objUsuarioLogueado;
    }


    public String VerificarUsuario() {
        /*objUsuario = objArchivos.VerificaUsuario(nombre, contrasena);*/
        try {
            objRespuestaSP = objUsuarioDAL.verificarUsuario(correo, contrasena);
            if (objRespuestaSP.isExito()) {
                  setObjUsuarioLogueado(objUsuarioDAL.informacionUsuario(correo, contrasena));
               return "Usuario/pagRedireccion.xhtml?faces-redirect=true";
            } else 
            {
                //lstPermiso = objArchivos.VerificarPermiso(objUsuario.getRol());
                return "";
            }

        } catch (Exception e) {
            return "";
        }

    }
    
    

    public String cerrarSesion() {
               
        this.objUsuarioLogueado = null;
        return "/index.xhtml?faces-redirect=true";
    }

    public void validarCamposText() {

    }


}
