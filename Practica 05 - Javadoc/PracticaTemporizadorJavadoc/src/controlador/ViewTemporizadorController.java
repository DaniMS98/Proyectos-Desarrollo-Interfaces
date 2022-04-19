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
 * El package Controlador es el Controller de nuestro MVC.<br><br>
 * 
 * Clase Controlador del Proyecto Temporizador que se encarga de diferentes funciones como
 * referenciar los componentes graficos, crear valores necesarios para el funcionamiento del temporizador,
 * añadir eventos para los componentes y utilizar Threads para simular el paso del 
 * tiempo en los valores que utilizamos para mostrar el temporizador.<br>
 * 
 * <br><hr><br>
 * 
 * <b>Practica Temporizador - Estructura</b><br><br>
 * El Proyecto esta compuesto por muchos paquetes de los cuales 3 paquetes 
 * son de suma importancia al ser el modelo MVC (Modelo - Vista - Controlador):<br>
 * 
 * <ul>
 * <li><b>Modelo:</b> Clase PracticaTemporizador {@link practicatemporizador.PracticaTemporizador}</li>
 * <li><b>Vista:</b> Clase ViewTemporizador {@code vista.ViewTemporizador}</li>
 * <li><b>Controlador:</b> Clase ViewTemporizadorController {@link controlador.ViewTemporizadorController}</li>
 * <li><b>Estilos:</b> Hoja de Estilo Hoja.css {@code estilos.hoja.css}</li>
 * <li><b>Imagenes:</b> Imagenes de la App {images.imagenes}</li>
 * </ul><br>
 * 
 * @author Daniel Mayor Sánchez
 * @see <a href="https://github.com/DaniMS98">Perfil de GitHub</a>
 * @see <a href="https://github.com/DaniMS98/Proyectos-Desarrollo-Interfaces-DAM">Proyectos - Desarrollo de Interfaces</a>
 * @see <a href="https://github.com/DaniMS98/Proyectos-Desarrollo-Interfaces-DAM/tree/master/Practica%2003%20-%20Animaciones%20y%20Estilos">Proyecto Temporizador</a>
 * @see <a href="https://github.com/DaniMS98/Proyectos-Desarrollo-Interfaces-DAM/tree/master/Practica%2001%20-%20Colores">Proyecto Colores</a>
 * @since 19/04/2022
 * @version 1.0
 */

public class ViewTemporizadorController implements Initializable {
    
    //Atributos
    
    /**
     * Referencia a los Componentes de tipo AnchorPane creados desde la vista FXML 
     */

    @FXML
    protected AnchorPane timePanel, menuPanel;
    
    /**
     * Referencia a los Componentes de tipo Button creados desde la vista FXML 
     */
    
    @FXML
    protected Button btnParar, btnConfigurar, btnReanudar, btnIniciar, btnHora;
    
    /**
     * Referencia a los Componentes de tipo Text creados desde la vista FXML 
     */
    
    @FXML
    protected Text txtHora, txtMinutos, txtSegundos;
    
    /**
     * Referencia a los Componentes de tipo ComboBox enteros creados desde la vista FXML 
     */
    
    @FXML
    protected ComboBox<Integer> inputHoras, inputMinutos, inputSegundos;
    
    /**
     * Referencia a los Componentes de tipo TextField creados desde la vista FXML 
     */
    
    @FXML   
    protected TextField txtRecordatorio;
    
    /**
     * Referencia a los Componentes de tipo Label creados desde la vista FXML 
     */
    
    @FXML
    protected Label txtTarea;
    
    /**
     * String para mostrar la hora, minutos y segundos del Temporizador junto
     * a un mensaje de Recordatorio.
     */
    
    public String mensaje, hora, minutos, segundos;
    
    /**
     * Objeto de tipo Calendar que sirve para recoger el valor de la 
     * hora actual del usuario.
     */
    
    public Calendar calendario;
    
    /**
     * Mapa de Numeros que utilizaremos para registrar los numeros del Temporizador.
     */
    
