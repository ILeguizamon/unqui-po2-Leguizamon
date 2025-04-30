package ar.edu.unq.po2.tp4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SupermercadoTest {
	
	 Producto arroz;
	 Producto leche;
	 Supermercado supermercado;
	
	// --------------------- SETUP ---------------------
	@BeforeEach
	public void setUp() {
		
		// Crear productos
		arroz = new Producto("Arroz", 100d, false);
		leche = new Producto("Leche", 300d, true);
        
        // Crear supermercado con los productos
		supermercado = new Supermercado("Super 12", "Quilmes");
		
		// Agrego productos al supermercado
		supermercado.agregarProducto(arroz);
		supermercado.agregarProducto(leche);
	}
	
	// ------------------------ TESTS ------------------------
	@Test
	public void testVerificarQueLaCantDeProductoEsLaEsperada() {
		int cantEsperada = 2;
		
		assertEquals(cantEsperada, supermercado.getProductos().size());
	}
	
	@Test
	public void testVerificarQueLaCantDeLaSumaDePreciosEsLaEsperada() {
		double cantEsperada = 400d;
		
		assertEquals(cantEsperada, supermercado.totalDePreciosDeProductos());
	}
}
