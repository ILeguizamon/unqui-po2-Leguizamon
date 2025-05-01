package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.List;

public class ReciboDeHaberes {

    private String nombreEmpleado;
    private String direccionEmpleado;
    private LocalDate fechaEmision;
    private Double sueldoBruto;
    private Double sueldoNeto;
    private List<Concepto> conceptos;

    // ---------- CONSTRUCTOR ----------
    public ReciboDeHaberes(Empleado empleado) {
        this.nombreEmpleado = empleado.getNombre();
        this.direccionEmpleado = empleado.getDireccion();
        this.fechaEmision = LocalDate.now();
        this.sueldoBruto = empleado.sueldoBruto();
        this.sueldoNeto = empleado.sueldoNeto();  
        this.conceptos = empleado.getConceptos();
    }

    // ---------------- GETTERS ------------------

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

    public List<Concepto> getConceptos() {
        return conceptos;
    }
}