    public Map<Integer, String> mapaNumber;
    
    /**
     * Objeto de tipo Integer necesario para el transcurso del tiempo en el
     * Temporizador una vez este en marcha.
     */
    
    public Integer segundosActuales;
    
    /**
     * Dos Threads: Uno de ellos es para el Temporizador,
     * el otro para la hora actual.
     */
    
    public Thread trd, trHoraActual;
    
     //Metodos
    
    /**
     * Metodo Inicial que da valores predeterminados a los componentes graficos.<br><hr>
     * 
     * Se trata de un metodo que se encarga de inicializar listas de valores
     * (Horas, Minutos y Segundos), meter los valores indicados a cada una de
     * las listas a traves de un for que rellena la lista con los valores maximos.<br>
     * 
     * Dichos valores los inserta en los comboBox de horas, minutos y segundos 
     * que usaremos para decirle al Temporizador el tiempo necesario que queremos.
     * Iniciamos el Mapa de Numeros y le otorgamos valores hasta el 
     * numero 59.<br>
     * 
     * @param url url necesaria
     * @param rb ResourceBundle si queremos internacionalizar la aplicacion en diferentes idiomas
     * <hr>
     */
    
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
    
    /**
     * Metodo que inicia su evento cuando el usuario pulsa los botones: Configurar,
     * Stop o Reanudar. Cada uno de estos botones realiza una funcion diferente.
     * 
     * <ul>
     * <li><b>Configurar: </b> Invoca al metodo cambiarPanelTiempo() que 
     * te devuelve al menu principal, ademas de parar el Thread de la Hora Actual
     * en caso de que este activo.</li>
     * <li><b>Parar:</b> Suspende el Thread del cronometro. El tiempo se para.</li>
     * <li><b>Reanudar: </b>Reanuda el Thread del cronometro. El tiempo sigue desde
     * el punto en el que nos quedamos al pulsar el boton Pausa.</li>
     * </ul>
     * 
     * @param event registra el boton que ha sido pulsado
     */
    
    @FXML
    public void onClickButton(ActionEvent event) {   
        Object evt = event.getSource();
        
        if(evt.equals(btnConfigurar)) {
            txtTarea.setText("");
            cambiarPanelTiempo();

            if(trHoraActual.isAlive()) {
                trHoraActual.stop();
            }
        } else if(evt.equals(btnParar)) {       
            trd.suspend();
        } else if(evt.equals(btnReanudar)) {       
            trd.resume();
        } 
    }
    
    /**
     * Metodo que se invoca al pulsar el botón Iniciar que provoca un evento onClick.
     * 
     * Se trata de un metodo que se inicia al pulsar el botón Iniciar y provoca
     * cambios en la vista:<br>
     * <ol>
     * <li>Cambian las propiedades y visibilidad de ciertos componentes graficos.</li>
     * <li>Cambia el Panel que te envia al panel del Temporizador.</li>
     * <li>Almacena los valores de los ComboBox convertidos a segundos en el entero segundosActuales</li>
     * <li>Guarda el Recordatorio que haya escrito el usuario.</li>
     * <li>Resetea todos los valores de los comboBox y Textfield.</li>
     * <li>Por ultimo, invoca al metodo empezarCuentaAtras que inicia un Thread.</li>
     * </ol>
     * 
     * @param event registra la accion del boton
     */
    
    @FXML
    public void onClickIniciar(ActionEvent event) {
        btnReanudar.setVisible(true);
        btnParar.setVisible(true);
        btnConfigurar.setText("Configurar");
        
        cambiarPanelMenu();
        
        //Recoge todos los valores almacenados en los ComboBox de Horas, Minutos y Segundos
        //y los mete en la variable segundosActuales
        segundosActuales = convertirASegundos(inputHoras.getValue(), inputMinutos.getValue(), inputSegundos.getValue());
        mensaje = txtRecordatorio.getText();
        
        inputHoras.setValue(0);
        inputMinutos.setValue(0);
        inputSegundos.setValue(0);
        txtRecordatorio.setText("");
        txtTarea.setText("Tarea: " + mensaje);
        
        empezarCuentaAtras();
    }
    
