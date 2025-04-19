package ar.edu.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoPlantaTemporaria extends Empleado {
	private LocalDate fechaFinDesignacion;
	private int cantHorasExtras;
	
	
	// ---------------- CONSTRUCTOR -----------------------------
			public EmpleadoPlantaTemporaria(String nombre, String direccion, String estadoCivil, LocalDate fechaDeNacimiento, double sueldoBasico, LocalDate 
					fechaFinDesignacion, int cantHorasExtras) {
				super(nombre, direccion, estadoCivil, fechaDeNacimiento, sueldoBasico);
				this.fechaFinDesignacion = fechaFinDesignacion;
				this.cantHorasExtras = cantHorasExtras;  
			}
	
	// ---------------- METODOS --------------------------------------
			
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
		
	
	    // ---------------- METODOS ADICIONALES -------------------
		public double extraPorEdadMayorACincuenta() {
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
		
		@Override
		public List<String> desgloseDeConceptos() {
		    List<String> conceptos = new ArrayList<>();

		    conceptos.add("Sueldo Básico: " + this.getSueldoBasico());

		    if (this.getCantHorasExtras() > 0) {
		        conceptos.add("Pago por Horas Extras: " + (this.getCantHorasExtras() * 5));
		    }

		    conceptos.add("Aportes Jubilatorios: " + this.retencionPorAportesJubilatorios());
		    conceptos.add("Obra Social: " + this.retencionPorObraSocial());

		    return conceptos;
		}

}
