package ar.edu.unq.po2.tp5.colecciones;

import java.time.LocalDate;
import java.time.Period;

public class Persona implements Nombrable {
	private String nombre;
	private LocalDate fechaDeNacimiento;
	
	// ---------------- CONSTRUCTOR -----------------------------
	public Persona(String nombre, LocalDate fechaDeNacimiento) {
		this.nombre = nombre;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	// ---------------- GETTERS & SETTERS -----------------------------
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaDeNacimiento() {
		return this.fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	// ---------------- MÉTODOS -----------------------------
	public int edad() {
		LocalDate fechaActual = LocalDate.now();
		return Period.between(getFechaDeNacimiento(), fechaActual).getYears();
	}
	
	public boolean menorQue(Persona persona) {
		return this.edad() < persona.edad();
	}
}
