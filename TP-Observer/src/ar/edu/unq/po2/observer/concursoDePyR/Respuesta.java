package ar.edu.unq.po2.observer.concursoDePyR;

public class Respuesta {
    private Pregunta pregunta;          // La pregunta a la que responde
    private String respuestaDada;       // La respuesta escrita por el participante
    private Participante participante;  // Quien responde

    public Respuesta(Pregunta pregunta, String respuestaDada, Participante participante) {
        this.pregunta = pregunta;
        this.respuestaDada = respuestaDada;
        this.participante = participante;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public String getRespuestaDada() {
        return respuestaDada;
    }

    public Participante getParticipante() {
        return participante;
    }

}
