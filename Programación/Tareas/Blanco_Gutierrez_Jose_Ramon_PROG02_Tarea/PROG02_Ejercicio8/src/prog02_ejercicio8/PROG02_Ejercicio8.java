
package prog02_ejercicio8;

import java.util.Scanner;

/**
 *
 * @author José Ramón Blanco Gutiérrez
 */
public class PROG02_Ejercicio8 {

    /**
     * Diseña un programa Java denominado PROG02_Ejerc8 que dados el número de alumnos
     * matriculados en Programación, número de alumnos matriculados  en Entornos de Desarrollo 
     * y número de alumnos matriculados en Base de datos. El programa deberá mostrar el % de alumnos
     * matriculado en cada uno de los tres módulos. Se supone que un alumno sólo puede estar matrículado 
     * en un módulo. Trata de mostrar un solo decimal en los porcentajes.
     */
    public static void main(String[] args) {
        //Instaciamos a la clase Scanner para crear un objeto cpn el que podeamos leer el teclado
        Scanner teclado = new Scanner(System.in); 
        

        //Definición de variables
        int numAlumProgramacion, numAlumEntornosDesarrollo, numAlumBasesDatos;
        int totalModulo;
        
        
        System.out.println("--- Calcular el % de matriculados ---");
        System.out.print("Introduce el número  de alumnos en Programación: ");
        numAlumProgramacion = teclado.nextInt();
        System.out.print("Introduce el número de alumnos en Entornos de Desarrollo: ");
        numAlumEntornosDesarrollo = teclado.nextInt();
        System.out.print("Introduce el número de alumnos en Bases de Datos: ");
        numAlumBasesDatos = teclado.nextInt();
        
        //Sumamos todos los alumnos matriculados en cada modulo y así tenemos todos, ya que un alumno
        //solo puede matricularse en 1 solo modulo (Enunciado)
        totalModulo = numAlumProgramacion + numAlumEntornosDesarrollo + numAlumBasesDatos;
        
        float resultado; //Variable que utilizo para almacenar los calculos y la voy reutilizando en cada operación
        
        resultado = (float)(numAlumProgramacion*100)/totalModulo;  // Calculamos el porcentaje de alumnos de programación
        System.out.printf("El %.1f %% de los alumnos están matriculador en PROGRAMACIÓN\n",resultado);
        
        resultado = (float)(numAlumEntornosDesarrollo*100)/totalModulo; // Calculamos el porcentaje de alumnos de Entornos de Desarrollo
        System.out.printf("El %.1f %% de los alumnos están matriculador en ENTORNOS DE DESARROLLO\n",resultado);
        
        resultado = (float)(numAlumBasesDatos*100)/totalModulo; // Calculamos el porcentaje de alumnos de Bases de Datos
        System.out.printf("El %.1f %% de los alumnos están matriculador en BASE DE DATOS\n",resultado);
        
        //Nota: el %.1f indica al printf que solo muestre un decimal del float
        //      el %% es para que me muestre el simbolo de porcentaje.
    }
    
}
