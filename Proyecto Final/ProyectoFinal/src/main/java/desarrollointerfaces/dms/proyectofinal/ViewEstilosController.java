/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Dani
 */
public class ViewEstilosController implements Initializable {
    
    Stage stage;
    @FXML
    private Button btnEstilo1, btnEstilo2, btnEstilo3;
    
    @FXML
    private Button btnControl1;
    
    @FXML
    private CheckBox btnControl2;
    
    @FXML
    private RadioButton btnControl3;
    
    @FXML
    private ComboBox btnControl4;
    
    @FXML
    private ToggleButton btnControl5;
    
    @FXML
    private HBox hbox;
    
    
    
    //Cambiar entre Hojas de Estilos
    
    @FXML
    private void onClickEstilos(ActionEvent event) throws IOException {
        
        //Guarda un objeto para recoger el evento de acción
        Object evnt = event.getSource();
        
        //Guardamos los estilos en los resources
        String estilo1 = this.getClass().getResource("estilos/hojaEstilos01.css").toExternalForm();
        String estilo2 = this.getClass().getResource("estilos/hojaEstilos02.css").toExternalForm();
        String estilo3 = this.getClass().getResource("estilos/hojaEstilos03.css").toExternalForm();
        String hojaPrincipal = this.getClass().getResource("estilos/hojaEstilos.css").toExternalForm();
        
         //Si pulsamos el primer boton entonces cambia todo el estilo de los botones que hemos indicado
        
        if(evnt.equals(btnEstilo1)) {
            
            if(hbox.getStylesheets().get(0).contains("hojaEstilos.css")) {
                
                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo1);
                     
            } else if(hbox.getStylesheets().get(0).contains("hojaEstilos02.css")) {
                
                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo1);
                
            } else if(hbox.getStylesheets().get(0).contains("hojaEstilos03.css")) {
                
                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo1);
                
            }
            
        } else if(evnt.equals(btnEstilo2)) {
            
            if(hbox.getStylesheets().get(0).contains("hojaEstilos.css")) {
                
                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo2);
                
            } else if(hbox.getStylesheets().get(0).contains("hojaEstilos01.css")) {
                
                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo2);
                
            } else if(hbox.getStylesheets().get(0).contains("hojaEstilos03.css")) {
                
                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo2);
                
            }
            
        } else if(evnt.equals(btnEstilo3)) {
            
            if(hbox.getStylesheets().get(0).contains("hojaEstilos.css")) {
                
                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo3);
                
            } else if(hbox.getStylesheets().get(0).contains("hojaEstilos01.css")) {
                
                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo3);
                
            } else if(hbox.getStylesheets().get(0).contains("hojaEstilos02.css")) {
                
                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo3);
                
            }   
        }   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        public void closeWindows() {
        
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
            
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.setScene(scene);
            stage.show();
            
            Stage miStage = (Stage) this.btnControl1.getScene().getWindow();
            miStage.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
