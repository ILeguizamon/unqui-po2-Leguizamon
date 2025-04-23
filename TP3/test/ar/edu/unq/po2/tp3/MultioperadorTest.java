package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MultioperadorTest {
	
	private Multioperador multioperador;

	// --------------------- SETUP ---------------------
	@BeforeEach
	public void setUp() throws Exception {
		
		multioperador = new Multioperador();

		multioperador.agregarNumero(10);
		multioperador.agregarNumero(30);
		multioperador.agregarNumero(50);
		multioperador.agregarNumero(70);
	}
	
	// --------------------- TEST: Suma ---------------------
	@Test
	public void testSumaTotalDeNumeros() {
		int sumaEsperada = 160;  // 10 + 30 + 50 + 70
		int suma = multioperador.sumarTodosLosNumeros();

		assertEquals(sumaEsperada, suma);  
	}

	// --------------------- TEST: Resta ---------------------
	@Test
	public void testRestarTotalDeNumeros() {
		int restaEsperada = -160;  // 0 - 10 - 30 - 50 - 70
		int resta = multioperador.restarTodosLosNumeros();

		assertEquals(restaEsperada, resta); 
	}

	// --------------------- TEST: Multiplicación ---------------------
	@Test
	public void testMultiplicarTotalDeNumeros() {
		int multEsperada = 1050000;  // 10 * 30 * 50 * 70
		int mult = multioperador.multiplicarTodosLosNumeros();

		assertEquals(multEsperada, mult);
	}
}
