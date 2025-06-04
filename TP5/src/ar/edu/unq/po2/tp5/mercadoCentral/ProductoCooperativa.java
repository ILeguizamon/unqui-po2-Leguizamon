package ar.edu.unq.po2.tp5.mercadoCentral;


public class ProductoCooperativa extends Producto {
	
	// ---------------- CONSTRUCTOR -----------------------------
	public ProductoCooperativa(String nombre, double monto) {
		super(nombre, monto);
	}
	
	// ---------------- MÉTODOS -----------------------------
	@Override
	public double getMonto() {
		double descuento = super.getMonto() * 0.10; // Aplico un 10% al precio base del producto
		return super.getMonto() - descuento;
	}
}
