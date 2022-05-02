
package Controlador;

import Modelo.Vehiculo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author JRBlanco
 */
public class CochesController implements Initializable {

    @FXML
    private TableView<Vehiculo> tablaVehiculos;
    @FXML
    private TableColumn columMarca;
    @FXML
    private TableColumn columMatricula;
    @FXML
    private TableColumn columKm;
    @FXML
    private TableColumn columFecha;
    @FXML
    private TableColumn columDescrip;
    @FXML
    private TableColumn columPrecio;
    @FXML
    private TableColumn columPropietario;
    @FXML
    private TableColumn columDni;

    private ObservableList<Vehiculo> vehiculos;
    
    @FXML
    private MenuItem menuBorrarVehiculo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vehiculos = FXCollections.observableArrayList();    //Inicializa el ObservableList con un ArrayList de JavaFX
        this.tablaVehiculos.setItems(vehiculos);            //Vincula a la tabla el Arraylist
        
        //-- Asocia cada atributo de Vehiculo con las columnas de la tabla
        this.columMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        this.columMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
        this.columKm.setCellValueFactory(new PropertyValueFactory("kilometros")); 
        this.columFecha.setCellValueFactory(new PropertyValueFactory("fechaMatriculacion"));
        this.columDescrip.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.columPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
        this.columPropietario.setCellValueFactory(new PropertyValueFactory("nombrePropietaro"));
        this.columDni.setCellValueFactory(new PropertyValueFactory("dniPropietario"));
    }    
    
    /**
     * Método para editar una vehiculo de la tabla
     * @param event 
     */
    @FXML
    private void clickEditarVehiculo(ActionEvent event) {
        
        Vehiculo vehiculotemporal = this.tablaVehiculos.getSelectionModel().getSelectedItem(); 
        
        if (vehiculotemporal == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información" );
            alert.setContentText("Se tiene que seleccionar un vehiculo para poderle borrar");
            alert.showAndWait();
        }else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/FormularioVehiculo.fxml"));

                Parent root = loader.load();

                FormularioVehiculoController controlador = loader.getController();
                controlador.iniciarAtributos(vehiculos,vehiculotemporal);
                
                controlador.getTxtMatricula().setDisable(true);

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Editar Vehiculo");
                stage.setResizable(false);
                stage.initStyle(StageStyle.UTILITY);
                stage.setScene(scene);
                stage.showAndWait();

                vehiculotemporal = controlador.getVehiculo();
                
                if (vehiculotemporal != null) {
                    this.tablaVehiculos.refresh();
             
                }                    

            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error" );
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }   
        }
    }
    /**
     * Método para borrar un elemento (Vehiculo) de la tabla
     * @param event 
     */
    @FXML
    private void clickBorrarVehiculo(ActionEvent event) {
        //Crea un objeto temporal con la fila seleccionada
        Vehiculo vehiculotemporal = this.tablaVehiculos.getSelectionModel().getSelectedItem(); 
        
        if (vehiculotemporal == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información" );
            alert.setContentText("Se tiene que seleccionar un vehiculo para poderle borrar");
            alert.showAndWait();
        } else {
            this.vehiculos.remove(vehiculotemporal); //borra el elemento selecionado
            this.tablaVehiculos.refresh(); //Actualiza la tabla

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información" );
            alert.setContentText("Se ha borrado el vehiculo " + vehiculotemporal.getMatricula());
            alert.showAndWait();            
        }
    }
    /**
     * Método para añadir un vehiculo nuevo
     * @param event 
     */
    @FXML
    private void clickNuevoVehiculo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/FormularioVehiculo.fxml"));
            
            Parent root = loader.load();
            
            FormularioVehiculoController controlador = loader.getController();
            controlador.iniciarAtributos(vehiculos);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Nuevo vehiculo");
            stage.setResizable(false);
            stage.initStyle(StageStyle.UTILITY);
            stage.setScene(scene);
            stage.showAndWait();
            
            Vehiculo vehiculoTemp = controlador.getVehiculo();
            
            if (vehiculoTemp != null) {
                this.vehiculos.add(vehiculoTemp);
                this.tablaVehiculos.refresh();
            }                    
                    
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error" );
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }      
    }    

    /**
     * Método para cerrar el programa
     * @param event 
     */
    @FXML
    private void clickSalir(ActionEvent event) {
        Stage stage = (Stage) this.tablaVehiculos.getScene().getWindow(); //De un objeto de la ventana obtenemos s Stage
        stage.close(); //Cerrar
    }
}
