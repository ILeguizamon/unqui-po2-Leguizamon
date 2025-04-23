package ar.edu.unq.po2.tp3;

public class Rectangulo {
    private Point posicion;
    private int ancho; 
    private int alto;  

    // ---------------------- CONSTRUCTOR ----------------------
    public Rectangulo(Point posicion, int ancho, int alto) {
        this.posicion = posicion;
        this.ancho = ancho;
        this.alto = alto;
    }

    // ---------------------- MÉTODOS ----------------------

    public int area() {
        return ancho * alto;
    }

    public int perimetro() {
        return 2 * (ancho + alto);
    }

    public boolean esHorizontal() {
        return ancho > alto;
    }

    public boolean esVertical() {
        return alto > ancho;
    }

    // ---------------------- GETTERS ----------------------

    public Point getPosicion() {
        return posicion;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
}
