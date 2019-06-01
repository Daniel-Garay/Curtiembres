package edu.curtiembres.conexionsql;

import edu.curtiembres.modelo.RespuestaSP;
import edu.curtiembres.modelo.UnidadMedida;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
    
    public RespuestaSP eliminarUnidadMedida(String unidadMedida) throws SQLException {
    CallableStatement entrada = Conexion.getConexion().prepareCall("{call EliminarUnidadMedida(?,?,?)}");
    entrada.setString(1,unidadMedida);
    entrada.registerOutParameter(2, Types.VARCHAR);
    entrada.registerOutParameter(3, Types.BOOLEAN);
    entrada.execute();
    
    respuestaSP = new RespuestaSP(entrada.getString(2), entrada.getString(3).equals("1")?true:false);
    return respuestaSP;
    }
    
    public RespuestaSP crearUnidadMedida(UnidadMedida objUnidMedida)throws SQLException {
     CallableStatement entrada = Conexion.getConexion().prepareCall("{call CrearUnidadMedida(?,?,?,?,?)}");
     entrada.setString(1, objUnidMedida.getCodigo());
     entrada.setString(2, objUnidMedida.getDescripcion());
     entrada.setBoolean(3, objUnidMedida.isDisponible());
     entrada.registerOutParameter(4, Types.VARCHAR);
     entrada.registerOutParameter(5, Types.BOOLEAN);
     entrada.execute();
     
     respuestaSP = new RespuestaSP(entrada.getString(4),entrada.getString(5).equals("1")?true:false);
     return respuestaSP;
    }
    
    public RespuestaSP actualizarUnidadMedida(UnidadMedida objunidadMedida)throws SQLException{
     CallableStatement entrada = Conexion.getConexion().prepareCall("{call ActualizarUnidadMedida(?,?,?,?,?)}");
     entrada.setString(1, objunidadMedida.getCodigo());
     entrada.setString(2, objunidadMedida.getDescripcion());
     entrada.setBoolean(3, objunidadMedida.isDisponible());
     entrada.registerOutParameter(4, Types.VARCHAR);
     entrada.registerOutParameter(5, Types.BOOLEAN);
     entrada.execute();
     
     respuestaSP = new RespuestaSP(entrada.getString(4),entrada.getString(5).equals("1")?true:false);
     return respuestaSP;
    }
    
}
