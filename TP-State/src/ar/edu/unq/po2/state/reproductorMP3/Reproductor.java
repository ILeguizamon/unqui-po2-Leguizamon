package ar.edu.unq.po2.state.reproductorMP3;

public class Reproductor {
	private EstadoDeReproduccion estado;
	private Song cancion;

	public Reproductor(Song cancion) {
		this.cancion = cancion;
		this.estado = new EstadoStop(this);
	}
	
	public String play() {
		return this.estado.play();
	}
	
	public String pause() {
		return this.estado.pausa();
	}
	
	public String stop() {
		return this.estado.stop();
	}

	public EstadoDeReproduccion getEstado() {
		return estado;
	}

	public void setEstado(EstadoDeReproduccion estado) {
		this.estado = estado;
	}

	public Song getCancion() {
		return cancion;
	}
}
