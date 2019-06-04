package edu.curtiembres.controlador;

import edu.curtiembres.conexionsql.ProductoDAL;
import edu.curtiembres.modelo.Producto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.annotation.PostConstruct;

@Named(value = "productoSession")
@SessionScoped
public class ProductoSession implements Serializable {

    public ProductoSession() {
    }

    private List<Producto> lstProducto;
    private ProductoDAL objProductoDAL = new ProductoDAL();

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

    public void consultar() throws Exception {
        lstProducto = new ArrayList<>();
        setLstProducto(objProductoDAL.consultarProducto());
    }

}
