/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.ideas;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Dani
 */
public class Alumno {
    
    private SimpleStringProperty nombre;
    private SimpleStringProperty apellidos;
    private SimpleIntegerProperty nota;

    public Alumno() {
    }

    public Alumno(String nombre, String apellidos, Integer nota) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.nota = new SimpleIntegerProperty(nota);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getApellidos() {
        return apellidos.get();
    }

    public void setApellidos(String apellidos) {
        this.apellidos = new SimpleStringProperty(apellidos);
    }

    public Integer getNota() {
        return nota.get();
    }

    public void setNota(Integer nota) {
        this.nota = new SimpleIntegerProperty(nota);
    } 
    
}
