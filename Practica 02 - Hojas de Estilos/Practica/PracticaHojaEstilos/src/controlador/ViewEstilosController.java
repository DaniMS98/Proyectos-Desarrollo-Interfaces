/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controlador;

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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Dani
 */
public class ViewEstilosController implements Initializable {
    
    Stage stage;
    
    @FXML
    private Button btnEstilo1, btnEstilo2, btnEstilo3, btnControl1;
    
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
        
           Object evnt = event.getSource();
       
       //Guardamos los estilos en los resources
        String estilo1 = this.getClass().getResource("/estilos/hoja1.css").toExternalForm();
        String estilo2 = this.getClass().getResource("/estilos/hoja2.css").toExternalForm();
        String estilo3 = this.getClass().getResource("/estilos/hoja3.css").toExternalForm();
        String hojaPrincipal = this.getClass().getResource("/estilos/hojaprincipal.css").toExternalForm();
       
       //Si pulsamos el primer boton entonces cambia todo el estilo de los botones que hemos indicado
        
        if(evnt.equals(btnEstilo1)) {
            
            if(hbox.getStylesheets().get(0).contains("hojaprincipal.css")) {

                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo1);

            } else if(hbox.getStylesheets().get(0).contains("hoja2.css")) {

                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo1);

            } else if(hbox.getStylesheets().get(0).contains("hoja3.css")) {

                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo1);

            }
           
        } else if(evnt.equals(btnEstilo2)) { //Lo mismo con el segundo boton
            
             if(hbox.getStylesheets().get(0).contains("hojaprincipal.css")) {

                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo2);

            } else if(hbox.getStylesheets().get(0).contains("hoja1.css")) {

                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo2);

            } else if(hbox.getStylesheets().get(0).contains("hoja1.css")) {

                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo2);

            }
            
        } else if(evnt.equals(btnEstilo3)) { //Lo mismo con el tercer boton
            
             if(hbox.getStylesheets().get(0).contains("hojaprincipal.css")) {

                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo3);

            } else if(hbox.getStylesheets().get(0).contains("hoja1.css")) {

                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo3);

            } else if(hbox.getStylesheets().get(0).contains("hoja2.css")) {

                hbox.getStylesheets().remove(0);
                hbox.getStylesheets().add(estilo3);

            }           
        } 
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
