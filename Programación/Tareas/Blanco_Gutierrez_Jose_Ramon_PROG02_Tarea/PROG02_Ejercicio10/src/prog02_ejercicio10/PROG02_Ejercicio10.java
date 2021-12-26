/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejercicio10;

/**
 *
 * @author José Ramón Blanco Gutiérrez
 */
public class PROG02_Ejercicio10 {

    /**
     * Diseña un programa Java, denominado PROG02_Ejerc9, que realice las siguientes operaciones, 
     * en el orden que se muestran. Se indica la variable y el tipo de dato que recibe el valor o 
     * resultado de la operación indicada:
     */
    public static void main(String[] args) {
//        ------- Conversiones entre enteros y coma flotante -------
//        Producto de int por float: j= i*x = 9
//        Producto de float por double: dz=dx * y = 6.0   
        System.out.println("------- Conversiones entre enteros y coma flotante -------");        
        float x = 4.5f;
        float y = 3.0f;
        int i = 2;  
        int j = (int)(i * x); //Conversión explicita
        System.out.println("Producto de int por float: j= i*x = " + j);
        
        double dx = 2.0d;
        double dz = dx*y; //Conversión directa
        System.out.println("Producto de float por double: dz=dx * y = " + dz);
//        ------- Operaciones con byte -------
//        byte: 5 - 2 = 3
//        byte -128 - 1 = 127
//        (int)(-128 - 1) = -129    
        System.out.println("------- Operaciones con byte -------");
        byte bx = 5;
        byte by = 2;        
        byte bz = (byte)(bx - by); //Las operaciones entre tipos byte dan como resultado Int  por lo tanto se tiene que castear
        System.out.printf("\nbyte: %d + %d = %d", bx, by, bz);
        
        bx = -128; //Al limite pero valido ya que el byte va desde -128 a 127
        by = 1;
        bz = (byte)(bx - by); //Las operaciones entre tipos byte dan como resultado Int por lo tanto se tiene que castear
        System.out.printf("\nbyte %d + %d = %d",bx,by,bz);
        
        int varEntero = bx - by; //Creo una variable de tipo entero, como las operaciones entre byte devuelve int no hay casteo
        System.out.printf("(int)(%d + %d) = %d",bx,by,varEntero);
        
//        ------- Operaciones con short -------
//        short: 10 - 1 = 3
//        short 32767 + 1 = -32768
        System.out.println("\n------- Operaciones con short -------");
        short sx = 5;
        short sy = 2;
        
        short sz = (short)(sx - sy); //Las operaciones dan como resultado un int, por lo tanto casteo short
        System.out.printf("\nshort: %d - %d = %d", sx,sy,sz);
        
        sx = 32767;
        sy = 1;
        sz = (short)(sx + sy); //Como sx es el ultimo valor adminitdo al sumarle 1, empieza por el primero permitido -32768
        System.out.printf("\nshort %d + %d = %d",sx,sy,sz);
        
//        ------- Operaciones con char -------
//        char: - = 14
//        char(0x000F) - 1 = 14
//        (int)( ) = 65535
//        (short)( ) = -1
//        -32768 short-char-int = 32768
//        -1 short-char-int = 65535
        System.out.println("\n------- Operaciones con char -------");
        char cx = '\u000F';
        char cy = '\u0001';
        int z = cx - cy; //Conversión a int es directa
        System.out.printf("\nchar: " + cx + " - " + cy + " = " + z);
        
        z = cx - 1; //COnversión a int es directa no es necesario el casteo
        System.out.printf("\nchar(%#06X) - 1 = %d",(int)cx,z); //Para mostrar el valor en Hexadecimas hacemos casteo a int
        
        cx = '\uFFFF';
        z = cx; //Conversión directa a int
        System.out.printf("\n(int)(%c) = %d", cx,z);
        
        sx = (short)cx; //Conversión explicita a short
        System.out.printf("\n(short)(%c) = %d",cx,sx);
        
        sx = -32768; //el número más pequeño que acepta
        cx = (char)sx; //Conversión explitica a char
        z = cx; //conversión directa
        System.out.printf("\n%d short-char-int %d",sx, z);
        
        sx = -1;
        cx = (char)sx; //Conversión explicita
        z = cx; //Directa
        System.out.printf("\n%d short-char-int %d",sx, z);
        
    }
    
}
