package ar.edu.unq.po2.tp7.composite.juegoDeEstrategia;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EjercitoTest {

    @Test
    public void testMoverEjercitoSinSoldados() {
        // Crear el ejército con una ubicación inicial y mapa
        Punto ubicacionEjercito = new Punto(0, 0);
        Mapa mapa = new Mapa();
        Ejercito ejercito = new Ejercito(ubicacionEjercito, mapa);
        
        // Intentar mover el ejército (sin soldados)
        Punto destino = new Punto(5, 5);
        ejercito.moverA(destino);
        
        // Como no hay soldados, no hay cambios en el ejército
        assertEquals(0, ejercito.cantidadDeSoldados());
    }
    
    @Test
    public void testIngenieroNoSeMueveSiYaEstaEnElDestino() {
        // Crear mapa y bolsa
        Mapa mapa = new Mapa();
        BolsaDeLajas bolsa = new BolsaDeLajas(10);

        // Crear al ingeniero ya ubicado en (1,1)
        Punto ubicacionInicial = new Punto(1, 1);
        Ingeniero ingeniero = new Ingeniero(ubicacionInicial, mapa, bolsa);

        // Llamar a moverA con el mismo punto
        Punto destino = new Punto(1, 1);
        ingeniero.moverA(destino);

        // Verificar que no se movió
        assertEquals(1, ingeniero.getUbicacion().getX());
        assertEquals(1, ingeniero.getUbicacion().getY());
    }
    
    @Test
    public void testIngenieroSeMueve() {
        // Arrange: crear mapa y bolsa
        Mapa mapa = new Mapa();
        BolsaDeLajas bolsa = new BolsaDeLajas(10);

        // Crear Ingeniero en (0,0)
        Punto ubicacionInicial = new Punto(0, 0);
        Ingeniero ingeniero = new Ingeniero(ubicacionInicial, mapa, bolsa);

        // Act: mover al destino (1,1)
        Punto destino = new Punto(1, 1);
        ingeniero.moverA(destino);

        // Assert: verificar que está en (1,1)
        assertEquals(1, ingeniero.getUbicacion().getX());
        assertEquals(1, ingeniero.getUbicacion().getY());
    }

}

