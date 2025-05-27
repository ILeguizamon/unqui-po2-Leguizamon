package ar.edu.unq.po2.tp7.composite.juegoDeEstrategia;

public class BolsaDeLajas {
    private int cantidadLajas;

    public BolsaDeLajas(int cantidadInicial) {
        this.cantidadLajas = cantidadInicial;
    }

    public boolean tieneLajas() {
        return cantidadLajas > 0;
    }

    public void usarLaja() {
        if (tieneLajas()) {
            cantidadLajas--;
        }
    }

    public int getCantidadLajas() {
        return cantidadLajas;
    }
}

