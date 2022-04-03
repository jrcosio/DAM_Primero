
package PROG09_Ejerc1;

import java.io.Serializable;

/**
 *  Clase Persona para almanecar los datos de una persona
 * @author JRBlanco
 */
public class Persona implements Imprimible, Serializable {
    /**
     * Atributos de la clase PRIVADOS
     */    
    private String nombre, apellidos, dni;

    /**
     * Constructor de la clase
     * @param nombre Nombre de la persona
     * @param apellidos Apellidos de la persona
     * @param dni DNI de la persona
     */
    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    /**
     * Método Getter del atributo nombre
     * @return Atributo nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Método setter del atributo nombre
     * @param nombre Cadena de caracteres que es el nombre la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método Getter del atributo apellidos
     * @return Atributo apellidos
     */
    public String getApellidos() {
        return apellidos;
    }
    /**
     * Método setter del atributo apellido
     * @param apellidos Cadena de caracteres que son los apellidos la persona
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    /**
     * Método Getter del atributo dni
     * @return atributo dni
     */
    public String getDni() {
        return dni;
    }
    
    /**
     * Método Setter del atributo dni
     * @param dni Cadena de caracteres que es el DNI 00000000A
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Método que devuelve la información de la clase en forma de string
     * @return Cadena de caracteres con los datos de los atributos
     */
    @Override
    public String devolverInfoString() {
        return this.getNombre() + " " + this.getApellidos() + " " + this.getDni();
    }
    
    
}
