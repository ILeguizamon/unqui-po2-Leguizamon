package ar.edu.unq.po2.AyTm.sueldosRecargados;

public class EmpleadoTemporario extends Empleado {
	private boolean tieneHijos;
	private boolean estaCasado;
	private double sueldoBasico;
	private int cantHorasTrabajadas;
	
	public EmpleadoTemporario(boolean tieneHijos, boolean estaCasado, double sueldoBasico, int cantHorasTrabajadas) {
		super();
		this.tieneHijos = tieneHijos;
		this.estaCasado = estaCasado;
		this.sueldoBasico = 1000d;
		this.cantHorasTrabajadas = cantHorasTrabajadas;
	}
	
	@Override
	public double sueldo() {
		return this.bonoPorHora() + this.getSueldoBasico() + this.bonoPorFamilia();
	}
	
	private double bonoPorFamilia() {
		if(this.getTieneHijos() || this.getEstaCasado()) {
			return 100d;
		}
		return 0d;
	}

	private double bonoPorHora() {
		return (5d * this.getHorasTrabajadas());
	}
	
	protected boolean getTieneHijos() {
		return tieneHijos;
	}
	
	protected boolean getEstaCasado() {
		return estaCasado;
	}
	
	protected double getSueldoBasico() {
		return sueldoBasico;
	}
	
	protected int getHorasTrabajadas() {
		return cantHorasTrabajadas;
	}
	
}
