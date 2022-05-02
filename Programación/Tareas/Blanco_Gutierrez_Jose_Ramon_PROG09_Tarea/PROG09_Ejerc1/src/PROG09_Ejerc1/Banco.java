/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG09_Ejerc1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 * Clase Banco para la gestión de las cuentas del Banco
 * @author JRBlanco
 */
public class Banco {
    
    /**
     * Explicación HASHSET: Para esta Aplicación me he decantado por el conjunto de datos hashSet, ya que cada cuenta bancaria tiene que ser
     *                      única, y las colecciones tienen no admiten duplicados.
     *                      Y los HashSet almacenan los objetos en este caso la cuentas bancarias usando tablas hash, lo cual acelera mucho
     *                      el acceso a los datos, con respecto a otras colecciones de datos, tiene una impotante deventajas y es que almacena
     *                      los objetos de forma desordenada y si se quiesira ordenar pues abria que recurrir a métodos externos de la colección,
     *                      pero no es un criterio para esta aplicación por lo tanto sigo considerando a hashSet como la mejor opción de todas.
     *
     *                      Observaciones: Para que con objetos funcione el HASHSET y no permita duplicados se tienen que sobreescribir
     *                                     los método equals y hashCode de la clase del objeto. Pero en el caso de esta aplicación no es en la
     *                                     clase CuentaBancaria ya que en verdad las cuentas son otra clase que heredan las propiedades, pero equals
     *                                     y hashcode no se heredan y cada clase tiene la suya propia, por lo tanto he tenido que sobreescribir estos
     *                                     dos métodos en las 3 clases de tipo de cuenta.
     */
    private HashSet<CuentaBancaria> cuentasBancarias;

    /**
     * Contructor de la clase
     * 
     * Inicializa la estructura de cuentas bancarias
     */
    public Banco() {
        this.cuentasBancarias = new HashSet<CuentaBancaria>();
    }
    
    /**
     * Método para buscar una cuenta bancaria por medio de su IBAN
     * 
     * @param iban numero IBAN que se desea buscar
     * @return Devuelve un cadena de texto con los datos de la cuenta o NULL sino existe
     */
    public String informacionCuenta(String iban) {
        for (CuentaBancaria cb:this.cuentasBancarias) {
            if (cb.getIban().equalsIgnoreCase(iban)) {
                return cb.devolverInfoString(); //Si le ha encontrado utilizo devuelvo los datos y termina el FOR
            }
        }
        return null;
    }
    
    /**
     * Método pata abrir una cuenta, añadiendo a la estructura la cuenta que se pasa
     * @param cb Cuenta Bancaria, usando el polimorfismo almacenamos en el array uno de los diferentes objetos de cuentas
     * @return Devuelve true si todo es correcto y false sino ha añadido nada.
     */
    public boolean abrirCuenta(CuentaBancaria cb) {     
        if (cb != null) {                   //Verifico que el objeto que se ha pasado no sea NULL
            return this.cuentasBancarias.add(cb);
        }
        return false;
    }
    
    /**
     * Método que lista todas las cuentas del Banco
     * @return Cadena de caracteres con los datos de las diferentes cuentas, sino hay datos que lista retorna NULL
     */
    public String[] listadoCuentas() {
        String[] listado = null;    //Array String
        int i = 0;                  //Variable contador
        if (!this.cuentasBancarias.isEmpty()){
            listado = new String[this.cuentasBancarias.size()];
            for (CuentaBancaria cb:cuentasBancarias) {
                listado[i] = cb.devolverInfoString();
                i++;
            }
        }
        return listado;     //Returnamos el listado de las cuentas
    }
    
    /**
     * Método para ingresar dinero en la cuenta bancaria
     * @param iban Número de IBAN en el que se quiere hacer el ingreso
     * @param ingreso Dinero que se quiere ingresar
     * @return True todo correcto false incorrecto
     */
    public boolean ingresoCuenta(String iban, double ingreso) {
        for (CuentaBancaria cb:cuentasBancarias) {
            if (cb.getIban().equalsIgnoreCase(iban)){
                cb.ingresoDinero(ingreso);
                return true;
            }
        }
        return false;   //En caso que el bucle se recorra entero es que no ha encontrado el iban y devuelve false
    }
    
    /**
     * Método para retirar dinero de un cuenta
     * @param iban Número de IBAN de la cuenta que se quiere retirar dinero
     * @param retira Dinero que se quiere retirar
     * @return True todo correcto false incorrecto
     */
    public boolean retiradaCuenta(String iban, double retira){
        for (CuentaBancaria cb:cuentasBancarias) {
            if (cb.getIban().equalsIgnoreCase(iban)){
                return cb.retirarDinero(retira);
            }
        }
        return false;   //En caso que el bucle se recorra entero es que no ha encontrado el iban y devuelve false
    }
    
