package ar.edu.unq.po2.AyTm.sueldosRecargados;

public class EmpleadoDePlanta extends Empleado{
	private int cantHijos;
	
	public EmpleadoDePlanta(int cantHijos) {
		super();
		this.cantHijos = cantHijos;
	}
	
	@Override
	public double sueldo() {
		return this.sueldoBasico() + this.bonoPorHijos();
	}

	private double bonoPorHijos() {
		return this.getCantHijos() * 150d;
	}

	private double sueldoBasico() {
		return 3000d;
	}
	
	protected int getCantHijos() {
		return cantHijos;
	}

}
