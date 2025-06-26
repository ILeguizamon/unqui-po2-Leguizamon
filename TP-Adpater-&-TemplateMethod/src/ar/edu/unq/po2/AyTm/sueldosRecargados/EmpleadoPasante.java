package ar.edu.unq.po2.AyTm.sueldosRecargados;

public class EmpleadoPasante extends Empleado {
	private int cantHorasTrabajadasAlMes;
	
	public EmpleadoPasante(int cantHorasTrabajadasAlMes) {
		super();
		this.cantHorasTrabajadasAlMes = cantHorasTrabajadasAlMes;
	}

	@Override
	public double sueldo() {
		return this.getCantHorasTrabajadas() * 40d;
	}
	
	protected int getCantHorasTrabajadas() {
		return cantHorasTrabajadasAlMes;
	}
}
