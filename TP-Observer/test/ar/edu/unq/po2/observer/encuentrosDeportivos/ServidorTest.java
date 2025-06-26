package ar.edu.unq.po2.observer.encuentrosDeportivos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServidorTest {

    private Servidor servidor;

    @BeforeEach
    public void setUp() {
        servidor = new Servidor();
        servidor.getDeportesInteresados().add("Fútbol");
        servidor.limpiarNotificado();
    }

    @Test
    public void notificaSiElDeporteCoincide() {
        Partido partido = new Partido("Ganó 2-1", "Fútbol");

        servidor.actualizar(partido);

        assertTrue(servidor.fueNotificado());
    }

    @Test
    public void noNotificaSiElDeporteNoCoincide() {
        Partido partido = new Partido("Ganó 3-0", "Tenis");

        servidor.actualizar(partido);

        assertFalse(servidor.fueNotificado());
    }
}
