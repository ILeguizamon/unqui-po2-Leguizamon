package ar.edu.unq.po2.tp5.mercadoCentral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AgenciaRecaudadoraTest {

    private AgenciaRecaudadora agencia;
    private FacturaImpuesto facturaImpuesto;
    private FacturaServicio facturaServicio;

    @BeforeEach
    public void setUp() {
        agencia = new AgenciaRecaudadora();
        facturaImpuesto = new FacturaImpuesto(agencia, 100.0);
        facturaServicio = new FacturaServicio(agencia, 50.0, 2);
    }

    @Test
    public void testRegistrarPagoFacturaImpuesto() {
        agencia.registrarPago(facturaImpuesto);
        assertTrue(agencia.getFacturasPagadas().contains(facturaImpuesto));
    }

    @Test
    public void testRegistrarPagoFacturaServicio() {
        agencia.registrarPago(facturaServicio);
        assertTrue(agencia.getFacturasPagadas().contains(facturaServicio));
    }

    @Test
    public void testRegistrarVariosPagos() {
        agencia.registrarPago(facturaImpuesto);
        agencia.registrarPago(facturaServicio);
        assertEquals(2, agencia.getFacturasPagadas().size());
    }
}
