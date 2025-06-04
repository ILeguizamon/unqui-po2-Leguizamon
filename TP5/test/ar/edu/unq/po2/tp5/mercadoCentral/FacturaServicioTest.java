package ar.edu.unq.po2.tp5.mercadoCentral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FacturaServicioTest {

    private AgenciaRecaudadora agencia;
    private FacturaServicio factura;

    @BeforeEach
    public void setUp() {
        agencia = new AgenciaRecaudadora();
        factura = new FacturaServicio(agencia, 100.0, 5);
    }

    @Test
    public void testGetMonto() {
        assertEquals(500.0, factura.getMonto());
    }

    @Test
    public void testGetCostoPorUnidad() {
        assertEquals(100.0, factura.getCostoPorUnidad());
    }

    @Test
    public void testGetUnidadesConsumidas() {
        assertEquals(5, factura.getUnidadesConsumidas());
    }
}
