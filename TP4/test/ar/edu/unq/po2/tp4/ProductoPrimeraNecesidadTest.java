package ar.edu.unq.po2.tp4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductoPrimeraNecesidadTest {

	ProductoPrimeraNecesidad leche;
	ProductoPrimeraNecesidad queso;
	
	// --------------------- SETUP ---------------------
	@BeforeEach
	public void setUp() {
		leche = new ProductoPrimeraNecesidad("Leche", 35d, false, 15);
		queso = new ProductoPrimeraNecesidad("Queso", 100d, false);
	}
	
	@Test
	public void testPrecioConDescuentoFijo() {
		assertEquals(90.0, queso.getPrecio());
	}

	@Test
	public void testPrecioConDescuentoVariable() {

		assertEquals(29.75d, leche.getPrecio());
	}

}
