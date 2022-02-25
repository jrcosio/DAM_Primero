/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog07_tarea;

/**
 *
 * @author JRBlanco
 */
public class CuentaAhorro extends CuentaBancaria{
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
        return "Cuenta de ahorro { " + this.getIban() + " " + 
                      this.getTitular().devolverInfoString() + " " + 
                      this.getSaldo() + " " + 
                      this.getTipoInteresAnual() + " }";
                      
    }
    
    
}
