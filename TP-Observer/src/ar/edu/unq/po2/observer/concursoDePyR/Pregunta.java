package ar.edu.unq.po2.observer.concursoDePyR;

public class Pregunta {
	private int id;
	private String enunciado;
	private String respuesta;
	
	public Pregunta(int id, String enunciado, String respuesta) {
		this.id = id;
		this.enunciado = enunciado;
		this.respuesta = respuesta;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public int getId() {
		return id;
	}
	
	public boolean esCorrecta(String respuestaDada) {
        return this.respuesta.equalsIgnoreCase(respuestaDada.trim());
    }
}
