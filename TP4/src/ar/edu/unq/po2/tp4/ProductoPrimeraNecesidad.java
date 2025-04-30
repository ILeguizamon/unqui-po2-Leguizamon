package ar.edu.unq.po2.tp4;

public class ProductoPrimeraNecesidad extends Producto{
	private double descuento;
	
	// ---------------- CONSTRUCTORES -----------------------------
	
	public ProductoPrimeraNecesidad(String nombre, double precio) {
		this(nombre, precio, false, 10d);
	}


	public ProductoPrimeraNecesidad(String nombre, double precio, boolean esPrecioCuidado) {
		this(nombre, precio, esPrecioCuidado, 10d);
	}

	// Constructor con descuento variable (Ejercicio 2)
	public ProductoPrimeraNecesidad(String nombre, double precio, boolean esPrecioCuidado, double descuento) {
		super(nombre, precio, esPrecioCuidado);
		this.descuento = descuento;
	}
	
	
	// ---------------- GETTERS -----------------------------
	public double getDescuento() {
		return descuento;
	}

	
	// ---------------- OVERRIDE -----------------------------
	@Override
	public double getPrecio() {
		double descuentoFinal = (descuento / 100) * super.getPrecio();
		return super.getPrecio() - descuentoFinal;
	}

}
