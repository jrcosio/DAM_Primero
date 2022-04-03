/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG09_Ejerc1;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase para la creación de Cuentas Corrientes de Empresas y por eso hereda de la clase CuentaCorriente
 * Implementa la interfaz Serializable para que se pueda guardar en un archivo
 * @author JRBlanco
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente implements Serializable{
    /**
     * Atributos de la clase
     */
    private float tipoInteresDescubierto;
    private double maximoDescubiertoPermitido, comisionDescubierto;

    /**
     * Constructor de la clase
     * 
     * @param titular Clase persona con los datos del titulas
     * @param iban  Numero de cuenta
     * @param saldo Dinero de inicio de suenta
     * @param lista Lista de Entidades
     * @param interesXDescubierto   Intereses por Descubierto
     * @param maxDescubierto        Máximo por descubierto
     * @param comisionDescubierto   Comisión de descubierto
     */
    public CuentaCorrienteEmpresa(Persona titular, String iban, double saldo, String lista, 
                                    float interesXDescubierto, 
                                    double maxDescubierto, 
                                    double comisionDescubierto) {
        super(titular, iban, saldo, lista);
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
        final CuentaCorrienteEmpresa other = (CuentaCorrienteEmpresa) obj;
        if (!Objects.equals(this.getIban(), other.getIban())) {
            return false;
        }
        return true;
    }
        
}
