package edu.iudigital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{
    // Configuración de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/registro_profesores"; // Cambia por tu BD
    private static final String USUARIO = "root";
    private static final String PASSWORD = "35220912";

    public static Connection getConnection() {
        try {
            // Registrar el driver (opcional si usas Java +6)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            return DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se encontró el driver de MySQL", e);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar a la base de datos", e);
        }
    }

    //Metodo main para probar la conexión
    public static void main(String[] args) {
        try (Connection conn = getConnection()) { // try-with-resources
            if (conn != null && !conn.isClosed()) {
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        }
    }

}