
package edu.curtiembres.controlador;

import edu.curtiembres.conexionsql.InventarioDAL;
import edu.curtiembres.modelo.Inventario;
import edu.curtiembres.modelo.ProductoOutInventario;
import edu.curtiembres.modelo.RespuestaSP;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Daniel
 */
@Named(value = "inventarioSesion")
@SessionScoped
public class InventarioSesion implements Serializable {

    public InventarioSesion() {
    }

    private List<Inventario> lstInvetario;
    private List<ProductoOutInventario> lstProdOutInv;
    InventarioDAL objProcedimiento = new InventarioDAL();
    RespuestaSP objResp = new RespuestaSP();
    private Inventario objInventario = new Inventario();
    private String activo;
    private boolean visible = true;

    @PostConstruct
    public void init() {
        if (this.lstInvetario == null) {
            try {
                Consultar();
            } catch (Exception e) {
            }
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public List<Inventario> getLstInvetario() {
        return lstInvetario;
    }

    public void setLstInvetario(List<Inventario> lstInvetario) {
        this.lstInvetario = lstInvetario;
    }

    public Inventario getObjInventario() {
        return objInventario;
    }

    public void setObjInventario(Inventario objInventario) {
        this.objInventario = objInventario;
    }

    public List<ProductoOutInventario> getLstProdOutInv() {
        return lstProdOutInv;
    }

    public void setLstProdOutInv(List<ProductoOutInventario> lstProdOutInv) {
        this.lstProdOutInv = lstProdOutInv;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public void actualizar() throws SQLException  {
        if (this.objInventario == null) {
           objResp.setExito(false);
            objResp.setMensaje("Complete los campos del formulario");

        } else {
              this.objInventario.setActivo(this.activo.equals("1") ? true : false);
           
            objResp = objProcedimiento.actualizarInventario(objInventario);
            Consultar();
        }
        mensajesUsuario();
    }

    public void Consultar() throws SQLException {
        lstInvetario = new ArrayList<>();
        setLstInvetario(objProcedimiento.ConsultarInventario());
    }

    public void consultarProdOutInv() throws SQLException {
        lstProdOutInv = new ArrayList<>();
        setLstProdOutInv(objProcedimiento.consultarProductoOutInventario());
    }

    public void crear() throws SQLException {
        if (this.objInventario == null) {
            objResp.setExito(false);
            objResp.setMensaje("Complete los campos del formulario");

        } else {
            this.objInventario.setActivo(this.activo.equals("1") ? true : false);
            
            objResp = objProcedimiento.CrearInventario(objInventario);
            Consultar();
        }
        mensajesUsuario();
    }
    
    public void asignarValoresModal(int codProducto, int cantDisponible, String activo){
     this.objInventario.setCodigoProducto(codProducto);
     this.objInventario.setCantidadDisponible(cantDisponible);
     this.setActivo(activo);
    }

    public void Editar(Inventario inv) throws SQLException {
        ProductoOutInventario objProdOut = new ProductoOutInventario();
        objProdOut.setCodigo(inv.getCodigoProducto());
        objProdOut.setDescripcion(inv.getDescripcion());
        asignarValoresModal(inv.getCodigoProducto(),inv.getCantidadDisponible(), inv.isActivo()?"1":"2");
        
        lstProdOutInv = new ArrayList<>();
        lstProdOutInv.add(objProdOut);
        
        setVisible(false);
        PrimeFaces.current().executeScript("AbrirModal('')");
    }

    public void eliminar(int codigoProducto) throws SQLException {
        objResp = objProcedimiento.EliminarInventario(codigoProducto);

        mensajesUsuario();
        Consultar();
    }

    public void mensajesUsuario() {

        if (objResp.isExito()) {
            PrimeFaces.current().executeScript("estadoOk('" + objResp.getMensaje() + "')");
        } else {
            PrimeFaces.current().executeScript("estadoBad('" + objResp.getMensaje() + "')");
        }
    }

    public void nuevo() throws SQLException {
        setVisible(true);
        asignarValoresModal(0,0,"1");
        PrimeFaces.current().executeScript("AbrirModal('')");
        consultarProdOutInv();
       
    }

}
