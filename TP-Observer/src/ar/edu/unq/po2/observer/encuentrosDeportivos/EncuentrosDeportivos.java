package ar.edu.unq.po2.observer.encuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;

public class EncuentrosDeportivos implements Subject{
    private List<Observer> observadores;
    private List<Partido> partidos;
    
    public EncuentrosDeportivos() {
    	this.observadores = new ArrayList<>();
    	this.partidos = new ArrayList<>();
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
	public void notificar(Partido p) {
        for (Observer o : observadores) {
            o.actualizar(p);
        }
    }
    
    public void nuevoPartido(Partido p) {
        this.notificar(p);
    }
}
