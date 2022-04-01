
package Concesionario;

import Util.Dni;
import java.time.LocalDate;

/**
 * Clase Vehiculo
 * 
 * @author José Ramón Blanco Gutiérrez
 */
public class Vehiculo implements Comparable<Vehiculo>{   //La interfaz Comparable que nos obliga a imprementar el método compareTo
    /**
     * Atributos de la Clase
     */
    private String marca;                   //Atributo de tipo cadena que es la marca del vehiculo Seat
    private String matricula;               //Atributo de cadena que es la matricula del vehiculo Ejemplo = 0000GHT
    private int kilometros;                 //Atributo de entero que son los kilometros que tiene hechos el vehiculo.
    private LocalDate fechaMatriculacion;   //Atributo de tipo fecha que es donde se almacena la fecha de matriculación
    private String descripcion;             //Atributo de tipo cadena que almacena una descripción del vehiculo
    private float precio;                   //Atributo de tipo decimal que almacena el precio
    private String nombrePropietaro;        //Atributo de tipo cadena que es el nombre del propietario
    private Dni dniPropietario;             //Atributo de tipo DNI para almacenar el DNI del propietario

    /**
     * Contructor de la clase Vehiculo.
     * 
     * @param marca Atributo de tipo cadena que es la marca del vehiculo Seat
     * @param matricula Atributo de cadena que es la matricula del vehiculo Ejemplo = 0000GHT
     * @param kilometros Atributo de entero que son los kilometros que tiene hechos el vehiculo.
     * @param fechaMatriculacion Atributo de tipo fecha que es donde se almacena la fecha de matriculación
     * @param descripcion Atributo de tipo cadena que almacena una descripción del vehiculo
     * @param precio Atributo de tipo float que almacena el precio
     * @param nombrePropietaro Atributo de tipo cadena que es el nombre del propietario
     * @param dniPropietario Atributo de tipo DNI para almacenar el DNI del propietario
     */
    
    public Vehiculo(String marca, String matricula, int kilometros, LocalDate fechaMatriculacion, String descripcion, float precio, String nombrePropietaro, Dni dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.kilometros = kilometros;
        this.fechaMatriculacion = fechaMatriculacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietaro = nombrePropietaro;
        this.dniPropietario = dniPropietario;
    }
    
    /**
     * Método que devuelve el valor del atributo matricula
     * 
     * @return retorna la matricula del vehiculo.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Método para establecer el valor del atributo matricula
     * 
     * @param matricula 
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Método que devuelve el valor del atributo kilometros
     * 
     * @return retorna los kilometros del vehiculo
     */
    public int getKilometros() {
        return kilometros;
    }
    /**
     * Metodo para actualizar los kilometros del vehiculos
     * @param kilometros los kilometros
     */
    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    /**
     * Método que devuelve la Fecha de matriculación
     * 
     * @return Retorna el objeto LocalDate que contiene la fecha de matriculación
     */
    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    /**
     * Método para modificar el año de la Matriculación de un vehiculo
     * 
     * @param fechaMatriculacion Un Objeto de LocalDate se tiene que pasar como parametro.
     */
    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }
    
    /**
     * Metodo que devuelve los años que tiene el vehiculo, restado al año actual el año de matriculación
     * 
     * @return retorna los años que tiene el vehiculos
     */
    public int get_Anios(){
        return (LocalDate.now().getYear() - this.fechaMatriculacion.getYear());
    }
    
    /**
     * Método que devuelve el nombre del propietario del vehiculo
     * 
     * @return Retorna una cadena con el nombre introducido.
     */
    public String getNombrePropietaro() {
        return nombrePropietaro;
    }

    /**
     * Método para cambiar el nombre del propietario
     * 
     * @param nombrePropietaro Un cadena de caracteres con el nombre del propietario
     */
    public void setNombrePropietaro(String nombrePropietaro) {
        this.nombrePropietaro = nombrePropietaro;
    }
    
    /**
     * Método para devolver el número de DNI con la letra correspondiente usando el método de la clase Dni
     * 
     * @return retorna el número de DNI y la letra correspondiente
     */
    public String getDniPropietario() {
        return dniPropietario.getNif();
    }
    
    /**
     * Método que  cambia el dni del propietario
     * 
     * @param dniPropietario Objeto de tipo Dni
     */
    public void setDniPropietario(Dni dniPropietario) {
        this.dniPropietario = dniPropietario;
    }
    
    /**
     * Método para obtener la marca del vehiculo
     * 
     * @return Retorna una cadena con la marca del vehiculo
     */
    public String getMarca() {
        return marca;
    }
    
      
    /**
     * Método para obtener la descripción del vehiculo
     * 
     * @return Cadena de caracteres con la descripción del vehiculo.
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Método para cambiar la descripción del vehiculo
     * 
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Método para obtener el precio del vehiculo
     * 
     * @return El precio del vehiculo de tipo float
     */
    public float getPrecio() {
        return precio;
    }
    
    /**
     * Método para cambiar el precio del vehiculo
     * 
     * @param precio El nuevo precio que se quiere poner al vehiculo
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }    

    /**
     * Método compareTo necesario por la colección TreeSet para poder comparar los vehiculos por su mátricula
     * @param v es un Objeto Vehiculos
     * @return 0 si son igual, -1 si el objeto es menor y 1 si es mayot
     */
    @Override
    public int compareTo(Vehiculo v) {
        return this.matricula.compareTo(v.getMatricula());
    }
}
