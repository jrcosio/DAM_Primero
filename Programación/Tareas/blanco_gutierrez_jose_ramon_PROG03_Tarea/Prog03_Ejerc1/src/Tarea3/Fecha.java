
/**
 *
 * Construye un nuevo proyecto Java denominado Prog03_Ejerc1. En el proyecto debe aparecer un paquete,
 * que no puede ser el paquete por defecto, ponle el nombre que creas oportuno.
 */
package Tarea3;

/**
 *
 * @author José Ramón Blanco
 * 
 */

/**
 * Enumerador para los meses.
 * NOTA NO HE PUESTO EL PUBLIC PARA QUE NO DE ERROR EL IDE ya que pide crear nuevo fichero, como clase o pseudo clase que es...
 * public enum enumMes {....
 */
enum enumMes {
    ENERO,
    FEBRERO,
    MARZO,
    ABRIL,
    MAYO,
    JUNIO,
    JULIO,
    AGOSTO,
    SEPTIEMBRE,
    OCTUBRE,
    NOVIEMBRE,
    DICIEMBRE;
}

/**
 *  Crea una clase denominada Fecha. Esta clase no debe contener método main.
 */
public class Fecha {
    // -- Atributos ---
    private int dia;
    private enumMes mes;
    private int anio;

    
    //    -- Contructores --
    
    //Implementa un constructor que inicialice el mes al valor recibido por parámetro y los demás atributos a 0.
    public Fecha(enumMes mes) {
        this.mes = mes;
        this.dia = 0;
        this.anio = 0;
    } 
    //Declara otro constructor que inicialice todos los atributos de la clase.
    public Fecha(int dia, enumMes mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    /*
        -- Métodos Getter y Setter --
        Implementa los métodos que permitan acceder y modificar cada uno de los atributos de la clase.
        Los nombres de dichos métodos serán: getXXX () para obtener el valor del atributo XXX y setXXX(v)
        para actualizar el atributo XXX con el valor v.
        Explicación: Dado que los atributos son privados por lo tanto no se puede acceder a ellos desde fuera de la clase,
                     por lo tanto se crean los getter y setter para nada atributo y así de forma controlada se pueden modificsar los datos.
    */
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public enumMes getMes() {
        return mes;
    }

    public void setMes(enumMes mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    /**
     *  Método: isSummer
     *  Descripción: Implementa un método que devuelva true si el valor contenido en la fecha es verano y false en caso contrario.
     *  Devuelve: true/false
     *  Explicación: Dado que el verano va desde el 21 de Junio hasta el 21 de Septiembre, pues he includo esa compararión que en JUNIO
     *               ademas de comprar el mes tambien tambien tiene que ser mayo o igual de 21. 
     *               Y para septiembre lo mismo salvo que tiene que ser menor de 21.
     */
    public boolean isSummer() {          
        return ((this.mes.equals(enumMes.JUNIO) && this.dia>=21) || 
                 this.mes.equals(enumMes.JULIO) || 
                 this.mes.equals(enumMes.AGOSTO) || 
                (this.mes.equals(enumMes.SEPTIEMBRE) && this.dia<21));
    }
    
    /**
     *   Método: toString
     *   Descripción: Implementa un método que devuelva una cadena con la fecha en formato largo, por ejemplo, 15 de julio de 2020.
     *   Devuelve: Cadena con el formato de fecha en este: DIA de MES de AÑO
     *   Explicación: Como es un método que esta especificado en la clase Object de la cual todas las clases en Java heredan su comportamiento,
     *                al crear el método toString el IDE nos recomienda poner @override para indicar que sobreescribimos dicho método, aunque si
     *                el funciona perfectamente.
     * 
     *                this.mes.name().toLowerCase() -> Utilizo este método ya que como el enum están los meses en mayusculas, con este método
     *                                                 salen en minuculas, cumpliendo así la salida deseada que este en minusculas.
     *
     *                @Override, al ser un método de la clase Object que es de la cual todas las clase en JAVA
     *                heredan, el IDE nos recomienda poner el overrride indicando que estamos sobreescribiendo
     *                este método de la clase Object, funciona sin ponerlo pero nos da un warning
     */   
    @Override
    public String toString() {
        return this.dia + " de " + this.mes.name().toLowerCase() + " de " + this.anio ;
    }
    
    
}
