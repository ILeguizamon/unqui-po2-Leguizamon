package ar.edu.unq.po2.tp7.composite.juegoDeEstrategia;

public class Caballero extends Soldado {
	
	public Caballero(Punto ubicacion, Mapa mapaActual) {
		super(ubicacion, mapaActual);
	}

	@Override
	public void moverA(Punto otroPunto) {
	    // Mientras la ubicación no sea igual al destino, mover paso a paso
	    while (!(this.ubicacion.equals(otroPunto))) {
	        // Si no estamos en el destino en X, moveremos en X
	        if (this.ubicacion.getX() != otroPunto.getX()) {
	            this.moverseUnaUbicacionEnX(otroPunto);
	        }

	        // Si no estamos en el destino en Y, moveremos en Y
	        if (this.ubicacion.getY() != otroPunto.getY()) {
	            this.moverseUnaUbicacionEnY(otroPunto);
	        }
	    }
	}

	// Método para mover en el eje X, por implementar (por ejemplo, en zigzag)
	private void moverseUnaUbicacionEnX(Punto destino) {
	    // Lógica de caminata en zigzag (por implementar)
	}

	// Método para mover en el eje Y, por implementar (por ejemplo, en zigzag)
	private void moverseUnaUbicacionEnY(Punto destino) {
	    // Lógica de caminata en zigzag (por implementar)
	}

}