package ar.edu.unq.po2.tp3;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
    private String nombre;
    private String apellido;
    private LocalDate fechaDeNacimiento;

    // ---------------- CONSTRUCTORES -----------------------------
    public Persona(String nombre, String apellido, LocalDate fechaDeNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    
    public Persona(String nombre, LocalDate fechaDeNacimiento) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    
    // ---------------- MÉTODOS -----------------------------
    public boolean menorQue(Persona persona) {
        return (this.getEdad() < persona.getEdad());
    }

    // ---------------- GETTERS -----------------------------
    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public int getEdad() {
        return Period.between(this.fechaDeNacimiento, LocalDate.now()).getYears();
    }
}
