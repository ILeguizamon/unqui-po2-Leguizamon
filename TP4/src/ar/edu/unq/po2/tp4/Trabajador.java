package ar.edu.unq.po2.tp4;

import java.util.ArrayList;
import java.util.List;

public class Trabajador {
	private List<Ingreso> ingresos;
	
	// ---------------- CONSTRUCTOR -----------------------------
	public Trabajador() {
		ingresos = new ArrayList<Ingreso>();
	}
	
	// ---------------- GETTER -----------------------------
	public List<Ingreso> getIngresos() {
		return ingresos;
	}
	
	// ---------------- MÉTODOS -----------------------------
	public void agregarIngreso(Ingreso ingreso) {
		this.ingresos.add(ingreso);
	}
	
	public Double getTotalPercibido() {
		Double monto = 0d;
		for (Ingreso ingreso : getIngresos()) {  
			monto += ingreso.getMontoPercibido();
		}
		return monto; //retornar el monto total percibido por el trabajador
	}
	
	public Double getMontoImponible() {
		Double monto = 0d;
		for (Ingreso ingreso : getIngresos()) { 
			monto += ingreso.getMontoImponible(); 
		}
		return monto; //retorna el monto imponible al impuesto al trabajador
	}
	
	public Double getImpuestoAPagar() {
		return (getMontoImponible() * 2) / 100; //retorna el monto a pagar por el trabajador, calculado como el 2% del monto imponible
	}
}

