package edu.curtiembres.conexionsql;

import edu.curtiembres.modelo.RespuestaSP;
import edu.curtiembres.modelo.UnidadMedida;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnidadMedidaDAL {

    RespuestaSP respuestaSP;

    public List<UnidadMedida> consultarUnidadMedida() throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call ConsultarUnidadMedida()}");
        
        List<UnidadMedida> lstUnidadMedida = new ArrayList<>();
        ResultSet rs = entrada.executeQuery();
         
         while(rs.next()){
         UnidadMedida objUnidadMedida = new UnidadMedida(rs.getString("Codigo"),rs.getString("Descripcion"), rs.getString("Disponible").equals("1")?true:false);
         lstUnidadMedida.add(objUnidadMedida);
         }
        
        return lstUnidadMedida;
    }
    
}
