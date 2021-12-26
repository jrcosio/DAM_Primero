
package prog02_ejercicio4;

import java.util.Scanner;

/**
 *
 * @author José Ramón Blanco Gutiérrez
 */
public class PROG02_Ejercicio4 {

    /**
     *  Diseña un programa Java denominado PROG02_Ejerc4 que dada la edad de una persona,
     *  muestre un mensaje indicando si es mayor de edad. NO se puede utilizar el operador condicional if.
     */
    public static void main(String[] args) {
        byte edad; //Escojo de tipo byte, porque es suficiente para la edad de cualquiera
        
        //Instaciamos a la clase Scanner para crear un objeto cpn el que podeamos leer el teclado
        Scanner teclado = new Scanner(System.in);
        System.out.println("--- Programa para saber si esa mayor de edad ---");
        System.out.print("Introduce la edad: ");
        edad = teclado.nextByte(); //Pide al usuario introducir una edad y lo guarda en la variable
        
        //Si la edad es mayir o igual a 18, envia a println la cadena "Es MAYOR..." si es menor envia "Es MENOR..."
        System.out.println((edad>=18)?"Es MAYOR de edad":"Es MENOR de edad");
    }
}
