package desarrollointerfaces.dms.proyectofinal;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewInternacionalizacionController implements Initializable {

    @FXML
    private ChoiceBox<String> cbSemana;
    
    @FXML
    private Button btnIdiomaEspaña, btnIdiomaEEUU, btnIdiomaFrancia, btnIdiomaItalia, btnIdiomaReinoUnido;
  
    @FXML
    private Button btnMostrar, btnAñadir;
    
    @FXML
    private Label txtInfoAlumno;
    
    @FXML
    private TableView<Alumno> tableAlumnos;
    
    @FXML
    private TableColumn<Alumno, String> tableNombre;
    
    @FXML
    private TableColumn<Alumno, String> tableApellidos;
    
    @FXML
    private TableColumn<Alumno, Integer> tableNotas;
    
    @FXML
    private AreaChart<?, ?> areaDiseñoInterfaces;
    
    @FXML
    private NumberAxis areaMedias;
    
    @FXML
    private CategoryAxis areaNotas;
    
    @FXML
    private Label txtDiaSemana, txtNombre, txtNota, txtApellidos;
   
    @FXML
    private TextField inputNombre, inputApellidos;
    @FXML
    private ChoiceBox<Integer> cbNotas;
    
    ObservableList<Alumno> listaAlumnos;
    ObservableList<Alumno> alumnoSelected;
    ObservableList<Alumno> listPassAlumn;
    
    private Stage stage;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Creamos un Array de String donde vamos a introducir la key que nos
        //permitira acceder a los dias de la semana en diferentes idiomas
        //ubicados en sus respectivos bundles de idioma
        String dias_semana[] = {
            rb.getString("lunes"),
            rb.getString("martes"),
            rb.getString("miercoles"),
            rb.getString("jueves"),
            rb.getString("viernes"),
            rb.getString("sabado"),
            rb.getString("domingo")};
        
        //Inicializamos el ChoiceBox con el String[] creado
        cbSemana.setItems(FXCollections.observableArrayList(dias_semana));
        //Añadimos como valor por defecto el primer dia de la semana
        cbSemana.setValue(rb.getString("lunes"));
         
        //Creamos un Array de Integer para almacenar las notas del 1-10
        Integer notas[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        //Inicializamos el ChoiceBox con el Integer[] creado
        cbNotas.setItems(FXCollections.observableArrayList(notas));
        
        //Ponemos como valor por defecto el numero 5
        cbNotas.setValue(5);
        
        //Indicamos en cada columna de la tabla el valor que va a almacenar
        //usando la clase Alumno creada especialmente para el correcto
        //funcionamiento de la tabla
        tableNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tableApellidos.setCellValueFactory(new PropertyValueFactory<>("Apellidos"));
        tableNotas.setCellValueFactory(new PropertyValueFactory<>("Nota"));
        
        //Inicializamos la lista de Alumnos como un observable ArrayList
        listaAlumnos = FXCollections.observableArrayList();     
    }

    //Metodo que se iniciara cuando pulsemos cualquier boton de Idiomas.
    //Su funcion sera cambiar la Vista al idioma en el que hemos hecho click
    @FXML
    private void onClickButton(ActionEvent event) throws IOException {
        
        Object evt = event.getSource();
        
        if(evt.equals(btnIdiomaEEUU)) { //Si pulsamos en el boton de EEUU
            
            //Creamos un objeto de tipo Locale que debe ser US 
            //asi debe terminar nuestro archivo .properties
            Locale l = new Locale("US");
            
            //Llamamos al metodo LoadView y le pasamos el parametro creado anteriormente
            LoadView(l);
            
        } else if(evt.equals(btnIdiomaEspaña)) { //Si pulsamos en el boton de España
            
            //Creamos un objeto de tipo Locale que debe ser ES 
            //asi debe terminar nuestro archivo .properties
            Locale l = new Locale("ES");
            
            //Llamamos al metodo LoadView y le pasamos el parametro creado anteriormente
            LoadView(l);
            
        } else if(evt.equals(btnIdiomaReinoUnido)) { //Si pulsamos en el boton de Reino Unido
            
            //Creamos un objeto de tipo Locale que debe ser EN 
            //asi debe terminar nuestro archivo .properties
            Locale l = new Locale("EN");
            
            //Llamamos al metodo LoadView y le pasamos el parametro creado anteriormente
            LoadView(l);
            
        } else if(evt.equals(btnIdiomaFrancia)) { //Si pulsamos en el boton de Francia
            
            //Creamos un objeto de tipo Locale que debe ser FR 
            //asi debe terminar nuestro archivo .properties
            Locale l = new Locale("FR");
            
            //Llamamos al metodo LoadView y le pasamos el parametro creado anteriormente
            LoadView(l);
            
        } else if(evt.equals(btnIdiomaItalia)) { //Si pulsamos en el boton de Italia
            
            //Creamos un objeto de tipo Locale que debe ser IT
            //asi debe terminar nuestro archivo .properties
            Locale l = new Locale("IT");
            
            //Llamamos al metodo LoadView y le pasamos el parametro creado anteriormente
            LoadView(l);
            
        }
    }
    
    //Metodo que se invoca cuando lo llamamos desde el metodo OnClickButton
    //para cargar una vista con el nuevo idioma
    public void LoadView(Locale locale) {
        //Creamos un objeto de tipo FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        
        //Indicamos la localizacion de nuestra vista fxml
        loader.setLocation(getClass().getResource("ViewIntern.fxml"));
        
        //Indicamos el lugar donde se encuentra nuestro bundle.properties
        // y añadimos el archivo locale que hemos pasado en el metodo
        loader.setResources(ResourceBundle.getBundle("desarrollointerfaces.dms.proyectofinal.idiomas.bundle", locale));
        
        try {
            //Carga todos los datos en un Parent
            Parent root = loader.load();
            
            //En el Stage indicamos el objeto Parent, las medidas y lo mostramos
            stage = (Stage) btnAñadir.getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 700));
            stage.show();
        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //Metodo que se invoca cuando pulsamos el boton Mostrar
    //Para ello deberemos haber seleccionado un Alumno en el TableView anteriormente
    @FXML
    private void onClickMostrar(ActionEvent event) {
        //Creamos un objeto de tipo Alumno
        Alumno alumno = new Alumno();
      
        //alumnoSelected es un ObservableList de tipo String que guarda el
        //Alumno seleccionado
        alumnoSelected = tableAlumnos.getSelectionModel().getSelectedItems();

        //En el Label de informacion de alumno mostramos los datos de dicho
        //Alumno por si queremos ver unicamente los datos de un Alumno
        txtInfoAlumno.setText(" - " + alumnoSelected.get(0).getNombre() + "\n" +
              " - " + alumnoSelected.get(0).getApellidos() + "\n" +
               " - " + alumnoSelected.get(0).getNota() + "\n");
    }

    //Metodo que se invoca cuando pulsamos el boton Añadir
    //Para ello deberemos haber seleccionado un Alumno en el TableView anteriormente
    @FXML
    private void onClickAdd(ActionEvent event) {
        
        //Si rellenamos todos los campos (nombre, apellidos y nota) el codigo
        //del if se ejecutara
        if(!inputNombre.getText().isEmpty() && !inputApellidos.getText().isEmpty()) {
        
        //Guardamos todos los datos de los TextField y ChoiceBox
        String nombre = inputNombre.getText();
        String apellidos = inputApellidos.getText();
        Integer nota = cbNotas.getValue();
        
        //Creamos un objeto de tipo Alumno y agregamos los datos para crear uno
        Alumno alumno = new Alumno(nombre, apellidos, nota);
        
        //Añadimos el objeto alumno a la lista de Alumnos
        listaAlumnos.add(alumno);
        
        //Agregamos la lista de Alumnos a la Table View
        tableAlumnos.setItems(listaAlumnos);
        
        //Reseteamos los campos Nombre y Apellido y ponemos el valor
        //por defecto de la nota
        inputNombre.setText("");
        inputApellidos.setText("");
        cbNotas.setValue(5);
        
        //Saltara una alerta que nos indicara que todo ha salido correctamente
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Mensaje de Confirmacion");
        alert.setContentText("Los datos se han registrado correctamente.");
        alert.showAndWait();
            
        } else { // En caso de no rellenar algun campo (nombre o apellido) saltara este codigo
            
            //Saltara una alerta que nos avisara que ha ocurrido un error
            //por no rellenar los campos para agregar alumnos
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("Hay campos vacios a la hora de añadir un Alumno.\n"
                    + "Porfavor rellene todos los campos (nombre, apellidos y nota)");
            alert.showAndWait();
        }
    }
    
    //Metodo que cierra la aplicación para devolver al usuario al menu principal
    //donde se encuentran todas las aplicaciones
    public void closeWindows() {
        
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
            
            Parent root = loader.load();
            
            Scene scene = new Scene(root, 500, 300);
            Stage stage = new Stage();
            
            String css = this.getClass().getResource("estilos/hojaPrincipal.css").toExternalForm();
            scene.getStylesheets().add(css);
            
            stage.setScene(scene);
            
            stage.setTitle("Recopilacion de Proyectos - Desarrollo de Interfaces");
            stage.getIcons().add(new Image("desarrollointerfaces/dms/proyectofinal/images/iconoPrincipal.png"));
            stage.initStyle(StageStyle.DECORATED);
            
            stage.show();
            
            Stage miStage = (Stage) this.btnAñadir.getScene().getWindow();
            miStage.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
