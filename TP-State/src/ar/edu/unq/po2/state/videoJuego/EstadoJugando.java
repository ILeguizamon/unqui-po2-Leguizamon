package ar.edu.unq.po2.state.videoJuego;

public class EstadoJugando implements EstadoMaquina {
    private MaquinaArcade maquina;

    public EstadoJugando(MaquinaArcade maquina) {
        this.maquina = maquina;
    }
    
    @Override
    public void insertarFicha() {
        System.out.println("Esperá a que termine la partida.");
    }
    
    @Override
    public void presionarBotonInicio() {
        System.out.println("Ya estás jugando.");
    }

    @Override
    public void jugar() {
        System.out.println("Jugando... Fin del juego.");
        maquina.setEstadoActual(new EstadoSinFicha(maquina));
    }
    
    @Override
    public String nombreEstado() {
        return "Jugando";
    }
}
