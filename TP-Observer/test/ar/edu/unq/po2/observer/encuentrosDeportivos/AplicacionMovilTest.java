package ar.edu.unq.po2.observer.encuentrosDeportivos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AplicacionMovilTest {

    private AplicacionMovil app;

    @BeforeEach
    public void setUp() {
        app = new AplicacionMovil();
        app.getDeportes().add("Fútbol");
        app.getContrincantes().add("Messi");
    }

    @Test
    public void testNotificaSiElDeporteCoincide() {
        Partido partido = new Partido("Ganó 2-1", "Fútbol");
        partido.agregarContrincante("Cristiano");

        app.actualizar(partido);

        assertTrue(app.fueNotificada());
    }

    @Test
    public void testNotificaSiElContrincanteCoincide() {
        Partido partido = new Partido("Ganó todos los sets", "Voley");
        partido.agregarContrincante("Messi");

        app.actualizar(partido);

        assertTrue(app.fueNotificada());
    }

    @Test
    public void noNotificaSiNoCoincideNada() {
        Partido partido = new Partido("Ganó 6-0", "Tenis");
        partido.agregarContrincante("Nadal");

        app.actualizar(partido);

        assertFalse(app.fueNotificada());
    }
}

