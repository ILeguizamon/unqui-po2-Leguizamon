package ar.edu.unq.po2.observer.publicaciones;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPublicaciones implements Subject {
    private List<Observer> observadores;
    
    public RepositorioPublicaciones() {
    	this.observadores = new ArrayList<>();
    }
    
    public void agregarArticulo(Articulo articulo) {
        this.notificar(articulo);
    }

    @Override
    public void agregarObservador(Observer o) {
        observadores.add(o);
    }

    @Override
    public void quitarObservador(Observer o) {
        observadores.remove(o);
    }

    @Override
    public void notificar(Articulo articulo) {
        for (Observer o : observadores) {
            o.actualizar(articulo);
        }
    }
}

