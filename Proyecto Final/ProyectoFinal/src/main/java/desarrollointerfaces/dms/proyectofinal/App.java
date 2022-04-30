package desarrollointerfaces.dms.proyectofinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 500, 300);
        
        String css = this.getClass().getResource("estilos/hojaPrincipal.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        
        stage.setTitle("Recopilacion de Proyectos - Desarrollo de Interfaces");
        stage.getIcons().add(new Image("desarrollointerfaces/dms/proyectofinal/images/iconoPrincipal.png"));
        stage.initStyle(StageStyle.DECORATED);
        
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}