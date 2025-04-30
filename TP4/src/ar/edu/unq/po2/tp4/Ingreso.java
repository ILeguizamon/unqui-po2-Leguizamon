package ar.edu.unq.po2.tp4;

public class Ingreso {
	private int mes;
	private double montoPercibido;
	private String concepto;
	
	// ---------------- CONSTRUCTOR -----------------------------
	public Ingreso(int mes, String concepto, double montoPercibido) {
		this.mes = mes;
		this.concepto = concepto;
		this.montoPercibido = montoPercibido;
	}
	
	// ---------------- GETTERS -----------------------------
	public int getMes() {
		return mes;
	}
	
	public String getConcepto() {
		return concepto;
	}
	
	public double getMontoPercibido() {
		return montoPercibido;
	}
	
	// ---------------- MÉTODOS -----------------------------
	public double getMontoImponible() {
		return getMontoPercibido();
	}
}
