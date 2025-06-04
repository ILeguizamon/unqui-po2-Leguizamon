package ar.edu.unq.po2.state.videoJuego;

public class EstadoSinFicha implements EstadoMaquina {
    private MaquinaArcade maquina;

    public EstadoSinFicha(MaquinaArcade maquina) {
        this.maquina = maquina;
    }
    
    @Override
    public void insertarFicha() {
        System.out.println("Insertar ficha");
        maquina.setEstadoActual(new EstadoConFicha(maquina));
    }
    
    @Override
    public void presionarBotonInicio() {
        System.out.println("Insertá una ficha primero.");
    }
    
    @Override
    public void jugar() {
        System.out.println("No podés jugar sin una ficha.");
    }
    
    @Override
    public String nombreEstado() {
        return "SinFicha";
    }
}
