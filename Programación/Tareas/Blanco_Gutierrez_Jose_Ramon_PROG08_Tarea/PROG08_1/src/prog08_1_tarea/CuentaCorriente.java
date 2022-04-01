/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog08_1_tarea;

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
     * @param lista Lista de Entidades autorizadas
     */
    public CuentaCorriente(Persona titular, String iban, double saldo, String lista) {
        super(titular, iban, saldo);
        this.listaEntidades = lista;
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

    /**
     * Método de la interface Imprimible y  es para visualizar los atributos de la clase
     * @return Cadena de texto que devuelve los atributos de la clase
     */
    @Override
    public String devolverInfoString() {
        String contenido = super.devolverInfoString();              //Llamamo a la método de la clase padre
        
        contenido = contenido.substring(0, contenido.length()-1);   //Se quita el corchete final
        
        return contenido + " " + this.getListaEntidades() + "}";    // Añadirmos Lista de Entidades y el cerramos el corchete
    }
}
