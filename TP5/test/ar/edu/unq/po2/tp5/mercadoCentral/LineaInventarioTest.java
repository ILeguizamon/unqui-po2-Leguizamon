package ar.edu.unq.po2.tp5.mercadoCentral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LineaInventarioTest {

    private Producto producto;
    private LineaInventario linea;

    @BeforeEach
    public void setUp() {
        producto = new Producto("Yerba", 500);
        linea = new LineaInventario(producto, 5);
    }

    @Test
    public void testDevuelveElProductoCorrectamente() {
        assertEquals(producto, linea.getProducto());
    }

    @Test
    public void testDevuelveElStockInicialCorrectamente() {
        assertEquals(5, linea.getStock());
    }

    @Test
    public void testDescontarStockReduceElStockEnUno() {
        linea.descontarStock();
        assertEquals(4, linea.getStock());
    }

    @Test
    public void testDescontarStockNoReduceElStockSiEsCero() {
        linea = new LineaInventario(producto, 0);
        linea.descontarStock();
        assertEquals(0, linea.getStock());
    }

    @Test
    public void testDescontarStockVariasVecesFuncionaCorrectamente() {
        linea.descontarStock(); // 4
        linea.descontarStock(); // 3
        linea.descontarStock(); // 2
        assertEquals(2, linea.getStock());
    }
}
