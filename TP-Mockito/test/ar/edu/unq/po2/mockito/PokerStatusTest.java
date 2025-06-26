package ar.edu.unq.po2.mockito;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PokerStatusTest {

    PokerStatus pokerStatus;

    // Setup 
    Carta cartaP2;  
    Carta cartaC2;
    Carta cartaD4;
    Carta cartaT5;
    Carta cartaPK;
    Carta cartaP8;
    Carta cartaC8;
    Carta cartaT8;
    Carta cartaD8;
    Carta cartaDK;
    Carta cartaCK;
    Carta cartaTK;

    @BeforeEach
    public void setup() {
        pokerStatus = new PokerStatus();

        // Instanciación de cartas
        cartaP2 = new Carta("P", "2");
        cartaC2 = new Carta("C", "2");
        cartaD4 = new Carta("D", "4");
        cartaT5 = new Carta("T", "5");
        cartaPK = new Carta("P", "K");

        cartaP8 = new Carta("P", "8");
        cartaC8 = new Carta("C", "8");
        cartaT8 = new Carta("T", "8");
        cartaD8 = new Carta("D", "8");

        cartaDK = new Carta("D", "K");
        cartaCK = new Carta("C", "K");
        cartaTK = new Carta("T", "K");
    }

    @Test
    public void testTodasDiferentes() {
        // Setup: cartaP2, cartaC2, cartaD4, cartaT5, cartaPK que no forman jugada

        // Exercise
        String resultado = pokerStatus.verificar(cartaP2, cartaC2, cartaD4, cartaT5, cartaPK);

        // Verify
        assertEquals("Nada", resultado);

        // Teardown (no requerido)
    }

    @Test
    public void testDosCartasIguales() {
        // Setup: dos cartas con mismo valor 2, pero no hay trio ni poquer

        // Exercise
        String resultado = pokerStatus.verificar(cartaP2, cartaC2, cartaD4, cartaT5, cartaPK);

        // Verify
        assertEquals("Nada", resultado);
    }

    @Test
    public void testTresCartasIguales() {
        // Setup: tres cartas rey (K) igual valor (trío)

        // Exercise
        String resultado = pokerStatus.verificar(cartaDK, cartaCK, cartaTK, cartaT5, cartaP2);

        // Verify
        assertEquals("Trio", resultado);
    }

    @Test
    public void testCuatroCartasIguales() {
        // Setup: cuatro cartas con valor 8 (póquer)

        // Exercise
        String resultado = pokerStatus.verificar(cartaP8, cartaC8, cartaT8, cartaD8, cartaPK);

        // Verify
        assertEquals("Poquer", resultado);
    }

    @Test
    public void testCuatroCartasIgualesEnDiferentePosicion() {
        // Setup: mismo póquer pero en diferente orden

        // Exercise
        String resultado = pokerStatus.verificar(cartaPK, cartaP8, cartaC8, cartaT8, cartaD8);

        // Verify
        assertEquals("Poquer", resultado);
    }

    @Test
    public void testColor() {
        // Setup: todas las cartas del mismo palo "P"

        Carta cartaP4 = new Carta("P", "4");
        Carta cartaP6 = new Carta("P", "6");

        // Exercise
        String resultado = pokerStatus.verificar(cartaP2, cartaP4, cartaP6, cartaP8, cartaPK);

        // Verify
        assertEquals("Color", resultado);
    }

    @Test
    public void testNada() {
        // Setup: cartas variadas sin jugada

        // Exercise
        String resultado = pokerStatus.verificar(cartaP2, cartaC2, cartaD4, cartaT5, cartaPK);

        // Verify
        assertEquals("Nada", resultado);
    }
    
    @Test
    public void testMismoPalo() {
        // Setup: cartaP2 y cartaPK (ambas palo "P")
        // Exercise
        boolean resultado = cartaP2.mismoPaloQue(cartaPK);

        // Verify
        assertTrue(resultado);
    }

    @Test
    public void testDistintoPalo() {
        // Setup: cartaP2 (palo "P") y cartaC2 (palo "C")
        // Exercise
        boolean resultado = cartaP2.mismoPaloQue(cartaC2);

        // Verify
        assertFalse(resultado);
    }

    @Test
    public void testCartaMayor() {
        // Setup: cartaPK (K) y cartaP2 (2), cartaPK es mayor
        // Exercise
        boolean resultado = cartaPK.esMayorQue(cartaP2);

        // Verify
        assertTrue(resultado);
    }
}

