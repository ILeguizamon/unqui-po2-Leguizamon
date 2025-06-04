package ar.edu.unq.po2.tp5.mercadoCentral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FacturaTest {

    private AgenciaRecaudadora agencia;
    private FacturaImpuesto facturaImpuesto;
    private FacturaServicio facturaServicio;

    @BeforeEach
    public void setUp() {
        agencia = new AgenciaRecaudadora();
        facturaImpuesto = new FacturaImpuesto(agencia, 500.0);
        facturaServicio = new FacturaServicio(agencia, 100.0, 5);
    }

    @Test
    public void testRegistrarPagoFacturaImpuesto() {
        facturaImpuesto.registrarPago();
        assertTrue(agencia.getFacturasPagadas().contains(facturaImpuesto));
    }

    @Test
    public void testRegistrarPagoFacturaServicio() {
        facturaServicio.registrarPago();
        assertTrue(agencia.getFacturasPagadas().contains(facturaServicio));
    }
}
