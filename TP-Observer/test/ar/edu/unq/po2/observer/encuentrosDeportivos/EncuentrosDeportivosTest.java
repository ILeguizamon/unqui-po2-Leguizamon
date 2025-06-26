package ar.edu.unq.po2.observer.encuentrosDeportivos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EncuentrosDeportivosTest {

    private class ObservadorSimple implements Observer {
        private boolean notificado = false;

        @Override
        public void actualizar(Partido partido) {
            notificado = true;
        }

        public boolean fueNotificado() {
            return notificado;
        }
    }

    @Test
    public void testNotificaATodosLosObservadores() {
        EncuentrosDeportivos encuentros = new EncuentrosDeportivos();

        ObservadorSimple o1 = new ObservadorSimple();
        ObservadorSimple o2 = new ObservadorSimple();

        encuentros.agregarObservador(o1);
        encuentros.agregarObservador(o2);

        Partido partido = new Partido("Ganó 3-1", "Fútbol");

        encuentros.nuevoPartido(partido);

        assertTrue(o1.fueNotificado());
        assertTrue(o2.fueNotificado());
    }

    @Test
    public void testQuitarObservadorNoLoNotifica() {
        EncuentrosDeportivos encuentros = new EncuentrosDeportivos();

        ObservadorSimple o1 = new ObservadorSimple();
        encuentros.agregarObservador(o1);
        encuentros.quitarObservador(o1);

        Partido partido = new Partido("Ganó 3-1", "Fútbol");

        encuentros.nuevoPartido(partido);

        assertFalse(o1.fueNotificado());
    }
}
