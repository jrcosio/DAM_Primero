
package com.prog11.bbdd;

import com.prog11.model.Vehiculo;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.Connection;

/**
 * Clase que se encarga de realizar la conexión contra la base de datos.
 * @author JRBlanco
 */
public class VehiculosDAO {
    
    /**
     * Método para insertar un nuevo vehiculo en la base de datos.
     * @param veh Objeto de tipo vehiculo
     * @param conexion conexión con la base de datos
     * @return 0 si todo ha ido correcto, -1 si ha habido un error
     */
    public static int insertarVehiculo(Vehiculo veh, Connection conexion){
        int codErr = -1;
        PreparedStatement sentencia = null;
        
        if (veh == null) return codErr; //Comprueba que se pasa un objeto vehiculo inicializado
               
        if (!VehiculosDAO.existeVehiculo(veh.getMatricula(), conexion)) {   //Si no existe el vehiculo inserta
   
            String sentenciaSQL = "INSERT INTO vehiculos (mat_veh,marca_veh,kms_veh,precio_veh,desc_veh,id_prop) values (?,?,?,?,?,?)"; 
            try {
                sentencia = conexion.prepareStatement(sentenciaSQL);
                sentencia.setString(1, veh.getMatricula());
                sentencia.setString(2, veh.getMarca());
                sentencia.setInt(3, veh.getKm());
                sentencia.setFloat(4, veh.getPrecio());
                sentencia.setString(5, veh.getDescripcion());
                sentencia.setInt(6, veh.getId_prop());
                sentencia.executeUpdate();
                codErr = 0;     //Todo ha ido correcto
            } catch (SQLException ex) {
                Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
                codErr = -1;
            }
        } else codErr = -1;
            
        return codErr;
    }
    
    /**
     * Metetodo que comprueba si existe un vehiculo por medio de su matricula
     * @param matricula matricula del vehiculo que se quiere saber si existe
     * @param conexion conexión con la base de datos
     * @return true si existe
     */
    private static boolean existeVehiculo(String matricula, Connection conexion){
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        boolean existe= true;
                
        String sentenciaSQL = "SELECT * FROM vehiculos v WHERE v.mat_veh=?";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, matricula);
            rs = sentencia.executeQuery();
            
            if (rs.next()==false) existe=false;
            
        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
    
    /**
     * Método que compruba si un propietario dado por ID existe en la tabla propietarios
     * @param idpropietario id de propietario que se quiere saber si existe
     * @param conexion conexión con la base de datos
     * @return true si existe
     */
    private static boolean existePropietario(int idpropietario, Connection conexion){
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        boolean existe= true;
                
        String sentenciaSQL = "SELECT * FROM propietarios p WHERE p.id_prop=?";
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setInt(1, idpropietario);
            rs = sentencia.executeQuery();
            
            if (rs.next()==false) existe=false;
            
        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }
    
    /**
     * Metodo que cambia el propietario de un vehiculo por otro dado
     * @param matricula matricula del vehiculo que se quiere cambiar
     * @param idprop nuevo id de propietario
     * @param conexion conexión con la base de datos
     * @return 0 si todo ha ido bien, -1 si ha habido error
     */
    public static int actualizarPropietarioVehiculo(String matricula, int idprop, Connection conexion) {
        int codErr = -1;
        PreparedStatement sentencia = null;
        
        //Comprobamos la vehiculo si existe
        if (!VehiculosDAO.existeVehiculo(matricula, conexion)) return codErr;    
        //COmprobamos si existe el propietario
        if (!VehiculosDAO.existePropietario(idprop, conexion)) return codErr;
       
        String sentenciaSQL = "UPDATE vehiculos SET id_prop = ? WHERE mat_veh = ?"; 
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setInt(1, idprop);
            sentencia.setString(2, matricula);
            sentencia.executeUpdate();
            codErr = 0;     //Todo ha ido correcto
        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
            codErr = -1;
        }
                
