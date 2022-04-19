/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */

package practicacolores;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * El package PracticaColores es la parte Modelo de nuestro MVC.<br><br>
 * 
 * Clase Principal del Proyecto Colores que carga una vista diseñada
 * para la eleccion de distintos colores y su proceso de guardado en listas.<br><hr><br>
 * 
 * <b>Practica Colores - Estructura</b><br><br>
 * El Proyecto esta compuesto por 3 paquetes que se dividen
 *  en el modelo MVC (Modelo - Vista - Controlador):<br>
 * 
 * <ul>
 * <li><b>Modelo:</b> Clase PracticaColores {@link PracticaColores}</li>
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

public class PracticaColores extends Application {
    
    /**
     * Metodo start que carga una Vista, la mete en una Scene y
     * la muestra al usuario con el parametro stage.
     * 
     * @param stage muestra la Scene de la app
     * @throws Exception lanza una excepción si se produce algun error 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/ViewColores.fxml"));
        
        Scene scene = new Scene(root);
                
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metodo que se encarga de cargar la aplicación.
     * 
     * @param args los argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
