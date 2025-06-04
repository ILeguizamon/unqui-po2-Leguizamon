package ar.edu.unq.po2.state.reproductorMP3;

public abstract class EstadoDeReproduccion {
	protected Reproductor reproductor;
	
	public EstadoDeReproduccion(Reproductor reproductor) {
		this.reproductor = reproductor;
	}
	
	public abstract String getNombreEstado();

	public abstract String play();
	public abstract String pausa();
	public abstract String stop();
}
