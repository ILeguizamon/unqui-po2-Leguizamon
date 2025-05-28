package ar.edu.unq.po2.tp7.composite.juegoDeEstrategia;

public class Caballero extends Soldado {
	
	public Caballero(Punto ubicacion, Mapa mapaActual) {
		super(ubicacion, mapaActual);
	}

	@Override
	public void moverA(Punto otroPunto) {

	    while (!(this.ubicacion.equals(otroPunto))) {

	        if (this.ubicacion.getX() != otroPunto.getX()) {
	            this.moverseUnaUbicacionEnX(otroPunto);
	        }

	        if (this.ubicacion.getY() != otroPunto.getY()) {
	            this.moverseUnaUbicacionEnY(otroPunto);
	        }
	    }
	}

	private void moverseUnaUbicacionEnX(Punto destino) {
		// caminata en zigzag en eje X
	}

	private void moverseUnaUbicacionEnY(Punto destino) {
		 // caminata en zigzag en eje Y
	}

}