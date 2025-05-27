package ar.edu.unq.po2.tp7.composite.juegoDeEstrategia;

import java.util.ArrayList;
import java.util.List;

public class Ejercito extends Soldado{
	private List<Soldado> soldados;
	
	public Ejercito(Punto ubicacion, Mapa mapaActual) {
		super(ubicacion, mapaActual);
		this.soldados = new ArrayList<>();
	}
	
	public List<Soldado> soldados() {
		return this.soldados;
	}
	
	public void agregarSoldado(Soldado soldado) {
		this.soldados.add(soldado);
	}

	public int cantidadDeSoldados() {
		return this.soldados.size();
	}

	@Override
	public void moverA(Punto punto) {
		for(Soldado soldado: soldados){
			soldado.moverA(punto);
		}
	}
}
