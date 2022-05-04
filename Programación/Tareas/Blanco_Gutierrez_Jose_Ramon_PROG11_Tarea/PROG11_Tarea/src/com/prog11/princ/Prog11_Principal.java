
package com.prog11.princ;

import com.prog11.bbdd.ConnectionDB;
import com.prog11.bbdd.PropietariosDAO;
import com.prog11.bbdd.VehiculosDAO;
import com.prog11.model.Propietario;
import com.prog11.model.Vehiculo;
import java.util.ArrayList;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author JRBlanco
 */
public class Prog11_Principal {
    
    /**
     * Método para verificar las operaciones que devuelve un int
     * @param v valor que devuelven las funciones DAO
     */
    public static void verificaOperacion(int v){
        if (v == 0) System.out.println("Operación realiza con éxito");
        else System.out.println("Error en la operación");
    }
    
    /**
     * Método Main
     * @param args 
     */
    public static void main(String[] args) {
      
        ConnectionDB conn = new ConnectionDB();
        Connection conexion = conn.openConnection(); //abrir la conexión con la base de datos
        int valor;
    
        
        //---- Insertar varios vehículos y propietarios ----
        System.out.println("--------------------------------");
        System.out.println("1.-Inserción de propietarios");
        System.out.println("--------------------------------");
          
        valor = PropietariosDAO.insertarPropietario(new Propietario(0,"Paco Santamaria","82838222Y"), conexion);
        verificaOperacion(valor);
        valor = PropietariosDAO.insertarPropietario(new Propietario(0,"Luis Frenandez","99876567S"), conexion);
        verificaOperacion(valor);
        valor = PropietariosDAO.insertarPropietario(new Propietario(0,"Marta Sanchez","17234545H"), conexion);
        verificaOperacion(valor);
        
        System.out.println("--------------------------------");
        System.out.println("Inserción de vehículos");
        System.out.println("--------------------------------");
        
        valor = VehiculosDAO.insertarVehiculo(new Vehiculo("9898YTR","Ford Fiesta",192000,1000,"Coche clasico 80",8), conexion);        
        verificaOperacion(valor);
        valor = VehiculosDAO.insertarVehiculo(new Vehiculo("1299GGE","Toyota",12321,5500,"Todo terreno",9), conexion);
        verificaOperacion(valor);
        valor = VehiculosDAO.insertarVehiculo(new Vehiculo("1188LPO","Mercedes",98888,3000,"Coche turismo",10), conexion);
        verificaOperacion(valor);
        
        
        //---- Listar todos los vehículos ----
        System.out.println("--------------------------------");
        System.out.println("2.-Listar todos los vehículos");
        System.out.println("--------------------------------");
        
        ArrayList<String> lista = VehiculosDAO.listaVehiculos(conexion);
        lista.forEach(System.out::println); //foeEach usando el modelo de datos STREAMS
        
        //---- Actualizar propietario de un vehiculo ----        
        System.out.println("---------------------------------------");
        System.out.println("3.-Actualizar propietario de un vehiculo");
        System.out.println("---------------------------------------");
        
        valor = VehiculosDAO.actualizarPropietarioVehiculo("1299GGE", 2, conexion);
        verificaOperacion(valor);
        
        //---- Listar todos los vehículos ----
        System.out.println("--------------------------------");
        System.out.println("4.-Listar todos los vehículos");
        System.out.println("--------------------------------");
        
        lista = VehiculosDAO.listaVehiculos(conexion);
        lista.forEach(System.out::println); //foeEach usando el modelo de datos STREAMS
        
        //---- Eliminar un vehículo que exista ----
        System.out.println("--------------------------------");
        System.out.println("5.-Eliminar un vehículo que exista");
        System.out.println("--------------------------------");
        
        valor = VehiculosDAO.eliminarVehiculo("6778LKJ", conexion);
        verificaOperacion(valor);
        
        //Eliminar un vehículo que no exista
        System.out.println("-------------------------------------");
        System.out.println("6.-Eliminar un vehículo que NO exista");
        System.out.println("-------------------------------------");
        
        valor = VehiculosDAO.eliminarVehiculo("0000AAA", conexion);
        verificaOperacion(valor);
        
        //---- Listar todos los vehículos ----
        System.out.println("--------------------------------");
        System.out.println("7.-Listar todos los vehículos");
        System.out.println("--------------------------------");
        
        lista = VehiculosDAO.listaVehiculos(conexion);
        lista.forEach(System.out::println); //foeEach usando el modelo de datos STREAMS
        
        //---- Listar los vehículos de una marca.
        System.out.println("-------------------------------------");
        System.out.println("8.-Listar los vehículos de una marca.");
        System.out.println("-------------------------------------");
        
        lista = VehiculosDAO.listaVehiculoXMarca("Renault", conexion);
        lista.forEach(System.out::println); //foeEach usando el modelo de datos STREAMS
        
        //---- Listar todos los vehículos de un propietario ----
        System.out.println("------------------------------------------------");
        System.out.println("9.-Listar todos los vehículos de un propietario");
        System.out.println("------------------------------------------------");
        
        lista = PropietariosDAO.listaVehiculosPropietario("12345678A", conexion);
        lista.forEach(System.out::println); //foeEach usando el modelo de datos STREAMS
        
        //---- Eliminar un propietario con vehículos ----
        System.out.println("------------------------------------------");
        System.out.println("10.-Eliminar un propietario con vehículos");
        System.out.println("------------------------------------------");
        
        valor = PropietariosDAO.eliminarPropietario("92934944G", conexion);
        if (valor==0) {
            System.out.println("No se ha eliminado ningún propietario");
        } else {
            System.out.println("Se han eliminado " + " propietarios");
        }
        
        //---- Eliminar un propietario sin vehículos ----
        System.out.println("------------------------------------------");
        System.out.println("11.-Eliminar un propietario sin vehículos");
        System.out.println("------------------------------------------");
        
        valor = PropietariosDAO.eliminarPropietario("75654312P", conexion);
        if (valor==0) {
            System.out.println("No se ha eliminado ningún propietario");
        } else {
            System.out.println("Se han eliminado " + " propietarios");
        }
        
        conn.closeConnection(); //cierra la conexxión con la base de datos
        
    }
    
}
