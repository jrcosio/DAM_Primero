/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejecicio2;

/**
 *
 * @author JRBlanco
 */
public class PROG02_Ejecicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean var1 = true;
        boolean var2 = true;
        boolean var3 = false;
        
        int X=5;
        int Y=-8;
        int Z=10;
        
        System.out.println("var1 || var2 && var3 = " + (var1 || var2 && var3));
        System.out.println("(var1 || var3) && (var2 && !var1) = " +((var1 || var3) && (var2 && !var1)));
        System.out.println("(var2 || !var1 || !var3) && var1 = " +((var2 || !var1 || !var3) && var1));
        System.out.println("(X > 3 || Y > 3) && Z < -3 = " + ((X > 3 || Y > 3) && Z < -3));
        System.out.println("(X+Z == 15) && (Y != 2) = " + ((X+Z == 15) && (Y != 2)));
    }
    
}
