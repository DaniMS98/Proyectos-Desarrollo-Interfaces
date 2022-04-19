/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package practicatemporizador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * El package PracticaTemporizador es el Modelo de nuestro MVC.<br><br>
 * 
 * Clase Principal del Proyecto Temporizador que carga una vista diseñada
 * donde se muestran valores de tiempo, distintos botones que muestran la hora
 * y temporizador en directo con avisos.<br>
 * 
 * Tiene una hoja de estilos CSS, un titulo e icono personalizados.
 * <br><hr><br>
 * 
 * <b>Practica Temporizador - Estructura</b><br><br>
 * El Proyecto esta compuesto por muchos paquetes de los cuales 3 paquetes 
 * son de suma importancia al ser el modelo MVC (Modelo - Vista - Controlador):<br>
 * 
 * <ul>
 * <li><b>Modelo:</b> Clase PracticaTemporizador {@link PracticaTemporizador}</li>
 * <li><b>Vista:</b> Clase ViewTemporizador {@code vista.ViewTemporizador}</li>
 * <li><b>Controlador:</b> Clase ViewTemporizadorController {@link controlador.ViewTemporizadorController}</li>
 * <li><b>Estilos:</b> Hoja de Estilo Hoja.css {@code estilos.hoja.css}</li>
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

public class PracticaTemporizador extends Application {
    
    /**
     * Objeto de tipo Stage que sirve para mostrar escenas
     */
    
    protected Stage stage;
    
    /**
     * Metodo start que carga una Vista, la mete en una Scene y
     * la muestra al usuario con el parametro stage.
     * 
     * El metodo start previsualiza todos los aspectos necesarios de la aplicación
     * como puede ser:
     * 
     * <br><ul>
     * <li>Titulo de la aplicación</li>
     * <li>Icono de la aplicación</li>
     * <li>Decoración</li>
     * <li>Hoja de Estilos CSS que conformara a la aplicación de un diseño personalizado.</li>
     * <li>Vista / Interfaz Grafica FXML</li>
     * </ul>
     * 
     * @param stage muestra la Scene de la aplicación
     * @throws Exception lanza una excepción si se produce algun error 
     */
    
    @Override
    public void start(Stage stage) throws Exception {
        
        this.stage = stage;
        this.stage.setTitle("Temporizador");
        this.stage.getIcons().add(new Image("/images/icono.png"));
        
        stage.initStyle(StageStyle.DECORATED);
        
        Parent root = FXMLLoader.load(getClass().getResource("/vista/ViewTemporizador.fxml"));
        Scene scene = new Scene(root);
        
        String css = this.getClass().getResource("/estilos/hoja.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metodo que se encarga de cargar la aplicación
     * 
     * @param args los argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
