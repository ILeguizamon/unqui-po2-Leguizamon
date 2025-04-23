package ar.edu.unq.po2.tp3;

public class Cuadrado extends Rectangulo {
    
    // Constructor del cuadrado, recibe la posición y el lado (como los dos lados del cuadrado son iguales)
    public Cuadrado(Point posicion, int lado) {
        // Llama al constructor de la clase Rectangulo con el mismo valor para ancho y alto (lado)
        super(posicion, lado, lado); 
    }
}
