
package prog07_tarea;

import utilidades.Valida;
import java.util.Scanner;

/**
 * Clase Principal del Programa
 * @author JRBlanco
 */
public class Principal{

    /**
     * Método que visualiza el menú principal
     */
    public static void menu() {
        System.out.println("\n");
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
    }
    
    /**
     * Método que visualiza el menú de los tipos de cuentas
     */
    public static void menuCuentas() {
        System.out.println("\n");
        System.out.println("-------------------------------");
        System.out.println("        Tipo de cuenta");
        System.out.println("-------------------------------");
        System.out.println("1. Cuenta de ahorro");
        System.out.println("2. Cuenta corriente personal");
        System.out.println("3. Cuenta corriente de empresa");
        System.out.println("4. Volver al menú principal");
        System.out.println("-------------------------------");
        System.out.print("Elige una opción[1-4] ");

    }
    /**
     * Método que va pidiendo al usuario los datos necesarios para crear una nueva cuenta
     * @return Devuelve un Objeto compatible con CuentaBancaria, los tres tipo de cuentas
     * que se devuelce heredan de CuentaBancaria.
     */
    public static CuentaBancaria nuevaCuenta(){
        
        /**
         * Variable para introducir los datos de las diferentes tipos de cuentas
         */
        Scanner sc = new Scanner(System.in);
        boolean check=false;                                         //Usada para los chequeos de introducción de datos
        String nombre, apellidos, dni, iban;                         //Para los datos personales y el Iban
        double dinero, maxDescubierto, comisionDescubierto;          //Para los diferentes datos de tipo doubles
        byte opcion;                                                 //Para el menú de tipos
        float tipoInteresRemunerado,comisionMantenimiento,interesDescubierto;   //para almacenar datos de tipo float
            
        
        
        System.out.println("Introduce el nombre:");
        nombre = sc.nextLine();
        System.out.println("Introduce apellidos:");
        apellidos = sc.nextLine();
        System.out.println("Introduce DNI:");
        dni = sc.nextLine();
        do {
            System.out.println("Introduce nuevo IBAN");
            iban = sc.nextLine();
            check = Valida.checkIban(iban.toUpperCase());   //Valida que el IBAN sea correcto
        } while (!check);                   //Se repite mientras el Iban no tenga el formato correcto
        
        System.out.println("Introduce saldo inicial:");
        dinero = sc.nextDouble();
        sc.nextLine();
        menuCuentas();          //LLama al método que muestra el menú de tipos de cuentas
        opcion = sc.nextByte();
        sc.nextLine();
        switch (opcion) {                  //Los case no necesitan break ya que llamo a return que finaliza todo el mótodo
            case 1: //1. Cuenta de ahorro
                System.out.println("Introduce tipo interes remunerado:");
                tipoInteresRemunerado = sc.nextFloat();
                sc.nextLine();
                /**
                 * Crea el objeto de la clase Cuenta Ahorro
                 */
                CuentaAhorro ca = new CuentaAhorro(new Persona(nombre,apellidos,dni),iban,dinero,tipoInteresRemunerado);
                return ca;      //Devolvemos el objeto CuentaAhorro
            case 2: //2. Cuenta corriente personal
                System.out.println("Introduce comisión de mantenimiento:");
                comisionMantenimiento = sc.nextFloat();
                sc.nextLine();
                /**
                 * Crea el objeto de la clase Cuenta Corriente Persona
                 */
                CuentaCorrientePersonal ccp = new CuentaCorrientePersonal(new Persona(nombre, apellidos, dni),iban,dinero,null,comisionMantenimiento);
                return ccp;      //Devolvemos el Objeto CuentaCorrientePersonal
            case 3: //3. Cuenta corriente de empresa
                System.out.println("Introduce máximo de descubierto:");
                maxDescubierto = sc.nextDouble();
                sc.nextLine();
                System.out.println("Introduce comisión por descubierto:");
                comisionDescubierto = sc.nextDouble();
                sc.nextLine();
                System.out.println("Introduce interes por descubierto:");
                interesDescubierto = sc.nextFloat();
                sc.nextLine();
                /**
                 * Crea el objeto de la clase de la cuenta corriente de empresa
                 */
                CuentaCorrienteEmpresa cce = new CuentaCorrienteEmpresa(new Persona(nombre, apellidos, dni),iban,dinero,null,interesDescubierto,maxDescubierto,comisionDescubierto);
                return cce;     //Devolvemos el objeto CuentaCorrienteEmpresa
        }              
        return null;    //Sino es ninguna de las 3 opciones retorna NULL
    }
    /**
     * Método principal del programa
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte opcion;                        //Para el menú
        boolean salir = false;              //Para controlar el bucle principal;
       
        Banco banco = new Banco();          //Objeto principal del banco.
        String iban="";                     //Cadena de texto para introducir los iban
        double dinero;

       
        
        while (!salir) {
            menu();
            opcion = sc.nextByte();
            sc.nextLine();
            switch (opcion){
                case 1: //1. Abrir una nueva cuenta     
                    /**
                     * LLama al método de abrir cuenta y le pasamos el método creado para introducir los datos de una cuenta,
                     * como devuelve un objeto de CuentaBancaria es compatible con el métoto abrirCuenta de Banco.
                     */
                    if (banco.abrirCuenta(nuevaCuenta())) {     
                        System.out.println("\nNueva cuenta creada con éxito");
                    } else {
                        System.out.println("\nNo se ha podido crear la cuenta");
                    }
                    break;
                case 2: //2. Listado de cuentas
                    String[] listado = banco.listadoCuentas();
                    if (listado != null) {
                        for (int i=0;i<listado.length;i++) {  //Recorremos el array para ir accediendo a cada fila del array
                            System.out.println(listado[i]);
                        }
                    } else {
                        System.out.println("No hay cuentas");
                    }
                    break;
                case 3: //3. Ver cuenta. Ingresar Dinero
                    System.out.println("\nIntroduce número de cuenta (IBAN):");
                    iban = sc.nextLine();
                    if (Valida.checkIban(iban.toUpperCase())) {     //Chequeamos que el IBAN este correctamente formado
                        String infoCuenta = banco.informacionCuenta(iban);      //Obtenemos la información de la cuenta
                        if (infoCuenta != null) {       //Si existe la cuenta con el IBAN
                            System.out.println(infoCuenta);
                            System.out.println("\nDesea hacer un ingreso? [S/N]");  //Pregunta si quiere el usuario hacer un ingreso
                            String pregunta = sc.next();
                            if (pregunta.equalsIgnoreCase("S")) {
                                System.out.println("Dinero que va a ingresar:");
                                dinero = sc.nextDouble();
                                sc.nextLine();
                                if (banco.ingresoCuenta(iban, dinero)) {        //Realiza el igreso
                                    System.out.println("Operación de INGRESO realizada con éxito.");
                                }else {
                                    System.out.println("No se ha podido realizar la operación.");
                                }
                            }
                        }
                    }else {
                        System.out.println("Formato de IBAN Incorrecto");
                    }                    
                    break;
                case 4: //4. Retirar efectivo en cuenta
                    System.out.println("\nIntroduce número de cuenta (IBAN):");
                    iban = sc.nextLine();
                    System.out.println("Dinero que desea retirar de la cuenta:");
                    dinero = sc.nextDouble();
                    sc.nextLine();
                    if (Valida.checkIban(iban.toUpperCase())) {     //Chequeamos que el IBAN este correctamente formado
                        if (banco.retiradaCuenta(iban, dinero)) {   //llama al método que retira el dinero de la cuenta
                            System.out.println("Operación de RETIRAR realizada con éxito.");
                        } else {
                            System.out.println("No se ha podido realizar la operación.");
                        }
                    }else {
                        System.out.println("Formato de IBAN Incorrecto");
                    }
                    break;
                case 5: //5. Consultar saldo de una cuenta
                    System.out.println("\nIntroduce número de cuenta (IBAN):");
                    iban = sc.nextLine();
                    if (Valida.checkIban(iban.toUpperCase())) {
                        double saldo = banco.obtenerSaldo(iban);
                        if (saldo == -1 ) {
                            System.out.println("No se encuentra la cuenta: " + iban.toUpperCase());
                        } else {
                            System.out.println("El saldo de la cuenta: " + iban.toUpperCase() + 
                                               " es de " + saldo + " €");
                        }
                    } else {
                        System.out.println("Formato de IBAN Incorrecto");
                    }
                    
                    break;
                case 6: //"6. Salir
                    salir = true;
                    System.out.println("Saliendo ...");
                    break;                    
            }
        }
        
    }    
}
