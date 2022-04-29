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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cambiarAppColores(ActionEvent event) throws IOException {
        
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewColores.fxml"));
       
        Parent root = loader.load();
        
        ViewColoresController controladorColores = loader.getController();
        
        Scene scene = new Scene(root, 800, 600);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.setTitle("Practica Colores");
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
    
}
