/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 *
 * @author Dani
 */
public class ViewColoresController implements Initializable, ChangeListener {
  
    @FXML
    private Label txtR, txtG, txtB, txtRGB, lbColorRGB;
    
    @FXML
    private Slider slider1, slider2, slider3;
    
    @FXML
    private Button btnGuardar;
    
    @FXML
    private ListView<Color> listView1;
    
    @FXML
    private Color miColor;
    
    int miSlider1, miSlider2, miSlider3;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        miColor = Color.rgb(0, 0, 0);
        lbColorRGB.setBackground(new Background(new BackgroundFill(miColor, CornerRadii.EMPTY, Insets.EMPTY)));
        
        slider1.valueProperty().addListener(this);
        slider2.valueProperty().addListener(this);
        slider3.valueProperty().addListener(this);
        
        listView1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Color>() {
           
            @Override
            public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
              
                miColor = listView1.getSelectionModel().getSelectedItem();
                lbColorRGB.setBackground(new Background(new BackgroundFill(miColor, CornerRadii.EMPTY, Insets.EMPTY)));
                
            }
            
        });
    }    

    private void generarColorRGB() {
        
        miColor = Color.rgb(miSlider1, miSlider2, miSlider3);
        lbColorRGB.setBackground(new Background(new BackgroundFill(miColor, CornerRadii.EMPTY, Insets.EMPTY)));
        
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        
        miSlider1 = (int) slider1.getValue();
        txtR.setText("R: " + miSlider1);
        
        miSlider2 = (int) slider2.getValue();
        txtG.setText("G: " + miSlider2);
                
        miSlider3 = (int) slider3.getValue();
        txtB.setText("B: " + miSlider3);
        
        txtRGB.setText("Color (RGB): " + miSlider1 + ", " + miSlider2 + ", " + miSlider3);
                
        generarColorRGB();
        
    }
    
    @FXML
    private void onClickGuardar(ActionEvent event) {
        
        listView1.getItems().add(Color.rgb(miSlider1, miSlider2, miSlider3));
    }
    
}
