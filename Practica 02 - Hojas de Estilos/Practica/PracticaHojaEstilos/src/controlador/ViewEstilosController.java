/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;

/**
 *
 * @author Dani
 */
public class ViewEstilosController implements Initializable {
    
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
    private void onClickEstilos(ActionEvent event) {
        
    }
    
    @FXML
    private void onClickSurprise(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
