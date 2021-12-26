/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog04_ejerc3;

import java.util.Scanner;

/**
 * 
 * Ejercicio 3:<br>
 * El Mínimo Común Múltiplo (MCM) de un conjunto de dos números es el número positivo más pequeño que es múltiplo de los dos números.
 * <br>Implementa un programa Java que pida dos números por teclado, compruebe que son positivos y calcule su MCM.
 * <br>En caso de no ser ambos números positivos, el programa mostrará un mensaje por pantalla y finalizará.
 * 
 * @author José Ramón Blanco Gutiérrez
 */
public class PROG04_Ejerc3 {

    /**
     * 
     * Es el método MAIN, donde esta el bucle principal, en el cual se piden los dos numeros 
     * y si estos no son negativos ni cero pues calculamos el MCM y lo mostramos en pantalla.<br>
     * El bucle se termina cuando el usuario introduce dos numeros negativos.
     * 
     * @param args Son los parametros que se pasan por la linea de comandos, no son usados en este programa.
     * 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = 0, num2 = 0; //Variables para almacenar los numeros.      
       
        do {
            System.out.print("\nIntroduce un número: ");
            num1 = sc.nextInt();
            System.out.print("Introduce otro número: ");
            num2 = sc.nextInt();
            
            if ((num1 > 0) && (num2 > 0)) {  //Solo entra si los numero introducidos son mayores que 0
                System.out.println("El MCM de " + num1 + " y " + num2 + " es " + mcm(num1,num2));
            }else {
                System.out.println("No se puede calcular, vuelva a intentarlo.");
            }
            
        }while ((num1 >= 0) || (num2 >= 0)); //mientras los dos numeros sean iguales o mayores que cero, se repite el bucle y Si son negativos los dos, se termina.
        
        
        System.out.println("Dos numero negativos, saliendo...");
        
        
    }
    
    /**
     * 
     * Método que calcula el Minimo Común Multiplo de dos numero;
     * 
     * @param numero1 primer numero para calcular el MCM
     * @param numero2 segundo numero para calcular el MCM
     * @return <code>entero</code> retorna un Entero que es el MCM de los dos numero pasados como parametros.
     */
    
    public static int mcm(int numero1, int numero2){
        
        int max = Math.max(numero1, numero2); //Obtenemos cual es el mayor de los dos numeros, ya que el MCM no puede ser inferior al mayor de los dos.
        
        while (true) {    //Bucle infinito, se repite tantas veces como sea necesarias hasta que encuentre el MCM        
    
            if ((max % numero1 == 0) && (max % numero2 == 0)) { //hace la comprobación que max es divisinle por los dos, en caso de que sea divisible por ambos numeros
                return max;                                     //entonces es el MCM y uso return para que devuelva el MCM y a la vez termine el método.
            }
            max++; //Incrementa max para seguir haciendo comprobaciones.
        }
        
    }    
}
