package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PointTest {
	
	private Point point;

	// --------------------- SETUP ---------------------

	@BeforeEach
	public void setUp() {
		point = new Point();
	}

	// ---------------------- TESTS ----------------------

	@Test
	public void testPuntoEnCoordenadas0() {
	    assertEquals(0, point.getX());
	    assertEquals(0, point.getY());
	}

	@Test
	public void testSumarConOtroPuntoDevuelveNuevoPuntoConCoordenadasSumadas() {
	    Point point2 = new Point(2, 2);  // Segundo punto (2, 2)
	    Point resultado = point.sumar(point2);  // Se espera un nuevo punto en (2, 2)
	    
	    assertEquals(2, resultado.getX());
	    assertEquals(2, resultado.getY());
	}

	@Test
	public void testMoverPuntoANuevasCoordenadas() {
	    point.moverA(5, 5);  // Mueve el punto a (5, 5)
	    
	    assertEquals(5, point.getX());
	    assertEquals(5, point.getY());
	}
}
