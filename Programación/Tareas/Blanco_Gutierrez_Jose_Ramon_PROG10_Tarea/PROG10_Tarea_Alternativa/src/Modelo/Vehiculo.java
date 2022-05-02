
package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase Vehiculo
 * 
 * @author José Ramón Blanco Gutiérrez
 */
public class Vehiculo implements Serializable{
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
    private String dniPropietario;             //Atributo de tipo DNI para almacenar el DNI del propietario

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
    
    public Vehiculo(String marca, String matricula, int kilometros, LocalDate fechaMatriculacion, String descripcion, float precio, String nombrePropietaro, String dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.kilometros = kilometros;
        this.fechaMatriculacion = fechaMatriculacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietaro = nombrePropietaro;
        this.dniPropietario = dniPropietario;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.marca);
        hash = 61 * hash + Objects.hashCode(this.matricula);
        hash = 61 * hash + this.kilometros;
        hash = 61 * hash + Objects.hashCode(this.fechaMatriculacion);
        hash = 61 * hash + Objects.hashCode(this.descripcion);
        hash = 61 * hash + Float.floatToIntBits(this.precio);
        hash = 61 * hash + Objects.hashCode(this.nombrePropietaro);
        hash = 61 * hash + Objects.hashCode(this.dniPropietario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (this.kilometros != other.kilometros) {
            return false;
        }
        if (Float.floatToIntBits(this.precio) != Float.floatToIntBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.nombrePropietaro, other.nombrePropietaro)) {
            return false;
        }
        if (!Objects.equals(this.dniPropietario, other.dniPropietario)) {
            return false;
        }
        if (!Objects.equals(this.fechaMatriculacion, other.fechaMatriculacion)) {
            return false;
        }
        return true;
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
        return dniPropietario;
    }
    
    /**
     * Método que  cambia el dni del propietario
     * 
     * @param dniPropietario Objeto de tipo Dni
     */
    public void setDniPropietario(String dniPropietario) {
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
}
