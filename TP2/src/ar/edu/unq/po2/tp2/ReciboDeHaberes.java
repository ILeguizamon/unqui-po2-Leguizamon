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
    
    // ---------------- MÉTODOS -----------------------------

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
    
    
	    // ------------- IMPLEMENTACIÓN DE LOS MÉTODOS -------------
	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("Nombre: ").append(nombreEmpleado).append("\n");
	        sb.append("Dirección: ").append(direccionEmpleado).append("\n");
	        sb.append("Fecha de Emisión: ").append(fechaEmision).append("\n");
	        sb.append("Sueldo Bruto: ").append(sueldoBruto).append("\n");
	        sb.append("Sueldo Neto: ").append(sueldoNeto).append("\n");
	        sb.append("Desglose de Conceptos:\n");
	
	        for (String concepto : conceptos) {
	            sb.append("  - ").append(concepto).append("\n");
	        }
	
	        return sb.toString();
	    }

}