package ar.edu.unq.po2.observer.encuentrosDeportivos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PartidoTest {

    private Partido partido;

    @BeforeEach
    public void setUp() {
        partido = new Partido("Ganó 3-2", "Fútbol");
    }

    @Test
    public void testGetResultado() {
        assertEquals("Ganó 3-2", partido.getResultado());
    }

    @Test
    public void testGetDeporte() {
        assertEquals("Fútbol", partido.getDeporte());
    }
    
    @Test
    public void testListaDeContrincantesInicialmenteVacia() {
        assertTrue(partido.getContrincantes().isEmpty());
    }

    @Test
    public void testAgregarYObtenerContrincantes() {
        partido.agregarContrincante("Messi");
        partido.agregarContrincante("Cristiano");

        List<String> contrincantes = partido.getContrincantes();

        assertEquals(2, contrincantes.size());
        assertTrue(contrincantes.contains("Messi"));
        assertTrue(contrincantes.contains("Cristiano"));
    }
}
