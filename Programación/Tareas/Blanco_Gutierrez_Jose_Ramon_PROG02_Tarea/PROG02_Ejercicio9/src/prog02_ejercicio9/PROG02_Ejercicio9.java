
package prog02_ejercicio9;

import java.util.Scanner;

/**
 *
 * @author José Ramón Blanco Gutiérrez
 */
public class PROG02_Ejercicio9 {

    /**
     * Aunque aparentemente los años bisiestos son aquellos que son múltiplos de 4,  
     * no es del todo preciso, ya que años como 1900 y como 2100 no fueron, ni serán, 
     * bisiestos respectivamente. Existe una explicación física que tiene que ver con 
     * que el año del calendario no coincide exactamente, en duración, con el año solar. 
     * Así, un cálculo más exacto indica que la duración real de un año es de 365,2425 días. 
     * Para corregir este desfase, se utiliza el criterio de que se considerará año bisiesto 
     * aquel que sea divisible por 4 pero no por 100 salvo que sea divisible por 400. 
     * Por esto 1900 no es bisiesto, 1904 sí y 2000 también.  Diseña un programa Java, 
     * denominado PROG02_Ejerc9, que dado un año indique si es bisiesto o no. 
     */
    public static void main(String[] args) {
        //Instaciamos a la clase Scanner para crear un objeto cpn el que podeamos leer el teclado
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("--- Calcular si un año es bisiesto ---");
        System.out.print("Introduce un año: ");
        short anyo = teclado.nextShort(); //Utilizo short xq es el tipo de datos más pequeño en el que cabe un año
        
        
        /*
         *  Como no se han dado los condicionales IF sigo utilizando el operador ternario
         *  En esta ocasión para no ponerlo todo en la misma linea y hacer ilegible el println
         *  he creado una variable boleana donde guardo true si cumple que es bisiesto y false sino lo es
        */
        boolean esBisiesto = (anyo % 4 == 0) && ((anyo % 100 != 0) || (anyo % 400 == 0));
        
        // Uso el Operador Ternario para que diga si es true que "es bisiesto" y si es false "no es bisiesto"
        System.out.println("El año " + anyo + (esBisiesto?" es bisiesto":" no es bisiesto"));
        
    }
    
}
