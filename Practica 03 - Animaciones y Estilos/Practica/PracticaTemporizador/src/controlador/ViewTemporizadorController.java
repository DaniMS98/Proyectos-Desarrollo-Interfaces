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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Dani
 */
public class ViewTemporizadorController implements Initializable {

    @FXML
    private AnchorPane timePanel;
    
    @FXML
    private Label lbHora;
    
    @FXML
    private Label lbMinutos;
    
    @FXML
    private Label lbSegundos;
    
    @FXML
    private Button btnConfigurar;
    
    @FXML
    private Button btnParar;
    
    @FXML
    private Button btnCancelar;
    
    @FXML
    private Button btnReanudar;
    
    @FXML
    private AnchorPane menuPanel;
    
    @FXML
    private ComboBox<?> inputHoras;
    
    @FXML
    private ComboBox<?> inputMinutos;
    
    @FXML
    private ComboBox<?> inputSegundos;
    
    @FXML
    private TextField txtRecordatorio;
    
    @FXML
    private Button btnIniciar;
    
    @FXML
    private Button btnHora;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClickConfigure(ActionEvent event) {
    }

    @FXML
    private void onClickStop(ActionEvent event) {
    }

    @FXML
    private void onClickCancelar(ActionEvent event) {
    }

    @FXML
    private void onClickReanudar(ActionEvent event) {
    }

    @FXML
    private void onClickIniciar(ActionEvent event) {
    }

    @FXML
    private void onClickHoraActual(ActionEvent event) {
    }
    
}
