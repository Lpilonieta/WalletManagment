package Model;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLconection {
    public static java.sql.Connection con;

    public static String driver  = "com.cj.mysql.jdbc.Driver";
    public static String user = "root";
    public static String pass = "";
    public static String url = "jdbc:mysql://localhost:3306/registros";


    public static void SqlConection() throws SQLException {
        con = null;
        //Aca se puede probrar si la conexion fue exitosa

        try {


            con =  DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException e) {
            System.out.println("Conexión no exitosa");
        }

    }

}
