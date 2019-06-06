package edu.curtiembres.controlador;

import edu.curtiembres.conexionsql.UsuarioDAL;
import edu.curtiembres.modelo.Permiso;
import edu.curtiembres.modelo.RespuestaSP;
import edu.curtiembres.modelo.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "usuarioSesion")
@SessionScoped
public class UsuarioSesion implements Serializable {

    private Usuario objUsuarioLogueado;
    private List<Permiso> lstPermisoLogin = new ArrayList<>();
    private String correo = "";
    private String contrasena = "";
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

    public Usuario getObjUsuarioLogueado() {
        return objUsuarioLogueado;
    }

    public void setObjUsuarioLogueado(Usuario objUsuarioLogueado) {
        this.objUsuarioLogueado = objUsuarioLogueado;
    }

    public List<Permiso> getLstPermisoLogin() {
        return lstPermisoLogin;
    }

    public void setLstPermisoLogin(List<Permiso> lstPermisoLogin) {
        this.lstPermisoLogin = lstPermisoLogin;
    }    
    
    public String VerificarUsuario() {
        try {
            objRespuestaSP = objUsuarioDAL.verificarUsuario(correo, contrasena);
            if (objRespuestaSP.isExito()) {
                setObjUsuarioLogueado(objUsuarioDAL.informacionUsuario(correo, contrasena));
                lstPermisoLogin = objUsuarioDAL.permisoPorUsuario(correo, contrasena);
                if (lstPermisoLogin != null) {
                     return "Usuario/pagRedireccion.xhtml?faces-redirect=true";
                } else {
                    return "";
                }
            } else {
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
    


}
