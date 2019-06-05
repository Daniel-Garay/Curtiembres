package edu.curtiembres.controlador;

import edu.curtiembres.conexionsql.ProductoDAL;
import edu.curtiembres.conexionsql.UnidadMedidaDAL;
import edu.curtiembres.modelo.Producto;
import edu.curtiembres.modelo.RespuestaSP;
import edu.curtiembres.modelo.UnidadMedida;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.annotation.PostConstruct;
import org.primefaces.PrimeFaces;

@Named(value = "productoSession")
@SessionScoped
public class ProductoSession implements Serializable {

    public ProductoSession() {
    }

    private List<Producto> lstProducto;
    private ProductoDAL objProductoDAL = new ProductoDAL();
    private UnidadMedidaDAL objUnidadMedidaDAL = new UnidadMedidaDAL();
    private RespuestaSP objrtaSP = new RespuestaSP();
    private Producto objProducto = new Producto();
    private List<UnidadMedida> lstUnidadMedida;
    private String activo;

    @PostConstruct
    public void init() {
        if (this.lstProducto == null) {
            try {
                consultar();
            } catch (Exception e) {
            }
        }
    }

    public List<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

    public ProductoDAL getObjProductoDAL() {
        return objProductoDAL;
    }

    public void setObjProductoDAL(ProductoDAL objProductoDAL) {
        this.objProductoDAL = objProductoDAL;
    }

    public Producto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(Producto objProducto) {
        this.objProducto = objProducto;
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

    public RespuestaSP getObjrtaSP() {
        return objrtaSP;
    }

    public void setObjrtaSP(RespuestaSP objrtaSP) {
        this.objrtaSP = objrtaSP;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public void consultar() throws SQLException {
        lstProducto = new ArrayList<>();
        setLstProducto(objProductoDAL.consultarProducto());
    }

    public void consultarUnidadMedida() throws SQLException {
        lstUnidadMedida = new ArrayList<>();
        setLstUnidadMedida(objUnidadMedidaDAL.consultarUnidadMedida());

    }

    public void eliminar(int codigo) throws SQLException {
       objrtaSP = objProductoDAL.eliminarProducto(codigo);
        if (objrtaSP.isExito()) {
            mensajesUsuario();
            consultar();
        } else {
            PrimeFaces.current().executeScript("estadoFK()");
        }
    }

    public void mensajesUsuario() {

        if (objrtaSP.isExito()) {
            PrimeFaces.current().executeScript("estadoOk('" + objrtaSP.getMensaje() + "')");
        } else {
            PrimeFaces.current().executeScript("estadoBad('" + objrtaSP.getMensaje() + "')");
        }
    }

    public void crear() throws SQLException {
        if (!validarProducto()) {
            objrtaSP.setExito(false);
            objrtaSP.setMensaje("Complete todos los campos del formulario");
        } else {
            this.objProducto.setActivo(this.activo.equals("1") ? true : false);
            objrtaSP = objProductoDAL.crearProducto(objProducto);
            consultar();
        }
        mensajesUsuario();
    }

    public boolean validarProducto() {
        boolean valido = true;
        if (objProducto.getDescripcion().equals("") || objProducto.getCodUnidadMedida().equals("0")) {
            valido = false;
        }
        return valido;
    }

    public void nuevo() throws SQLException {
        consultarUnidadMedida();
        PrimeFaces.current().executeScript("AbrirModal('')");
    }

}
