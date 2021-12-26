
package Tarea3;

/**
 *
 * @author José Ramón Blanco
 */
public class Principal {
    
    public static void main(String[] args) {
        Fecha objFecha1 = new Fecha(enumMes.FEBRERO);
        objFecha1.setDia(20);
        objFecha1.setAnio(2000);
        
        System.out.println("Primera fecha, inicializada con el primer constructor");
        System.out.println("La fecha es: " + objFecha1.toString());
        System.out.println(objFecha1.isSummer()?"Es Verano":"No es verano");
        
        Fecha objFecha2 = new Fecha(2,enumMes.JULIO,2015);
        
        System.out.println("\nSegunda fecha, inicializada con el segundo constructor");
        System.out.println("La fecha 2 contiene el año " + objFecha2.getAnio());
        System.out.println("La fecha es " + objFecha2.toString());
        System.out.println(objFecha2.isSummer()?"Es Verano":"No es verano");
    }
}
