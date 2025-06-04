package ar.edu.unq.po2.tp5.mercadoCentral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventarioTest {

    private Inventario inventario;
    private Producto producto;

    @BeforeEach
    public void setUp() {
        inventario = new Inventario();
        producto = new Producto("Yerba", 500);
    }

    @Test
    public void testAgregarProducto() {
        inventario.agregarProducto(producto, 10);
        assertTrue(inventario.getProductos().contains(producto));
        assertEquals(1, inventario.getLineas().size());
        assertEquals(10, inventario.getLineas().get(0).getStock());
    }

    @Test
    public void testBuscarLineaProductoExistente() {
        inventario.agregarProducto(producto, 10);
        LineaInventario linea = inventario.buscarLinea("Yerba");
        assertNotNull(linea);
        assertEquals(producto, linea.getProducto());
        assertEquals(10, linea.getStock());
    }

    @Test
    public void testBuscarLineaProductoNoExistente() {
        LineaInventario linea = inventario.buscarLinea("No Existente");
        assertNull(linea);
    }

    @Test
    public void testAgregarProductoYBuscar() {
        inventario.agregarProducto(producto, 20);
        LineaInventario linea = inventario.buscarLinea("Yerba");
        assertNotNull(linea);
        assertEquals(20, linea.getStock());
    }

    @Test
    public void testBuscarLineaDevuelveNullSiNoExiste() {
        inventario.agregarProducto(producto, 15);
        LineaInventario linea = inventario.buscarLinea("Azúcar");
        assertNull(linea);
    }
}
