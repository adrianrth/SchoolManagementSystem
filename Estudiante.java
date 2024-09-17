/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagementsystem;
import java.time.LocalDate;
/**
 *
 * @author lape4
 */
public class Estudiante extends Persona {
    private int id;
    private LocalDate fechaDeNacimiento;
    private String estado; // Puede ser "matriculado", "inactivo", "graduado"

    // Constructor
    public Estudiante(int id, String nombre, String apellido, LocalDate fechaDeNacimiento, String estado) {
        super(nombre, apellido);
        this.id = id;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}