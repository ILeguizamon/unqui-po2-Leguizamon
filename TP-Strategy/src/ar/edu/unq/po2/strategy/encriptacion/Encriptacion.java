package ar.edu.unq.po2.strategy.encriptacion;

public interface Encriptacion {
	// cada forma de encriptación debe tener su forma inversa de desencriptar
    public String encriptar(String texto);
    public String desencriptar(String texto);
}

