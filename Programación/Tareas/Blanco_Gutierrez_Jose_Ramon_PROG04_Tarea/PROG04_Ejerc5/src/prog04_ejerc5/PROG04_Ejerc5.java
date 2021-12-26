/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog04_ejerc5;

import java.util.Scanner;

/**
 *
 * Ejercicio 5: 
 * Cuando dividimos un número entre 0 se genera un valor indeterminado. 
 * En cualquier lenguaje de programación este tipo de operaciones genera un error de ejecución 
 * que debe ser controlado desde el código para evitar malas experiencias al usuario. En Java, 
 * cuando se produce esta operación se genera la excepción ArithmeticException. Queremos implementar 
 * un programa Java que calcule la división de dos números solicitados por teclado (dividendo y divisor). 
 * El programa solicitará números indefinidamente hasta que los dos números solicitados sean -1. 
 * Se debe controlar mediante excepciones que el divisor no sea 0. En caso de serlo, se mostrará un mensaje por pantalla. 
 * También habrá que mostrar por pantalla el número de divisiones calculadas. Utiliza número enteros para las variables.
 * 
 * 
 * @author José Ramón Blanco Gutierrez
 * 
 */
public class PROG04_Ejerc5 {

    /**
     * 
     * Método MAIN Es el método pricipal del programa, en el cual esta el bucle principal que se repite mientras los dos numeros no sean -1.<br>
     * si durante la ejecución el usuario como divisor pone un cero el programa controla la excepción
     * 
     * @param args the command line arguments
     * @exception ArithmeticException  Si al dividir el divisor es cero salta la excepción (/ by zero) y la controlamos mostrando un mensaje;
     * en caso que la excepción fuera otra de origen Aritmetico mostramos el mensaje de ella.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dividendo = 0, divisor = 0;
        int contadorDivisiones = 0;

         
        while ((dividendo != -1) || (divisor != -1)) {            
            System.out.print("\nIntroduzca el dividendo: ");
            dividendo = sc.nextInt();
            System.out.print("\nIntroduzca el divisor: ");
            divisor = sc.nextInt();
            
            
            if ((dividendo != -1) || (divisor != -1)) {                    //este IF es para que se salte todo en caso que los dos numeros sean -1
                try {
                    System.out.println(dividendo + " / " + divisor + " = " + (dividendo/divisor));

                    contadorDivisiones++;                                  // Solo se incrementa si se ha realizado la división y no ha generado excepción
                    System.out.println("\nDivisiones realizadas: " + contadorDivisiones);
                } catch (ArithmeticException ex) {
                    if (ex.getMessage().equals("/ by zero")) {
                        System.out.println("NO se puede dividir entre CERO");
                    } else {
                        System.out.println("ERROR:\n" + ex.getMessage()); // por si hubiera otra Excepción Aritmetica que lo muestre
                    }

                }
            }
            
        }
        System.out.println("Divisiones realizadas: " + contadorDivisiones);
        System.out.println("Adios...");
        
    }
    
}
