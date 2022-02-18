/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JRBlanco
 */
public class Pila {
    
    class Nodo {
        String info; //tipo de datos
        Nodo sig; //Puntero al siguiente Nodo
    }
    
    private Nodo raiz;
    
    public Pila(){
        raiz = null;
    }
    
    public void insertar(String x){
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        
        if (raiz==null){
            nuevo.sig = null;
            this.raiz = nuevo;
        } else {
            nuevo.sig = raiz;
            raiz = nuevo;
        }
        
    }
    
    public String extraer ()
    {
        if (raiz!=null)
        {
            String informacion = raiz.info;
            raiz = raiz.sig;
            return informacion;
        }
        else
        {
            return "";
        }
    }
    
    public void imprimir() {
        Nodo reco=raiz;
        System.out.println();
        System.out.println("Lista de tipo PILA");
        while (reco != null) {
            System.out.print(reco.info + " ");
            reco = reco.sig;
        }
    }
    
    public static void main(String[] args) {
        Pila p = new Pila();
        
        p.insertar("Hola");
        p.insertar("David");
        p.insertar("que");
        p.insertar("tal");
        p.insertar("estas");
        
        p.imprimir();
        
        System.out.println("\n\nExtrae de la PILA: " + p.extraer()); //estas
        p.imprimir();
        
        System.out.println("\n\nExtrae de la PILA: " + p.extraer()); //tal
        p.imprimir();
        
        System.out.println("\n\nExtrae de la PILA: " + p.extraer()); //que
        p.imprimir();
        
        System.out.println("\n\nExtrae de la PILA: " + p.extraer()); //David
        p.imprimir();
        
        System.out.println("\n\nExtrae de la PILA: " + p.extraer()); //Hola
        p.imprimir();
        
        System.out.println("\n\nExtrae de la PILA: " + p.extraer()); //------
        p.imprimir();
        
        System.out.println("\n\nExtrae de la PILA: " + p.extraer()); //------
        p.imprimir();
    }
}
