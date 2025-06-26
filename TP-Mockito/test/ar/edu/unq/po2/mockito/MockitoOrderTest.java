package ar.edu.unq.po2.mockito;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

public class MockitoOrderTest {

    @Test
    public void testOrdenDeLlamadas() {
        Carta c6 = mock(Carta.class);
        Carta c7 = mock(Carta.class);

        // Llama métodos en cierto orden
        c6.getNumero();
        c7.getNumero();
        c6.getPalo();

        // Creo un InOrder para verificar orden de llamadas
        InOrder inOrder = inOrder(c6, c7);

        inOrder.verify(c6).getNumero();  // Primero debe llamarse c6.getNumero()
        inOrder.verify(c7).getNumero();  // Después c7.getNumero()
        inOrder.verify(c6).getPalo();    // Finalmente c6.getPalo()
    }
}
