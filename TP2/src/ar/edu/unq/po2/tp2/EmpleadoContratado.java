package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoContratado extends Empleado {
    
    private int numeroDeContrato;
    private String medioDePago;
    
    // ---------------- CONSTRUCTOR -------------------------
    public EmpleadoContratado(String nombre, String direccion, String estadoCivil, LocalDate fechaDeNacimiento, double sueldoBasico, int numeroDeContrato, String medioDePago) {
        super(nombre, direccion, estadoCivil, fechaDeNacimiento, sueldoBasico);
        this.numeroDeContrato = numeroDeContrato;
        this.medioDePago = medioDePago;
    }
    
    // ---------------- GETTERS & SETTERS -------------------
    public int getNumeroDeContrato() {
        return numeroDeContrato;
    }

    public void setNumeroDeContrato(int numeroDeContrato) {
        this.numeroDeContrato = numeroDeContrato;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }
    
    // ---------------- IMPLEMENTACIÓN DE LOS MÉTODOS -------------------
    @Override
    public double retenciones() {
        return 50;
    }

    @Override
    public double sueldoBruto() {
        return this.getSueldoBasico();
    }

    @Override
    public List<String> desgloseDeConceptos() {
        List<String> conceptos = new ArrayList<>();
        
        conceptos.add("Sueldo Básico: " + this.getSueldoBasico());
        conceptos.add("Gastos Administrativos Contractuales: " + this.retenciones());
        conceptos.add("Medio de Pago: " + this.getMedioDePago());
        
        return conceptos;
    }

    // Métodos sobrescritos debido a que la clase base Empleado los define como abstractos.
    // Como el tipo EmpleadoContratado no tiene retenciones de obra social ni aportes jubilatorios,
    // se devuelve 0.0 para cumplir con la obligación de definir estos métodos sin aplicar una lógica específica.
    @Override
    public double retencionPorObraSocial() {
        return 0.0;
    }

    @Override
    public double retencionPorAportesJubilatorios() {
        return 0.0;
    }
}
