/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jrblanco
 */
public class Main extends Application{

    @Override
    public void start(Stage stage) throws Exception {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("/Views/CalculadoraView.fxml"));
//        Pane ventana = (Pane) loader.load();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/CalculadoraView.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Calculadora Tarea 10 DAM");
        stage.show();    
    }
    
    public static void main(String[] args) {
        System.out.println("Iniciando Calculadora JavaFX...");
        launch(args);
    }
}
