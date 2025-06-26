package ar.edu.unq.po2.mockito;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class MockitoVerificacionTest {

    @Test
    public void testVerificacionDeLlamadas() {
        Carta c6 = mock(Carta.class);

        // Simulación de llamadas
        c6.getNumero();
        c6.getNumero();
        c6.getPalo();

        // Verificación de que getNumero() fue llamado exactamente 2 veces
        verify(c6, times(2)).getNumero();

        // Verificación de que getPalo() fue llamado 1 vez
        verify(c6, times(1)).getPalo();

        // Verificación de que no hubo otras interacciones
        verifyNoMoreInteractions(c6);
    }
}
