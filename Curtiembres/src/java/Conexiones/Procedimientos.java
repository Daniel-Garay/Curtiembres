package Conexiones;

import edu.curtiembres.modelo.Inventario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Procedimientos {

    public  List<Inventario> ConsultarInventario() throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call ConsultarInventario()}");
        //entrada.setInt(1, a);   ---> Esto sería con parámetros de entrada
        // entrada.execute();

        List<Inventario> lstInventario = new ArrayList<>();
        ResultSet rs = entrada.executeQuery();
        while (rs.next()) {
            Inventario objInventario = new Inventario(Integer.parseInt(rs.getString("codigoProducto")), rs.getString("descripcion"), Integer.parseInt(rs.getString("cantidadDisponible")), Boolean.parseBoolean(rs.getString("activo")));
            lstInventario.add(objInventario);
        }
        return lstInventario;
    }

}
