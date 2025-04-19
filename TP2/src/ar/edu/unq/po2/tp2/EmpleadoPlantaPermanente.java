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
    
 	// ---------------- METODOS ---------------------------------
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
		public double salarioFamiliar() {
		    return sueldoAsignacionPorHijo() + sueldoAsignacionPorConyuge() + sueldoAsignacionPorAntiguedad();
		}
	
		public double sueldoAsignacionPorAntiguedad() {
			return this.antiguedad * 50.0; 
		}
		
		public double sueldoAsignacionPorConyuge() {
		    if (getEstadoCivil().toLowerCase().equals("casado") || getEstadoCivil().toLowerCase().equals("casada")) {
		        return 100.0;
		    } else {
		        return 0.0;
		    }
		}
	
		public double sueldoAsignacionPorHijo() {
		    return this.getCantidadHijos() * 150.0;
		}

	
		// ------------- IMPLEMENTACIÓN DE LOS MÉTODOS -------------
	
		@Override
		public double sueldoBruto() {
		    return this.getSueldoBasico() + this.salarioFamiliar();
		}
	
		@Override
		public double retencionPorObraSocial() {
		    return this.sueldoBruto() * 0.10 + (this.getCantidadHijos() * 20);
		}
	
		@Override
		public double retencionPorAportesJubilatorios() {
		    return this.sueldoBruto() * 0.15;
		}
	
		@Override
		public double retenciones() {
		    return this.retencionPorObraSocial() + this.retencionPorAportesJubilatorios();
		}
		
		@Override
		public List<String> desgloseDeConceptos() {
		    List<String> conceptos = new ArrayList<>();
	
		    conceptos.add("Sueldo Básico: " + this.getSueldoBasico());
	
		    if (this.getAntiguedad() > 0) {
		        conceptos.add("Adicional por Antigüedad: " + this.sueldoAsignacionPorAntiguedad());
		    }
	
		    if (this.getCantidadHijos() > 0) {
		        conceptos.add("Adicional por Hijos: " + this.sueldoAsignacionPorHijo());
		    }
	
		    if (this.getEstadoCivil().equalsIgnoreCase("casado") || this.getEstadoCivil().equalsIgnoreCase("casada")) {
		        conceptos.add("Asignación por Cónyuge: " + this.sueldoAsignacionPorConyuge());
		    }
	
		    conceptos.add("Aportes Jubilatorios: " + this.retencionPorAportesJubilatorios());
		    conceptos.add("Obra Social: " + this.retencionPorObraSocial());
	
		    return conceptos;
		}

}
