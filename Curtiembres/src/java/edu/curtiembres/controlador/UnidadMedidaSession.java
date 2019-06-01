package edu.curtiembres.controlador;

import edu.curtiembres.conexionsql.UnidadMedidaDAL;
import edu.curtiembres.modelo.RespuestaSP;
import edu.curtiembres.modelo.UnidadMedida;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.primefaces.PrimeFaces;

@Named(value = "unidadMedidaSession")
@SessionScoped
public class UnidadMedidaSession implements Serializable {

    public UnidadMedidaSession() {
    }

    private List<UnidadMedida> lstUnidadMedida;
    private UnidadMedidaDAL objUnidadMedidaDAL = new UnidadMedidaDAL();
    private RespuestaSP objRespuestaSP = new RespuestaSP();
    private UnidadMedida objUnidadMedida = new UnidadMedida();
    private String disponible;
    private boolean isEdit = false;

    @PostConstruct
    public void init() {
        if (this.lstUnidadMedida == null) {
            try {
                consultar();
            } catch (Exception e) {
            }
        }
    }

    
    public List<UnidadMedida> getLstUnidadMedida() {
        return lstUnidadMedida;
    }

    public void setLstUnidadMedida(List<UnidadMedida> lstUnidadMedida) {
        this.lstUnidadMedida = lstUnidadMedida;
    }

    public UnidadMedidaDAL getObjUnidadMedidaDAL() {
        return objUnidadMedidaDAL;
    }

    public void setObjUnidadMedidaDAL(UnidadMedidaDAL objUnidadMedidaDAL) {
        this.objUnidadMedidaDAL = objUnidadMedidaDAL;
    }

    public RespuestaSP getObjRespuestaSP() {
        return objRespuestaSP;
    }

    public void setObjRespuestaSP(RespuestaSP objRespuestaSP) {
        this.objRespuestaSP = objRespuestaSP;
    }

    public UnidadMedida getObjUnidadMedida() {
        return objUnidadMedida;
    }

    public void setObjUnidadMedida(UnidadMedida objUnidadMedida) {
        this.objUnidadMedida = objUnidadMedida;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }
    
    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
    

    public void actualizar() throws SQLException {
        if (objUnidadMedida == null) {
            objRespuestaSP.setExito(false);
            objRespuestaSP.setMensaje("Complete todos los campos");

        } else {
            this.objUnidadMedida.setDisponible(this.disponible.equals("1") ? true : false);
            objRespuestaSP = objUnidadMedidaDAL.actualizarUnidadMedida(objUnidadMedida);
            consultar();
        }
        mensajesUsuario();
    }

    public void consultar() throws SQLException {
        lstUnidadMedida = new ArrayList<>();
        setLstUnidadMedida(objUnidadMedidaDAL.consultarUnidadMedida());
    }

    public void crear() throws SQLException {
        if (objUnidadMedida == null) {
            objRespuestaSP.setExito(false);
            objRespuestaSP.setMensaje("Complete los campos del formulario");
        } else {
            this.objUnidadMedida.setDisponible(this.disponible.equals("1") ? true : false);
            objRespuestaSP = objUnidadMedidaDAL.crearUnidadMedida(objUnidadMedida);
            consultar();
        }
        mensajesUsuario();
    }
    
    public void editar(UnidadMedida objUnidMed){
        setIsEdit(true);
        if(objUnidMed != null){
            objUnidadMedida.setCodigo(objUnidMed.getCodigo());
            objUnidadMedida.setDescripcion(objUnidMed.getDescripcion());
            this.setDisponible(objUnidMed.isDisponible()?"1":"2");
        PrimeFaces.current().executeScript("AbrirModal('')");
        }
    
    }

    public void eliminar(String codUnidadMedida) throws SQLException {
        objRespuestaSP = objUnidadMedidaDAL.eliminarUnidadMedida(codUnidadMedida);
        mensajesUsuario();
        consultar();
    }
    
    public void limpiar(){
    objUnidadMedida.setCodigo("");
    objUnidadMedida.setDescripcion("");
    this.setDisponible("1");
    
    }

    public void mensajesUsuario() {

        if (objRespuestaSP.isExito()) {
            PrimeFaces.current().executeScript("estadoOk('" + objRespuestaSP.getMensaje() + "')");
        } else {
            PrimeFaces.current().executeScript("estadoBad('" + objRespuestaSP.getMensaje() + "')");
        }
    }

    public void nuevo() throws SQLException {
        setIsEdit(false);
        PrimeFaces.current().executeScript("AbrirModal('')");
        limpiar();
    }


}
