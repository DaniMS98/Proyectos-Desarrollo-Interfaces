package es.ideas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController implements Initializable {

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
    private Label txtDiaSemana, txtAlumno, txtNombre, txtNota, txtApellidos;
   
    @FXML
    private TextField inputNombre, inputApellidos;
    @FXML
    private ChoiceBox<Integer> cbNotas;
    
    ObservableList<Alumno> listaAlumnos = FXCollections.observableArrayList();
    ObservableList<Alumno> alumnoSelected;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Inicialización del ComboBox con los días de la semana
        //También tiene que traducirse
        String dias_semana[] = {"Lunes", "Martes", "Miércoles", "Jueves",
            "Viernes", "Sábado", "Domingo"};
        cbSemana.setItems(FXCollections.observableArrayList(dias_semana));
        cbSemana.setValue("Lunes");
        
        Integer notas[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        cbNotas.setItems(FXCollections.observableArrayList(notas));
        cbNotas.setValue(5);
        
        tableNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tableApellidos.setCellValueFactory(new PropertyValueFactory<>("Apellidos"));
        tableNotas.setCellValueFactory(new PropertyValueFactory<>("Nota"));
        tableAlumnos.setItems(listaAlumnos);
        
    }

    @FXML
    private void onClickButton(ActionEvent event) {
    }

    @FXML
    private void onClickMostrar(ActionEvent event) {
        Alumno alumno = new Alumno();
      
        alumnoSelected = tableAlumnos.getSelectionModel().getSelectedItems();
        
        txtInfoAlumno.setText("Información del Alumno: \n" + 
                "Nombre: " + alumnoSelected.get(0).getNombre() + "\n" +
                "Apellidos: " + alumnoSelected.get(0).getApellidos() + "\n" +
                "Nota: " + alumnoSelected.get(0).getNota() + "\n");
    }

    @FXML
    private void onClickAdd(ActionEvent event) {
        
        String nombre = inputNombre.getText();
        String apellidos = inputApellidos.getText();
        Integer nota = cbNotas.getValue();
        Alumno alumno = new Alumno(nombre, apellidos, nota);
        listaAlumnos.add(alumno);      
        tableAlumnos.setItems(listaAlumnos);
        
        inputNombre.setText("");
        inputApellidos.setText("");
        cbNotas.setValue(5);
    }
}
