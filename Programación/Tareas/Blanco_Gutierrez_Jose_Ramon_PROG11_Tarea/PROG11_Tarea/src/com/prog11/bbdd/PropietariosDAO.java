
package com.prog11.bbdd;

import com.prog11.model.Propietario;
import org.mariadb.jdbc.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para acceder a los datos de la tabla propietario
 * @author JRBlanco
 * 
 * NOTA: Utilizo siempre el PreparedStatement como metodo para evitar el SQL Inyectión
 */
public class PropietariosDAO {
    
    /**
     * Método para insertar en la tabla propietarios un nuevo registro;
     * @param prop
     * @param conexion
     * @return 
     */    
    public static int insertarPropietario(Propietario prop, Connection conexion){
        int codErr = -1;
        if (prop == null) return codErr;
        
        if (!PropietariosDAO.compruebaPropietarios(prop.getDni(), conexion)) { //Comprobamos que no existe ese DNI en la BD
            String sentaciaSQL = "INSERT INTO propietarios (nombre_prop,dni_prop) values (?,?)"; //El campo id_prop al ser auto incremental no se pone.
            PreparedStatement sentencia = null;

            try {
                sentencia = conexion.prepareStatement(sentaciaSQL);
                sentencia.setString(1,prop.getNombre());
                sentencia.setString(2, prop.getDni());
                sentencia.executeUpdate();
                codErr = 0;     //Todo ha ido correcto
               
            } catch (SQLException ex) {
                Logger.getLogger(PropietariosDAO.class.getName()).log(Level.SEVERE, null, ex);
                codErr = -1;
            }       
        } else {
            codErr = -1;
        }
        
        return codErr;
    }
    
    /**
     * Método que borra todos los propietarios con un DNI concreto
     * @param dni
     * @param conexion
     * @return 
     */
    public static int eliminarPropietario(String dni, Connection conexion){
        String sentanciaSQL = "DELETE FROM propietarios WHERE dni_prop = ?";
        PreparedStatement sentencia = null;
        int contador = 0;
        
        
        if (PropietariosDAO.compruebaPropietarios(dni, conexion)) {
            try {
                sentencia = conexion.prepareStatement(sentanciaSQL);
                sentencia.setString(1, dni);
                contador = sentencia.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(PropietariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return contador;        
    }
    
    /**
     * Método que me devuelve cuantos propietarios hay con el mismo DNI
     * @param dni
     * @param conexion
     * @return 
     */
    public static boolean compruebaPropietarios(String dni, Connection conexion){
        boolean existe = true;
        String sentenciaSQL = "SELECT * FROM propietarios where dni_prop= ?";
        PreparedStatement sentencia=null;
        ResultSet rs = null;
        
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, dni);
            rs = sentencia.executeQuery();
           
            if (rs.next()==false) existe=false;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return existe;     
    }
    
    /**
     * Método que devuelve la lista de los vehiculos de un propietario
     * @param dni
     * @param conexion
     * @return 
     */
    public static ArrayList<String> listaVehiculosPropietario(String dni, Connection conexion){
        ArrayList<String> listaAux = new ArrayList<>();
        String sentenciaSQL = "select v.mat_veh,v.marca_veh,v.kms_veh,v.precio_veh from vehiculos v inner join propietarios p on v.id_prop=p.id_prop where p.dni_prop= ?";
        PreparedStatement sentencia=null;
        ResultSet rs = null;
        
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, dni);
            rs = sentencia.executeQuery();
            while (rs.next()){
                listaAux.add(rs.getString(1) + " " 
                           + rs.getString(2) + " " 
                           + rs.getInt(3) + " " 
                           + rs.getFloat(4));                
            }            
        } catch (SQLException ex) {
            Logger.getLogger(PropietariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            listaAux = null;
        }
        return listaAux;
    }
    
}
