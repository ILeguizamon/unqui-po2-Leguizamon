package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoPlantaTemporaria extends Empleado {

    private LocalDate fechaFinDesignacion;
    private int cantHorasExtras;

    // ---------------- CONSTRUCTOR -----------------------------
    public EmpleadoPlantaTemporaria(String nombre, String direccion, String estadoCivil, LocalDate fechaDeNacimiento, double sueldoBasico, LocalDate fechaFinDesignacion, int cantHorasExtras) {
        super(nombre, direccion, estadoCivil, fechaDeNacimiento, sueldoBasico);
        this.fechaFinDesignacion = fechaFinDesignacion;
        this.cantHorasExtras = cantHorasExtras;  
    }

    // ---------------- GETTERS & SETTERS -----------------------------
    public LocalDate getFechaFinDesignacion() {
        return fechaFinDesignacion;
    }

    public int getCantHorasExtras() {
        return cantHorasExtras;
    }

    public void setFechaFinDesignacion(LocalDate fechaFinDesignacion) {
        this.fechaFinDesignacion = fechaFinDesignacion;
    }

    public void setCantHorasExtras(int cantHorasExtras) {
        this.cantHorasExtras = cantHorasExtras;
    }

    // ---------------- MÉTODOS ADICIONALES -------------------
    private double extraPorEdadMayorACincuenta() {
        if (this.edad() > 50) {
            return 25.0;
        } else {
            return 0.0;
        }
    }

    // ------------- IMPLEMENTACIÓN DE LOS MÉTODOS -------------
    @Override
    public double sueldoBruto() {
        return this.getSueldoBasico() + this.getCantHorasExtras() * 40;
    }

    @Override
    public double retencionPorObraSocial() {
        return this.sueldoBruto() * 0.10 + this.extraPorEdadMayorACincuenta();
    }

    @Override
    public double retencionPorAportesJubilatorios() {
        return this.sueldoBruto() * 0.10 + (this.getCantHorasExtras() * 5);
    }

    @Override
    public double retenciones() {
        return this.retencionPorObraSocial() + this.retencionPorAportesJubilatorios(); 
    }
    
    // ------------- NUEVO MÉTODO DE DETALLE -------------
    @Override
    public List<Concepto> getConceptos() {
        List<Concepto> conceptos = new ArrayList<>();
        
        // Sueldo básico
        conceptos.add(new Concepto("Sueldo Básico", this.getSueldoBasico()));
        
        // Horas extras
        double montoHorasExtras = this.getCantHorasExtras() * 40;
        conceptos.add(new Concepto("Pago por Horas Extras (" + this.getCantHorasExtras() + " hs)", montoHorasExtras));
        
        // Retención por obra social (incluye extra si es mayor a 50)
        conceptos.add(new Concepto("Retención por Obra Social (incluye +$25 si > 50 años)", -this.retencionPorObraSocial()));
        
        // Retención por aportes jubilatorios (incluye $5 por hora extra)
        conceptos.add(new Concepto("Retención por Aportes Jubilatorios (+$5 por hora extra)", -this.retencionPorAportesJubilatorios()));
        
        return conceptos;
    }

}
