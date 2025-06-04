package ar.edu.unq.po2.tp5.mercadoCentral;

public class LineaInventario {

    private Producto producto;
    private int stock;

    // Constructor
    public LineaInventario(Producto producto, int stock) {
        this.producto = producto;
        this.stock = stock;
    }

    // Getters
    public Producto getProducto() {
        return producto;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void descontarStock() {
        if (getStock() > 0) {
        	stock = getStock() - 1;
        }
    }

	public void setStock(int stock) {
		this.stock = stock;
	}
    
    
}


