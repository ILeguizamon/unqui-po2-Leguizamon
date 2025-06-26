package ar.edu.unq.po2.observer.concursoDePyR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcursoPyR {
    private Cuestionario cuestionarioDePreguntas;
    private List<Participante> participantes;
    private boolean esJuegoEnCurso;
    private Map<Participante, RegistroDeProgreso> progresoPorParticipante;

    public ConcursoPyR(Cuestionario cuestionario) {
        this.cuestionarioDePreguntas = cuestionario;
        this.participantes = new ArrayList<>();
        this.progresoPorParticipante = new HashMap<>();
        this.esJuegoEnCurso = false;
    }

    public void comenzarJuego() {
        if (this.verificarSiDaComienzoElConcurso()) {
            for (Participante participante : participantes) {
                participante.agregarPreguntas(this.preguntasParaElConcurso());
                progresoPorParticipante.put(participante, new RegistroDeProgreso(participante));
            }
            this.esJuegoEnCurso = true;
        }
    }

    public Respuesta recibirRespuesta(Respuesta respuesta) {
        Participante jugador = respuesta.getParticipante();
        Pregunta pregunta = respuesta.getPregunta();
        String respuestaDada = respuesta.getRespuestaDada();

        if (!esJuegoEnCurso) {
            System.out.println("El juego no ha comenzado.");
            return null;
        }

        if (pregunta.esCorrecta(respuestaDada)) {
            // Registrar progreso: obtengo el registro de progreso del jugador
            RegistroDeProgreso progreso = progresoPorParticipante.get(jugador);

            // Agrego la pregunta respondida correctamente
            progreso.agregarPreguntaRespondida(pregunta);

            // Notificar al jugador que respondió correctamente
            jugador.notificarRespuestaCorrecta(pregunta);

            // Notificar a todos los participantes
            notificarRespuestaCorrectaATodos(jugador, pregunta);

            // Verificar si el jugador ganó (por ejemplo, respondió 5 preguntas correctas)
            if (progreso.cantidadPreguntasRespondidas() == 5) {
                for (Participante participante : participantes) {
                    participante.notificarGanador(jugador.getNombre());
                }
                esJuegoEnCurso = false;
            }
        } else {
            // Si respondió mal, notifico sólo al jugador
            jugador.notificarRespuestaIncorrecta(pregunta);
        }

        return respuesta;
    }


    private void notificarRespuestaCorrectaATodos(Participante jugador, Pregunta pregunta) {
        for (Participante participante : participantes) {
            participante.notificarJugadorRespondioCorrectamente(jugador.getNombre(), pregunta.getEnunciado());
        }
    }


    public void agregarParticipanteAlJuego(Participante participante) {
        if (this.participantes.size() < 5 && !this.participantes.contains(participante)) {
            this.participantes.add(participante);
        }
    }

    private List<Pregunta> preguntasParaElConcurso() {
        return this.cuestionarioDePreguntas.getPreguntasParaElConcurso(); // Debe existir este método en Cuestionario
    }

    private boolean verificarSiDaComienzoElConcurso() {
        return this.cantidadDeParticipantes() == 5 && !this.esJuegoEnCurso;
    }

    private int cantidadDeParticipantes() {
        return this.participantes.size();
    }

    private boolean getEsJuegoEnCurso() {
        return esJuegoEnCurso;
    }

    private List<Participante> getParticipantes() {
        return participantes;
    }
}
