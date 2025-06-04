package ar.edu.unq.po2.tp5.mercadoCentral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoCooperativaTest {

    private ProductoCooperativa producto;

    @BeforeEach
    public void setUp() {
        producto = new ProductoCooperativa("Arroz", 100);
    }

    @Test
    public void testMontoConDescuento() {
        assertEquals(90.0, producto.getMonto());
    }

    @Test
    public void testNombreProducto() {
        assertEquals("Arroz", producto.getNombre());
    }

    @Test
    public void testMontoConDescuentoDecimal() {
        producto = new ProductoCooperativa("Fideos", 99.99);
        double montoEsperado = 99.99 - (99.99 * 0.10);
        assertEquals(montoEsperado, producto.getMonto(), 0.001); // tolerancia para decimales
    }

    @Test
    public void testProductoCooperativaEsProducto() {
        Producto productoPadre = new ProductoCooperativa("Pan", 150);
        assertEquals(135.0, productoPadre.getMonto());
    }
}
