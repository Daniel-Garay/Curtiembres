
package edu.curtiembres.controlador;

import Conexiones.Procedimientos;
import edu.curtiembres.modelo.Inventario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "inventarioRequest")
@RequestScoped
public class InventarioRequest {

    public InventarioRequest() {
    }
    
    private List<Inventario> lstInvetario = new ArrayList<>();
    Procedimientos objProcedimiento = new Procedimientos();
    
    public List<Inventario> getLstInvetario() {
        return lstInvetario;
    }

    public void setLstInvetario(List<Inventario> lstInvetario) {
        this.lstInvetario = lstInvetario;
    }
    
    public void Consultar() throws SQLException{
    setLstInvetario(objProcedimiento.ConsultarInventario());
    }
}
