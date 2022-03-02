/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog07_tarea;

/**
 * Clase para la creación de Cuentas Corrientes de Empresas
 * @author JRBlanco
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {
    /**
     * Atributos de la clase
     */
    private float tipoInteresDescubierto;
    private double maximoDescubiertoPermitido, comisionDescubierto;

    
    public CuentaCorrienteEmpresa(Persona titular, String iban, double saldo, 
                                    float interesXDescubierto, 
                                    double maxDescubierto, 
                                    double comisionDescubierto) {
        super(titular, iban, saldo);
        this.tipoInteresDescubierto = interesXDescubierto;
        this.maximoDescubiertoPermitido = maxDescubierto;
        this.comisionDescubierto = comisionDescubierto;
    }

    /**
     * Método que obliga la interface a declarar para obetener la información de la cuenta
     * @return Cadena de texto con la info de todos los atributos.
     */
    @Override
    public String devolverInfoString() {
        
        String contenido = super.devolverInfoString();              //Llamamo a la método de la clase padre
        
        contenido = contenido.substring(0, contenido.length()-1);   //Se quita el corchete final
        
        return "C. C. Empresas   " + contenido + " " + 
                       this.getTipoInteresDescubierto() + " " + 
                       this.getMaximoDescubiertoPermitido() + " " + 
                       this.getComisionDescubierto() + "}";
    }

    /**
     * Método sobreescrito ya que ha diferencia de las otras cuentas, en esta de empresa se permite el descubierto,
     * por lo tanto si puede funcionar con numeros negativos en saldo.
     * @param retirar Es el dinero que se quiere retirar de la cuenta
     * @return True si se ha retirado y false sino se ha podido.
     */
    @Override
    public boolean retirarDinero(double retirar) {
        if (retirar <= this.getSaldo()) {                                       //si saldo sufiente retira el dinero
            this.setSaldo(this.getSaldo()-retirar);
            return true;
        } else {                                                                //Está o va a entrar en numeros negativos
            double NuevoSaldoNegativo = this.getSaldo() - retirar;              //Realiza el calculo en una variable auxiliar
            if (NuevoSaldoNegativo >= (this.maximoDescubiertoPermitido*-1)){    //Multiplico por -1 para comparar más facil con el saldo en numeros rojos
                this.setSaldo(NuevoSaldoNegativo);
                return true;
            }            
        }
        return false;
    } 
    
    /**
     * Método getter del atributo tipoInteresDescubierto
     * @return retorno el tipo de interes por descubierto de la cuenta
     */
    public float getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }
    
    /**
     * Método getter del atributo maximoDescubiertoPermitido
     * @return retorna el máximo de descubierto permitido en la cuenta.
     */
    public double getMaximoDescubiertoPermitido() {
        return maximoDescubiertoPermitido;
    }
    
    /**
     * Método getter del atributo comisionDescubierto
     * @return Devuelve la comisión que se aplica por descubierto de la cuenta.
     */
    public double getComisionDescubierto() {
        return comisionDescubierto;
    }

    /**
     * Método getter para el atributo tipoInteresDescubierto
     * @param tipoInteresDescubierto Nuevo tipo de intereres por descubierto
     */
    public void setTipoInteresDescubierto(float tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }
    /**
     * Método getter para el atributo maximoDescubiertoPermitido
     * @param maximoDescubiertoPermitido nuevo maximo por descubierto permitido1
     */
    public void setMaximoDescubiertoPermitido(double maximoDescubiertoPermitido) {
        this.maximoDescubiertoPermitido = maximoDescubiertoPermitido;
    }
    /**
     * Método getter para el atributo comisionDescubierto
     * @param comisionDescubierto nueva comisión por descubierto
     */
    public void setComisionDescubierto(double comisionDescubierto) {
        this.comisionDescubierto = comisionDescubierto;
    }
        
}
