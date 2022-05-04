/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog11.model;

/**
 *  Clase Vehiculo
 * @author JRBlanco
 */
public class Vehiculo {
    private String matricula;
    private String marca;
    private int km;
    private float precio;
    private String descripcion;
    private int id_prop;

    public Vehiculo(String matricula, String marca, int km, float precio, String descripcion, int id_prop) {
        this.matricula = matricula;
        this.marca = marca;
        this.km = km;
        this.precio = precio;
        this.descripcion = descripcion;
        this.id_prop = id_prop;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_prop() {
        return id_prop;
    }

    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
    }
    
    
}
