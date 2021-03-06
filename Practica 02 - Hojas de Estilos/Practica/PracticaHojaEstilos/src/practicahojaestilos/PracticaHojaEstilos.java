/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package practicahojaestilos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Dani
 */
public class PracticaHojaEstilos extends Application {

    private Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        //Añadiendo Titulo a la Aplicacion
        this.stage = stage;
        this.stage.setTitle("Hoja de Estilos");
        
        //Añadiendo Icono
        this.stage.getIcons().add(new Image("/images/css.png"));
        
        //Cargamos la vista que vamos a cargar en la aplicacion
        
        Parent root = FXMLLoader.load(getClass().getResource("/vista/ViewEstilos.fxml"));
        Scene scene = new Scene(root);
        
        //Indicamos la hoja de estilo CSS que vamos a añadir a nuestra aplicacion
        String css = this.getClass().getResource("/estilos/hojaprincipal.css").toExternalForm();
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
