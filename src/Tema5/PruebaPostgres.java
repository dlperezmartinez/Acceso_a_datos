package Tema5;

import java.sql.*;

public class PruebaPostgres {
    private static Connection conexion;

    public static void main(String[] args) throws SQLException {
        establecerConexion();

        // He tenido que setear este atributo a datestyle para que dejara de darme un error de rango
        Statement statement = conexion.createStatement();
        statement.execute("SET datestyle = dmy;");

//        crearTablas();
//        insercionDatos();
//        consulta1();
//        consulta2();
//        consulta3();
//        actualizacion1();
        actualizacion2();

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

    static void crearTablas() throws SQLException {
        Statement statement = conexion.createStatement();
        statement.execute(
            "create domain dom_dni as text check ( value ~ '^[0-9]{8}[A-Z]$');" +
                "SET DATESTYLE TO 'European';" +
                "" +
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
                "" +
                "CREATE TABLE Bonos_Activos (" +
                "ID_bono dom_id," +
                "DNI_usuario dom_dni," +
                "ID_linea dom_id," +
                "Caducidad Date);");

        System.out.println("Tablas creadas con éxito.");
    }

    static void insercionDatos() throws SQLException {
        Statement statement = conexion.createStatement();
        statement.executeUpdate(
                "INSERT INTO Bonos VALUES (1, 'todo incluido', 1)," +
                "(2, 'todo incluido', 7)," +
                "(3, 'todo incluido', 30)," +
                "(4, '50%', 1)," +
                "(5, '50%', 7)," +
                "(6, '50%', 30);" +
                "" +
                "INSERT INTO Usuario VALUES ('11222333A', 'Patricia P ́erez', '10/12/1990', 'Burriana')," +
                "('22333444B', 'Lia Lorca', '31/01/2002', 'Castell ́on')," +
                "('33444555C', 'Nela N ́u~nez', '28/03/2008', 'Almazora')," +
                "('44555666D', 'Jose Jim ́enez', '15/12/2001', 'Nules')," +
                "('55666777E', 'Antonio Aranda', '09/09/1989', 'Mascarell');" +
                "" +
                "INSERT INTO Bonos_Activos VALUES (2, '11222333A', 11, '22/02/22')," +
                "(5, '11222333A', 31, '17/02/22')," +
                "(1, '22333444B', 41, '16/02/22')," +
                "(4, '33444555C', 21, '16/02/22')," +
                "(6, '44555666D', 51, '15/03/22')," +
                "(3, '44555666D', 21, '01/03/22');"
                );
    }

    // Consulta 1
    static void consulta1() throws SQLException {
        Statement statement = conexion.createStatement();
        String texto;

        ResultSet resultado = statement.executeQuery("SELECT nombre FROM conductores " +
                                                            "WHERE ID_conductor = (SELECT ID_conductor FROM lineas " +
                                                                "WHERE ID_linea = (SELECT ID_linea FROM Bonos_Activos " +
                                                                    "WHERE Caducidad > CURRENT_DATE))");
        while (resultado.next()) {
            System.out.println(resultado.getString(1));
        }
    }

    // Consulta 2
    static void consulta2() throws SQLException {
    Statement statement = conexion.createStatement();

    // TODO He intentado hacerlo con JOIN también pero no veo donde está el error
    ResultSet resultado = statement.executeQuery("SELECT Nombre, " +
                                                        "(EXTRACT(YEAR FROM CURRENT_DATE) - EXTRACT(YEAR FROM F_nacimiento)) " +
                                                        "FROM Usuario " +
                                                        "WHERE DNI = (SELECT DNI_usuario FROM Bonos_Activos); " +
                                                            "WHERE ID_bono = (SELECT ID_bono FROM Bonos " +
                                                                "WHERE Duracion > 1))"
    );
        while (resultado.next()) {
            System.out.println(resultado.getString(2));
        }
    }

    // Consulta 3
    static void consulta3() throws SQLException {
        Statement statement = conexion.createStatement();
        ResultSet resultado;

        resultado = statement.executeQuery("SELECT COUNT(ID_bono), date_trunc('WEEK', Caducidad) AS Semana " +
                "FROM Bonos_Activos " +
                "GROUP BY Semana");

        while (resultado.next()) {
            System.out.println("En la semana del " + resultado.getString(2) + " caducan " +
                                resultado.getString(1) + " bonos.");
        }
    }

    // Actualización 1
    static void actualizacion1() throws SQLException {
        Statement statement = conexion.createStatement();

        statement.executeUpdate("DELETE FROM Usuario " +
                "WHERE (EXTRACT(YEAR FROM CURRENT_DATE) - EXTRACT(YEAR FROM F_nacimiento)) < 18 ");
    }

    static void actualizacion2() throws SQLException {
        Statement statement = conexion.createStatement();

        statement.executeUpdate("DELETE FROM Bonos " +
                "WHERE (tipo LIKE '50%%') AND (duracion = 30)");
    }
}
