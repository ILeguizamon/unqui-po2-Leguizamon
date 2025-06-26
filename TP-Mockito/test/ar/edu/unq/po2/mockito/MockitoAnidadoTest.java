package ar.edu.unq.po2.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class MockitoAnidadoTest {

    public interface Mano {
        Carta getCartaPrincipal();
    }

    @Test
    public void testAnidacionDeMocks() {
        // Creo mocks
        Mano mano = mock(Mano.class);
        Carta cartaPrincipal = mock(Carta.class);

        // Configuración de que mano.getCartaPrincipal() devuelve cartaPrincipal
        when(mano.getCartaPrincipal()).thenReturn(cartaPrincipal);

        // Configuración del mock anidado
        when(cartaPrincipal.getNumero()).thenReturn("A");

        // Uso anidado
        String numero = mano.getCartaPrincipal().getNumero();

        assertEquals("A", numero);
    }
}
