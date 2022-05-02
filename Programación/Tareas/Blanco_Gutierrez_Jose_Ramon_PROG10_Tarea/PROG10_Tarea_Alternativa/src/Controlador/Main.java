
package Controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author JRBlanco
 */
public class Main extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/CochesVista.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Gestión de Vehículos Tarea DAM");
        stage.show();    
    }
    
    public static void main(String[] args) {
        System.out.println("Iniciando Gestión de vehiculos en JavaFX...");
        launch(args);
    }
    
}
