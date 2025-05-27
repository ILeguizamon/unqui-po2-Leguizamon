package ar.edu.unq.po2.tp7.composite.cultivos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PorcionTest {

    @Test
    public void testGananciaPorcionTrigo() {
        Porcion trigo = new PorcionDeTrigo();
        assertEquals(300.0, trigo.gananciaAnual());
    }

    @Test
    public void testGananciaPorcionSoja() {
        Porcion soja = new PorcionDeSoja();
        assertEquals(500.0, soja.gananciaAnual());
    }

    @Test
    public void testGananciaPorcionMixta() {
        Porcion soja = new PorcionDeSoja();
        Porcion trigo = new PorcionDeTrigo();

        PorcionCompuesta mixta = new PorcionCompuesta();
        mixta.agregarSubPorcion(soja);  // soja ahora tiene 1 división
        mixta.agregarSubPorcion(trigo); // trigo ahora tiene 1 división
        mixta.agregarSubPorcion(trigo); // trigo ahora tiene 1 división
        mixta.agregarSubPorcion(soja);  // soja ahora tiene 1 división
        
        // Soja: 500 / 4 = 125
        // Trigo: 300 / 4 = 75
        double gananciaEsperada = 125 * 2 + 75 * 2;

        assertEquals(gananciaEsperada, mixta.gananciaAnual(), 0.01);
    }

}

/*

5. Roles en el patrón Composite:

Porcion (abstracta): Componente base, define la interfaz común.

PorcionDeSoja / PorcionDeTrigo: Hojas, representan objetos simples sin hijos.

PorcionCompuesta: Composición, puede contener múltiples Porcion (otras hojas o compuestas), y se encarga de coordinar su comportamiento.

*/