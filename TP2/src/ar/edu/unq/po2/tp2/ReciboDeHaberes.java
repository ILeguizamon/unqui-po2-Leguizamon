package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.List;

public class ReciboDeHaberes {
    
    private String nombreEmpleado;
    private String direccionEmpleado;
    private LocalDate fechaEmision;
    private Double sueldoBruto;
    private Double sueldoNeto;
    private List<String> conceptos;
    
    // ---------------- GETTERS & SETTERS -----------------------------
    
    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public void setSueldoNeto(double sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }

    public void setConceptos(List<String> conceptos) {
        this.conceptos = conceptos;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public Double getSueldoBruto() {
        return sueldoBruto;
    }

    public Double getSueldoNeto() {
        return sueldoNeto;
    }

    public List<String> getConceptos() {
        return conceptos;
    }

    // ------------- MÉTODO --------------
    
    public void imprimirRecibo() {
        System.out.println("Nombre: " + getNombreEmpleado());
        System.out.println("Dirección: " + getDireccionEmpleado());
        System.out.println("Fecha de Emisión: " + getFechaEmision());
        System.out.println("Sueldo Bruto: " + getSueldoBruto());
        System.out.println("Sueldo Neto: " + getSueldoNeto());
        System.out.println("Desglose de Conceptos:");

        for (String concepto : getConceptos()) {
            System.out.println("  - " + concepto);
        }
    }
}
