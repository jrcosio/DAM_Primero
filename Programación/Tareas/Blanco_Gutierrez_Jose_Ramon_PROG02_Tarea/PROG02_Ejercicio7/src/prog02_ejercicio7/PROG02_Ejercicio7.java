/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejercicio7;

import java.util.Scanner;

/**
 *
 * @author José Ramón Blanco Gutiérrez
 */
public class PROG02_Ejercicio7 {

    /**
     * Diseña un programa Java denominado PROG02_Ejerc7 para resolver una ecuación de 
     * primer grado con una incógnita (x), suponiendo que los coeficientes de la ecuación 
     * son C1 y C2 se inicializan en el método main:
     *      C1x + C2 = 0
     */
    public static void main(String[] args) {
        //Instaciamos a la clase Scanner para crear un objeto cpn el que podeamos leer el teclado
        Scanner teclado = new Scanner(System.in); 
        //Definición de variables
        float c1, c2;
        float x; 
        
        System.out.println("--- Resolver Ecucación de primer grado C1x + C2 = 0 ---");
        System.out.print("Introduce valor de C1: ");
        c1 = teclado.nextFloat();
        System.out.print("Introduce valor de C2: ");
        c2 = teclado.nextFloat();
       
        
        //Resolver la ecuación C1x + C2 = 0 --> C1x = 9-c2 --> x = -C2 / C1 
        x = -c2 / c1;
        //El resultado de x Se debe mostrar el resultado con 4 decimales, para ello ponemos %.4f 
        System.out.printf("La incógnita 'x' tiene un resultado de: %.4f",x);
    }
    
}
