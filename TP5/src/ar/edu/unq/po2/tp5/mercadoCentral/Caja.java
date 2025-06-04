package ar.edu.unq.po2.tp5.mercadoCentral;

import java.util.ArrayList;
import java.util.List;

public class Caja {

    private double montoTotal;
    private List<Cobrable> cobrables;  // Lista de cobrables que puede incluir productos y facturas
    private Mercado mercado;

    // Constructor
    public Caja(Mercado mercado) {
        this.montoTotal = 0.0;
        this.cobrables = new ArrayList<>();
        this.mercado = mercado;
    }

    // Obtener cobrables
    public List<Cobrable> getCobrables() {
        return cobrables;
    }

    // Obtener monto total
    public double getMontoTotal() {
        return montoTotal;
    }

    // Registrar cobrables (productos o facturas)
    public void registrar(Cobrable cobrable) {
        cobrables.add(cobrable);
    }

    // Cobrar el total de los cobrables (productos y facturas)
    public void cobrar() {
        for (Cobrable cobrable : cobrables) {
            // Si el cobrable es un producto, se hace el cobro y se descuenta del inventario
            if (cobrable instanceof Producto) {
                Producto producto = (Producto) cobrable;
                LineaInventario linea = mercado.getInventario().buscarLinea(producto.getNombre());
                if (linea != null && linea.getStock() > 0) {
                    // Descontar el stock desde el inventario, no desde la caja
                    mercado.getInventario().descontarStock(producto);
                    montoTotal += producto.getMonto();
                }
            } 
            // Si el cobrable es una factura, se hace el cobro y se registra el pago en la agencia
            else if (cobrable instanceof Factura) {
                Factura factura = (Factura) cobrable;
                montoTotal += factura.getMonto();
                factura.registrarPago();  // Registrar el pago en la agencia
            }
        }
        cobrables.clear();  // Limpiar la lista de cobrables después de cobrar
    }
}
