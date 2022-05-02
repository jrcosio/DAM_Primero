/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelo.Validar;
import Modelo.Vehiculo;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JRBlanco
 */
public class FormularioVehiculoController implements Initializable {

    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtMatricula;
    @FXML
    private TextField txtKm;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtPropietario;
    @FXML
    private TextField txtDni;
    @FXML
    private DatePicker dpFecha;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCerrar;
    
    private Vehiculo vehiculo;
    private ObservableList<Vehiculo> vehiculos;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public TextField getTxtMatricula() {
        return txtMatricula;
    }
    
    /**
     * Método para pasar al formulario de nuevo el arraylist
     * @param v 
     */
    public void iniciarAtributos(ObservableList<Vehiculo> v) {
        this.vehiculos = v;
    }
    /**
     * Método para pasar al formulario en modo editar el arralist y el objeto seleccionado
     * para modificar.
     * @param v 
     */
    public void iniciarAtributos(ObservableList<Vehiculo> vList, Vehiculo veh ) {
        //Iniciamos los objetos
        this.vehiculos = vList;
        this.vehiculo = veh;
        //Llena los textfield con los datos pasados
        this.txtMarca.setText(veh.getMarca());
        this.txtMatricula.setText(veh.getMatricula());
        this.txtKm.setText(veh.getKilometros()+"");
        this.dpFecha.setValue(veh.getFechaMatriculacion());
        this.txtDescripcion.setText(veh.getDescripcion());
        this.txtPrecio.setText(veh.getPrecio()+"");
        this.txtPropietario.setText(veh.getNombrePropietaro());
        this.txtDni.setText(veh.getDniPropietario());
    }

    /**
     * Método del botón de guardar, que recoge los datos de los textField y lo guarda en el atributo Vehiculo.
     * @param event 
     */
    @FXML
    private void clickBtnGuardar(ActionEvent event) {
         
        Vehiculo vehiculoTemporal=null;
        String marca = null;                   
        String matricula = null;              
        int kilometros = 0;                
        LocalDate fechaMatriculacion = null;   
        String descripcion = null;            
        float precio = 0;                   
        String nombrePropietaro = null;
        String dniPropietario = null;
        
        //Pasa los datos de los textfiels a las variables para crear un objeto temporal
        try {
            marca = this.txtMarca.getText();                   
            matricula = this.txtMatricula.getText();              
            kilometros = Integer.parseInt(this.txtKm.getText());                
            fechaMatriculacion = this.dpFecha.getValue();   
            descripcion = this.txtDescripcion.getText();            
            precio = Float.parseFloat(this.txtPrecio.getText());                   
            nombrePropietaro = this.txtPropietario.getText();
            dniPropietario = this.txtDni.getText();

            vehiculoTemporal = new Vehiculo(marca, matricula, kilometros, 
                                                     fechaMatriculacion, descripcion, 
                                                     precio, nombrePropietaro, dniPropietario);
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Error en los datos, posiblemente tengas datos en blanco o números incorrectos");
            alert.showAndWait();
            return;
        }
        
       
        if (!this.vehiculos.contains(vehiculoTemporal)) {   //Comprueba si existe en el arraylist el nuevo vehiculo    
            if (this.vehiculo != null) {    //Estamos modificando
                this.vehiculo.setMarca(marca);
                this.vehiculo.setMatricula(matricula);
                this.vehiculo.setKilometros(kilometros);
                this.vehiculo.setFechaMatriculacion(fechaMatriculacion);
                this.vehiculo.setDescripcion(descripcion);
                this.vehiculo.setPrecio(precio);
                this.vehiculo.setNombrePropietaro(nombrePropietaro);
                this.vehiculo.setDniPropietario(dniPropietario);
            }else {                         //Es nuevo
                this.vehiculo = vehiculoTemporal;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Info");
                alert.setContentText("Se ha añadido un nuevo vehiculo");
                alert.showAndWait();
            }
        } else {            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Atención!!");
            alert.setContentText("El vehiculo ya existe");
            alert.showAndWait();           
        }
        //Para cerrar la ventana
        Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
        stage.close();
         
    }
    
    /**
     * Método que se llama para cerrar la ventana de dialogo.
     * @param event 
     */
    @FXML
    private void ClickBtnCerrar(ActionEvent event) {
        this.vehiculo = null;
        Stage stage = (Stage) this.btnCerrar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void verificarDNI(KeyEvent event) {
        TextField txt = (TextField) event.getSource();
        
        if (!Validar.checkDNI(txt.getText())) {
            txt.setStyle("-fx-background-color: #ff6c6c;"
                       + "-fx-border-color: #bfbfbf;"
                       + "-fx-border-radius: 4px;");
        } else {
            txt.setStyle("-fx-background-color: #2A2E37;"
                        +"-fx-text-fill: #ddff00;"
                        +"-fx-border-width: 0 0 1px 0;"
                        +"-fx-border-color: #ddff00;");
        }
    }

    @FXML
    private void verificarMatricula(KeyEvent event) {
        TextField txt = (TextField) event.getSource();
        
        if (!Validar.checkMatricula(txt.getText())) {
            txt.setStyle("-fx-background-color: #ff6c6c;"
                       + "-fx-border-color: #bfbfbf;"
                       + "-fx-border-radius: 4px;");
        } else {
            txt.setStyle("-fx-background-color: #2A2E37;"
                        +"-fx-text-fill: #ddff00;"
                        +"-fx-border-width: 0 0 1px 0;"
                        +"-fx-border-color: #ddff00;");
        }
    }
    
}
