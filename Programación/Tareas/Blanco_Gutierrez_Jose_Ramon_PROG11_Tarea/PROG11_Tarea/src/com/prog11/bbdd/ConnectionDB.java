
package com.prog11.bbdd;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.Connection;
import java.sql.*;

//import java.sql.*;


/**
 *
 * @author JRBlanco
 */
public class ConnectionDB {
    private final String driver = "org.mariadb.jdbc.Driver";
    private final String url = "jdbc:mariadb://localhost:3306/concesionario";
    private final String usuario = "root";
    private final String password = "";
    
    private Connection conn = null;
    
    /**
     * Método para abrir la conexión con la base de datos. 
     * @return Devuelve la conexión con la base de datos.
     */
    public Connection openConnection(){
        
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, usuario, password);
            
        }catch (ClassNotFoundException ex) {
            System.out.println("Error cargando Driver: " + ex.getMessage());
        }catch (SQLException ex) {
            System.out.println("Error en la conexión con la base de datos: " + ex.getMessage());
        }
        return conn;     
    }
    
    /**
     * Método que cierra la conexión con la base de datos.
     */
    public void closeConnection() {
         try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error cerrando conexión de la BD\n" + ex.getMessage());
        }
    }
}
