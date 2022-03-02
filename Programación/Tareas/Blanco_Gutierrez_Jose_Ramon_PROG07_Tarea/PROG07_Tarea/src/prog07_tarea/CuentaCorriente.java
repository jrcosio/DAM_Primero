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
    /**
     * Atributo lista de Entidades
     */
    private String listaEntidades;
    
    /**
     * Constructor de la Clase
     * @param titular Objeto que es el titular de la cuenta (Nombre, apellidos y dni)
     * @param iban numero de cuenta IBAN
     * @param saldo Saldo con el que iniciar la cuenta corriente
     */
    public CuentaCorriente(Persona titular, String iban, double saldo) {
        super(titular, iban, saldo);
    }
    
    /**
     * Método getter del atributo listaEntidades
     * @return Cadena de texto con la lista de Entidades
     */
    public String getListaEntidades() {
        return listaEntidades;
    }
    /**
     * Método setter del atributo listaEntidades
     * @param listaEntidades Establece la lista de Entidades
     */
    public void setListaEntidades(String listaEntidades) {
        this.listaEntidades = listaEntidades;
    }
    
    
    
}
