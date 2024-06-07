package com.conexionbd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// Patrón Singleton
public class conexionbd {
    private static conexionbd instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/bdcafeteria";
    private String username = "root";
    private String password = "Progra.8343452";
    private conexionbd() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // driver MySQL
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error: No se encontró el driver de MySQL.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.err.println("Error: Fallo en la conexión a la base de datos.");
            ex.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public static synchronized conexionbd getInstance() {
        if (instance == null) {
            instance = new conexionbd();
        } else {
            try {
                if (instance.getConnection().isClosed()) {
                    instance = new conexionbd();
                }
            } catch (SQLException ex) {
                System.err.println("Error: Fallo al comprobar el estado de la conexión.");
                ex.printStackTrace();
            }
        }
        return instance;
    }
    // Método de prueba para verificar la conexión
    public static void main(String[] args) {
        conexionbd conexionBD = conexionbd.getInstance();
        Connection connection = conexionBD.getConnection();
        if (connection != null) {
            System.out.println("La conexión a la base de datos es válida.");
            // Ejecutar una consulta de prueba
            try (Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT 1");
                if (rs.next()) {
                    System.out.println("Consulta de prueba ejecutada con éxito. Resultado: " + rs.getInt(1));
                }
            } catch (SQLException ex) {
                System.err.println("Error al ejecutar la consulta de prueba.");
                ex.printStackTrace();
            }
        } else {
            System.err.println("No se pudo establecer la conexión a la base de datos.");
        }
    }
}

