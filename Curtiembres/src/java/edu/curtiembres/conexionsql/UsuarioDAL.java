package edu.curtiembres.conexionsql;

import edu.curtiembres.modelo.Permiso;
import edu.curtiembres.modelo.RespuestaSP;
import edu.curtiembres.modelo.UnidadMedida;
import edu.curtiembres.modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAL {

    RespuestaSP respuestaSP;
    Usuario objUsuarioLogin;
 

    public RespuestaSP verificarUsuario(String email, String pass) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call ValidarUsuario(?,?,?,?)}");
        entrada.setString(1, email);
        entrada.setString(2, pass);
        entrada.registerOutParameter(3, Types.BOOLEAN);
        entrada.registerOutParameter(4, Types.VARCHAR);
        entrada.execute();

        respuestaSP = new RespuestaSP(entrada.getString(4), entrada.getString(3).equals("1") ? true : false);
        return respuestaSP;
    }

    public Usuario informacionUsuario(String email, String pass) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call InformacionUsuario(?,?,?,?,?,?,?,?,?)}");
        entrada.setString(1, email);
        entrada.setString(2, pass);
        entrada.registerOutParameter(3, Types.INTEGER);
        entrada.registerOutParameter(4, Types.VARCHAR);
        entrada.registerOutParameter(5, Types.INTEGER);
        entrada.registerOutParameter(6, Types.VARCHAR);
        entrada.registerOutParameter(7, Types.VARCHAR);
        entrada.registerOutParameter(8, Types.BOOLEAN);
        entrada.registerOutParameter(9, Types.VARCHAR);
        entrada.execute();
        objUsuarioLogin = new Usuario(
                entrada.getInt(3),
                entrada.getString(4),
                entrada.getInt(5),
                entrada.getString(6),
                entrada.getString(7),
                email,
                pass,
                entrada.getString(8).equals("1") ? true : false,
                entrada.getString(9),
                true);
        return objUsuarioLogin;
    }

    public List<Permiso> permisoPorUsuario(String email, String pass) throws SQLException {
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call PermisosPorUsuario(?,?)}");
        entrada.setString(1, email);
        entrada.setString(2, pass);

        List<Permiso> lstPermisoLogin = new ArrayList<>();
        ResultSet rs = entrada.executeQuery();
        
        while (rs.next()) {
            Permiso objPermisoLogin = new Permiso(Integer.parseInt(rs.getString("codigoPermiso")), rs.getString("nombre"), rs.getString("descripcion"));
            lstPermisoLogin.add(objPermisoLogin);
        }
        return lstPermisoLogin;
    }
}
