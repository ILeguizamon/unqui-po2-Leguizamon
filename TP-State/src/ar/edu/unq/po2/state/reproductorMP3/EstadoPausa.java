package ar.edu.unq.po2.state.reproductorMP3;

public class EstadoPausa extends EstadoDeReproduccion {

	public EstadoPausa(Reproductor reproductor) {
		super(reproductor);
	}

	@Override
	public String play() {
		this.reproductor.getCancion().play(); // ⬅️ retoma la reproducción
		this.reproductor.setEstado(new EstadoPlay(this.reproductor));
		return "Reproduciendo...";
	}

	@Override
	public String pausa() {
		return "Se encuentra pausado"; // nada cambia, ni se invoca a Song
	}

	@Override
	public String stop() {
		this.reproductor.getCancion().stop(); // ⬅️ detiene la canción
		this.reproductor.setEstado(new EstadoStop(this.reproductor));
		return "Parado";
	}

	@Override
	public String getNombreEstado() {
		// TODO Auto-generated method stub
		return "Pause";
	}


}
