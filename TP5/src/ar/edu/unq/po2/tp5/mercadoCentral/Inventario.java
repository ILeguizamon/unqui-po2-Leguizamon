package ar.edu.unq.po2.tp5.mercadoCentral;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Producto> productos;
    private List<LineaInventario> lineas;

    public Inventario() {
        this.productos = new ArrayList<>();
        this.lineas = new ArrayList<>();
    }
    
    public List<Producto> getProductos() {
        return productos;
    }

    public List<LineaInventario> getLineas() {
        return lineas;
    }

    public void agregarProducto(Producto producto, int stockInicial) {
        productos.add(producto);
        lineas.add(new LineaInventario(producto, stockInicial));
    }

    public LineaInventario buscarLinea(String nombreProducto) {
        for (LineaInventario linea : lineas) {
            if (linea.getProducto().getNombre().equals(nombreProducto)) {
                return linea;
            }
        }
        return null;
    }
    
    // Método para descontar el stock de un producto
    public void descontarStock(Producto producto) {
        LineaInventario linea = buscarLinea(producto.getNombre());
        if (linea != null && linea.getStock() > 0) {
            linea.setStock(linea.getStock() - 1);  // Descontar 1 unidad del stock
        }
    }
}