package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CounterTest {
	
	private Counter counter;
	
	// --------------------- SETUP ---------------------
	
	// Método que se ejecuta antes de cada test
	@BeforeEach
	public void setUp() {

		counter = new Counter();
		
		counter.agregarNumero(1);
		counter.agregarNumero(3);
		counter.agregarNumero(5);
		counter.agregarNumero(7);
		counter.agregarNumero(9);
		counter.agregarNumero(1);
		counter.agregarNumero(1);
		counter.agregarNumero(1);
		counter.agregarNumero(1);
		counter.agregarNumero(42682);
	}
	
	// ------------------------ TESTS ------------------------

	@Test
	public void testNumerosPares() {
		int nroPares = counter.cantidadDePares();
		assertEquals(1, nroPares); // Solo 42682 es par
	}
	
	@Test
	public void testNumerosImpares() {
		int nroImpares = counter.cantidadDeImpares();
		assertEquals(9, nroImpares); // Los 9 restantes son impares
	}
	
	@Test
	public void testDeMultiplo() {
		int nro = counter.cantidadDeMultiplos(7);
		assertEquals(1, nro); // Solo uno de los números cargados es múltiplo de 7 (probablemente el 7)
	}
	
	@Test
	public void testObtenerLaMayorCantidadDeNumerosPares() {
		int nro = counter.numeroConMasDigitosPares(counter.getNumeros());
		assertEquals(42682, nro); // Tiene 4 dígitos pares: 4, 2, 6, 8
	}
	

	@Test
	public void testObtenerElMayorMultiploEntreDosNumeros() {
		int nro = counter.maxMultiploEntre0y1000(250, 500);
		assertEquals(1000, nro); // 1000 es múltiplo de 250 y 500
	}
}

