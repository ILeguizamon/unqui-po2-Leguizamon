package ar.edu.unq.po2.tp5.mercadoCentral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CajaTest {

    private Caja caja;
    private Mercado mercado;
    private Inventario inventario;
    private AgenciaRecaudadora agencia;
    private Producto producto;

    @BeforeEach
    public void setUp() {
        inventario = new Inventario();
        agencia = new AgenciaRecaudadora();
        mercado = new Mercado(inventario, agencia);
        caja = new Caja(mercado);
        producto = new Producto("Yerba", 500);
        inventario.agregarProducto(producto, 10);  // Producto 'Yerba' con stock de 10
    }

    @Test
    public void testRegistrarProductoYCobrar() {
        // Registrar el producto en la caja
        caja.registrar(producto);
        assertEquals(0.0, caja.getMontoTotal(), "El monto total debe ser 0 antes de cobrar");

        // Realizar el cobro
        caja.cobrar();

        // Verificar que el monto total se haya actualizado
        assertEquals(500.0, caja.getMontoTotal(), "El monto total debe ser 500 después de cobrar el producto");

        // Verificar que el stock del producto se haya descontado correctamente
        LineaInventario linea = mercado.getInventario().buscarLinea("Yerba");
        assertNotNull(linea, "La línea del producto debe existir en el inventario");
        assertEquals(9, linea.getStock(), "El stock del producto 'Yerba' debe ser 9 después de cobrarlo");
    }

    @Test
    public void testRegistrarFacturaYCobrar() {
        // Registrar una factura en la caja
        Factura factura = new FacturaImpuesto(agencia, 100);
        caja.registrar(factura);
        assertEquals(0.0, caja.getMontoTotal(), "El monto total debe ser 0 antes de cobrar");

        // Realizar el cobro
        caja.cobrar();

        // Verificar que el monto total se haya actualizado
        assertEquals(100.0, caja.getMontoTotal(), "El monto total debe ser 100 después de cobrar la factura");

        // Verificar que la factura haya sido registrada correctamente en la agencia
        assertTrue(agencia.getFacturasPagadas().contains(factura), "La factura debe estar registrada en la agencia como pagada");
    }

    @Test
    public void testCobroMultiple() {
        // Registrar un producto y una factura
        caja.registrar(producto);
        Factura factura = new FacturaImpuesto(agencia, 200);
        caja.registrar(factura);

        // Realizar el cobro
        caja.cobrar();

        // Verificar el monto total
        assertEquals(700.0, caja.getMontoTotal(), "El monto total debe ser 700 después de cobrar el producto y la factura");

        // Verificar que el stock del producto se haya descontado correctamente
        LineaInventario linea = mercado.getInventario().buscarLinea("Yerba");
        assertNotNull(linea, "La línea del producto debe existir en el inventario");
        assertEquals(9, linea.getStock(), "El stock del producto 'Yerba' debe ser 9 después de cobrarlo");

        // Verificar que la factura haya sido registrada correctamente en la agencia
        assertTrue(agencia.getFacturasPagadas().contains(factura), "La factura debe estar registrada en la agencia como pagada");
    }
}
