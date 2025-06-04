package ar.edu.unq.po2.tp5.colecciones;

public class Mascota implements Nombrable{
	private String nombre;
	private String raza;
	
	// ---------------- CONSTRUCTOR -----------------------------
	public Mascota(String nombre, String raza) {
		this.nombre = nombre;
		this.raza = raza;
	}
	
	// ---------------- GETTERS & SETTERS -----------------------------
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	
}
