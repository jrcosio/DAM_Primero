/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog07_tarea;

import java.util.Hashtable;

/**
 * Clase Cuenta Corriente
 * @author JRBlanco
 */
public abstract class CuentaCorriente extends CuentaBancaria{
    private Hashtable listaEntidades;
    
    /**
     * Constructor de la Clase
     * @param titular Objeto que es el titular de la cuenta (Nombre, apellidos y dni)
     * @param iban numero de cuenta IBAN
     * @param saldo Saldo con el que iniciar la cuenta corriente
     */
    public CuentaCorriente(Persona titular, String iban, double saldo) {
        super(titular, iban, saldo);
    }
    
}
