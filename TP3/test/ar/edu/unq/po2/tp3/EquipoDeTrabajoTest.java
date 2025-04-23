package ar.edu.unq.po2.tp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class EquipoDeTrabajoTest {

    private EquipoDeTrabajo equipo;
    private Persona persona1;
    private Persona persona2;
    private Persona persona3;
    private Persona persona4;
    private Persona persona5;
    
    // --------------------- SETUP ---------------------
    @BeforeEach
    public void setUp() {
        equipo = new EquipoDeTrabajo("Equipo A");
        
        persona1 = new Persona("Juan", "Pérez", LocalDate.of(1990, 5, 15)); // 34 años (2025)
        persona2 = new Persona("Ana", "Gómez", LocalDate.of(1995, 10, 22)); // 29 años (2025)
        persona3 = new Persona("Luis", "Martínez", LocalDate.of(2000, 3, 10)); // 25 años (2025)
        persona4 = new Persona("Marta", "Lopez", LocalDate.of(1992, 7, 8));  // 32 años (2025)
        persona5 = new Persona("Carlos", "Vega", LocalDate.of(1998, 1, 20)); // 27 años (2025)

        equipo.agregarPersona(persona1);
        equipo.agregarPersona(persona2);
        equipo.agregarPersona(persona3);
        equipo.agregarPersona(persona4);
        equipo.agregarPersona(persona5);
    }
    
    // ------------------------ TESTS ------------------------
    @Test 
    public void testUnEquipoConoceSuNombre() {
    	assertEquals("Equipo A", equipo.getNombre());
    }
    @Test
    public void testAgregarIntegrantesAlEquipo() {
        // Verifica que el equipo tenga 5 integrantes
        assertEquals(5, equipo.getEquipo().size());
    }

    @Test
    public void testPromedioEdad() {
        // Calcular el promedio de edad
        double promedio = equipo.promedioEdad();
        
        // Promedio esperado: (34 + 29 + 25 + 32 + 27) / 5 = 29.0
        assertEquals(29.0, promedio); // Verifica que el promedio calculado sea el esperado
    }

}
