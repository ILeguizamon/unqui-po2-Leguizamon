package ar.edu.unq.po2.observer.encuentrosDeportivos;

public interface Subject {
	void agregarObservador(Observer o);
	void quitarObservador(Observer o);
	void notificar(Partido partido);
}
