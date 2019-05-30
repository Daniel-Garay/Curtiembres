package Conexiones;

import edu.curtiembres.modelo.Inventario;
import edu.curtiembres.modelo.ProductoOutInventario;
import edu.curtiembres.modelo.RespuestaSP;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class Procedimientos {

    RespuestaSP objRespuestaSp;

    public List<Inventario> ConsultarInventario() throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call ConsultarInventario()}");

        List<Inventario> lstInventario = new ArrayList<>();
        ResultSet rs = entrada.executeQuery();
        while (rs.next()) {
            Inventario objInventario = new Inventario(Integer.parseInt(rs.getString("codigoProducto")), rs.getString("descripcion"), Integer.parseInt(rs.getString("cantidadDisponible")), rs.getString("activo").equals("1") ? true : false);
            lstInventario.add(objInventario);
        }
        return lstInventario;
    }

    public List<ProductoOutInventario> consultarProductoOutInventario() throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call ConsultarProductoOutInventario()}");

        List<ProductoOutInventario> lstProdOutInv = new ArrayList<>();
        ResultSet rs = entrada.executeQuery();
        while (rs.next()) {
            ProductoOutInventario objProdOutInv = new ProductoOutInventario(Integer.parseInt(rs.getString("codigo")), rs.getString("descripcion"), rs.getString("activo").equals("1") ? true : false, rs.getString("codUnidadMedida"));
            lstProdOutInv.add(objProdOutInv);
        }
        return lstProdOutInv;
    }

    public RespuestaSP CrearInventario(Inventario objInventario) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call CrearInventario(?,?,?,?,?)}");
        entrada.setInt(1, objInventario.getCodigoProducto());
        entrada.setInt(2, objInventario.getCantidadDisponible());
        entrada.setBoolean(3, objInventario.isActivo());
        entrada.registerOutParameter(4, Types.VARCHAR);
        entrada.registerOutParameter(5, Types.BOOLEAN);
        entrada.execute();
        objRespuestaSp = new RespuestaSP(entrada.getNString(4), entrada.getString(5).equals("1") ? true : false);
        return objRespuestaSp;
    }

    public RespuestaSP EliminarInventario(int codigoProducto) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EliminarInventario(?,?,?)}");
        entrada.setInt(1, codigoProducto);
        entrada.registerOutParameter(2, Types.VARCHAR);
        entrada.registerOutParameter(3, Types.BOOLEAN);
        entrada.execute();

        objRespuestaSp = new RespuestaSP(entrada.getString(2), (entrada.getString(3).equals("1") ? true : false));
        return objRespuestaSp;
    }

    public RespuestaSP actualizarInventario(Inventario objInventario) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call ActualizarInventario(?,?,?,?,?)}");
        entrada.setInt(1, objInventario.getCodigoProducto());
        entrada.setInt(2, objInventario.getCantidadDisponible());
        entrada.setBoolean(3, objInventario.isActivo());
        entrada.registerOutParameter(4, Types.VARCHAR);
        entrada.registerOutParameter(5, Types.BOOLEAN);
        entrada.execute();
        objRespuestaSp = new RespuestaSP(entrada.getNString(4), entrada.getString(5).equals("1") ? true : false);
        return objRespuestaSp;
    }

}
