/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.*;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author Dani
 */
public class ViewTemporizadorController implements Initializable {
    
    //Creamos objetos y los referenciamos con el archivo FXML creado anteriormente

    @FXML
    private AnchorPane timePanel, menuPanel;
    
    @FXML
    private Button btnParar, btnConfigurar, btnReanudar, btnIniciar, btnHora;
    
    @FXML
    private Text txtHora, txtMinutos, txtSegundos;
    
    @FXML
    private ComboBox<Integer> inputHoras, inputMinutos, inputSegundos;
    
    @FXML   
    private TextField txtRecordatorio;
    
    @FXML
    private Label txtTarea;
    
    //Creamos variables necesarias para el 
    //correcto funcionamiento de la aplicación
    
    String mensaje, hora, minutos, segundos;
    
    Calendar calendario;
    
    Map<Integer, String> mapaNumber;
    
    Integer segundosActuales;
    
    Thread trd, trHoraActual;
    
     
    //Metodo que le da valores iniciales a los objetos
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<Integer> listaHoras = FXCollections.observableArrayList();
        ObservableList<Integer> listaMinutosYSegundos = FXCollections.observableArrayList();
        
        //Creamos un for donde iniciamos una variable i  
        //que podra leer hasta el numero 59
        for(Integer i=0; i<60 ; i++) {
            
            //Las horas solo contaran hasta el numero 23
            if(i >= 0 && i<24) {
                listaHoras.add(i);
            }
            //Los minutos y segundos podran contar hasta el numero 59
            listaMinutosYSegundos.add(i);   
        }
        
        //Añadimos el rango de tiempo que pueden tener las Horas, Minutos y Segundos
        //Por defecto el comboBox valdra 0
        
        inputHoras.setItems(listaHoras);
        inputHoras.setValue(0);
        
        inputMinutos.setItems(listaMinutosYSegundos);
        inputMinutos.setValue(0);
        
        inputSegundos.setItems(listaMinutosYSegundos);
        inputSegundos.setValue(0);
        
        //Iniciamos el mapa de Numeros que podra contar numeros hasta el 59
        mapaNumber = new TreeMap<>();
        
        for(Integer i=0; i<60; i++) {
            
            if(0 <= i && i <= 9) {
                mapaNumber.put(i, "0" + i.toString());
            } else {
                mapaNumber.put(i, i.toString());
            }
           
        }
    }

    //Este metodo convierte las horas y minutos en segundos
    //para luego sumarlo todo (horas + minutos + segundos)
    public Integer convertirASegundos(Integer h, Integer m, Integer s) {     
        Integer horaASegundos = h*3600;
        Integer minutoASegundos = m*60;
        Integer total = horaASegundos + minutoASegundos + s;
        
        return total;
    }
    
    //Este metodo convierte los segundos en Horas y Minutos
    //para luego meter las horas, minutos y segundos en un List
    //y hacer un return de la lista
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
    
    //Metodo que empieza la Cuenta Atras del Temporizador
    public void empezarCuentaAtras() {    
  
        trd = new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    
                    //Mientras el Thread sea true entonces hara el siguiente codigo
                    while(true) {
                        
                        //Crea un objeto List tipo Integer donde su valor sera
                        //la lista de tiempo creada en el metodo
                        LinkedList<Integer> hmsActuales = convertirSegundosAHoraMinutos(segundosActuales); 
                        
                        //En los Text de Hora, Minuto y Segundo ponemos los
                        //valores correspondientes
                        txtHora.setText(mapaNumber.get(hmsActuales.get(0)));
                        txtMinutos.setText(mapaNumber.get(hmsActuales.get(1)));
                        txtSegundos.setText(mapaNumber.get(hmsActuales.get(2)));
                        
                        //Provocamos un Thread cada segundo 
                        Thread.sleep(1000);
                        
                        //Si los segundos llegan a 0 entonces salta un JOptionPane
                        //con el mensaje que habiamos escrito anteriormente
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
    
    public void cambiarAPanelMenu() {
        //1.º Metodo (Sencillo): Hacemos Visible un Panel y el otro lo ocultamos
        menuPanel.setVisible(false);
        timePanel.setVisible(true);
        
        //2.º Metodo: Crear una Transicion donde movemos un Panel de un lado a otro
        /*
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
        */
    }
    
    public void cambiarAPanelTiempo() {
        //1.º Metodo (Sencillo): Hacemos Visible un Panel y el otro lo ocultamos
        menuPanel.setVisible(true);
        timePanel.setVisible(false);
        
        //2.º Metodo: Crear una Transicion donde movemos un Panel de un lado a otro
        /*
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
        */
    }

    //Este evento se inicia al pulsar uno de los siguientes botones
    // (Configurar, Stop, Cancelar, Reanudar)
    @FXML
    private void onClickButton(ActionEvent event) {   
        Object evt = event.getSource();
        
        if(evt.equals(btnConfigurar)) {
            txtTarea.setText("");
            cambiarAPanelTiempo();

            if(trHoraActual.isAlive()) {
                trHoraActual.stop();
            }
        } else if(evt.equals(btnParar)) {       
            trd.suspend();
        } else if(evt.equals(btnReanudar)) {       
            trd.resume();
        } 
    }
    
    //Iniciar la cuenta atras del Temporizador
    @FXML
    private void onClickIniciar(ActionEvent event) {
        btnReanudar.setVisible(true);
        btnParar.setVisible(true);
        btnConfigurar.setText("Configurar");
        cambiarAPanelMenu();
        
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
        txtTarea.setText("Tarea: " + mensaje);
        
        //Se mueve al panel del Temporizador y empieza la Cuenta Atras
        empezarCuentaAtras();
    }

    //Muestra la Hora Actual
    @FXML
    private void onClickHoraActual(ActionEvent event) {
        //Cambia el Panel y oculta los Botones Reanudar y Parar
        //ya que no tienen ninguna funcion relevante al mostrarse la hora actual
        btnReanudar.setVisible(false);
        btnParar.setVisible(false);
        btnConfigurar.setText("Volver");
        txtTarea.setText("Hora Actual (España)");
        cambiarAPanelMenu();
        
        //Reinicia los valores del ComboBox y TextField
        inputHoras.setValue(0);
        inputMinutos.setValue(0);
        inputSegundos.setValue(0);
        txtRecordatorio.setText("");
        
        empezarHoraActual();
    }
    
    //Metodo que muestra la Hora Actual
    private void empezarHoraActual() {

        trHoraActual = new Thread(new Runnable() {
            @Override
            public void run() {
          
                //Mientras el Thread sea true entonces hara el siguiente codigo
                while(true) {
                    //Accede al siguiente metodo
                    calcularHoraActual();
                    
                    //Inserta en los Componentes la hora, minutos y segundos actuales
                    txtHora.setText(hora);
                    txtMinutos.setText(minutos);
                    txtSegundos.setText(segundos);
                    
                    //Se produce un Thread de 1 segundo
                    try {
                        Thread.sleep(1000);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            } 
        });       
        trHoraActual.start();
    }
        
    //Metodo que permite calcular la Hora Actual del Usuario
     private void calcularHoraActual() {
         //Inicializamos el objeto de tipo Calendar como un GregorianCalendar
         calendario = new GregorianCalendar();
         //Creamos un objeto Date
         Date fechaHoraActual = new Date();
         
         //Insertamos la hora actual en el calendario
         calendario.setTime(fechaHoraActual);
         
         //Guardamos los datos necesarios en los valores String creados al principio
         hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);  
         minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
         segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);   
     }            
}