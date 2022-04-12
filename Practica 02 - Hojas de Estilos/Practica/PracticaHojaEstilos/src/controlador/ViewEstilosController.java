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
    private void onClickEstilos(ActionEvent event) throws IOException {
        
       Object evnt = event.getSource();
        
        if(evnt.equals(btnEstilo1)) {
            
            Parent root = FXMLLoader.load(getClass().getResource("/vista/ViewEstilos.fxml"));
            Scene scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            scene.setUserAgentStylesheet("/estilos/hoja1.css");           
            stage.setScene(scene);
            stage.show();
        } else if(evnt.equals(btnEstilo2)) {
            
            Parent root = FXMLLoader.load(getClass().getResource("/vista/ViewEstilos.fxml"));
            Scene scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            scene.setUserAgentStylesheet("/estilos/hoja2.css");           
            stage.setScene(scene);
            stage.show();
        } else if(evnt.equals(btnEstilo3)) {
            
            Parent root = FXMLLoader.load(getClass().getResource("/vista/ViewEstilos.fxml"));
            Scene scene = new Scene(root);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            scene.setUserAgentStylesheet("/estilos/hoja3.css");           
            stage.setScene(scene);
            stage.show();
        }
        
    }
    
    @FXML
    private void onClickSurprise(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
