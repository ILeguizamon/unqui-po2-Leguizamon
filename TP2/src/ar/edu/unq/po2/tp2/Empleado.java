package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
    private String nombre;
    private String direccion;
    private String estadoCivil;
    private LocalDate fechaDeNacimiento;
    private double sueldoBasico;
    private List<ReciboDeHaberes> recibos;

    // ---------------- CONSTRUCTOR -----------------------------
    public Empleado(String nombre, String direccion, String estadoCivil, LocalDate fechaDeNacimiento, double sueldoBasico) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.sueldoBasico = sueldoBasico;
        this.recibos = new ArrayList<ReciboDeHaberes>();
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

    public List<ReciboDeHaberes> getRecibos() {
        return this.recibos;
    }

    public int edad() {
        return Period.between(this.getFechaDeNacimiento(), LocalDate.now()).getYears();
    }

    public double sueldoNeto() {
        return this.sueldoBruto() - this.retenciones();
    }

    public double diezPorCientoSueldoBruto() {
        return (this.sueldoBruto() * 10) / 100;
    }

    // ---------------- MÉTODOS ABSTRACTOS -------------------
    public abstract double sueldoBruto();

    public abstract double retenciones();

    public abstract double retencionPorObraSocial();

    public abstract double retencionPorAportesJubilatorios();

    public abstract List<String> desgloseDeConceptos();

    // ---------------- MÉTODOS PARA EL RECIBO -------------------
    public ReciboDeHaberes generarRecibo() {
        ReciboDeHaberes recibo = new ReciboDeHaberes();
        recibo.setNombreEmpleado(this.getNombre());
        recibo.setDireccionEmpleado(this.getDireccion());
        recibo.setFechaEmision(LocalDate.now()); // Utilizando LocalDate
        recibo.setSueldoBruto(this.sueldoBruto());
        recibo.setSueldoNeto(this.sueldoNeto());
        recibo.setConceptos(this.desgloseDeConceptos());

        return recibo;
    }

    public void generarYGuardarRecibo() {
        this.guardarRecibo(this.generarRecibo());
    }

    public void guardarRecibo(ReciboDeHaberes unRecibo) {
        this.recibos.add(unRecibo);
    }
}
