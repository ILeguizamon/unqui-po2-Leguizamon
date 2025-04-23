package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RectanguloTest {

    private Rectangulo rectangulo;

    // --------------------- SETUP ---------------------
    @BeforeEach
    public void setUp() {
        Point posicion = new Point();  // Crea un punto con coordenadas (0,0)
        rectangulo = new Rectangulo(posicion, 10, 5); // Crea un rectángulo con ancho 10 y alto 5
    }

    // ------------------------ TESTS ------------------------

    @Test
    public void testCalcularArea() {
        assertEquals(50, rectangulo.area()); // Espera 10 * 5 = 50
    }

    @Test
    public void testCalcularPerimetro() {
        assertEquals(30, rectangulo.perimetro()); // Espera 2*(10 + 5) = 30
    }

    @Test
    public void testVerificarSiEsHorizontalCuandoElAnchoEsMayorQueElAlto() {
        assertTrue(rectangulo.esHorizontal());  
        assertFalse(rectangulo.esVertical());  
    }

    @Test
    public void testVerificarSiEsVerticalCuandoElAltoEsMayorQueElAncho() {
        Rectangulo vertical = new Rectangulo(new Point(1, 1), 4, 9); 
        assertTrue(vertical.esVertical());  
        assertFalse(vertical.esHorizontal()); 
    }

    @Test
    public void testLaPosicionDelRectanguloEsLaCorrecta() {
        Point pos = rectangulo.getPosicion();  
        assertEquals(0, pos.getX());  
        assertEquals(0, pos.getY());  
    }
}