        return codErr;
    }
    
    /**
     * Método que elimina un vehiculo de la base de datos
     * @param matricula matricula del vehiculo que se quiere cambiar
     * @param conexion conexión con la base de datos
     * @return 0 si todo ha ido bien, -1 si ha habido error
     */
    public static int eliminarVehiculo(String matricula, Connection conexion) {
        int codErr = -1;
        PreparedStatement sentencia = null;
        //Comprobamos la vehiculo si existe
        if (!VehiculosDAO.existeVehiculo(matricula, conexion)) return codErr;    
        
        String sentenciaSQL = "DELETE FROM vehiculos WHERE mat_veh = ?"; 
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, matricula);
            sentencia.executeUpdate();
            codErr = 0;     //Todo ha ido correcto
        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
            codErr = -1;
        }
        
        return codErr;
    }
    
    /**
     * Metodo que lista todos los vehiculos y el nombre del propietario
     * @param conexion conexión con la base de datos
     * @return
     */
    public static ArrayList<String> listaVehiculosyPropietarios(Connection conexion){
        ArrayList<String> listaAux = new ArrayList<>();
        
        String sentenciaSQL = "select v.mat_veh,v.marca_veh,v.kms_veh,v.precio_veh,v.desc_veh,p.nombre_prop "
                            + "from vehiculos v left join propietarios p on v.id_prop=p.id_prop";
        PreparedStatement sentencia=null;
        ResultSet rs = null;
        
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            rs = sentencia.executeQuery();
            while (rs.next()){
                listaAux.add(rs.getString(1) + " " 
                           + rs.getString(2) + " " 
                           + rs.getInt(3) + " " 
                           + rs.getFloat(4) + " "
                           + rs.getString(5) + " "
                           + rs.getString(6));                
            }            
        } catch (SQLException ex) {
            Logger.getLogger(PropietariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            listaAux = null;
        }        
        return listaAux;
    }
    
    /**
     * Recuperar vehículos por marca: Recibe una marca por parámetro y devuelve una lista 
     * con el listado de vehículos de la citada marca. Para cada vehículo, la lista contendrá 
     * una cadena de caracteres con los datos del mismo, incluido el nombre del propietario.
     * @param marca
     * @param conexion conexión con la base de datos
     * @return Lista de vehiculos y si no existen vehículos, devuelve el ArrayList vacío.
     */
    public static ArrayList<String> listaVehiculoXMarca(String marca, Connection conexion) {
        ArrayList<String> listaAux = new ArrayList<>();
        
        String sentenciaSQL = "select v.mat_veh,v.marca_veh,v.kms_veh,v.precio_veh,v.desc_veh,p.nombre_prop "
                            + "from vehiculos v left join propietarios p on v.id_prop=p.id_prop where v.marca_veh like ?";
        PreparedStatement sentencia=null;
        ResultSet rs = null;
        
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1,"%"+marca+"%");
            rs = sentencia.executeQuery();
            while (rs.next()){
                listaAux.add(rs.getString(1) + " " 
                           + rs.getString(2) + " " 
                           + rs.getInt(3) + " " 
                           + rs.getFloat(4) + " "
                           + rs.getString(5) + " "
                           + rs.getString(6));                
            }            
        } catch (SQLException ex) {
            Logger.getLogger(PropietariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            listaAux = null;
        }        
        return listaAux;
    }
    
    /**
     * Recuperar vehículos: No recibe parámetros (solo la coneción con la BBDD) y 
     * retorna una lista con la matrícula, marca, kilómetros y precio de cada vehículo.
     * @param conexion conexión con la base de datos
     * @return Lista de vehiculos y si no existen vehículos, devuelve el ArrayList vacío
     */
    public static ArrayList<String> listaVehiculos(Connection conexion) {
        ArrayList<String> listaAux = new ArrayList<>();
        
        String sentenciaSQL = "select v.mat_veh,v.marca_veh,v.kms_veh,v.precio_veh from vehiculos v";
        PreparedStatement sentencia=null;
        ResultSet rs = null;
        
        try {
            sentencia = conexion.prepareStatement(sentenciaSQL);
            
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
