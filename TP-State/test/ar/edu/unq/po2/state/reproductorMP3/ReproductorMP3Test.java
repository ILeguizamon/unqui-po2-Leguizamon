package ar.edu.unq.po2.state.reproductorMP3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReproductorMP3Test {
    private Reproductor reproductor;

    @BeforeEach
    public void setUp() {
        Song song = new Song();
        reproductor = new Reproductor(song);
    }

    @Test
    public void alCrearReproductorEstadoInicialEsStop() {
        assertEquals("Stop", reproductor.getEstado().getNombreEstado());
    }

    @Test
    public void desdeStopPlayCambiaAPlay() {
        String resultado = reproductor.play();
        assertEquals("Play", reproductor.getEstado().getNombreEstado());
        assertEquals("Reproduciendo...", resultado);
    }

    @Test
    public void desdeStopPauseCambiaAPause() {
        String resultado = reproductor.pause();
        assertEquals("Pause", reproductor.getEstado().getNombreEstado());
        assertEquals("Pausado", resultado);
    }

    @Test
    public void desdeStopStopNoCambiaEstado() {
        String resultado = reproductor.stop();
        assertEquals("Stop", reproductor.getEstado().getNombreEstado());
        assertEquals("Se encuentra parado", resultado);
    }

    @Test
    public void desdePlayPlayNoCambiaEstado() {
        reproductor.play();
        String resultado = reproductor.play();
        assertEquals("Play", reproductor.getEstado().getNombreEstado());
        assertEquals("Reproduciendo...", resultado);
    }

    @Test
    public void desdePlayPauseCambiaAPause() {
        reproductor.play();
        String resultado = reproductor.pause();
        assertEquals("Pause", reproductor.getEstado().getNombreEstado());
        assertEquals("Pausado", resultado);
    }

    @Test
    public void desdePlayStopCambiaAStop() {
        reproductor.play();
        String resultado = reproductor.stop();
        assertEquals("Stop", reproductor.getEstado().getNombreEstado());
        assertEquals("Parado", resultado);
    }

    @Test
    public void desdePausePlayCambiaAPlay() {
        reproductor.play();
        reproductor.pause();
        String resultado = reproductor.play();
        assertEquals("Play", reproductor.getEstado().getNombreEstado());
        assertEquals("Reproduciendo...", resultado);
    }

    @Test
    public void desdePausePauseNoCambiaEstado() {
        reproductor.play();
        reproductor.pause();
        String resultado = reproductor.pause();
        assertEquals("Pause", reproductor.getEstado().getNombreEstado());
        assertEquals("Se encuentra pausado", resultado);
    }

    @Test
    public void desdePauseStopCambiaAStop() {
        reproductor.play();
        reproductor.pause();
        String resultado = reproductor.stop();
        assertEquals("Stop", reproductor.getEstado().getNombreEstado());
        assertEquals("Parado", resultado);
    }
}

