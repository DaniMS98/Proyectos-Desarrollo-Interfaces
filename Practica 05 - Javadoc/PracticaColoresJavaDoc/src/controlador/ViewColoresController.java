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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * El package controlador es la parte Controlador de nuestro MVC.<br><br>
 * 
 * Clase ViewColoresController que se encarga de diferentes funciones 
 * y controles de la aplicacion para el correcto funcionamiento de 
 * todos los componentes graficos y eventos de los mismos.<br><hr><br>
 * 
 * <b>Practica Colores - Estructura</b><br><br>
 * El Proyecto esta compuesto por 3 paquetes que se dividen
 *  en el modelo MVC (Modelo - Vista - Controlador):<br>
 * 
 * <ul>
 * <li><b>Modelo:</b> Clase PracticaColores {@link practicacolores.PracticaColores}</li>
 * <li><b>Vista:</b> Clase ViewColores {@code vista.ViewColores.fxml}</li>
 * <li><b>Controlador:</b> Clase ViewColoresController {@link controlador.ViewColoresController}</li>
 * </ul>
 * 
 * @author Daniel Mayor Sánchez
 * @see <a href="https://github.com/DaniMS98">Perfil de GitHub</a>
 * @see <a href="https://github.com/DaniMS98/Proyectos-Desarrollo-Interfaces-DAM">Proyectos - Desarrollo de Interfaces</a>
 * @see <a href="https://github.com/DaniMS98/Proyectos-Desarrollo-Interfaces-DAM/tree/master/Practica%2003%20-%20Animaciones%20y%20Estilos">Proyecto Temporizador</a>
 * @see <a href="https://github.com/DaniMS98/Proyectos-Desarrollo-Interfaces-DAM/tree/master/Practica%2001%20-%20Colores">Proyecto Colores</a>
 * @since 19/04/2022
 * @version 1.0
 */

public class ViewColoresController implements Initializable, ChangeListener {
  
    /**
     * Referencia a todos los Componentes Graficos creados desde la vista
     * ViewColores.fxml. 
     * 
     * Se referencian a partir de un ID unico.
     */
    //Atributos
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
    
    /**
     * Integer utilizados para recoger el valor de los Slider que conforman
     * los 3 colores de la aplicacion
     */
    
    int miSlider1, miSlider2, miSlider3;
    
    /**
     * 
     * Metodo Inicial que se encarga de iniciar los componentes con las propiedades
     * por defecto que hayamos programado ademas de dar funciones de evento
     * a diferentes componentes como Listas o Sliders.
     * 
     * @param url
     * @param rb 
     */
    //Metodos
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        miColor = Color.rgb(0, 0, 0);
        lbColorRGB.setBackground(new Background(new BackgroundFill(miColor, CornerRadii.EMPTY, Insets.EMPTY)));
        
        slider1.valueProperty().addListener(this);
        slider2.valueProperty().addListener(this);
        slider3.valueProperty().addListener(this);
        
        /**
         * Metodo ChangeListener que se ejecuta cada vez que el usuario
         * seleccione un elemento de la lista.
         * 
         * La función de este metodo es recoger con el objeto miColor
         * los datos del elemento seleccionado en la lista con el fin
         * de añadir el Background de un Label del color que hayamos recogido
         * con el componente miColor.
         */
        
        listView1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Color>() {
           
            @Override
            public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
              
                miColor = listView1.getSelectionModel().getSelectedItem();
                lbColorRGB.setBackground(new Background(new BackgroundFill(miColor, CornerRadii.EMPTY, Insets.EMPTY)));
                
            }
            
        });
    }    
    
    /**
     * Metodo que utiliza los Integer creados anteriormente (miSlider1,2,3)
     * para recoger los valores de los Sliders de la aplicacion y mostrar en 
     * un Label los valores RGB que estamos seleccionando
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    
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
    
    /**
     * Este metodo se ejecuta cuando estamos haciendo uso de los componentes Sliders.
     * 
     * El metodo realiza los siguientes pasos:
     * <ul>
     * <li>El objeto miColor guarda los valores enteros de los Sliders en formato RGB.</li>
     * <li>El label cambia el color conforme vamos moviendo los Sliders de la aplicacion.</li>
     * <li>De esta forma, el usuario puede visualizar el color RGB inmediatamente.</li>
     * </ul>
     */

    private void generarColorRGB() {
        
        miColor = Color.rgb(miSlider1, miSlider2, miSlider3);
        lbColorRGB.setBackground(new Background(new BackgroundFill(miColor, CornerRadii.EMPTY, Insets.EMPTY)));
        
    }
    
    /**
     * 
     * Metodo encargado de guardar los valores RGB en los elementos
     * del ListView de la aplicación.
     * 
     * @param event registra el evento del Boton
     */
    
    @FXML
    private void onClickGuardar(ActionEvent event) {
        
        listView1.getItems().add(Color.rgb(miSlider1, miSlider2, miSlider3));
    }
    
}
