package ar.edu.unq.po2.observer.concursoDePyR;

import java.util.List;

public class Cuestionario {
	List<Pregunta> preguntasParaElConcurso;
	
	public Cuestionario(List<Pregunta> preguntas) {
	    if (preguntas.size() != 5) {
	        throw new IllegalArgumentException("El cuestionario debe tener exactamente 5 preguntas.");
	    }
	    this.preguntasParaElConcurso = preguntas;
	}

	public List<Pregunta> getPreguntasParaElConcurso() {
		return preguntasParaElConcurso;
	}

}
