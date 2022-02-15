package Tema5;

import java.sql.*;

public class PruebaPostgres {
    private static Connection conexion;

    public static void main(String[] args) throws SQLException {
        establecerConexion();



        cerrarConexion();
    }

    static void establecerConexion() throws SQLException {
        //Donde se localiza la BD
        String url = "jdbc:postgresql://localhost:5432/lineas";
        //Credenciales de la BD
        String user = "postgres";
        String pwd = "postgres";

        // Establece la conexión con la BD
        conexion = DriverManager.getConnection(url, user, pwd);
    }

    static void cerrarConexion() throws SQLException {
        // Cierra la conexión con la BD
        conexion.close();
    }

    static void crearTabla(String sql) throws SQLException {
        Statement statement = conexion.createStatement();
        statement.execute(sql);
    }
}
