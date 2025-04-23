package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonaTest {

    private Persona persona1;
    private Persona persona2;
    
    // --------------------- SETUP ---------------------
    @BeforeEach
    public void setUp() {
        persona1 = new Persona("Ivan", LocalDate.of(2000, 5, 10));
        persona2 = new Persona("Maria", LocalDate.of(1990, 3, 15));
    }
    
    // ------------------------ TESTS ------------------------
    @Test
    public void testEdadDePersona() {
        int edadEsperada = 24; 
        assertEquals(edadEsperada, persona1.getEdad());
    }

    @Test
    public void testMenorQue() {
        assertTrue(persona1.menorQue(persona2));
        assertFalse(persona2.menorQue(persona1));
    }
}
