/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea6;

import Concesionario.Concesionario;
import Tarea5.Dni;
import Tarea5.Validar;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author José Ramón Blanco Gutiérrez
 */
public class Principal {
    
    public static void menu() {
        System.err.println();
        System.out.println("-------------------------");
        System.out.println("      Concesionario      ");
        System.out.println("-------------------------");
        System.out.println("1. Nuevo Vehiculo");
        System.out.println("2. Listar Vehiculos");
        System.out.println("3. Buscar Vehiculo");
        System.out.println("4. Modificar kms Vehiculo");
        System.out.println("5. Borrar un vehiculo");
        System.out.println("6. Salir");
        System.out.println("-------------------------");
        System.out.println("Seleccione una opción [1,2,3,4,5,6]");
    }
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean salir = false, check = false;   //Para el bucle principal del programa y bucles de validación
        byte opcion;                    //Variable para la selección del menú
        
        /**
         * Variables necesarias para todos los atributos de la clase Vehiculo
         */
        String marca;
        String matricula;
        int kilometros = 0;
        int dia, mes, anyo;
        LocalDate fecha;
        String descripcion;
        float precio;
        String nombre;
        String dniString;
        Dni dni;
        
        
        Concesionario concesionario = new Concesionario(); //Creación del concesionario
        
        while (!salir) {
            menu();
            opcion = sc.nextByte();
            sc.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.println("Introduce marca del vehiculo:");
                    marca = sc.nextLine();
                    
                    do {
                        System.out.println("Introduce matricula del vehiculo:");
                        matricula = sc.nextLine().toUpperCase();            //convierte todo en mayusculas
                        check = Validar.checkMatricula(matricula);    //como todo esta en mayusculas solo exigimos A-Z
                        if (!check) System.out.println("ERROR MATRICULA: Introduzca una matrícula válida");
                    }while(!check);
                    
                    do {
                        System.out.println("Introduce los kilometros que tiene el vehiculo:");
                        kilometros = sc.nextInt();
                        sc.nextLine();

                        check = Validar.checkKilometros(kilometros); //Método de la clase Util que valida si el número de kilometros es mayor que 0
                        if (!check) System.out.println("ERROR KM: los Km del vehiculos tiene que ser mayor que 0");
          
                    }while(!check); //Repite hasta que se introduzca un kilometro mayor que 0
                    
                    do {
                        System.out.println("----- Fecha de Matriculación -----");
                        System.out.println("Introduce el día:");
                        dia = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Introduce el mes:");
                        mes = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Introduce el año:");
                        anyo = sc.nextInt();
                        sc.nextLine();

                        fecha = LocalDate.of(anyo, mes, dia); //Inicia el Objeto con los datos creados

                        check = Validar.checkFecha(fecha);   //Método de la clase Util que valida si la fecha es anterior a la fecha actual

                        if (!check) System.out.println("ERROR FECHA: La fecha debe ser anterior a hoy");
                    }while(!check); //Se repite mientras la fecha no sea anterior
                    
                    System.out.println("Introducir descripción del vehiculo:");
                    descripcion = sc.nextLine();

                    System.out.println("Introdicir precio del vehiculo:");
                    precio = sc.nextFloat();
                    sc.nextLine();
                    
                    do {
                        System.out.println("Introducir nombre del propietario del vehiculo:");
                        nombre = sc.nextLine();
                        
                        check = Validar.contarEspacios(nombre)==2 && nombre.length()<40; //Si tiene dos espacios es que tiene tres palabras Y una longitud de menos de 40
                        
                        if (!check) System.out.println("ERROR Nombre: Tiene que ser asi: NOMBRE APELLIDO1 APELLIDO2");
                    } while (!check);
                    
                    do {
                        System.out.println("Introducir DNI con su Letra del propietario del vehiculo [00000000T]:");
                        dniString = sc.nextLine();
                        dni = new Dni();
                        check = Validar.checkDNI(dniString);    //Metodo que chequea el formato del DNI
                        if (check) {
                            try {                               //Control de la excepción que genera si el DNI es incorrecto
                                dni.setDni(dniString);
                                check = true;
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage()); //Muestra mensaje de la excepción diciendo que es Invalido
                                check = false;
                            }
                        }
                    }while(!check);
                    
                    //--- Se procede a insertar los datos del vehiculo en el concesionario ---
                    switch (concesionario.insertaVehiculo(marca, matricula, kilometros, fecha, descripcion, precio, nombre, dni)) {
                        case 0:
                            System.out.println("Vehiculo insertado con éxito\n");
                            break;
                        case -1:
                            System.out.println("El concesionario está lleno");
                            break;
                        case -2:
                            System.out.println("El Vehiculo con la matricula: " + matricula + " ya existe");
                            break;
                    }                    
                    break;
                case 2:         //Lista Vehiculos
                    concesionario.listaVehiculos();
                    break;
                case 3:         //Busca por matricula
                    System.out.println("Matricula del vehiculo que desea buscar:");
                    matricula = sc.nextLine();
                    
                    String result = concesionario.buscaVehiculo(matricula); //Como devuelve un string 
                    
                    if (result==null) {
                        System.out.println("No existe vehículo con la matrícula introducida\n");
                    } else {
                        System.out.println(result);
                    }
                    break;

                case 4:     //Modifica los kilometros de un vehiculo
                    System.out.println("Matricula del vehiculo que desea buscar:");
                    matricula = sc.nextLine();
                    System.out.println("Número de Kilometros:");
                    int km = sc.nextInt();
                    sc.nextLine();
                    
                    if (!concesionario.actualizaKms(matricula, km)) {
                        System.out.println("No se ha podido encontrar el vehiculo que desea cambiar los kilometros\n");
                    }  
                    break;
                case 5:     //Borra un vehiculo
                    System.out.println("Matricula del vehiculo que desea borrar:");
                    matricula = sc.nextLine();
                  
                    switch (concesionario.borrarVehiculo(matricula)) {
                        case 0:
                            System.out.println("Vehiculo borrado con éxito\n");
                            break;
                        case -1:
                            System.out.println("No hay vehiculos que borrar\n");
                            break;
                        case -2:
                            System.out.println("No existe vehículo con la matrícula introducida\n");
                            break;
                    }
                    break;
                case 6:
                    salir = true;
                    break;
            }
        }
    }
    
}
