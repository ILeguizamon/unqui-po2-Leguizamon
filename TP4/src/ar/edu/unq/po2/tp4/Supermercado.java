package ar.edu.unq.po2.tp4;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	private String nombre;
	private String direccion;
	private List<Producto> productos;
	
	// ---------------- CONSTRUCTOR -----------------------------
	public Supermercado(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.productos = new ArrayList<Producto>();
	}

	// ---------------- GETTERS -----------------------------
	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}
	
	 public List<Producto> getProductos() {
		return productos;
	}

	// ---------------- MÉTODOS -----------------------------
	public int cantTotalDeProductos() {
		return getProductos().size(); // Devuelve el tamaño de la lista de productos
	}
	
	public double totalDePreciosDeProductos() {
		double sumatTotalDePrecios = 0.0;
		
		for (Producto producto : getProductos()) {
			sumatTotalDePrecios += producto.getPrecio();
		}
		return sumatTotalDePrecios;
	}
	
	public void agregarProducto(Producto unProducto) {
		getProductos().add(unProducto);
	}
	
}
