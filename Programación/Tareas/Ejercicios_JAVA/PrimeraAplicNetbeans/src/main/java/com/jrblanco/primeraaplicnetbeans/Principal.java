
package com.jrblanco.primeraaplicnetbeans;

/**
 *
 * @author JOSE RAMON BLANCO GUTERREZ
 */
public class Principal {
    private enum Dias { LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO; 
    
        @Override
        public String toString() {
            return "Soy el día " + super.toString(); //To change body of generated methods, choose Tools | Templates.
        }
    };
    /*
     *   Método MAIN
     */
    public static void main(String[] args) {
        //Nombre del Módulo
        System.out.println("Módulo Profesional - PROGRAMACIÓN. UNIDAD DE TRABAJO 01");
	System.out.println("Introducción a la programación"); //Título de la Unidad
	System.out.println("JOSÉ RAMÓN BLANCO GUTIÉRREZ"); //Nombre del Programador
	System.out.println("Santander - Cantabria"); //Ciudad y Provincia
	System.out.println("6 de OCtubre de 2021"); //Fecha
	System.out.println("Programa1"); //Ultimo print
        /*
        * FIN DEL PROGRAMA
        */
        
       
        int numero = 53123;
        
        String n = Integer.toString(numero);
        
        for (int i=0;i<n.length();i++){
            System.out.print(n.charAt(i)+ " ");
        }
        
//        System.out.println("\n"+numero%10);
//        numero /= 10;
//        System.out.println(numero%10);
//        numero /= 10;
//        System.out.println(numero%10);
//        numero /= 10;
//        System.out.println(numero%10);
        System.out.println("");
        Dias dias = Dias.LUNES;
        
        System.out.println(dias.toString());
        
        String prueba = "jose ramon";
        
        System.out.print(prueba.substring(4));
        
        float a= 12.34566f;
        
        System.out.printf("\n%.4f", a);
        
        int edad =17;
        System.out.println((edad>=18)?"Mayor de Edad":"Menor de Edad");
    }
}
