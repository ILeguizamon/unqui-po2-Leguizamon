package ar.edu.unq.po2.state.videoJuego;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaquinaArcadeTest {
    private MaquinaArcade maquina;

    @BeforeEach
    public void setUp() {
        maquina = new MaquinaArcade();
    }

    @Test
    public void testEstadoInicialEsSinFicha() {
        assertEquals("SinFicha", maquina.getEstadoActual().nombreEstado());
    }

    @Test
    public void testInsertarUnaFichaCambiaAEstadoConFicha() {
        maquina.insertarFicha();
        assertEquals("ConFicha", maquina.getEstadoActual().nombreEstado());
    }

    @Test
    public void testInsertarDosFichasCambiaAEstadoCon2Fichas() {
        maquina.insertarFicha(); 
        maquina.insertarFicha(); 
        assertEquals("Con2Fichas", maquina.getEstadoActual().nombreEstado());
    }

    @Test
    public void testPresionarBotonConUnaFichaCambiaAEstadoJugando() {
        maquina.insertarFicha();       
        maquina.presionarBotonInicio(); 
        assertEquals("Jugando", maquina.getEstadoActual().nombreEstado());
    }

    @Test
    public void testPresionarBotonConDosFichasCambiaAEstadoJugando() {
        maquina.insertarFicha();       
        maquina.insertarFicha();       
        maquina.presionarBotonInicio(); 
        assertEquals("Jugando", maquina.getEstadoActual().nombreEstado());
    }

    @Test
    public void testJugarVuelveAEstadoSinFicha() {
        maquina.insertarFicha();     
        maquina.presionarBotonInicio();
        maquina.jugar();
        assertEquals("SinFicha", maquina.getEstadoActual().nombreEstado());
    }

}
