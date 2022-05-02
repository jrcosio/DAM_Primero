/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.math.BigDecimal;
import java.math.MathContext;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author José Ramón Blanco
 */
public class CalculadoraController implements Initializable {

    @FXML
    private Button btn0;
    @FXML
    private Button btnIgual;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btnSumar;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btnRestar;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btnMultiplicar;
    @FXML
    private Button btnDividir;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnBorrar;
    @FXML
    private Label lbOperacion;
    @FXML
    private Label lbDigitos;
    @FXML
    private Button btnPotencia;
    @FXML
    private Button btnRaiz;
    @FXML
    private Button btnPunto;
    
    //----------------------------------------------
    //----------- Para las operaciones -------------
    //----------------------------------------------
    private BigDecimal operador; //Para almacenar el numero en pantalla
    private String operacion;       //Para guardar la operación (+ - * /)
    private boolean checkOperacion; //para saber si se ha pulsado una operacion   

    /**
     * Métoto getPantalla
     * Es un getter pero no del objeto sino del atributo texto que muestra en pantalla
     * @return 
     */
    public String getPantalla() {
        return lbDigitos.getText();
    }
    
    /**
     * Métoto setPantalla
     * Es un setter pero no para cambiar el objeto sino del atributo texto que este muestre
     * y con este método cambiamos el texto.
     * 
     * @param nuevoDigito El nuevo digito que se desea mostrar en la patalla de la calculadora
     * 
     */
    public void setPantalla(String nuevoDigito) {
        this.lbDigitos.setText(nuevoDigito);
    }

    /**
     * Initializes the controller class.
     * 
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.checkOperacion = false;    //Inicializamos a false el atributo
    }    

    /**
     * Método clickBtnNum
     * Con este método se va creando un número que sea válido, es decir:
     *      - que no comienze por cero -> 0XXXX
     *      - que no empieze por punto -> .XXXXX
     *      - que solo tenga un punto decimal XXX.XXXX
     * 
     * @param event 
     */
    @FXML
    private void clickBtnNum(ActionEvent event) {
        Button btn = (Button) event.getSource(); //En la variable btn copiamos todos los datos del botón que ha generado el evento
        String aux = getPantalla();
                
        if (this.checkOperacion){
            if (btn.getText().equals(".")) // esto es para evitar que solo muestre un punto
                aux = "0.";
            else
                aux = btn.getText();
            checkOperacion = false;
        } else { 
            if (aux.equals("0"))                    //Si en pantalla hay un 0
                if (btn.getText().equals("."))      //Si se ha pulsado el punto
                    aux += btn.getText();           //Pues añadimos ese punto y queda así -> 0.
                else
                    aux = btn.getText();            //Cambia el 0 por el numero nuevo del 1 al 9
            else
                if (btn.getText().equals(".")) {    //Si hay un solo "0" y se ha pulsado un punto
                    if (!aux.contains("."))         //Si no se tiene un punto ya introducido
                        aux += btn.getText();       //Añade a que haya un punto -> XXX.
                }
                else
                    aux += btn.getText();           //Añade cualquier numero del 0 al 9
        }
        setPantalla(aux);
    }
    
    /**
     * Método btnOperador
     * Este método se lanza al pulsar + - * / =
     * y es para hacer las operaciones de la calculadora
     * @param event 
     */
    @FXML
    private void btnOperador(ActionEvent event) {
        
        Button btn = (Button) event.getSource();  //Obtenemos el objeto que ha generado el evento para saber que operación vamos a realizar

        BigDecimal entradaOperador = new BigDecimal(getPantalla());      //Leemos el digito que tenemos en pantalla

        if (this.operador == null) {            //Si es NULL el atributo donde lo almacenamos el primer operador
            this.operador = entradaOperador;    //pues le iniciamos en el valor de pantalla
        } else if (this.operacion != null) {    //si hay una operación en marcha
            switch (this.operacion){            //pregunta cul es la operación y en función de la que sea la realiza.
                case "+" -> this.operador = this.operador.add(entradaOperador);
                case "-" -> this.operador = this.operador.subtract(entradaOperador);
                case "*" -> this.operador = this.operador.multiply(entradaOperador);
                case "/" -> {
                    try {
                        this.operador = this.operador.divide(entradaOperador,MathContext.DECIMAL32);  //MathContext es la precisión del coma flotante
                    } catch (ArithmeticException ex) {      //Controlamos la división entre cero
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error" );
                        alert.setContentText("No se puede dividir entre cero.\n" + ex.getMessage());
                        alert.showAndWait();
                    }
                }
            }
            setPantalla(this.operador.toString());  //Muestra el resultado en pantalla.
        }
        if (btn.getText().equals("=")) { //Si la tecla pulsada es la de = pues inicia todo, sin borrar la pantalla
           // this.operacion = null;
            this.operador = null;
            lbOperacion.setText(lbOperacion.getText() + entradaOperador.toString() + " = ");  //Operación completa realiza
        } else {
            this.operacion = btn.getText();    //almacena la operación.
            lbOperacion.setText(this.operador.toString() + " " + this.operacion + " ");  //Muestra cual es la operación
        }

        this.checkOperacion =true;  //la activa para cambiar el valor de pantalla
        
    }

    /**
     * Método que se encargar de resetear toda la calculadora
     * borra las operaciones iniciadas y pone a cero todo.
     * 
     * @param event Es el objeto que ha regenerado el evento
     */
    @FXML
    private void ClickBtnReset(ActionEvent event) {
        setPantalla("0"); //Restablece la pantalla a cero
        lbOperacion.setText("");
        this.checkOperacion = false;
        this.operador = null;
        this.operacion = null;
    }

    /**
     * Método que borra el ultimo digito.
     * 
     * @param event Es el Objeto que ha generado el evento
     */
    @FXML
    private void ClickBtnBorrar(ActionEvent event) {
        String aux = getPantalla().substring(0,getPantalla().length()-1);
  
        if (aux.length()<=0)
            setPantalla("0");
        else
            setPantalla(aux);
        
    }

    /**
     * Método ClickBtnPotencia
     * Calcula el cuadrado de un número
     * @param event 
     */
    @FXML
    private void ClickBtnPotencia(ActionEvent event) {
        BigDecimal valor = new BigDecimal(getPantalla());   
        setPantalla(valor.pow(2).toString());
    }

    /**
     * Método ClickBtnRaiz
     * Calcula la raiz cuadrada de un numero
     * @param event 
     */
    @FXML
    private void ClickBtnRaiz(ActionEvent event) {
         BigDecimal valor = new BigDecimal(getPantalla());
         
         try {
            setPantalla(valor.sqrt(MathContext.DECIMAL32).toString());
         } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error" );
            alert.setContentText("Intento de raíz cuadrada de un número negativo\n" + ex.getMessage());
            alert.showAndWait();
         }
    }
    
    
}
