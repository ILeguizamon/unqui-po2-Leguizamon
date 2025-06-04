package ar.edu.unq.po2.tp5.mercadoCentral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FacturaImpuestoTest {

    private AgenciaRecaudadora agencia;
    private FacturaImpuesto factura;

    @BeforeEach
    public void setUp() {
        agencia = new AgenciaRecaudadora();
        factura = new FacturaImpuesto(agencia, 200.0);
    }

    @Test
    public void testGetMonto() {
        assertEquals(200.0, factura.getMonto());
    }

    @Test
    public void testGetTasaFija() {
        assertEquals(200.0, factura.getTasaFija());
    }
}
