package ar.edu.unq.po2.strategy.encriptacion;

public class EncriptarPorCambioDeVocales implements Encriptacion {
    
	@Override
	public String encriptar(String texto) {
	    texto = texto.toLowerCase();
	    StringBuilder resultado = new StringBuilder();

	    for (char c : texto.toCharArray()) {
	        switch (c) {
	            case 'a': resultado.append('e'); break;
	            case 'e': resultado.append('i'); break;
	            case 'i': resultado.append('o'); break;
	            case 'o': resultado.append('u'); break;
	            case 'u': resultado.append('a'); break;
	            default: resultado.append(c); break;
	        }
	    }
	    return resultado.toString();
	}
	
	@Override
	public String desencriptar(String texto) {
	    texto = texto.toLowerCase();
	    StringBuilder resultado = new StringBuilder();

	    for (char c : texto.toCharArray()) {
	        switch (c) {
	            case 'e': resultado.append('a'); break;
	            case 'i': resultado.append('e'); break;
	            case 'o': resultado.append('i'); break;
	            case 'u': resultado.append('o'); break;
	            case 'a': resultado.append('u'); break;
	            default: resultado.append(c); break;
	        }
	    }
	    return resultado.toString();
	}

}

