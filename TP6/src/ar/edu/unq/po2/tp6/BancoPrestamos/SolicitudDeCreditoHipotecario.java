package ar.edu.unq.po2.tp6.BancoPrestamos;

public class SolicitudDeCreditoHipotecario extends SolicitudDeCredito {
	private PropiedadInmobiliaria propiedad;
	
	public SolicitudDeCreditoHipotecario(Cliente cliente, double montoDeDinero, int plazoAPagar, PropiedadInmobiliaria propiedad) {
		super(cliente, montoDeDinero, plazoAPagar);
		this.propiedad = propiedad;
	}
	
	public PropiedadInmobiliaria getPropiedad() {
		return propiedad;
	}

	@Override
	public boolean esAceptable() {
		double ingresoLimite = ((getCliente().getSueldoNetoMensual()) * 50d) / 100d; // 50% de los ingresos mensuales del titular
		double ingresoValorFiscal = (getPropiedad().getValorFiscal() * 70d) / 100d; // 70% del valor fiscal de la garantía,
		return (montoDelaCuotaMensual() <= ingresoLimite) && (getMontoDeDinero() <= ingresoValorFiscal) && aniosSegunElPlazoDeCuotas() <= 65;
	}
	
	public int aniosSegunElPlazoDeCuotas() {
		int edadCliente = getCliente().getEdad();
		return edadCliente + (getPlazoAPagar() / 12); // Edad del cliente que tendría cuando pagase todas las cuotas.
	}
}
