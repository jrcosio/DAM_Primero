
package prog07_tarea;

import java.util.Scanner;

/**
 *
 * @author JRBlanco
 */
public class Principal{

    /**
     * Método que visualiza el menú principal y devuelve la opción elegida
     * @return el numero de la opción elegida
     */
    public static byte menu() {
        Scanner sc = new Scanner(System.in);
        byte opcion;
        
        System.out.println("");
        System.out.println("=================================");
        System.out.println("           BANCO DAM             ");
        System.out.println("=================================");
        System.out.println("1. Abrir una nueva cuenta");
        System.out.println("2. Listado de cuentas");
        System.out.println("3. Ver cuenta. Ingresar Dinero");
        System.out.println("4. Retirar efectivo en cuenta");
        System.out.println("5. Consultar saldo de una cuenta");
        System.out.println("6. Salir");
        System.out.println("==================================");
        System.out.print("Elige una opción [1-6] ");
        
        opcion = sc.nextByte();
        sc.nextLine();
        return opcion;        
    }
    /**
     * Método principal
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean salir = false;
      
        while (!salir) {
            switch (menu()){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    salir = true;
                    System.out.println("Saliendo ...");
                    break;                    
            }
        }
        
    }
    
}
