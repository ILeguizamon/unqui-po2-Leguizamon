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
	    int dx = Integer.compare(destino.getX(), this.ubicacion.getX()); // -1, 0 o 1
	    int dy = Integer.compare(destino.getY(), this.ubicacion.getY()); // -1, 0 o 1

	    this.ubicacion.setX(this.ubicacion.getX() + dx);
	    this.ubicacion.setY(this.ubicacion.getY() + dy);
	}


	
}
