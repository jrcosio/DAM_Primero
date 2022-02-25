/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog07_tarea;

/**
 *
 * @author JRBlanco
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {
    /**
     * Atributos de la clase
     */
    private float tipoInteresDescubierto;
    private double maximoDescubiertoPermitido, comisionDescubierto;

    
    public CuentaCorrienteEmpresa(Persona titular, String iban, double saldo, float interesXDescubierto, double maxDescubierto, double comisionDescubierto) {
        super(titular, iban, saldo);
        this.tipoInteresDescubierto = interesXDescubierto;
        this.maximoDescubiertoPermitido = maxDescubierto;
        this.comisionDescubierto = comisionDescubierto;
    }

    @Override
    public String devolverInfoString() {
        return "C.C. Empresa { " + this.getIban() + " " + 
                       this.getTitular().devolverInfoString() + " " + 
                       this.getSaldo() + " " + 
                       this.getTipoInteresDescubierto() + " " + 
                       this.getMaximoDescubiertoPermitido() + " " + 
                       this.getComisionDescubierto() + " }";
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
