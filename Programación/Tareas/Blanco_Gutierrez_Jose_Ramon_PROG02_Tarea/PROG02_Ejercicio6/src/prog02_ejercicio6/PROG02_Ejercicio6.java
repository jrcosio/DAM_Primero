/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejercicio6;

/**
 *
 * @author José Ramón Blanco Gutiérrez
 */
public class PROG02_Ejercicio6 {

    /**
     * Diseña un programa Java  denominado PROG02_Ejerc6 que cree un tipo enumerado
     * para las siguientes razas de perro: Mastín, Terrier, Bulldog, Pekines, Caniche y Galgo. 
     * El programa debe realizar las siguientes operaciones:
     * 
     *      - Crea una variable denominada var1 del tipo enumerador. Asígnale un valor.
     *      - Crea una variable denominada var2 del tipo enumerador. Asígnale un valor.
     *      - Muestra por pantalla el valor obtenido de comparar ambas variables.
     */
    private enum RazasPerro {MASTIN, TERRIER, BULLDOG, PEKINES, CANICHE, GALGO};
    
    public static void main(String[] args) {
        //Crea una variable denominada var1 del tipo enumerador. Asígnale un valor.
        RazasPerro var1 = RazasPerro.GALGO;
        
        //Crea una variable denominada var2 del tipo enumerador. Asígnale un valor.
        RazasPerro var2 = RazasPerro.TERRIER;
        
        //Muestra por pantalla el valor obtenido de comparar ambas variables
        System.out.println("Comparamos var1 y var2: " + var1.equals(var2));
        
        /**
         *   Investiga sobre la posibilidad averiguar la posición que ocupa un determinado valor 
         *   en el enumerado así como mostrar la cantidad de valores que contiene. Si lo consigues, 
         *   muestra la posición de las dos variables en el tipo enumerado.
         */ 
        System.out.println("var1 es un " + var1.toString() + " y es el número (posición): " + var1.ordinal());
        System.out.println("var2 es un " + var2.toString() + " y es el número (posición): " + var2.ordinal());
        
       
    }
    
}
