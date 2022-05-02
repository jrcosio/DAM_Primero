/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 * Clase Util, la cual contiene dos métodos estaticos para validar kilometros y Fecha
 * 
 * @author José Ramón Blanco Gutiérrez
 */
public class Validar {
    
    /**
     * Valida si los kilometros son mayores que cero
     * 
     * @param km Kilometros a validar
     * @return En caso que los KM sean mayor que cero devuelve true sino false 
     */
    public static boolean checkKilometros(int km){ 
        boolean ok = false;
        if (km>0) {
            ok = true;
        }
        return ok;
    }
    
    /**
     * Valida si la fecha es anterior a la fecha actuaal
     * 
     * @param fecha Fecha que se tiene que validar
     * @return Si la fecha es anterior a la actual entonces retorna true sino false
     */
    public static boolean checkFecha(LocalDate fecha){
        boolean ok = false;
        if (fecha.isBefore(LocalDate.now())) {
            ok = true;
        }
        return ok;
        
    }
     /**
     * Método que valida eñ formato de una matricula 0000LLL
     * 
     * @param matricula Matricula que se desea chequear el formato
     * @return 
     */
    public static boolean checkMatricula(String matricula) {
        return matricula.matches("^[0-9]{4}[A-Z]{3}$");
    }
    
    /**
     * Método que valida el formato de un DNI
     * 
     * @param dni DNI que hay que chequear el formato
     * @return 
     */
    public static boolean checkDNI(String dni) {
        return dni.matches("^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]{1}$");
    }
}
