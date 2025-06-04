package ar.edu.unq.po2.tp5.mercadoCentral;

import java.util.ArrayList;
import java.util.List;

public class AgenciaRecaudadora implements Agencia{
	private List<Factura> facturasPagadas;

	public AgenciaRecaudadora() {
		this.facturasPagadas = new ArrayList<Factura>();
	}
	
	public List<Factura> getFacturasPagadas() {
		return facturasPagadas;
	}
	
	public void registrarPago(Factura factura) {
		this.getFacturasPagadas().add(factura);
	}

	
}