    /** 
     * Metodo que realiza el calculo de horas y minutos a segundos
     * para crear un Integer que suma todos los valores de tiempo y
     * devuelve el total del tiempo.
     * 
     * @param h Valor de las horas
     * @param m Valor de los minutos
     * @param s Valor de los segundos
     * @return Tiempo total insertado en total
     */
    
    public Integer convertirASegundos(Integer h, Integer m, Integer s) {     
        Integer horaASegundos = h*3600;
        Integer minutoASegundos = m*60;
        Integer total = horaASegundos + minutoASegundos + s;
        
        return total;
    }
    
    /**
     * Metodo que crea varios Integer para almacenar las horas y minutos convertidos
     * en segundos. Acto seguido, se crea una lista de enteros (tiempo) 
     * donde añadimos las horas, minutos, segundos y devolvemos la lista de enteros.
     * 
     * @param segundosActual entero de tiempo que tiene la variable
     * @return lista de enteros que almacena el tiempo total
     */
    
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
    
    /**
     * Metodo que controla la cuenta atras del tiempo que hemos
     * seleccionado en el Menu.
     * 
     * <ol>
     * <li>Inicia un Thread donde recoge la lista del tiempo total.</li>
     * <li>Inserta en los Label los valores correspondientes de Horas, Minutos y Segundos.</li>
     * <li>Provocamos un Thread cada segundo y restamos -1 a la variable segundosActuales.</li>
     * <li>El tiempo llega a 0 y salta un mensaje Recordatorio junto al fin del Thread.</li>
     * </ol>
     */
    
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
    
    /**
     * Metodo que visualiza el panel del Temporizador y oculta el panel del Menu
     */
    
    public void cambiarPanelMenu() {
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
    
    /**
     * Metodo que visualiza el panel del Menu y oculta el panel del Temporizador
     */
    
    public void cambiarPanelTiempo() {
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

    /**
     * Metodo que se invoca al pulsar el botón Hora Actual que provoca un evento onClick.
     * 
     * Se trata de un metodo que se invoca al pulsar el botón de Hora Actual que
     * cambia propiedades de distintos componentes graficos, reinicia los valores
     * de ComboBox y Texfield ademas de invocar al metodo que da inicio al Thread
     * de la Hora Actual del usuario.
     * 
     * @param event registra la accion del boton
     */
    
    @FXML
    public void onClickHoraActual(ActionEvent event) {
        //Cambia el Panel y oculta los Botones Reanudar y Parar
        //ya que no tienen ninguna funcion relevante al mostrarse la hora actual
        btnReanudar.setVisible(false);
        btnParar.setVisible(false);
        btnConfigurar.setText("Volver");
        txtTarea.setText("Hora Actual (España)");
        cambiarPanelMenu();
        
        inputHoras.setValue(0);
        inputMinutos.setValue(0);
        inputSegundos.setValue(0);
        txtRecordatorio.setText("");
        
        empezarHoraActual();
    }
    
    /**
     * Metodo que interactua con la hora del Usuario para mostrarlo
     * a tiempo real.
     * 
     * Se trata de un metodo que inicia un nuevo Thread que accede al metodo
     * calcularHoraActual() que muestra la hora en tiempo real produciendose un
     * Thread cada segundo e insertando la hora en los campos Hora, Minutos y Segundos.
     */
    
    public void empezarHoraActual() {

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
        
    /**
     * Metodo que se invoca para calcular la hora a tiempo real.
     * 
     * Se trata de un metodo que calcula la hora a tiempo real creando e inicializando
     * objetos GregorianCalendar y Date con el proposito de insertar la hora actual 
     * a traves de Strings (hora, minutos y segundos) dentro del objeto calendario. 
     */
    
     public void calcularHoraActual() {
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