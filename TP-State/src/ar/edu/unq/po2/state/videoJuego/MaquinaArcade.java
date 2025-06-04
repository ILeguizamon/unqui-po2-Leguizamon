package ar.edu.unq.po2.state.videoJuego;

public class MaquinaArcade {
    private EstadoMaquina estadoActual;

    public MaquinaArcade() {
        this.estadoActual = new EstadoSinFicha(this);
    }

    public void insertarFicha() {
        estadoActual.insertarFicha();
    }

    public void presionarBotonInicio() {
        estadoActual.presionarBotonInicio();
    }

    public void jugar() {
        estadoActual.jugar();
    }

    public void setEstadoActual(EstadoMaquina estado) {
        this.estadoActual = estado;
    }

    public EstadoMaquina getEstadoActual() {
        return estadoActual;
    }
}


