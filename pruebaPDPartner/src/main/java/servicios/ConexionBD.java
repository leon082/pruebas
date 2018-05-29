/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.sql.*;


/**
 *
 * @author LuisLeon
 */
public class ConexionBD {
    

    private static Connection cnx = null;

    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url ="jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdpartner?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "leon082", "luisleon9");
            } catch (SQLException ex) {
                System.out.println("Error en conexion " + ex.getMessage());
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                System.out.println("Error en conexion " + ex.getMessage());
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }

    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }
}
