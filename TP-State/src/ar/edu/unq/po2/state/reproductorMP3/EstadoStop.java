package ar.edu.unq.po2.state.reproductorMP3;

public class EstadoStop extends EstadoDeReproduccion {

	public EstadoStop(Reproductor reproductor) {
		super(reproductor);
	}

	@Override
	public String play() {
		this.reproductor.getCancion().play(); // ⬅️ ahora se ejecuta play() en la canción
		this.reproductor.setEstado(new EstadoPlay(this.reproductor));
		return "Reproduciendo...";
	}

	@Override
	public String pausa() {
		// técnicamente esto no debería poder hacerse desde STOP.
		this.reproductor.getCancion().pause();
		this.reproductor.setEstado(new EstadoPausa(this.reproductor));
		return "Pausado";
	}

	@Override
	public String stop() {
		return "Se encuentra parado"; // no se hace nada con Song, porque ya está en stop
	}

	@Override
	public String getNombreEstado() {
		// TODO Auto-generated method stub
		return "Stop";
	}

	
}
