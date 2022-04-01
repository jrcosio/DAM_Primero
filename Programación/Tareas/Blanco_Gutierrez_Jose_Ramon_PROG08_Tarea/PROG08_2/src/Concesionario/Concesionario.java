package Concesionario;

import Util.Dni;
import java.time.LocalDate;
import java.util.TreeSet;


/**
 * Clase para la gestión del concesionario.
 * 
 * @author José Ramón Blanco Gutiérrez
 */
public class Concesionario {
    /*
        Explicación del TREESET: Me he decantado por la estructura TREESET, ya que dicha estructura en el momento 
                                 que insertas un vehiculo, la esctructura lo ordena automáticamente, y esto es 
                                 una de los requisitos del ejercicio que los vehiculos tienen que estar ordenados,
                                 y por eso he pensado que es mejor esta estructura que cada vez que añadas un Vehiculo
                                 tener que estar llamado a un metodo estatico de Collections para que lo ordene, si
                                 fuera otra estructura dinamica.
    
                                 Otra de las opciones por las que me he decidido que sea un Set (conjunto) es que
                                 estas estructuras no admiten duplicados y por lo tanto es ideal para que solo
                                 haya un objeto vehiculo por cada matricula, y de manera muy sencilla y facil, como
                                 se puede observar en el método insertar
    */
    /**
     * Estructura dinamica donde se almacenaran todos los vehiculos.
     */
    private TreeSet<Vehiculo> vehiculos;
    /**
     * CONTRUCTOR
     */
    public Concesionario() {
      
       vehiculos = new TreeSet<Vehiculo>(); //Inicializa la estructura dinámica
    }
    
    /**
     * Método para buscar un vehiculo por su matricula
     * 
     * @param matricula Matricula del vehiculo que se desa buscar
     * @return Un cadena con los datos del vehiculo encontrado o null en caso de error
     */
    public String buscaVehiculo(String matricula){
        for (Vehiculo v:vehiculos) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                return "{Marca: " + v.getMarca() +           //Al encontrar el vehiculo llamamos a return que finaliza el método terminando el bucle.
                       " Matricula: " + v.getMatricula() +
                       " Precio: " + v.getPrecio() + " €}";
            }
        }
        return null;    //Si ha recorrido todo el array y no hay ninguna coincidencia termina el bucle y retorna null.
    }
    
    /**
     * Imprime en pantalla la lista de todos los vehiculos del concesionario
     * 
     */
    public void listaVehiculos() {
        
        if (!vehiculos.isEmpty()){
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("%20s | %10s | %6s | %7s | %s\n","Marca","Matricula","Precio","Km","Descripción");
            System.out.println("-----------------------------------------------------------------------------");
            
           for (Vehiculo v:vehiculos) {                // foreach usando una experesión lambda
                System.out.printf("%20s | %10s | %6.2f | %7d | %s\n",v.getMarca(),
                                                                     v.getMatricula(),
                                                                     v.getPrecio(),
                                                                     v.getKilometros(),
                                                                     v.getDescripcion());
            }
            System.out.println("-----------------------------------------------------------------------------");
        } else {
            System.out.println("No hay vehiculos almacenados\n");                   //Muestra que no hay nada
        }
    }

    /**
     *  Método que Inserta un nuevo vehiculo en el array de Vehiculos[]
     * 
     * @param marca Marca del vehiculo
     * @param matricula Matricula del vehiculo nuevo
     * @param kilometros Km del vehiculo
     * @param fecha Fecha
     * @param descripcion Descripción
     * @param precio Precio
     * @param nombre Nombre del propietario 
     * @param dni DNI del propietario
     * 
     * @return 0 Correcto, -1 Existe ese vehiculo
     */
    public int insertaVehiculo(String marca, String matricula, int kilometros, LocalDate fecha, String descripcion, float precio, String nombre, Dni dni) {
        if (vehiculos.add(new Vehiculo(marca, matricula, kilometros, fecha, descripcion, precio, nombre, dni))) {
            return 0;
        } else {
            return -1; // El vehiculo ya existe con esa matricula
        }        
    }
    
    /**
     * Actualiza los kilometros de un vehiculo
     * @param matricula Matricula del vehiculo que se desea cambiar
     * @param nuevosKms Nuevos Kilometros
     * @return true si se ha actualizado sin problemas y false que no se ha actualizado
     */
    public boolean actualizaKms(String matricula, int nuevosKms) {
        for (Vehiculo v:vehiculos) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                 v.setKilometros(nuevosKms);
                 return true;
            }
        }
        return false;
    }
    
    /**
     * Método que borra un vehiculo del array
     * 
     * @param matricula Matricula del vehiculo que queremos borrar
     * @return 0 todo correcto, -1 no hay vehiculos que borrar
     */
    public int borrarVehiculo(String matricula) {
        for (Vehiculo v:vehiculos) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) {
                vehiculos.remove(v);
                return 0;
            }
        }
        return -1;  
    }
}
