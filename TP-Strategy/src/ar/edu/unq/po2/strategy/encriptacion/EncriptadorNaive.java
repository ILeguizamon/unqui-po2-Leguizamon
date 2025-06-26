package ar.edu.unq.po2.strategy.encriptacion;

public class EncriptadorNaive {
	// El comportamiento cambia según la estrategia que se le pasó.
	private Encriptacion encriptacion;
	
	public EncriptadorNaive(Encriptacion encriptacion) {
		this.encriptacion = encriptacion;
	}
	
	public String encriptar(String string) {
		return encriptacion.encriptar(string);
	}
	
	public String desencriptar(String string) {
		return encriptacion.desencriptar(string);
	}
}
