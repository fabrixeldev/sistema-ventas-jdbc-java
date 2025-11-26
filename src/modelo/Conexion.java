package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/xxx";
    private static final String USER = "xxx";
    private static final String PASSW = "xxx";

    public static Connection getConnection(){
        try {
            Connection con = DriverManager.getConnection(URL,USER,PASSW);
            System.out.println("CONEXION CORRECTA A LA BASE DE DATOS");
            return con;
        } catch (SQLException e) {
            System.out.println("ERROR EN LA CONEXION A LA BASE DE DATOS " + e.getMessage());
            return null;
        }
    }
}
