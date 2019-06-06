package edu.curtiembres.modelo;

public class Usuario {

     private int codigo;
     private String tipoDocumento;
     private int documento;
     private String nombre;
     private String apellido;
     private String email;
     private String contrasena;
     private Boolean activo;
     private String imgUsuario;
     private boolean lsAuthenticated;

    public Usuario() {
    }

    public Usuario(int codigo, String tipoDocumento, int documento, String nombre, String apellido, String email, String contrasena, Boolean activo, String imgUsuario, boolean lsAuthenticated) {
        this.codigo = codigo;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.activo = activo;
        this.imgUsuario = imgUsuario;
        this.lsAuthenticated = lsAuthenticated;
    }

    

    public boolean isLsAuthenticated() {
        return lsAuthenticated;
    }

    public void setLsAuthenticated(boolean lsAuthenticated) {
        this.lsAuthenticated = lsAuthenticated;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getImgUsuario() {
        return imgUsuario;
    }

    public void setImgUsuario(String imgUsuario) {
        this.imgUsuario = imgUsuario;
    }

    
}
