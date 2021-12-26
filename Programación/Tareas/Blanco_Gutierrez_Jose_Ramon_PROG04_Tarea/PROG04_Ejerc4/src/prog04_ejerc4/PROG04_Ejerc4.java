/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog04_ejerc4;

import java.util.Scanner;

/**
 *
 * Ejercicio 4:
 * Deseamos implementar un juego en Java que permita al usuario adivinar un número oculto (que será aleatorio). 
 * El funcionamiento será el siguiente:
 *      # El programa mostrará un pequeño menú en pantalla con las siguientes opciones (1. Configurar, 2. Jugar, 3. Salir).
 *           - Si el usuario selecciona el la primera opción, se le solicitará por teclado el número de intentos permitidos (numInt) y el número máximo  (numMax) generado.
 *           - Si el usuario selecciona la opción 2,  el programa generará un número aleatorio entre 0 y numMax que será el número a adivinar (numOculto).
 *             A partir de este momento, se le solicitarán al usuario números hasta adivinar el número oculto.
 *                   - Si el usuario adivina el número, se mostrará un mensaje "Has ganado!. Has necesitado X intentos".
 *                   - Si se consume el número de intentos sin adivinar el número, se mostrará el mensaje "Perdiste!. Intentos consumidos".
 *                   - En cada intento, si el usuario no adivina el número se le proporcionará una pista, por ejemplo, "El número oculto es menor".
 *                   - En ambos casos, la siguiente acción será mostrar el menú.
 *                   - Si el usuario selecciona Jugar sin configurar previamente el número de intentos y el número máximo generado, 
 *                     se tomarán como valores por defecto: numInt=5 y numMax=10.
 *           - Si el usuario pulsa la opción 3, el programa finaliza.
 *      # Para generar un número aleatorio en java puedes utilizar el siguiente código:
 *           int numOculto = (int)Math.floor(Math.random()*20+1); //genera un número aleatorio entre 0 y 20, ambos incluidos.
 * 
 * @author José Ramón Blanco Gutiérrez
 * 
 */
public class PROG04_Ejerc4 {

    /**
     * 
     * Método MAIN donde se encuentra el bucle principal del juego,
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcionMenu = 0;
        int numInt = 5;
        int numMax = 10;
        
        while (!salir) {            
            menu();
            opcionMenu = sc.nextInt();
            switch (opcionMenu) {
                case 1:
                    System.out.print("Número de Intentos:");
                    numInt = sc.nextInt();
                    System.out.print("Número Maximo para averiguar: ");
                    numMax = sc.nextInt();
                    break;
                case 2:
                    jugar(numInt, numMax);
                    break;
                case 3:
                    salir = true;
            }
        }
        System.out.println("Hasta la próxima");
        
    }
    
    /**
     * 
     * Método del Juego de adivinar el número oculto, que se genera aleatoriamente. 
     * 
     * @param intentos este parametro son la veces que el jugador tiene para intentar averiguar el número oculto
     * @param maximo Es el número máximo que el programa tiene para generar el número oculto.
     */
    public static void jugar(int intentos, int maximo) {
        Scanner sc = new Scanner(System.in);
        //Generamos el numero Oculto;
        int numOculto = (int)Math.floor(Math.random()*maximo+1); //genera un número aleatorio entre 0 y el numero que tenga numMax (maximo), ambos incluidos.
        int numero = 0;
        int intentosJugados = 1;
        boolean gameover = false;
        
        while (!gameover) { //Repite hasta que la variable boleana sea true.
            System.out.print("Qué número crees que es?: ");
            numero = sc.nextInt();
            
            if (numero == numOculto) { //si el número introducido es igual al Oculto ganaste el juego.
                System.out.println("Has ganado!. Has necesitado " + intentosJugados + " intentos");
                gameover = true; //cambia el valor para salir del bucle.
            } else if (numero > numOculto) { //Si el numero es menor que el oculto muestra mensaje de MENOR
                System.out.println("El número oculto es menor");
            } else { //sino es menor y tampoco el igual (hubieras ganado) pues el numero es MAYOR.
                System.out.println("El número oculto es mayor");
            }
           
            if ((intentosJugados == intentos) && (!gameover)) { //Si las veces que has jugado es igual al numero de intentos y no se ha ganado el juego.
                System.out.println("Perdiste!. Intentos consumidos.");
                gameover = true;
            }
            intentosJugados++; //cada vez que juegas incrementa en uno.
            
        }
        
    }
    
    /**
     * Este método muestra en pantalla el menú principal del juego.
     * 
     */
    
    public static void menu() {
        System.out.println("==================================");
        System.out.println("    Adivina el numero oculto");
        System.out.println("==================================");
        System.out.println("         Menú del Juego");
        System.out.println("         --------------");
        System.out.println("\t1.- Configurar");
        System.out.println("\t2.- Jugar");
        System.out.println("\t3.- Salir");
        System.out.print("\nEscoga una opción[1,2,3] y pulse Enter ");
    }
    
}
