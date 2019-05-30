
package edu.curtiembres.controlador;

import edu.curtiembres.conexionsql.UnidadMedidaDAL;
import edu.curtiembres.modelo.UnidadMedida;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

@Named(value = "unidadMedidaSession")
@SessionScoped
public class UnidadMedidaSession implements Serializable {

    public UnidadMedidaSession() {
    }
    
    private List<UnidadMedida> lstUnidadMedida;
    UnidadMedidaDAL objUnidadMedidaDAL = new UnidadMedidaDAL();
    
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
    
    
    
    public void consultar() throws SQLException{
    lstUnidadMedida = new ArrayList<>();
    setLstUnidadMedida(objUnidadMedidaDAL.consultarUnidadMedida());
    }
    
}
