package Tema5;

import java.sql.*;

public class PruebaPostgres {
    private static Connection conexion;

    public static void main(String[] args) throws SQLException {
        establecerConexion();

        crearSentencia(
            "create domain dom_dni as text check ( value ~ '^[0-9]{8}[A-Z]$');" +
                "CREATE TABLE Bonos ( " +
                    "ID_bono dom_id," +
                    "Tipo varchar(20)," +
                    "Duracion smallint);" +
                "" +
                "CREATE TABLE Usuario (" +
                    "DNI dom_dni," +
                    "Nombre varchar(20)," +
                    "F_nacimiento Date," +
                    "Ciudad varchar(15));" +
                "CREATE TABLE Bonos_Activos (" +
                    "ID_bono dom_id," +
                    "DNI_usuario dom_dni," +
                    "ID_linea dom_id," +
                    "Caducidad Date);");

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

    static void crearSentencia(String sql) throws SQLException {
        Statement statement = conexion.createStatement();
        statement.execute(sql);
    }
}
