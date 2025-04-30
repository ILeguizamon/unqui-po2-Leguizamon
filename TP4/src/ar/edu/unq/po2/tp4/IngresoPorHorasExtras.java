package ar.edu.unq.po2.tp4;

public class IngresoPorHorasExtras extends Ingreso {
	private int cantHorasExtras;
	
	// ---------------- CONSTRUCTOR -----------------------------
	public IngresoPorHorasExtras(int mes, String concepto, double montoPercibido, int cantidadHorasExtras) {
		super(mes, concepto, montoPercibido);
		this.cantHorasExtras = cantidadHorasExtras;
	}
	
	// ---------------- MÉTODOS -----------------------------
	public int getCantHorasExtras() {
		return cantHorasExtras;
	}

	@Override
	public double getMontoImponible() {
		return 0d; // están exentas
	}
}
