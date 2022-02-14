/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Concesionario;

import Tarea5.Dni;
import Tarea5.Vehiculo;
import java.time.LocalDate;


/**
 *
 * @author José Ramón Blanco Gutiérrez
 */
public class Concesionario {
    private Vehiculo[] vehiculos;               //Array de los vehiculos.
    private int numVehiculos;                   //Número de vehiculos en el concesionario
    
    private final int MAXIMO_VEHICULOS = 50;    //Constante con el número maximo de vehiculos en el consesionario

    /**
     * CONTRUCTOR
     */
    public Concesionario() {
        this.vehiculos = new Vehiculo[MAXIMO_VEHICULOS];    //Crea el array con el maximo de 50 (0-49)
        this.numVehiculos = 0;                              //Inicializa a cero el número de vehiculos
    }
    
    /**
     * Método para buscar un vehiculo por su matricula
     * 
     * @param matricula Matricula del vehiculo que se desa buscar
     * @return Un cadena con los datos del vehiculo encontrado o null en caso de error
     */
    public String buscaVehiculo(String matricula){
        for (int i=0;i<this.numVehiculos;i++) {
            if (vehiculos[i].getMatricula().equalsIgnoreCase(matricula)) {
                return "{Marca: " + vehiculos[i].getMarca() +           //Al encontrar el vehiculo llamamos a return que finaliza el método terminando el bucle.
                       " Matricula: " + vehiculos[i].getMatricula() +
                       " Precio: " + vehiculos[i].getPrecio() + "€}";
            }
        }
        return null;    //Si ha recorrido todo el array y no hay ninguna coincidencia termina el bucle y retorna null.
    }
    
    /**
     * Imprime en pantalla la lista de todos los vehiculos del concesionario
     * 
     */
    public void listaVehiculos() {
        if (this.numVehiculos != 0) {                                               //Solo si tiene vehiculos
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("%20s | %10s | %6s | %7s | %s\n","Marca","Matricula","Precio","Km","Descripción");
            System.out.println("-----------------------------------------------------------------------------");
            for (int i=0;i<this.numVehiculos;i++) {                                 //Recorre el array hasta el numero de vehiculos en el concesionario               
                System.out.printf("%20s | %10s | %6.2f | %7d | %s\n",vehiculos[i].getMarca(),
                                                                     vehiculos[i].getMatricula(),
                                                                     vehiculos[i].getPrecio(),
                                                                     vehiculos[i].getKilometros(),
                                                                     vehiculos[i].getDescripcion());
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
     * @return 0 Correcto, -1 Array lleno, -2 Existe ese vehiculo
     */
    public int insertaVehiculo(String marca, String matricula, int kilometros, LocalDate fecha, String descripcion, float precio, String nombre, Dni dni) {
        
        int valorRetorno;                                   //Uso esta variable para guardar los estados de retorno y solo usar un return
        
        if (this.numVehiculos < MAXIMO_VEHICULOS) {         //Si tenemos nemos vehiculo que el máximo 
            if (buscaVehiculo(matricula) == null) {         //Si es null es que no existe
                vehiculos[numVehiculos] = new Vehiculo(marca, matricula, kilometros, fecha, descripcion, precio, nombre, dni); //En la posición que indica creamos el objeto
                numVehiculos++;                             // Incrementamos 1 el número de vehiculos
                valorRetorno = 0;                           //Correcto
            } else {
                valorRetorno = -2;                          // Existe esa vehiculo
            }
        } else {
            valorRetorno = -1;                              // Esta lleno el concesionario
        }
        return valorRetorno;
     
    }
    
    /**
     * Actualiza los kilometros de un vehiculo
     * @param matricula Matricula del vehiculo que se desea cambiar
     * @param nuevosKms Nuevos Kilometros
     * @return 
     */
    public boolean actualizaKms(String matricula, int nuevosKms) {
        
        for (int i=0;i<this.numVehiculos;i++) {
            if (vehiculos[i].getMatricula().equalsIgnoreCase(matricula)) {
                 vehiculos[i].setKilometros(nuevosKms);
                 return true;
            }
        }
        return false;
    }
    
    /**
     * Método que borra un vehiculo del array
     * 
     * @param matricula Matricula del vehiculo que queremos borrar
     * @return 0 todo correcto, -1 no hay vehiculos que borrar, -2 Vehiculo no extiste
     */
    public int borrarVehiculo(String matricula) {
        Vehiculo[] aux = new Vehiculo[MAXIMO_VEHICULOS];
        
        int codRetorno;         //Donde se guardan los codigos para retornar al final del método
        int contAux = 0;        //Contador para el indice de aux
        
        if (this.numVehiculos != 0) {
            if (this.buscaVehiculo(matricula)!=null) {
                for (int i = 0; i<this.numVehiculos; i++){ 
                    if (!this.vehiculos[i].getMatricula().equalsIgnoreCase(matricula)) {
                        aux[contAux] = this.vehiculos[i];   //Guarda el vehiculo que sea distinto al buscado
                        contAux++;                          //Aumenta solo cuando se guarda un vehiculo
                    } 
                }
                this.vehiculos = aux;               //Sustitulle el Array Vehiculos por el nuevo creado sin el que se desea borrar
                this.numVehiculos--;                //Restamos 1 los vehiculos del concesionario.
                codRetorno = 0;
            } else {
                codRetorno = -2;                    //El vehiculo no existe;
            }
        } else {
            codRetorno = -1;                        // No hay vehiculos para borrar
        }
        
        return codRetorno;
    }
    
}
