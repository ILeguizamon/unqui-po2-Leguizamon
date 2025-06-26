package ar.edu.unq.po2.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PokerStatusMockitoTest {

    PokerStatus pokerStatus;

    Carta c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;

    @BeforeEach
    public void setup() {
        pokerStatus = new PokerStatus();

        //  Cartas reales "espías" (Spy: usa el código real, pero te permite espiar o sobrescribir métodos puntuales)
        c1 = spy(new Carta("P", "8"));
        c2 = spy(new Carta("C", "8"));
        c3 = spy(new Carta("T", "8"));
        c4 = spy(new Carta("D", "8"));
        c5 = spy(new Carta("P", "K"));
        
        // mocks de Carta para c6 a c10 (Mock: objeto completamente simulado (sin lógica real))
        c6 = mock(Carta.class);
        c7 = mock(Carta.class);
        c8 = mock(Carta.class);
        c9 = mock(Carta.class);
        c10 = mock(Carta.class);
    }
    
    @Test
    public void testPoquerConSpies() {

        String resultado = pokerStatus.verificar(c1, c2, c3, c4, c5);

        assertEquals("Poquer", resultado);
    }
    
    @Test
    public void testPoquerConMocksCartasC6aC10() {
        // Mocks de getNumero para simular 4 cartas con "9" y una con "A"
        when(c6.getNumero()).thenReturn("9");
        when(c7.getNumero()).thenReturn("9");
        when(c8.getNumero()).thenReturn("9");
        when(c9.getNumero()).thenReturn("9");
        when(c10.getNumero()).thenReturn("A");

        // Stub de mismoValorQue para simular las relaciones. (stub: simula la respuesta para controlar el comportamiento del test)
        // c6 a c9 iguales entre sí, distintas de c10

        // Para c6
        when(c6.mismoValorQue(c6)).thenReturn(true);
        when(c6.mismoValorQue(c7)).thenReturn(true);
        when(c6.mismoValorQue(c8)).thenReturn(true);
        when(c6.mismoValorQue(c9)).thenReturn(true);
        when(c6.mismoValorQue(c10)).thenReturn(false);

        // Para c7
        when(c7.mismoValorQue(c6)).thenReturn(true);
        when(c7.mismoValorQue(c7)).thenReturn(true);
        when(c7.mismoValorQue(c8)).thenReturn(true);
        when(c7.mismoValorQue(c9)).thenReturn(true);
        when(c7.mismoValorQue(c10)).thenReturn(false);

        // Para c8
        when(c8.mismoValorQue(c6)).thenReturn(true);
        when(c8.mismoValorQue(c7)).thenReturn(true);
        when(c8.mismoValorQue(c8)).thenReturn(true);
        when(c8.mismoValorQue(c9)).thenReturn(true);
        when(c8.mismoValorQue(c10)).thenReturn(false);

        // Para c9
        when(c9.mismoValorQue(c6)).thenReturn(true);
        when(c9.mismoValorQue(c7)).thenReturn(true);
        when(c9.mismoValorQue(c8)).thenReturn(true);
        when(c9.mismoValorQue(c9)).thenReturn(true);
        when(c9.mismoValorQue(c10)).thenReturn(false);

        // Para c10
        when(c10.mismoValorQue(c6)).thenReturn(false);
        when(c10.mismoValorQue(c7)).thenReturn(false);
        when(c10.mismoValorQue(c8)).thenReturn(false);
        when(c10.mismoValorQue(c9)).thenReturn(false);
        when(c10.mismoValorQue(c10)).thenReturn(true);

        String resultado = pokerStatus.verificar(c6, c7, c8, c9, c10);

        assertEquals("Poquer", resultado);
    }
}
