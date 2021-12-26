// -> Dentro del proyecto, crea un paquete denominado com.prog03.figuras.
package com.prog03.figuras;

/**
 *
 * @author José Ramón Blanco
 * 
 * -> Dentro de dicho paquete, crea una clase denominada Rectangulo
 */
public class Rectangulo {
    // -- Atributos --
    // -> Declare atributos para la base y la altura de un rectángulo
    // Les declaramos de forma privada para que no se puedan manipular desde fuera de la clase
    private int base;
    private int altura;

    // -> Declare un constructor vacío que inicialice los atributos a 0.
    public Rectangulo() {
        this.base = 0;
        this.altura = 0;
    }
    
    // -> Declara un constructor que inicialice base y altura.
    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }
    
    // -> Métodos para actualizar y obtener el valor de cada atributo.
    // -- Getter y Setter

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    // -> float getArea(): devuelve el área del rectángulo.
    /** 
     *  Explicación: El area de un rectangulo es base por altura, así que multiplicamos los dos
     *               atributos y devuelve el resultado que es el área.
     */
    public int getArea() {
        return this.base * this.altura;
    }

    // -> String toString(): devuelve una cadena conteniendo su área y su altura.
    /**
     * Explicación: @Override, al ser un método de la clase Object que es de la cual todas las clase en JAVA
     *              heredan el IDE nos re comienda poner el overrride indicando que estamos sobreescribiendo
     *              este método de la clase Object, funciona sin ponerlo pero nos da un warning
     * 
     *              Para que devuelva el área llamamos al método creado anterior que obteniamos el área y
     *              para la altura llamamos directamente al atributo ya que desde dentro de la clase podemos usar
     *              los atributos privados.
     */
    @Override
    public String toString() {
        return "El área del rectangulo es: " + getArea() + " y su altura es: " + this.altura;
    }
    
    // -> boolean isCuadrado(): devuelve un booleadno indicando si el rectángulo es cuadrado.
    /**
     * Explicación: Es un cuadrado cuando base y altura tienen la misma medida, por lo tanto le decirmos
     *              que compruebe si base es igual que altura y al ser una comparativa esta devuelve true o false
     */
    public boolean isCuadrado(){
        return (base==altura);
    }
    
    
    
    
    
    
}
