/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jrblanco.clasejava;

import java.sql.*;

/**
 *
 * @author JRBlanco
 */
public class Principal {
    public static void main(String[] args) {
        
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/basededatos","root","");
            Statement stmt = (Statement) conn.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from tabla");
//            
//            while (rs.next()) {
//                System.out.println(rs.getString(1) + " " + rs.getFloat(2));
//            }
//            
            int cantidad = stmt.executeUpdate("update productos set column2=20, column3=400 where column1='xxxx'");
            if (cantidad >= 1) {
                System.out.println("Todo OK");
            } else {
                System.out.println("No OK");
            }
            conn.close();
        }catch (Exception ex) {
            System.out.println("Fallo al conectar con la base de datos");
        }
        
    }
    
}
