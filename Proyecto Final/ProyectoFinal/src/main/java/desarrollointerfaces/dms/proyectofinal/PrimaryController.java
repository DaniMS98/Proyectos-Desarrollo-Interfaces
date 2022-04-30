/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package desarrollointerfaces.dms.proyectofinal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Dani
 */
public class PrimaryController implements Initializable {

    @FXML
    private Button btnAppColores;
    @FXML
    private Button btnAppEstilos;
    @FXML
    private Button btnAppTemporizador;
    @FXML
    private Button btnAppInternacionalizacion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /*
    Cambiar a la Aplicación de Colores
    */

    @FXML
    private void cambiarAppColores(ActionEvent event) throws IOException {
        
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewColores.fxml"));
       
        Parent root = loader.load();
        
        ViewColoresController controladorColores = loader.getController();
        
        Scene scene = new Scene(root, 800, 600);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.setTitle("Aplicación Colores");
        stage.getIcons().add(new Image("desarrollointerfaces/dms/proyectofinal/images/coloresRGB.png"));
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
        
        stage.setOnCloseRequest(eh -> controladorColores.closeWindows());
        
        Stage miStage = (Stage) this.btnAppColores.getScene().getWindow();
        miStage.close();
        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    /*
    Cambiar a la Aplicación de Hojas de Estilos
    */

    @FXML
    private void cambiarAppEstilos(ActionEvent event) {
        
                try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewEstilos.fxml"));
       
        Parent root = loader.load();
        
        ViewEstilosController controladorEstilos = loader.getController();
        
        Scene scene = new Scene(root, 800, 600);
        Stage stage = new Stage();
        
        String css = this.getClass().getResource("estilos/hojaEstilos.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.setTitle("Aplicación Hojas de Estilos");
        stage.getIcons().add(new Image("desarrollointerfaces/dms/proyectofinal/images/css.png"));
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
        
        stage.setOnCloseRequest(eh -> controladorEstilos.closeWindows());
        
        Stage miStage = (Stage) this.btnAppEstilos.getScene().getWindow();
        miStage.close();
        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
                
    }

    /*
    Cambiar a la Aplicación del Temporizador
    */
    
    @FXML
    private void cambiarAppTemporizador(ActionEvent event) {
        
          try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewTemporizador.fxml"));
       
        Parent root = loader.load();
        
        ViewTemporizadorController controladorTemporizador = loader.getController();
        
        Scene scene = new Scene(root, 850, 400);
        Stage stage = new Stage();
        
        String css = this.getClass().getResource("estilos/hojaTemporizador.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.setTitle("Aplicación Temporizador");
        stage.getIcons().add(new Image("desarrollointerfaces/dms/proyectofinal/images/icono.png"));
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
        
        stage.setOnCloseRequest(eh -> controladorTemporizador.closeWindows());
        
        Stage miStage = (Stage) this.btnAppTemporizador.getScene().getWindow();
        miStage.close();
        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    /*
    Cambiar a la Aplicación de Internacionalización
    */
    
    @FXML
    private void cambiarAppInternacionalizacion(ActionEvent event) {
        
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewIntern.fxml"));
        
        loader.setResources(ResourceBundle.getBundle("desarrollointerfaces.dms.proyectofinal.idiomas.bundle"));
       
        Parent root = loader.load();
        
        ViewInternacionalizacionController controladorInternacionalizacion = loader.getController();
        
        Scene scene = new Scene(root, 1000, 700);
        Stage stage = new Stage();
        
        String css = this.getClass().getResource("estilos/hojaInternacionalizacion.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.setTitle("Aplicación Internacionalización");
        stage.getIcons().add(new Image("desarrollointerfaces/dms/proyectofinal/images/espana.png"));
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
        
        stage.setOnCloseRequest(eh -> controladorInternacionalizacion.closeWindows());
        
        Stage miStage = (Stage) this.btnAppInternacionalizacion.getScene().getWindow();
        miStage.close();
        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
                  
    }
    
}
