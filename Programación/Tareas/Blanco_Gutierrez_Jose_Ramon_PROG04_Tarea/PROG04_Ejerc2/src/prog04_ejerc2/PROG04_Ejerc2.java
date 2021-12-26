
package prog04_ejerc2;

import java.util.Scanner;

/**
 *
 * Ejercicio 2: <br>
 * Un número es primo si solo tiene dos divisores: el 1 y el propio número. 
 * Implementa un programa Java que pida por teclado 5 números. 
 * Para cada uno de ellos:
 *      <br>- Comprueba si es negativo. En caso afirmativo, muestra el mensaje por pantalla "El número es negativo".
 *      <br>- Si es positivo, deberá mostrar por pantalla si es primo o no.
 *      <br>- Procesados los 5 números, el programa finaliza.
 * 
 * @author José Ramón Blanco Gutiérrez
 * 
 */
public class PROG04_Ejerc2 {


    /**
     * 
     * Método MAIN, donde se ejecuta el bucle for que va pidiendo los diferentes numeros al usuario.
     * 
     * 
     * @param args Son los parametros que se pasan por la linea de comandos, no son usados en este programa.
     * 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        
        for (int i=0; i<5; i++){
            System.out.print("\nIntroduce un numero: ");
            numero = sc.nextInt();
            if (numero < 0) {
                System.out.println("El número es negativo");
            } else {
                System.out.println("El numero " + numero + (esPrimo(numero)?" Es PRIMO":" NO es Primo"));


            }
        }
    }
    
    /**
     * 
     * Método que chequea si el número pasado como parametro es un número primo. 
     * 
     * @param num Número entero para chequear si es un número primo
     * @return <code>true</code> si es un número pasado como parámetro es primo;
     * <code>false</code> en caso que NO sea un número primo.
     * 
     * @see "Documentación para calcular si un número es primo:"
     * @see <a href="https://youtu.be/P9y8AVWJ4MQ">Video para Python</a>
     * @see <br><a href="http://www.ceiploreto.es/sugerencias/ceibal/Primo_o_compuesto/cmo_saber_si_un_nmero_es_primo.html">Enlace explicación</a>
     */ 
    
        
    public static boolean esPrimo(int num){
        boolean primo = false;
        if (num <= 1) {             // Esta condición decide que no son primos todos los número menores o iguales a 1, es decir todos los negativos y el 0
            primo = false;          // ya que por definición, los números primos son números naturales y mayores que 1.
        
        } else if ((num == 2) || (num == 3) || (num == 5)) { //Si el numero es 2 , 3 o 5 que son los primeros numeros primos pues es primo.
                primo = true;
        
        } else {
            primo = (num % 2 != 0) && (num % 3 != 0) && (num % 5 != 0); // Si el número no es divisible entre el 2, ni el 3, ni el 5 entonces retorno true ( que es PRIMO)
                                                                        // en caso que sea divisible por alguno de los tres números NO ES PRIMO.
        }
        return primo; 
    }
    
    /*   Es como le hice originalmente pero como en los apuntes aconseja no usar varios RETURN para finalizar el metodos y que se llegue al final pues no
    
    public static boolean esPrimo2(int num){
        
        if (num <= 1) return false;  // Esta condición decide que no son primos todos los número menores o iguales a 1, es decir todos los negativos y el 0
                                     // ya que por definición, los números primos son números naturales y mayores que 1.
                                     
        if ((num == 2) || (num == 3) || (num == 5)) { //Si el numero es 2 , 3 o 5 que son los primeros numeros primos pues es primo.
            return true;
        }
        return (num % 2 != 0) && (num % 3 != 0) && (num % 5 != 0); // Si el número no es divisible entre el 2, ni el 3, ni el 5 entonces retorno true ( que es PRIMO)
                                                                   // en caso que sea divisible por alguno de los tres números NO ES PRIMO. 
    }
    */
}
