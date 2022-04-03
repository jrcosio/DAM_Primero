/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG09_Ejerc1;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase Cuenta de ahorro
 * Implementa la interfaz Serializable para que se pueda guardar en un archivo
 * @author JRBlanco
 */
public class CuentaAhorro extends CuentaBancaria implements Serializable{
    /**
     * Atributo 
     */
    private float tipoInteresAnual;

    /**
     * Constructor de la Cuenta de Ahorro
     * @param titular Titular de la cuenta que es un Objeto de la clase Persona
     * @param iban Numero de IBAN nuevo
     * @param saldo Dinero de la cuenta.
     */
    public CuentaAhorro(Persona titular, String iban, double saldo, float interesAnual) {
        super(titular, iban, saldo);
        this.tipoInteresAnual = interesAnual;
    }
    /**
     * Método Getter del atributo tipointeresanual
     * @return Devuelve el Tipo de Interes
     */
    public float getTipoInteresAnual() {
        return tipoInteresAnual;
    }
    /**
     * Método setter para modificar el Tipo de interes
     * @param tipoInteresAnual nuevo tipo de interes que se quiere aplicar a la cuenta
     */
    public void setTipoInteresAnual(float tipoInteresAnual) {
        this.tipoInteresAnual = tipoInteresAnual;
    }
    
    /**
     * Método devolverInfoString es un método que la interfaz que estas en la clase abstrata 
     * y nos obliga a implementar
     * @return Cadena de texto con los todos los datos de la cuenta de ahorro
     */
    @Override
    public String devolverInfoString() {
        String contenido = super.devolverInfoString();              //Llamamo a la método de la clase padre
        
        contenido = contenido.substring(0, contenido.length()-1);   //Se quita el corchete final
        
        return "C. de Ahorro     " + contenido + " " + this.getTipoInteresAnual() + "}";
                      
    }
    
     /**
     * Método sobreescrito hashcode para que genere un numero hash basdo en el Iban
     * @return Numero HASH
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 69 * hash + Objects.hashCode(getIban());
        return hash;
    }

     /**
     * Metodo Sobreescrito Equals para comaparar otro un objeto con el que crea la clase
     * @param obj Objero a comparar
     * @return True si es igual
     */
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
        final CuentaAhorro other = (CuentaAhorro) obj;
        if (!Objects.equals(this.getIban(), other.getIban())) {
            return false;
        }
        return true;
    }
    
}
