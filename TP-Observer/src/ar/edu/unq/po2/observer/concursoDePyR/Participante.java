package ar.edu.unq.po2.observer.concursoDePyR;

import java.util.ArrayList;
import java.util.List;

public class Participante {
	private String nombre;
	List<Pregunta> preguntasDelConcurso;
	
	public Participante() {
		this.nombre = nombre;
		this.preguntasDelConcurso = new ArrayList<Pregunta>();
	};
	
	public void notificarAsistenciaAlJuego(ConcursoPyR concurso) {
		concurso.agregarParticipanteAlJuego(this);
	}

	public void agregarPreguntas(List<Pregunta> preguntasParaElConcurso) {
		this.preguntasDelConcurso = preguntasParaElConcurso;
	}
	
	public Respuesta enviarRespuesta(ConcursoPyR concurso, Respuesta respuesta) {
		return concurso.recibirRespuesta(respuesta);
	}
	
	public void notificarRespuestaCorrecta(Pregunta pregunta) {
	    System.out.println("¡Correcto! Respondiste bien la pregunta: " + pregunta.getEnunciado());
	}

	public void notificarRespuestaIncorrecta(Pregunta pregunta) {
	    System.out.println("Respuesta incorrecta para la pregunta: " + pregunta.getEnunciado());
	}

	public void notificarJugadorRespondioCorrectamente(String nombreJugador, String enunciadoPregunta) {
	    System.out.println(nombreJugador + " respondió correctamente la pregunta: " + enunciadoPregunta);
	}

	public void notificarGanador(String nombreGanador) {
	    System.out.println("¡El ganador es: " + nombreGanador + "!");
	}

	public String getNombre() {
	    return nombre;
	}

}
