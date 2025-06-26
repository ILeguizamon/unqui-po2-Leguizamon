package ar.edu.unq.po2.observer.concursoDePyR;

import java.util.HashSet;
import java.util.Set;

public class RegistroDeProgreso {
    private Participante participante;
    private Set<Pregunta> preguntasRespondidas;

    public RegistroDeProgreso(Participante participante) {
        this.participante = participante;
        this.preguntasRespondidas = new HashSet<>();
    }

    // Agrega una pregunta respondida correctamente al registro
    public void agregarPreguntaRespondida(Pregunta pregunta) {
        this.preguntasRespondidas.add(pregunta);
    }

    // Retorna la cantidad de preguntas respondidas correctamente
    public int cantidadPreguntasRespondidas() {
        return this.preguntasRespondidas.size();
    }

    // Opcional: podrías agregar un método para consultar si ya respondió cierta pregunta
    public boolean yaRespondio(Pregunta pregunta) {
        return this.preguntasRespondidas.contains(pregunta);
    }
}
