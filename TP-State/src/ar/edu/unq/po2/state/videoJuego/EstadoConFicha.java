package ar.edu.unq.po2.state.videoJuego;

public class EstadoConFicha implements EstadoMaquina {
    private MaquinaArcade maquina;

    public EstadoConFicha(MaquinaArcade maquina) {
        this.maquina = maquina;
    }

    @Override
    public void insertarFicha() {
        System.out.println("Insertaste una segunda ficha. Se habilita el modo de dos jugadores.");
        maquina.setEstadoActual(new EstadoCon2Fichas(maquina));
    }

    @Override
    public void presionarBotonInicio() {
        System.out.println("Iniciando juego para un jugador...");
        maquina.setEstadoActual(new EstadoJugando(maquina));
    }

    @Override
    public void jugar() {
        System.out.println("Jugando... Fin del juego.");
        maquina.setEstadoActual(new EstadoSinFicha(maquina));
    }
    
    @Override
    public String nombreEstado() {
        return "ConFicha";
    }
}


