
package Util;

/**
 * Clave de DNI, para almacenar y validar el DNI/NIF
 * 
 * @author José Ramón Blanco
 */
public class Dni {
     private int numDni;  
    
    /**
     * Metodo Getter que retorno el número del DNI
     * @return Numero entero del DNI
     */
    public int getDni() {
        return numDni;
    }

    /**
     * Método para retornar el NIF
     * @return Retorna el numero y la letra correspondiente;
     */
    public String getNif() {
        return (""+this.numDni+Dni.calcularLetraNIF(numDni));
    }
       
    /**
     * Método para establecer el DNI
     * 
     * @param numNIF Número de DNI junto con su letra 00000000T
     * @throws Exception Lanza una excepción si el numero de NIF no es correcto.
     */
    public void setDni(String numNIF) throws Exception {
        
        if (Dni.validarNIF(numNIF)) {
            this.numDni = Dni.extraerNumeroNIF(numNIF);
        } else {
            throw new Exception ("NIF Invalido: " + numNIF);
        }
        
    }
      
    /**
     * Método para establever el DNI en base al número
     * 
     * @param dni Solo el número de DNI son la letra
     * @throws Exception Lanza una excepción si el número de DNI no es válido
     */
    public void setDni(int dni) throws Exception {
        
        if (dni>999999 && dni<99999999) {
           this.numDni = dni; 
        } else {
            throw new Exception ("DNI invalido: "+ String.valueOf(dni));
        }
        
    }   
    
    /**
     * Calcula la letra del NIF
     * 
     * @param dni el numero de DNI
     * @return retorna la letra del NIF
     */
    public static char calcularLetraNIF(int dni){
        String secuenciaLetrasNIF = "TRWAGMYFPDXBNJZSQVHLCKE";
        return secuenciaLetrasNIF.charAt(dni % 23);
    }
    
    /**
     * Valida si el número de NIF es correcto, es decir esta bien formado
     * 
     * @param nif El número de DNI y su correcpondiente letra
     * @return Retorna true si es Válido.
     */
    public static boolean validarNIF(String nif) {
        int numero;
        char letra;
        boolean valido = false;
        
        
        if (nif== null) {
            valido = false;
        } else if (nif.length()<8 || nif.length()>9) {
            valido = false;
        } else {
            numero = Dni.extraerNumeroNIF(nif);
            letra = Dni.extraerLetraNIF(nif);

            if (letra == Dni.calcularLetraNIF(numero)) {
                valido = true;
            }
        }
        return valido;
    }
    
    /**
     * Extrae la letra de un NIF
     * 
     * @param nif Número de DNI y su letra
     * @return Retorna la letra del NIF
     */
    public static char extraerLetraNIF(String nif) {
        return Character.toUpperCase(nif.charAt(nif.length()-1)); 
    }
    
    /**
     * Extrae de un NIF el número de DNI
     * 
     * @param nif Numero del DNI y su Letra
     * @return Retorna el numero que compone el NIF
     */
    public static int extraerNumeroNIF(String nif) {
        return Integer.parseInt(nif.substring(0, nif.length()-1));
    }
    
}
