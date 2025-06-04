package ar.edu.unq.po2.tp5.mercadoCentral;

public class Producto implements Cobrable {

    private String nombre;
    private double monto;

    // Constructor
    public Producto(String nombre, double monto) {
        this.nombre = nombre;
        this.monto = monto;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getMonto() {
        return monto;
    }
}


