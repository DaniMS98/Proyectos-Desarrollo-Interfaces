package es.ideas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class MultiLenguajeUI extends Application {
    
    private Scene scene;
    
    //Metodo Start donde indicamos todo lo necesario para
    //cargar la Vista predeterminada
    @Override
    public void start(Stage stage) throws IOException {
        //Creamos un objeto FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        
        //Indicamos la localizacion de nuestra vista fxml
        loader.setLocation(getClass().getResource("primary.fxml"));
        
        //Indicamos el lugar donde se encuentra nuestro 
        //bundle.properties predeterminado
        loader.setResources(ResourceBundle.getBundle("es.ideas.idiomas.bundle"));
        
        //Carga todos los datos en un Parent
        Parent root = loader.load();
      
        //Indicamos el Titulo de la Ventana y el Estilo
        stage.setTitle("Multi-Lenguaje");
        stage.initStyle(StageStyle.DECORATED);
        
        //Seleccionamos la ventana y sus medidas
        scene = new Scene(root, 1000, 700);
        
        //Agregamos la hoja de estilos predeterminada que queremos cargar
        //al inicio de la aplicacion
        String css = this.getClass().getResource("hoja.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        //Mostramos la vista
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