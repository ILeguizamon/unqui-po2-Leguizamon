package ar.edu.unq.po2.state.videoJuego;

public class EstadoCon2Fichas implements EstadoMaquina {

    private MaquinaArcade maquina;

    public EstadoCon2Fichas(MaquinaArcade maquina) {
        this.maquina = maquina;
    }

    @Override
    public void insertarFicha() {
        System.out.println("Ya hay dos fichas insertadas.");
    }

    @Override
    public void presionarBotonInicio() {
        System.out.println("Iniciando juego para dos jugadores...");
        maquina.setEstadoActual(new EstadoJugando(maquina));  
    }

    @Override
    public void jugar() {
        System.out.println("Jugando con dos jugadores... Fin del juego.");
        maquina.setEstadoActual(new EstadoSinFicha(maquina));
    }
    
    @Override
    public String nombreEstado() {
        return "Con2Fichas";
    }
}

