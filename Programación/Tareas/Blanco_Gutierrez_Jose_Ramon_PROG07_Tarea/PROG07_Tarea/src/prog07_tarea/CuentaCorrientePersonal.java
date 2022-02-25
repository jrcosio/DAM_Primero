/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog07_tarea;

/**
 * Clase CuentaCorrientePersonal
 * @author JRBlanco
 */
public class CuentaCorrientePersonal extends CuentaCorriente{
    /**
     * Atributos de la clase
     */
    private float comisionMantenimiento;

    /**
     * Constructor de la clase
     * @param titular Obejeto de tipo Persona (nombre, apellidos y dni)
     * @param iban numero de cuenta IBAN
     * @param saldo saldo de inicio de la cuenta
     */
    public CuentaCorrientePersonal(Persona titular, String iban, double saldo) {
        super(titular, iban, saldo);
    }

    @Override
    public String devolverInfoString() {
       return "C. C. Personal { " + this.getIban() + " " + 
                       this.getTitular().devolverInfoString() + " " + 
                       this.getSaldo() + " " + 
                       this.getComisionMantenimiento() + " }";
    }    
    
    /**
     * Método Getter del atributo comisionMantenimiento
     * @return Retorna el valor de la comisión de mantenimiento.
     */
    public float getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    /**
     * Método setter del atributo comisionMantenimiento
     * @param comisionMantenimiento Establece la comisión de mantenimiento.
     */
    public void setComisionMantenimiento(float comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }
    
    
}
