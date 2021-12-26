
package prog02_ejecicio5;

import java.util.Scanner;

/**
 *
 * @author José Ramón Blanco Gutiérrez
 */
public class PROG02_Ejecicio5 {

    /**
     * 
     * Diseña un programa Java denominado PROG02_Ejerc5 que dado un número de segundos,
     * muestre en pantalla cuántos minutos, horas y días contiene
     */
    public static void main(String[] args) {
        //Instaciamos a la clase Scanner para crear un objeto cpn el que podeamos leer el teclado
        Scanner teclado = new Scanner(System.in); 
        
        int segundos; //Variable donde guardamos los seguntos que vamos a calcular
        int segundosRestantes; //Variable para almacenar los segundos que van quedado sin analizar en cada operación
        
        
        System.out.println("--- Conversor de segundos en Días, Horas y Minutos ---");
        System.out.print("Introduce los segundos: ");
        segundos = teclado.nextInt(); //Pide al usuario lo segundos que se quiren calcular
        
        short dias = (short)(segundos / 86400); //Divide entre el numero de segundo que tiene un día, obteniebdo los días
        segundosRestantes = (int)(segundos % 86400); //Calculamos el resto que son los segundos restantes .
        
        byte horas= (byte)(segundosRestantes / 3600); //Divide entre el numero de segundos que tiene una hora, obteniedo las horas
        segundosRestantes = segundosRestantes % 3600; //Calculo el resto que son los segundos que quedan
        
        byte minutos = (byte)(segundosRestantes / 60); //Divide entre el numero de segundos que tiene un minuto y se obtienen los minutros
        
        //Visualizamos  los resultado dias, horas y minutos
        System.out.print(segundos + " segundos, son " + dias + " días, " + horas + " horas y " + minutos + " minutos");
   
        //---- Opcional que no pide el ejercicio pero par que muestre los segundos que quedan.
        segundosRestantes = segundosRestantes % 60; //Calculamos el resto que son los seguntos que quedan sin analizar
        System.out.println(" y quedan " + segundosRestantes + " segundos");
        
    }
    
}
