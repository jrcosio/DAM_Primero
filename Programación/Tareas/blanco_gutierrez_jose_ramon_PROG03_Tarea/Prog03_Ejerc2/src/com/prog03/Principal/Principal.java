
package com.prog03.Principal;

/**
 * Explicacción: Para poder usar la clase Rectangulo, tenemos que importarla y por eso pornemos el nombre del paquete y el nombre
 *               de la clase. Como solo existe esta clase y además es la que necesitamos pues solo importamos la clase Rectagulo,
 *               si dentro del paquete com.prog03.figuras hubiera mas clases que necesitaramos hubieramos importado con el asterisco:
 *               com.prog03.figuras.* para que se pudieran usar todas las clases de ese paquete.
 *                  
 */
import com.prog03.figuras.Rectangulo;

/**
 *
 * @author José Ramón Blanco
 */
public class Principal {
    
    public static void main(String[] args) {
        
        Rectangulo rectandulo1 = new Rectangulo(8,7); //Llamamos al constructor que se le pasan los valores
     
        System.out.println("--- Primera prueba de la clase Rectangulo ---");
        System.out.println(rectandulo1.toString()); 
        System.out.println("La base es: " + rectandulo1.getBase()); //Llamo solo al getter de la Base, ya que al de la altura es llamado en el toString
        System.out.println(rectandulo1.isCuadrado()?"Es un cuadrado":"No es un cuadrado");
        
        
        Rectangulo rectangulo2 = new Rectangulo(); //Creamos el objeto con el otro constructor que los valores son cero
        rectangulo2.setBase(5); //Como lo valores son cero les inicializamos con los setter correspondientes.
        rectangulo2.setAltura(5);
        
        System.out.println("\n--- Segunda prueba de la clase Rectangulo ---");
        System.out.println(rectangulo2.toString());
        System.out.println("La base es: " + rectangulo2.getBase());  //Llamo solo al getter de la Base, ya que al de la altura es llamado en el toString
        System.out.println(rectangulo2.isCuadrado()?"Es un cuadrado":"No es un cuadrado");
    }     
}
