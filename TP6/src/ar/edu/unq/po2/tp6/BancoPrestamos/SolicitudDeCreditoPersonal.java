package ar.edu.unq.po2.tp6.BancoPrestamos;

public class SolicitudDeCreditoPersonal extends SolicitudDeCredito {

	public SolicitudDeCreditoPersonal(Cliente cliente, double montoDeDinero, int plazoAPagar) {
		super(cliente, montoDeDinero, plazoAPagar);
	}
	
	@Override
	public boolean esAceptable() {
		double ingresoLimite = ((getCliente().getSueldoNetoMensual()) * 70d) / 100d; // 70% de sus ingresos mensuales.
		return (getCliente().sueldoNetoAnual() >= 15000d) && (montoDelaCuotaMensual() <= ingresoLimite);
	}
}
