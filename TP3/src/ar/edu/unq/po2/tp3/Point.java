package ar.edu.unq.po2.tp3;

public class Point {
    private int x;  // Coordenada X
    private int y;  // Coordenada Y

    // ---------------------- CONSTRUCTORES ----------------------

    // Constructor con parámetros: crea un punto en la posición (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Constructor por defecto: crea un punto en el origen (0, 0)
    public Point() {
        this(0, 0); 
    }

    // ---------------------- MÉTODOS ----------------------

    public void moverA(int nuevoX, int nuevoY) {
        this.setX(nuevoX);
        this.setY(nuevoY);
    }

    public Point sumar(Point unPunto) {
        int nuevaX = this.x + unPunto.x;
        int nuevaY = this.y + unPunto.y;
        return new Point(nuevaX, nuevaY);
    }

    // ---------------------- GETTERS & SETTERS ----------------------

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
