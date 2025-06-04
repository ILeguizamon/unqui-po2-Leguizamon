package ar.edu.unq.po2.tp6.BancoPrestamos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {	
	private Cliente cliente;
	private Banco banco;
	private SolicitudDeCredito solicitud;
	
	// Set-Up
	@BeforeEach
	public void setUp() {
		cliente = new Cliente("Juan", "Perez", "Calle Falsa 123", 25, 950000d);
		banco = new Banco();
		solicitud = new SolicitudDeCreditoPersonal(cliente, 10000, 12);
	}
	
	// Tests
	@Test
	public void testClienteConoceSuInformacion() {
		
		assertEquals(cliente.getNombre(), "Juan");
		assertEquals(cliente.getEdad(), 25);
		assertEquals(cliente.getApellido(), "Perez");
		assertEquals(cliente.getDireccion(), "Calle Falsa 123");
		assertEquals(cliente.getSueldoNetoMensual(), 950000d);
	}
	
	@Test
	public void testClienteSolicitaCreditoYElBancoLoRegistra() {
	    cliente.solicitarCredito(banco, solicitud);

	    assertTrue(banco.getSolicitudesDeCredito().contains(solicitud));
	}


}
