package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public abstract class Empleado {
    private String nombre;
    private String direccion;
    private String estadoCivil;
    private LocalDate fechaDeNacimiento;
    private double sueldoBasico;

    // ---------------- CONSTRUCTOR -----------------------------
    public Empleado(String nombre, String direccion, String estadoCivil, LocalDate fechaDeNacimiento, double sueldoBasico) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.sueldoBasico = sueldoBasico;
    }

    // ---------------- GETTERS & SETTERS -----------------------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(Double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public int edad() {
        return Period.between(this.getFechaDeNacimiento(), LocalDate.now()).getYears();
    }

    
    public double sueldoNeto() {
        return this.sueldoBruto() - this.retenciones();
    }

    // ---------------- MÉTODOS ABSTRACTOS -------------------
    public abstract double sueldoBruto();

    public abstract double retenciones();

    public abstract double retencionPorObraSocial();

    public abstract double retencionPorAportesJubilatorios();

    // NUEVO:
    public abstract List<Concepto> getConceptos();
}