    /**
     * Método que devuelve el Saldo de la cuenta bancaria
     * @param iban Número de IBAN del que se quiere obtener el saldo.
     * @return Devuelve el saldo o si no existe -1
     */
    public double obtenerSaldo(String iban) {
         for (CuentaBancaria cb:cuentasBancarias) {
            if (cb.getIban().equalsIgnoreCase(iban)){
                return cb.getSaldo();
            }
        }
        return -1;  //En caso que no se encuentre devuelve -1
    }
    
    /**
     * Método que elimina una cuenta del banco si el saldo es cero
     * @param iban Número de IBAN del que se quiere obtener el saldo.
     * @return True si se ha realizado con exito y false en casi contrario
     */
    public boolean eliminarCuenta(String iban){
        for (CuentaBancaria cb:cuentasBancarias) {
            if (cb.getIban().equalsIgnoreCase(iban) && cb.getSaldo()==0) {
                return cuentasBancarias.remove(cb);
            }
        }
        return false;
    }
    
    /**
     * Guarda los datos en el fichero datoscuentasbancarias.dat
     * @return 0 si todo está correcto, 1 No encontradi, 2 problemas con el archivo, 3 Otro error
     */
    public boolean guardarDatos() {
        /**
         * Definimos variables para usar ficheros
         */
        FileOutputStream fichero = null;
        ObjectOutputStream salida = null;
        boolean valorRetorno = true;
        
        try {
            fichero = new FileOutputStream("datoscuentasbancarias.dat"); 
            salida = new ObjectOutputStream(fichero); 
            
            salida.writeObject(this.cuentasBancarias);   
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            valorRetorno = false;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            valorRetorno = false;
        } finally {
            if (fichero != null) { //SI el fichero tiene datos es que esta abierto
                try {
                    fichero.close();    //Cierra el fichero abierto
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    valorRetorno = false;
                }
            }
        }
        return valorRetorno;
    }
    
    /**
     * Lee el fichero datoscuentasbancarias.dat que es donde estan almacenados los datos de los clientes
     * @return True si todo está correcto
     */
    public boolean cargarDatos() {
        /**
         * Definimos variables para usar ficheros
         */
        FileInputStream fichero = null;
        ObjectInputStream salida = null;
        boolean valorRetorno = true;
                
        try {
            fichero = new FileInputStream("datoscuentasbancarias.dat");
            salida = new ObjectInputStream(fichero);        
            
            this.cuentasBancarias = (HashSet) salida.readObject(); //Lee todo el fichero y como es de tipo Object pues lo casteamos al tipo de la colección
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            valorRetorno = false;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            valorRetorno = false;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            valorRetorno = false;
        } finally {
            if (fichero != null) {  //SI el fichero tiene datos es que esta abierto
                try {
                    fichero.close();    //Cierras el fichero abierto
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    valorRetorno = false;
                }
            }
        }
        return valorRetorno;
    }
    
    /**
     *  Genera un fichero de texto llamado ListadoClientesCCC.txt con los IBAN y sus propietarios
     * @return True si todo ha ido bien y False si fallo algo.
     */
    public boolean listadoClientes() {
        /**
         * Definición de variables para manupular ficheros
         */
        FileWriter fichero = null;
        PrintWriter pw = null;
        boolean estado = true;
        
        //Inicializamos los objetos para manipular el fichero de 
        if (!this.cuentasBancarias.isEmpty()) {
            try {
                fichero = new FileWriter("ListadoClientesCCC.txt"); //Si quiera concatenar contenido añado true
                pw = new PrintWriter(fichero);
                    
                pw.println("--------------------------------------------------");
                pw.println("---------------Listado de Clientes----------------");
                pw.println("--------------------------------------------------");
                for (CuentaBancaria cb:cuentasBancarias){
                    pw.println("{" + cb.getIban() + " , " + 
                                        cb.getTitular().getNombre() + " " + 
                                        cb.getTitular().getApellidos() + "}");
                }
                pw.println("--------------------------------------------------");
                pw.println("Total de cuentas existentes: " + cuentasBancarias.size());
                pw.println("--------------------------------------------------");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                estado = false;
            } finally {
                if (fichero != null) {
                    try {
                        fichero.close();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }        
        } else {
            estado = false;
        }       
        return estado;
    }
}
