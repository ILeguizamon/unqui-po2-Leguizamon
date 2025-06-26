package ar.edu.unq.po2.observer.publicaciones;

public interface Subject {
	//  Sistema de publicaciones
    void agregarObservador(Observer o);
    void quitarObservador(Observer o);
    void notificar(Articulo articulo);
}

