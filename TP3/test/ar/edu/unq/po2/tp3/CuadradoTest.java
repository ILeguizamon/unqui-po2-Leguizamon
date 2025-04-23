package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuadradoTest {

    private Cuadrado cuadrado;

    // --------------------- SETUP ---------------------
    @BeforeEach
    public void setUp() {
        cuadrado = new Cuadrado(new Point(2, 3), 4);
    }

    // ------------------------ TESTS ------------------------
    @Test
    public void testCalcularAreaDeUnCuadrado() {
        assertEquals(16, cuadrado.area()); 
    }

    @Test
    public void testCalcularPerimetroDeUnCuadrado() {
        assertEquals(16, cuadrado.perimetro()); 
    }

    @Test
    public void testUnCuadradoNoEsNiHorizontalNiVertical() {
        assertFalse(cuadrado.esHorizontal()); 
        assertFalse(cuadrado.esVertical());   
    }

    @Test
    public void testObtenerPosicionInicialDelCuadrado() {
        Point pos = cuadrado.getPosicion();
        assertEquals(2, pos.getX());  
        assertEquals(3, pos.getY());  
    }
}