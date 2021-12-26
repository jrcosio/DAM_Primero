package prog02_ejercicio1;

/**
 *
 * @author José Ramón Blanco Gutiérrez
 */
public class PROG02_Ejercicio1 {

    /**
     * Crea un proyecto en Netbeans denominado PROG02_Ejerc1 con una clase clase y
     * método main y declara e inicializa una variable para almacenar cada uno de los siguientes valores.
     * Trata de utilizar el tipo de datos de mas se ajuste a los datos.
     * Justifica tu elección.
     */
    public static void main(String[] args) {
        //Valor máximo no modificable: 5000
        //Explición: Las constantes (final) no se pueden modicar por eso lo he usado y he usado Short ya que para el valor
        //           5000 es tipo de datos más pequeño en el que entra el número.
        final short VALOR_MAXIMO = 5000;
        System.out.printf("\nValor de VALOR_MAXIMO: %d",VALOR_MAXIMO);
        
        //Si el nuevo empleado tiene carnet de conducir o no
        //Explicación: He seleccionado de tipo boleano ya que es para almacesar si o no, o en el caso de java true (si) o false (no)
        boolean empledadoTieneCarnet = true;
        System.out.printf("\nValor de empledadoTieneCarnet: " + empledadoTieneCarnet);
        
        //Un mes del año en formato numérido y como cadena.
        //Explicación: He seleccionado el tipo byte ya que el numero maximo que almacenaría es 12 por lo tanto el dato mas
        //             pequeño en el que entra es byte.
        byte mes = 1;
        System.out.printf("\nValor de mes: %d", mes);
        
        //Explicación: Para Almacenar una cadena de texto el tipo es String
        String mesCadena = "Enero";
        System.out.printf("\nValor de mesCadena: %s", mesCadena);
        
        //El nombre y apellidos de una persona.
        //Explicacción: Para almacenar texto como es el nombre y apellidos de una personas el tipo de dato es el String
        String nombreYApellidos = "José Ramón Blanvo Gutiérrez";
        System.out.printf("\nValor de nombreYApellidos: %s", nombreYApellidos);
        //Sexo: con dos valores posibles 'V' o 'M'.
        //Explicacción: como nos pide almacenar una 'V' o una 'M' que son caracteres por eso he escogido char
        char sexo = 'V';        
        System.out.printf("\nValor de sexo: %c", sexo);
        
        //Milisegundos transcurridos desde el 01/01/1970 hasta nuestros días.
        //Explicación: El numero de milisegundos será un numero muy grande he seleccionado long que es el que más capacidad tiene
        long milisegundos = 621355968000000000L;
        System.out.printf("\nValor de milisegundos: %d",milisegundos);
        //Saldo de una cuenta bancaria.
        //Explicación: El tipo float es el tipo que permite decimales, por eso para almacenar cifras de dinero es el que he seleccionado.
        float saldoCuenta = 21324.50f;
        System.out.printf("\nValor de saldoCuenta: %f",saldoCuenta);
        //Distancia en kms desde la Tierra a Júpiter.
        //Explicación: He seleccionado int, ya que la distancia aproximada entre la Tierra y Jupiter es de 600.000.000 a 900.000.000 kilometros por
        //             lo tanto es una cifra que entra perfectamente en el tipo int de Java. Fuente: https://es.great-spacing.com/publication/13606/
        int kilometosJupiter = 588000000;      
        System.out.printf("\nValor de kilometrosJupiter: %d\n", kilometosJupiter);
    }
    
}
