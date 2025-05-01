package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoPlantaPermanente extends Empleado {
    
    private int cantidadHijos;
    private int antiguedad;

    // ---------------- CONSTRUCTOR -------------------------
    public EmpleadoPlantaPermanente(String nombre, String direccion, String estadoCivil, LocalDate fechaDeNacimiento, Double sueldoBasico, int cantidadHijos, int antiguedad) {
        super(nombre, direccion, estadoCivil, fechaDeNacimiento, sueldoBasico);
        this.cantidadHijos = cantidadHijos;  
        this.antiguedad = antiguedad;
    }
    
    // ---------------- GETTERS & SETTERS -------------------
    public int getCantidadHijos() {
        return cantidadHijos;
    }
    
    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }
    
    public int getAntiguedad() {
        return antiguedad;
    }
    
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    // ---------------- CALCULOS POR ASIGNACIÓN ---------------
    private double salarioFamiliar() {
        return sueldoAsignacionPorHijo() + sueldoAsignacionPorConyuge() + sueldoAsignacionPorAntiguedad();
    }

    private double sueldoAsignacionPorAntiguedad() {
        return this.getAntiguedad() * 50.0; 
    }

    private double sueldoAsignacionPorConyuge() {
        if (getEstadoCivil().toLowerCase().equals("casado") || getEstadoCivil().toLowerCase().equals("casada")) {
            return 100.0;
        } else {
            return 0.0;
        }
    }

    private double sueldoAsignacionPorHijo() {
        return this.getCantidadHijos() * 150.0;
    }

    // ------------- IMPLEMENTACIÓN DE LOS MÉTODOS -------------
    @Override
    public double sueldoBruto() {
        return this.getSueldoBasico() + this.salarioFamiliar();
    }

    @Override
    public double retencionPorObraSocial() {
        return this.sueldoBruto() * 0.10 + (getCantidadHijos() * 20);
    }

    @Override
    public double retencionPorAportesJubilatorios() {
        return this.sueldoBruto() * 0.15;
    }

    @Override
    public double retenciones() {
        return this.retencionPorObraSocial() + this.retencionPorAportesJubilatorios();
    }
    
    // ------------- NUEVO MÉTODO DE DETALLE -------------
    @Override
    public List<Concepto> getConceptos() {
        List<Concepto> conceptos = new ArrayList<>();
        
        // Componentes del sueldo bruto
        conceptos.add(new Concepto("Sueldo Básico", this.getSueldoBasico()));
        conceptos.add(new Concepto("Asignación por Antigüedad (" + this.getAntiguedad() + " años)", this.sueldoAsignacionPorAntiguedad()));
        conceptos.add(new Concepto("Asignación por Cónyuge (" + this.getEstadoCivil() + ")", this.sueldoAsignacionPorConyuge()));
        conceptos.add(new Concepto("Asignación por Hijos (" + this.getCantidadHijos() + " hijos)", this.sueldoAsignacionPorHijo()));
        
        // Retenciones
        conceptos.add(new Concepto("Retención por Obra Social", -this.retencionPorObraSocial()));
        conceptos.add(new Concepto("Retención por Aportes Jubilatorios", -this.retencionPorAportesJubilatorios()));
        
        return conceptos;
    }

}
