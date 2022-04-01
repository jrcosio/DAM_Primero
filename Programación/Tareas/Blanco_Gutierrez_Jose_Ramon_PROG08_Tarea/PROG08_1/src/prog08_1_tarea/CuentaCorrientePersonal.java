/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog08_1_tarea;

import java.util.Objects;

/**
 * Clase para cerar Cuentas Corrientes Personales
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
     * @param lista Lista de entidades
     * @param comisionMantenimiento Comisión de Mantenimiento
     */
     public CuentaCorrientePersonal( Persona titular, String iban, double saldo,String lista, 
                                        float comisionMantenimiento) {
        super(titular, iban, saldo, lista);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    /**
     * Método de oblidatoria implementación por la interface Imprimible y este es para visualizar los atributos.
     * @return Cadena de texto que devuelve los atributos de la clase
     */
    @Override
    public String devolverInfoString() {
        String contenido = super.devolverInfoString();              //Llamamo a la método de la clase padre
        
        contenido = contenido.substring(0, contenido.length()-1);   //Se quita el corchete final
        
        return "C. C. Personal   " + contenido + " " + this.getComisionMantenimiento() + "}";
        
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
    
    /**
     * Método sobreescrito hashcode para que genere un numero hash basdo en el Iban
     * @return Numero HASH
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 69 * hash + Objects.hashCode(getIban());
        return hash;
    }

    /**
     * Metodo Sobreescrito Equals para comaparar otro un objeto con el que crea la clase
     * @param obj Objero a comparar
     * @return True si es igual
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CuentaCorrientePersonal other = (CuentaCorrientePersonal) obj;
        if (!Objects.equals(this.getIban(), other.getIban())) {
            return false;
        }
        return true;
    }
}
