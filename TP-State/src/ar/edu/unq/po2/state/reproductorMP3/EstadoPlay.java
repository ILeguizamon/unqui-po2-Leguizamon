package ar.edu.unq.po2.state.reproductorMP3;

public class EstadoPlay extends EstadoDeReproduccion {

	public EstadoPlay(Reproductor reproductor) {
		super(reproductor);
	}
	
	@Override
	public String play() {
		return "Reproduciendo...";
	}

	@Override
	public String pausa() {
		this.reproductor.getCancion().pause();
		this.reproductor.setEstado(new EstadoPausa(this.reproductor));
		return "Pausado";
	}

	@Override
	public String stop() {
		this.reproductor.getCancion().stop();
		this.reproductor.setEstado(new EstadoStop(this.reproductor));
		return "Parado";
	}

	@Override
	public String getNombreEstado() {
		// TODO Auto-generated method stub
		return "Play";
	}


}