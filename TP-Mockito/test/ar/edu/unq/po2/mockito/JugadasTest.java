package ar.edu.unq.po2.mockito;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JugadasTest {

    private Carta carta1;
    private Carta carta2;
    private Carta carta3;
    private Carta carta4;
    private Carta carta5;

    private Carta carta6;
    private Carta carta7;
    private Carta carta8;
    private Carta carta9;
    private Carta carta10;

    private Jugada jugadaAlta;     // Poquer de ases
    private Jugada jugadaMedia1;  // Poquer de reyes
    private Jugada jugadaMedia2;  // Color
    private Jugada jugadaBaja;    // Trio
    private Jugada jugadaSinJuego;

    @BeforeEach
    public void setUp() {
        // Setup
        carta1 = new Carta("C", "A"); 
        carta2 = new Carta("P", "A"); 
        carta3 = new Carta("D", "A"); 
        carta4 = new Carta("T", "A"); 
        carta5 = new Carta("C", "K");

        carta6 = new Carta("P", "K");
        carta7 = new Carta("D", "K");
        carta8 = new Carta("T", "K");
        carta9 = new Carta("P", "10");
        carta10 = new Carta("P", "9");

        jugadaAlta     = new Jugada(carta1, carta2, carta3, carta4, carta5); 
        jugadaMedia1   = new Jugada(carta5, carta6, carta7, carta8, carta1);
        jugadaMedia2   = new Jugada(new Carta("P", "2"), new Carta("P", "5"), carta10, carta9, carta6); 
        jugadaBaja     = new Jugada(carta1, carta2, carta3, carta5, carta6); 
        jugadaSinJuego = new Jugada(carta1, carta5, carta9, carta7, carta4); 
    }

    /**
     * Jugada más fuerte (Poquer de ases) gana a una más débil (Trio)
     */
    @Test
    public void testJugadaAltaLeGanaAJugadaBaja() {
        // Exercise
        Jugada resultado = jugadaAlta.compararCon(jugadaBaja);

        // Verify
        assertEquals(jugadaAlta, resultado);

        // Teardown: Automático
    }

    /**
     * Jugada con poquer de ases gana a poquer de reyes (igual tipo, gana valor alto)
     */
    @Test
    public void testJugadaAltaLeGanaAJugadaMedia1() {
        // Exercise
        Jugada resultado = jugadaAlta.compararCon(jugadaMedia1);

        // Verify
        assertEquals(jugadaAlta, resultado);

        // Teardown: Automático
    }

    /**
     * Jugada de color gana a una jugada de tipo inferior (Trio)
     */
    @Test
    public void testJugadaMedia2LeGanaAJugadaBaja() {
        // Exercise
        Jugada resultado = jugadaMedia2.compararCon(jugadaBaja);

        // Verify
        assertEquals(jugadaMedia2, resultado);

        // Teardown: Automático
    }

    /**
     * Si ambas jugadas son exactamente iguales, se considera empate (devuelve null)
     */
    @Test
    public void testEmpateExactoDevuelveNull() {
        // Setup
        Jugada jugadaCopia = new Jugada(carta1, carta2, carta3, carta4, carta5);

        // Exercise
        Jugada resultado = jugadaAlta.compararCon(jugadaCopia);

        // Verify
        assertNull(resultado);

        // Teardown: Automático
    }

    /**
     * Una jugada sin combinación ('Nada') pierde contra un Trio
     */
    @Test
    public void testJugadaBajaLeGanaAJugadaSinJuego() {
        // Exercise
        Jugada resultado = jugadaBaja.compararCon(jugadaSinJuego);

        // Verify
        assertEquals(jugadaBaja, resultado);

        // Teardown: Automático
    }
}
