
package prog04_ejerc1;

import java.util.Scanner;

/**
 *
 * Ejercicio 1: 
 * Implementar un programa que muestre la tabla de multiplicar de un número leido desde teclado utilizando al menos tres bucles diferentes. 
 * El número leído desde teclado debe ser menor que 30. En caso contrario se mostrará un mensaje por pantalla y el programa finalizará.
 * 
 * 
 * @author José Ramón Blanco Gutierrez
 * 
 */
public class PROG04_Ejerc1 {

    /**
     * 
     * Método MAIN, es el donde se encuentra el bucle principal del programa. <br>
     * El bucle se repite mientras el número indicado sea menos que 30 y va mostrando su tabla de multiplicar
     * de tres formas diferentes.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;   
        
        do {            
            System.out.println("-----------------------------------");
            System.out.println("         Tabla de Multicar");
            System.out.println("-----------------------------------");
            System.out.print("Introducir un número: ");
            num = sc.nextInt();

            if (num < 30) {
                tablaMultiplicarConFOR(num);
                tablaMultiplicarConWhile(num);
                tablaMultiplicarConDoWhile(num);             
            } else {
                System.out.println("Ha introducido el Nº " + num + " y tiene que ser menor que 30");
                System.out.println("Saliendo...");
            }
        } while (num < 30);        
    }
    
    /**
     * 
     * Este método crea la tabla de multiplicar desde el 0 hasta el 10 (incluido) usando el bucle de repetición FOR
     * 
     * @param numero 
     */
    public static void tablaMultiplicarConFOR(int numero) {
        int contador;
        System.out.println("-----------------------------------------");
        System.out.println("Tabla del " + numero + " Usando un bucle FOR");
        for (contador = 0; contador <= 10; contador++){
            System.out.println(numero + " x " + contador + " = " + numero*contador);
        }
    }
    
    /**
     * 
     * Este método crea la tabla de multiplicar desde el 0 hasta el 10 (incluido) usando el bucle de repetición WHILE
     * 
     * @param numero 
     */
    public static void tablaMultiplicarConWhile(int numero) {
        int contador;
        System.out.println("-------------------------------------------");
        System.out.println("Tabla del " + numero + " Usando un bucle WHILE");
        contador = 0;
        while (contador <= 10) {
            System.out.println(numero + " x " + contador + " = " + numero*contador);
            contador++;
        }
    }
    
    /**
     * 
     * Este método crea la tabla de multiplicar desde el 0 hasta el 10 (incluido) usando el bucle de repetición DO-WHILE
     * 
     * @param numero 
     */
    public static void tablaMultiplicarConDoWhile(int numero) {
        int contador;
        System.out.println("-------------------------------------------");
        System.out.println("Tabla del " + numero + " Usando un bucle DO-WHILE");
        contador = 0;
        do {                
            System.out.println(numero + " x " + contador + " = " + numero*contador);
            contador++;
        }while (contador <= 10);
    }
}
