
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
     * Metodo para hacer un ingreso en la cuenta
     * @param ingreso Dinero que se quiere ingresar
     */
    public void ingresoDinero(double ingreso) {
        this.saldo += ingreso;
    }
    
    /**
     * Metodo que retira una cantidad de dinero de la cuenta, si el dinero a 
     * retirar es superior al que tiene no realiza la operación
     * @param retirar Dinero que se quiere retirar
     * @return true si se pude realizar la operación y false sino se pudo.
     */
    public boolean retirarDinero(double retirar){
        if (retirar <= this.saldo) {
            this.saldo -= retirar;
            return true;
        }
        return false;
    }
    
    /**
     * Método getter del atributo titular, que contiene los datos de titular de la cuenta
     * @return Retorna un objeto persona, no se retorna directamente el Objeto Titular, para
     * que haya ninguna posiblilidad de perder el encapsulamiento.
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
     * Metodo setter del atributo saldo, cambia todo el saldo por el numero.
     * Nota: No respeta el saldo que se tenga, para eso esta el método retirarDinero.
     * @param saldo El saldo que se pone
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Metodo sobreescrito de la interfaz Imprimible
     * @return La información de los atributos de la clase
     */
    @Override
    public String devolverInfoString() {              
        return "{" + this.iban + " " + 
                this.titular.devolverInfoString() + " " + 
                this.saldo + "}";
    }     
}
