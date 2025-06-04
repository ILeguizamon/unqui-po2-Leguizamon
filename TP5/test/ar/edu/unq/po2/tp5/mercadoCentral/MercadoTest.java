package ar.edu.unq.po2.tp5.mercadoCentral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MercadoTest {

    private Mercado mercado;
    private Inventario inventario;
    private AgenciaRecaudadora agencia;
    private Caja caja;
    private Producto producto;

    @BeforeEach
    public void setUp() {
        inventario = new Inventario();
        agencia = new AgenciaRecaudadora();
        mercado = new Mercado(inventario, agencia);
        caja = new Caja(mercado); 

        producto = new Producto("Yerba", 500);
        inventario.agregarProducto(producto, 10);
    }

    @Test
    public void testCobroProductoYFacturaEnAgencia() {
        // Al comenzar, el monto total de la caja debería ser 0
        assertEquals(0.0, caja.getMontoTotal(), "El monto total de la caja debe ser 0 antes del cobro");

        // Registrá un producto en la caja
        caja.registrar(producto);

        // Realizá el cobro del producto
        caja.cobrar();

        // Creá una factura y registrala en la agencia
        Factura factura = new FacturaImpuesto(agencia, producto.getMonto());
        mercado.registrarPagoEnAgencia(factura);

        // Asegurate de que el monto total de la caja sea el esperado
        assertEquals(500.0, caja.getMontoTotal(), "El monto total de la caja debe ser igual al monto del producto");

        // Buscá el producto en el inventario para verificar que se haya descontado el stock
        LineaInventario linea = inventario.buscarLinea("Yerba");
        assertNotNull(linea, "La línea de inventario para el producto Yerba debe existir");
        assertEquals(9, linea.getStock(), "El stock del producto Yerba debe haber disminuido en 1");

        // Verificá que la agencia haya registrado el pago de la factura
        assertTrue(agencia.getFacturasPagadas().contains(factura), "La factura debe haber sido registrada en la agencia");
    }

}
