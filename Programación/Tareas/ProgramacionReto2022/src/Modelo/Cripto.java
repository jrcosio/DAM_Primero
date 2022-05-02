
package Modelo;

/**
 * Clase para encriptar y desencriptar el texto usando el sistema de encriptación cesar
 * 
 * @author Jose Ramón Blanco
 */
public class Cripto {
  
    private static final String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";                   //Solo letras SIN la Ñ
    
    //private static final String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ1234567890@., ";   ///Letras incluida la Ñ y numeros y simbolos que encripta o desencripta
    
    /**
     * Devuelve el texto cifrado o descifrado, en funcion del parametro salto
     * 
     * @param text Texto que se desea encriptar o desencriptar
     * @param salto el salto determina el cifrado, es decir si para cifrar se uso un numero
     * para descifrar se necesita el mismo numero en negativo.
     * @return texto cifrado o descifrado
     */
    public static String cifradoCesar(String text, int salto) {
        char textArray[] = text.toUpperCase().toCharArray();
        int posLetra;
        for (int i=0;i<textArray.length;i++) {
            if (letras.contains(String.valueOf(textArray[i]))) {                      //Solo manipula si el caracter existe en el array
                posLetra = letras.indexOf(String.valueOf(textArray[i]).toUpperCase());              //Obtenemos la posición de la letra
             
                if ((posLetra+salto)>(letras.length()-1)){                                          //si la letra + el salto sobre pasa la Z
                     textArray[i]=letras.charAt((posLetra + salto)-(letras.length())); 
                } else if ((posLetra+salto)<0) {                                                    //si la letra + el salto es menor que la A
                    textArray[i]=letras.charAt((letras.length()) + (posLetra + salto));
                }else {
                     textArray[i]=letras.charAt(posLetra+salto);
                }
            }          
        }        
        return String.copyValueOf(textArray);
    }      
}
