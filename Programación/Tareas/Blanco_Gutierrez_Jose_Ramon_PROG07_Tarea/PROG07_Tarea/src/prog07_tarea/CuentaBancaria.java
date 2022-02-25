
package prog07_tarea;

/**
 * Clase Abstracta CuentaBancaria
 * 
 * @author JRBlanco
 * @version 1
 */
public abstract class CuentaBancaria implements Imprimible {
    /**
     * Atributos Privados
     */
    private Persona titular;
    private String iban;
    private double saldo;

    /**
     * Contructor que inicializa los atributos
     * 
     * @param titular Titular de la cuenta Clase Persona
     * @param iban Numero de Cuenta IBAN
     * @param saldo Saldo en la Cuenta
     */
    public CuentaBancaria(Persona titular, String iban, double saldo) {
        this.titular = titular;
        this.iban = iban;
        this.saldo = saldo;
    }
    
    /**
     * Método getter del atributo titular, que contiene los datos de titular de la cuenta
     * @return Retorna un objeto persona
     */
    public Persona getTitular() {
        Persona aux = this.titular;
        return aux;
    }
    
    /**
     * Metodo setter para modificar el nombre de un titular de cuenta
     * NOTA: Aunque no es habitual si es posible cambiar o modificar el nombre de una cuenta
     * @param titular 
     */
    public void setTitular(Persona titular) {
        this.titular = titular;
    }
    /**
     * Método getter del atributo IBAN, número de cuenta
     * @return Devuelve el número de IBAN
     */
    public String getIban() {
        return iban;
    }
    
    /**
     * Metodo setter del atributo iban
     * NOTA: Aunque no es habitual que el IBAN se tenga que cambiar, se puede dar el caso que si
     * @param iban IBAN o numero de cuenta
     */
    public void setIban(String iban) {
        this.iban = iban;
    }
    
    /**
     * Método getter del atributo IBAN, número de cuenta
     * @return Devuelve el número de IBAN
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Metodo setter del atributo saldo
     * @param saldo El saldo que se quiere añadir
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
    
}
