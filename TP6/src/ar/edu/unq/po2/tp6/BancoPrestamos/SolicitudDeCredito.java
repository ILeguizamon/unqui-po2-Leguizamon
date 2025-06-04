package ar.edu.unq.po2.tp6.BancoPrestamos;

public abstract class SolicitudDeCredito {
	private Cliente cliente;
	private double montoDeDinero;
	private int plazoAPagar;
	
	public SolicitudDeCredito(Cliente cliente, double montoDeDinero, int plazoAPagar) {
		super();
		this.cliente = cliente;
		this.montoDeDinero = montoDeDinero;
		this.plazoAPagar = plazoAPagar;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public double getMontoDeDinero() {
		return montoDeDinero;
	}

	public int getPlazoAPagar() {
		return plazoAPagar;
	}
	
	public double montoDelaCuotaMensual() {
		return (getMontoDeDinero() / getPlazoAPagar());
	}
	
	public abstract boolean esAceptable();
	
}
