package ar.edu.unq.po2.tp4;

public class Producto {
	private String nombre;
	private double precio;
	private boolean esPrecioCuidado;
	
	// ---------------- CONSTRUCTORES -----------------------------
	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
		this.esPrecioCuidado = false; // Por defecto, el producto no es parte del programa, a menos que se especifique lo contrario.
	}
	
	public Producto(String nombre, double precio, boolean esPrecioCuidado) {
		this.nombre = nombre;
		this.precio = precio;
		this.esPrecioCuidado = esPrecioCuidado;
	}
	
	// ---------------- GETTERS -----------------------------
	public String getNombre() {
		return this.nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public boolean isEsPrecioCuidado() {
		return esPrecioCuidado;
	}
	
}
