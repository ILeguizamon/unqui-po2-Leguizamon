package ar.edu.unq.po2.tp6.BancoPrestamos;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private List<Cliente> clientes;
	private List<SolicitudDeCredito> solicitudesDeCredito;
	
	public Banco() {
		this.clientes = new ArrayList<Cliente>();
		this.solicitudesDeCredito = new ArrayList<SolicitudDeCredito>();
	}
	
	public List<Cliente> getClientes(){
		return clientes;
	}
	
	public List<SolicitudDeCredito> getSolicitudesDeCredito(){
		return solicitudesDeCredito;
	}
	
	public void agregarCliente(Cliente cliente) {
		getClientes().add(cliente);
	}
	
	public void registrarSolicitudDeCredito(SolicitudDeCredito solicitud) {
		getSolicitudesDeCredito().add(solicitud); // Agrega la solicitud a su lista.
	}
	
	public void desembolsarSumaDeDinero() {
		for (SolicitudDeCredito solicitud : getSolicitudesDeCredito()) {
		    if (solicitud.esAceptable()) {
		         System.out.println("Se desembolsó $" + solicitud.getMontoDeDinero() + " al cliente " + solicitud.getCliente().getNombre());
		        }
		   }
	}
	
	public double montoTotalDesembolsado() {
		double montoTotal = 0d;
		for (SolicitudDeCredito solicitud: getSolicitudesDeCredito()) {
			if(solicitud.esAceptable()) {
				montoTotal += solicitud.getMontoDeDinero();
			}
		}
		return montoTotal;
	}
	
}
