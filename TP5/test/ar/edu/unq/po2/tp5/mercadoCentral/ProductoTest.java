package ar.edu.unq.po2.tp5.mercadoCentral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    private Producto producto;

    @BeforeEach
    public void setUp() {
        producto = new Producto("Yerba", 500);
    }

    @Test
    public void testCrearProducto() {
        assertNotNull(producto);
    }

    @Test
    public void testGetNombre() {
        assertEquals("Yerba", producto.getNombre());
    }

    @Test
    public void testGetMonto() {
        assertEquals(500, producto.getMonto());
    }

    @Test
    public void testProductoConMontoCero() {
        Producto productoCero = new Producto("Sal", 0);
        assertEquals(0, productoCero.getMonto());
    }

    @Test
    public void testProductoConNombreVacio() {
        Producto productoVacio = new Producto("", 200);
        assertEquals("", productoVacio.getNombre());
    }

    @Test
    public void testProductoComoCobrable() {
        Cobrable cobrable = producto;
        assertEquals(500, cobrable.getMonto());
    }
}
