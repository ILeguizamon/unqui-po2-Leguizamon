package ar.edu.unq.po2.tp7.composite.juegoDeEstrategia;

import java.util.ArrayList;
import java.util.List; 

public class Mapa {
    private List<Punto> puntosConLajas;

    public Mapa() {
		this.puntosConLajas = new ArrayList<>();
	}

	public boolean hayLajaEn(Punto punto) {
        return puntosConLajas.contains(punto);
    }

	public void colocarLaja(Punto punto) {
	     puntosConLajas.add(punto);
	}
	
}

