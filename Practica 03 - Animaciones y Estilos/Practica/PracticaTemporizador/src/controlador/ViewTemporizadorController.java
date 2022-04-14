/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.LinkedList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author Dani
 */
public class ViewTemporizadorController implements Initializable {

    @FXML
    private AnchorPane timePanel;
    
    @FXML
    private Button btnConfigurar, btnParar, btnCancelar, btnReanudar;
      
    @FXML
    private AnchorPane menuPanel;
    
    @FXML
    private Text txtHora;
    
    @FXML
    private Text txtMinutos;
    
    @FXML
    private Text txtSegundos;
    
    @FXML
    private ComboBox<Integer> inputHoras;
    
    @FXML
    private ComboBox<Integer> inputMinutos;
    
    @FXML
    private ComboBox<Integer> inputSegundos;
    
    @FXML   
    private TextField txtRecordatorio;
    
    @FXML
    private Button btnIniciar;
    
    @FXML
    private Button btnHora;
    
    String mensaje;
    
    Map<Integer, String> mapaNumber;
    
    Integer segundosActuales;
    
    Thread trd;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Integer> listaHoras = FXCollections.observableArrayList();
        ObservableList<Integer> listaMinutosYSegundos = FXCollections.observableArrayList();
        
        for(int i=0; i<=60 ; i++) {
            
            if(i >= 0 && i<=24) {
                listaHoras.add(new Integer(i));
            }
            
            listaMinutosYSegundos.add(new Integer(i));   
        }
        
        //Añadimos el rango de tiempo que pueden tener las Horas, Minutos y Segundos
        //Por defecto el comboBox valdra 0
        
        inputHoras.setItems(listaHoras);
        inputHoras.setValue(0);
        
        inputMinutos.setItems(listaMinutosYSegundos);
        inputMinutos.setValue(0);
        
        inputSegundos.setItems(listaMinutosYSegundos);
        inputSegundos.setValue(0);
        
        mapaNumber = new TreeMap<>();
        
        for(Integer i=0; i<=60; i++) {
            
            if(0 <= i && i <= 9) {
                mapaNumber.put(i, "0" + i.toString());
            } else {
                mapaNumber.put(i, i.toString());
            }
            
        }
    }

    public Integer convertirASegundos(Integer h, Integer m, Integer s) {
        
        Integer horaASegundos = h*3600;
        Integer minutoASegundos = m*60;
        Integer total = horaASegundos + minutoASegundos + s;
        
        return total;
    }
    
    public LinkedList<Integer> convertirSegundosAHoraMinutos(Integer segundosActual) {
        
        Integer horas = segundosActual / 3600;
        segundosActual = segundosActual % 3600;
        
        Integer minutos = segundosActual / 60;
        segundosActual = segundosActual % 60;
        
        Integer segundos = segundosActual;
        
        LinkedList<Integer> tiempo = new LinkedList<>();
        tiempo.add(horas);
        tiempo.add(minutos);
        tiempo.add(segundos);
        
        return tiempo;       
    }
    
    //Metodo que empieza la Cuenta Atras
    public void empezarCuentaAtras() {
        
        trd = new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                  
                    while(true) {
                        
                        LinkedList<Integer> hmsActuales = convertirSegundosAHoraMinutos(segundosActuales); 
                        
                        txtHora.setText(mapaNumber.get(hmsActuales.get(0)));
                        txtMinutos.setText(mapaNumber.get(hmsActuales.get(1)));
                        txtSegundos.setText(mapaNumber.get(hmsActuales.get(2)));
                        
                        Thread.sleep(1000);
                        
                        if(segundosActuales==0) {
                            JOptionPane.showMessageDialog(null, "El periodo de la tarea: " + mensaje + " ha finalizado." 
                                    , "RECORDATORIO", JOptionPane.INFORMATION_MESSAGE);
                            trd.stop();
                        }  
                        segundosActuales -= 1;                               
                    }           
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }  
        }); 
        trd.start();
    }
    
    public void cambiarPanelMenu() {
        
        //Creamos la Transicion de la Primera Vista (Panel del Menu)
        //y le otorgamos la posicion donde queremos moverla
        TranslateTransition transl1 = new TranslateTransition();
        
        transl1.setDuration(Duration.millis(100));
        transl1.setToX(0);
        transl1.setToY(-500);       
        transl1.setNode(menuPanel);
        
        //Lo mismo con la Segunda Vista (Panel del Temporizador)
        
        TranslateTransition transl2 = new TranslateTransition();
        
        transl2.setDuration(Duration.millis(100));
        transl2.setFromX(0);
        transl2.setFromY(500);  
        transl2.setToX(0);
        transl2.setToY(0);
        transl2.setNode(timePanel);
        
        //Creamos una transiccion en la que al pulsar un boton cambiaremos
        //de una vista a otra
        
        ParallelTransition parallel = new ParallelTransition(transl1, transl2);
        parallel.play();     
    }
    
    public void cambiarPanelTiempo() {
        
        //Creamos la Transicion de la Primera Vista (Panel del Menu
        //y le otorgamos la posicion donde queremos moverla
        TranslateTransition transl1 = new TranslateTransition();
        
        transl1.setDuration(Duration.millis(100));
        transl1.setToX(0);
        transl1.setToY(500);       
        transl1.setNode(timePanel);
        
        //Lo mismo con la Segunda Vista (Panel del Temporizador)
        
        TranslateTransition transl2 = new TranslateTransition();
        
        transl2.setDuration(Duration.millis(100));
        transl2.setFromX(0);
        transl2.setFromY(-500);  
        transl2.setToX(0);
        transl2.setToY(0);
        transl2.setNode(menuPanel);
        
        //Creamos una transiccion en la que al pulsar un boton cambiaremos
        //de una vista a otra
        
        ParallelTransition parallel = new ParallelTransition(transl1, transl2);
        parallel.play();
    }

    //Este evento se inicia al pulsar uno de los siguientes botones
    //
    @FXML
    private void onClickButton(ActionEvent event) {       
        cambiarPanelTiempo();
        trd.stop();
    }

    @FXML
    private void onClickStop(ActionEvent event) {
        trd.stop();
    }

    @FXML
    private void onClickCancelar(ActionEvent event) {
        trd.stop();
        cambiarPanelTiempo();
    }

    @FXML
    private void onClickReanudar(ActionEvent event) {
        
    }

    //Iniciar la cuenta atras del Temporizador
    @FXML
    private void onClickIniciar(ActionEvent event) {
        //Recoge todos los valores almacenados en los ComboBox de Horas, Minutos y Segundos
        //y los mete en la variable segundosActuales
        segundosActuales = convertirASegundos(inputHoras.getValue(), inputMinutos.getValue(), inputSegundos.getValue());
        
        //Guarda el mensaje escrito por el usuario
        mensaje = txtRecordatorio.getText();
        
        //Reinicia los valores del ComboBox y TextField
        inputHoras.setValue(0);
        inputMinutos.setValue(0);
        inputSegundos.setValue(0);
        txtRecordatorio.setText("");
        
        //Se mueve al panel del Temporizador y empieza la Cuenta Atras
        cambiarPanelMenu();
        empezarCuentaAtras();
    }

    @FXML
    private void onClickHoraActual(ActionEvent event) {
    }
    
}
