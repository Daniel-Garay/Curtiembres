package edu.curtiembres.conexionsql;

import edu.curtiembres.modelo.Producto;
import edu.curtiembres.modelo.RespuestaSP;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAL {

    RespuestaSP objRespuesta;

    public List<Producto> consultarProducto() throws Exception {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call ConsultarProducto()}");

        List<Producto> lstProducto = new ArrayList<>();
        ResultSet rs = entrada.executeQuery();

        while (rs.next()) {
            Producto objProducto = new Producto(Integer.parseInt(rs.getString("codigo")), rs.getString("descripcion"), rs.getString("activo").equals("1") ? true : false, rs.getString("codUnidadMedida"));
            lstProducto.add(objProducto);
        }
        return lstProducto;
    }
    
    public RespuestaSP eliminarProducto(int codigo) throws Exception {
    CallableStatement entrada = Conexion.getConexion().prepareCall("{call EliminarProducto(?,?,?)}");
    entrada.setInt(1, codigo);
    entrada.registerOutParameter(2, Types.VARCHAR);
    entrada.registerOutParameter(3, Types.BOOLEAN);
    entrada.execute();
    
    return objRespuesta;
    }

}
