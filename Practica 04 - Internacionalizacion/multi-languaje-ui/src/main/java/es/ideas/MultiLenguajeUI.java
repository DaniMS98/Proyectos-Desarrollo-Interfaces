package es.ideas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class MultiLenguajeUI extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("primary.fxml"));
        loader.setResources(ResourceBundle.getBundle("es.ideas.idiomas.bundle"));
        
        Parent root = loader.load();
      
        stage.setTitle("Multi-Lenguaje");
        stage.initStyle(StageStyle.DECORATED);
        
        Scene scene = new Scene(root, 1000, 700);
        stage.setScene(scene);
        stage.show();
    }

   /* static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MultiLenguajeUI.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
*/

    public static void main(String[] args) {
        launch(args);
    }

}