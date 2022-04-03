/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

/**
 * Clase para los método staticos usados para validar datos.
 * @author José Ramón Blanco
 */
public class Valida {
    
    /**
     * Método que chequea si el IBAN tiene un formato determinada ES00000000000000000000
     * @param iban Cadena de texto que se quiere validar
     * @return Devuelve verdadero si el formato es el correcto
     */
    public static boolean checkIban(String iban) {
        return iban.matches("^ES[0-9]{20}$");
    }
    
    
    
}
