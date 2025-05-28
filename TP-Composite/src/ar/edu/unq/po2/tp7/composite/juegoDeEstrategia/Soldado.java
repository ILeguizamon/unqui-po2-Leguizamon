package ar.edu.unq.po2.tp7.composite.juegoDeEstrategia;

public abstract class Soldado {
    protected Punto ubicacion;
    protected Mapa mapaActual;
    
    public Soldado(Punto ubicacion, Mapa mapaActual) {
        this.ubicacion = ubicacion;
        this.mapaActual = mapaActual;
    }
    
    
    public Punto getUbicacion() {
		return ubicacion;
	}


	public Mapa getMapaActual() {
		return mapaActual;
	}


	public Punto ubicacionActual() {
        return this.ubicacion;
    }

    // Método para iniciar la caminata
    public void caminar(Punto destino) {
        while (!this.ubicacion.equals(destino)) {
            moverA(destino); // Llama al método específico para mover de acuerdo al tipo de soldado
        }
    }

    // Método abstracto que será implementado por cada tipo de soldado
    public abstract void moverA(Punto destino);
}