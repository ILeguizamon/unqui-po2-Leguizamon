package ar.edu.unq.po2.strategy.encriptacion;

import java.util.ArrayList;
import java.util.List;

public class EncriptarPorCambioDeOrden implements Encriptacion{

	@Override
	public String encriptar(String texto) {
		String[] palabras = texto.split(" "); //  Divide el texto en palabras, usando el espacio " " como separador.
		List<String> invertidas = new ArrayList<>(); // Crea una nueva lista vacía donde guarda las palabras en orden invertido.

		for (int i = palabras.length - 1; i >= 0; i--) { // Recorre el arreglo de palabras de atrás hacia adelante (desde la última hasta la primera), y agrega cada palabra a la lista invertidas
		    invertidas.add(palabras[i]);
		}

		return String.join(" ", invertidas); // Une todas las palabras de la lista invertidas en una sola cadena, separadas por espacio.

	}

	@Override
	public String desencriptar(String texto) {
	    return this.encriptar(texto);
	}
}
