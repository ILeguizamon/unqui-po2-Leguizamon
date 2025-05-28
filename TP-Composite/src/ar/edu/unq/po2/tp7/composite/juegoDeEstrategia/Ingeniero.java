package ar.edu.unq.po2.tp7.composite.juegoDeEstrategia;

public class Ingeniero extends Soldado {
	private BolsaDeLajas bolsaDeLajas;
	
	public Ingeniero(Punto ubicacion, Mapa mapaActual, BolsaDeLajas bolsaDeLajas) {
		super(ubicacion, mapaActual);
		this.bolsaDeLajas = bolsaDeLajas;
	}
	
	
	public BolsaDeLajas getBolsaDeLajas() {
		return bolsaDeLajas;
	}
	
	public boolean hayLajaDondeEsta() {
		return this.mapaActual.hayLajaEn(ubicacion);
	}

	
	private void ponerLajaSiNoHay() {
		if(!(this.hayLajaDondeEsta()) & this.bolsaDeLajas.tieneLajas()) {
			this.bolsaDeLajas.usarLaja();
			this.mapaActual.colocarLaja(ubicacion);
		}
		
	}

	@Override
	public void moverA(Punto otroPunto) {
		while(this.ubicacion.getX() != otroPunto.getX() || this.ubicacion.getY() != otroPunto.getY()) {
			this.moverseUnaUbicacionMasCercaDe(otroPunto);
			this.ponerLajaSiNoHay();
		}
	}
	
	public void moverseUnaUbicacionMasCercaDe(Punto destino) {
		 // caminata en diagonal, moviéndose 1 unidad en X y/o Y hacia el destino
	}


	
}
