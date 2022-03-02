/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog07_tarea;

/**
 * Clase Banco para la gestión de las cuentas del Banco
 * @author JRBlanco
 */
public class Banco {
    private final byte MAX_NUM_CUENTAS = 100;       //Número maximo de Cuentas permitidas en el banco
    
    private CuentaBancaria[] cuentasBancarias;      //Array para guardar las cuentas
    private byte num_cuentas;                       //Las cuentas que están creadas en el banco

    /**
     * Contructor de la clase
     * 
     * Inicializa el array con el Maximo de cuentas que se establece en la constante 
     * MAX_NUM_CUENTAS y pone el num_cuentas a 0
     */
    public Banco() {
        this.cuentasBancarias = new CuentaBancaria[MAX_NUM_CUENTAS];
        this.num_cuentas = 0;
    }
    
    /**
     * Método para buscar una cuenta bancaria por medio de su IBAN
     * 
     * @param iban numero IBAN que se desea buscar
     * @return Devuelve un cadena de texto con los datos de la cuenta o NULL sino existe
     */
    public String informacionCuenta(String iban) {
        for (int i=0;i<this.num_cuentas;i++){
            if (this.cuentasBancarias[i].getIban().equalsIgnoreCase(iban)) {
                return this.cuentasBancarias[i].devolverInfoString();   //Si le ha encontrado utilizo devuelvo los datos y termina el FOR
            }
        }
        return null;
    }
    
    /**
     * Método pata abrir una cuenta, añadiendo al array la cuenta que se pasa
     * @param cb Cuenta Bancaria, usando el polimorfismo almacenamos en el array uno de los diferentes objetos de cuentas
     * @return Devuelve true si todo es correcto y false sino ha añadido nada.
     */
    public boolean abrirCuenta(CuentaBancaria cb) {        
        if (cb != null) {                               //Verifico que el objeto que se ha pasado no sea NULL
            if (this.num_cuentas < MAX_NUM_CUENTAS) {   //Si hay menos cuentas del máximo permitido
                if (this.informacionCuenta(cb.getIban()) == null) {
                    this.cuentasBancarias[num_cuentas] = cb;
                    num_cuentas++;
                    return true;                
                }
            }    
        }               
        return false;
    }
    
    /**
     * Método que lista todas las cuentas del Banco
     * @return Cadena de caracteres con los datos de las diferentes cuentas, sino hay datos que lista retorna NULL
     */
    public String[] listadoCuentas() {
        String[] listado = null;
        if (this.num_cuentas != 0) {
            listado = new String[this.num_cuentas];
            for (int i=0;i<this.num_cuentas;i++) {
                listado[i] = this.cuentasBancarias[i].devolverInfoString();
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
        for (int i=0;i<this.num_cuentas;i++){
            if (this.cuentasBancarias[i].getIban().equalsIgnoreCase(iban)) {
                this.cuentasBancarias[i].ingresoDinero(ingreso);        //Llama al método que ingresa el dinero en cuenta
                return true;                                            //Un vez ingresado llamamo a return para que finalice el método y devuel true
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
        for (int i=0;i<this.num_cuentas;i++){
            if (this.cuentasBancarias[i].getIban().equalsIgnoreCase(iban)) {
                return this.cuentasBancarias[i].retirarDinero(retira);          //Retira el dinero de la cuenta
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
        for (int i=0;i<this.num_cuentas;i++){
            if (this.cuentasBancarias[i].getIban().equalsIgnoreCase(iban)) {
                //((Object)banco).getClass().getSimpleName()  // Para saber que tipo de objeto es.
                return this.cuentasBancarias[i].getSaldo();   //Si le ha encontrado llama al metodo getSaldo y nos da el saldo de la cuenta
            }
        }       
        return -1;  //En caso que no se encuentre devuelve -1
    }
    
    
    
}
