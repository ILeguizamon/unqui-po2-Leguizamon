package ar.edu.unq.po2.tp4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProductoTest {
	
	 Producto arroz;
	
	// --------------------- SETUP ---------------------
	@BeforeEach
	public void setUp() {
		
		// Crear productos
		arroz = new Producto("Arroz", 99d, true);
	}
	
	// ------------------------ TESTS ------------------------
	@Test
	public void testUnProductoConoceSusAtributos() {
		assertEquals("Arroz", arroz.getNombre());
		assertEquals(99d, arroz.getPrecio());
		assertTrue(arroz.isEsPrecioCuidado());
	}
}
