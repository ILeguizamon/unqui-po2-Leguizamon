package ar.edu.unq.po2.AyTm.sueldosRecargados;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Empleado> empleados;
	
	public Empresa() {
		this.empleados = new ArrayList<>();
	}
	
	public void pagar() {
		for (Empleado empleado : empleados) {
			empleado.sueldoFinal();
		}
	}
}
