/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package practicatemporizador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Dani
 */
public class PracticaTemporizador extends Application {
    
    private Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        this.stage = stage;
        this.stage.setTitle("Temporizador");
        this.stage.getIcons().add(new Image("/images/icono.png"));
        
        stage.initStyle(StageStyle.DECORATED);
        
        Parent root = FXMLLoader.load(getClass().getResource("/vista/ViewTemporizador.fxml"));
        Scene scene = new Scene(root);
        
        String css = this.getClass().getResource("/estilos/hoja.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
