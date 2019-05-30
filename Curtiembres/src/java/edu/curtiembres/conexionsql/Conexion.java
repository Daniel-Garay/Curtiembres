package edu.curtiembres.conexionsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    static Connection contacto = null;
     public static String usuario;
    public static String password;
    public static boolean status = false;

    public static Connection getConexion() {
        status = false;
        String url = "jdbc:sqlserver://DESKTOP-86I5KLI:1433;databaseName=DB_A417A7_DvlpCurtiembres";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException e) {
            //JOptionPane.showMessageDialog(null, "No se pudo establece la conexion... revisar Driver" + e.getMessage(),
            //"Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        try {
            contacto = DriverManager.getConnection(url,"Zuly","ZulyVillate1994");
            status = true;
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
            //"Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        return contacto;
    }

}
