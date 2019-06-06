package edu.curtiembres.conexionsql;

import edu.curtiembres.modelo.Producto;
import edu.curtiembres.modelo.RespuestaSP;
import edu.curtiembres.modelo.UnidadMedida;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAL {

    RespuestaSP objRespuesta;

    public List<Producto> consultarProducto() throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call ConsultarProducto()}");

        List<Producto> lstProducto = new ArrayList<>();
        ResultSet rs = entrada.executeQuery();

        while (rs.next()) {
            Producto objProducto = new Producto(Integer.parseInt(rs.getString("codigo")), rs.getString("descripcion"), rs.getString("activo").equals("1") ? true : false, rs.getString("codUnidadMedida"));
            lstProducto.add(objProducto);
        }
        return lstProducto;
    }

    public RespuestaSP eliminarProducto(int codigo) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EliminarProducto(?,?,?)}");
        entrada.setInt(1, codigo);
        entrada.registerOutParameter(2, Types.VARCHAR);
        entrada.registerOutParameter(3, Types.BOOLEAN);
        entrada.execute();

        objRespuesta = new RespuestaSP(entrada.getString(2), entrada.getString(3).equals("1") ? true : false);
        return objRespuesta;
    }

    public RespuestaSP crearProducto(Producto objProducto) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call CrearProducto(?,?,?,?,?)}");
        entrada.setString(1, objProducto.getDescripcion());
        entrada.setBoolean(2, objProducto.isActivo());
        entrada.setString(3, objProducto.getCodUnidadMedida());
        entrada.registerOutParameter(4, Types.VARCHAR);
        entrada.registerOutParameter(5, Types.BOOLEAN);
        entrada.execute();

        objRespuesta = new RespuestaSP(entrada.getString(4), entrada.getString(5).equals("1") ? true : false);
        return objRespuesta;
    }

    public RespuestaSP actualizarProducto(Producto objProd) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call ActualizarProducto(?,?,?,?,?,?)}");
        entrada.setInt(1, objProd.getCodigo());
        entrada.setString(2, objProd.getDescripcion());
        entrada.setBoolean(3, objProd.isActivo());
        entrada.setString(4, objProd.getCodUnidadMedida());
        entrada.registerOutParameter(5, Types.VARCHAR);
        entrada.registerOutParameter(6, Types.BOOLEAN);
        entrada.execute();
        
        objRespuesta = new RespuestaSP(entrada.getString(5), entrada.getString(6).equals("1") ? true : false);
        return objRespuesta;
    }

}
