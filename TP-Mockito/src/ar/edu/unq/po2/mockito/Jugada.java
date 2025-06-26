package ar.edu.unq.po2.mockito;

import java.util.Arrays;
import java.util.List;

public class Jugada {

    private List<Carta> cartas;
    private PokerStatus pokerStatus;
    private String tipoJugada;

    public Jugada(Carta c1, Carta c2, Carta c3, Carta c4, Carta c5) {
        this.cartas = Arrays.asList(c1, c2, c3, c4, c5);
        this.pokerStatus = new PokerStatus();
        this.tipoJugada = pokerStatus.verificar(c1, c2, c3, c4, c5); //Retorna un tipo de jugada (String)
    }

    public Jugada compararCon(Jugada otra) {
        int valorEsta = valorTipo(this.tipoJugada);
        int valorOtra = valorTipo(otra.tipoJugada);

        if (valorEsta > valorOtra) {
            return this; // gana esta jugada por tipo
        }

        if (valorEsta < valorOtra) {
            return otra; // gana la otra jugada por tipo
        }

        // mismo tipo, desempatar por cartas
        if (esEmpate(otra)) {
            return this.desempate(otra); // empate total
        }

        if (leGana(otra)) {
            return this; // gana esta por valor de cartas
        }

        return otra; // gana la otra
    }

    private boolean esEmpate(Jugada otra) {
        for (int i = 0; i < this.cartas.size(); i++) {
            if (this.cartas.get(i).valorNumerico() != otra.cartas.get(i).valorNumerico()) {
                return false;
            }
        }
        return true;
    }
    
    private Jugada desempate(Jugada otra) {
        for (int i = 0; i < this.cartas.size(); i++) {
            int valorCarta1 = this.cartas.get(i).valorNumerico();
            int valorCarta2 = otra.cartas.get(i).valorNumerico();

            if (valorCarta1 > valorCarta2) {
                return this;
            }
            if (valorCarta1 < valorCarta2) {
                return otra;
            }
            // Si son iguales, sigue comparando la siguiente carta
        }
        // Si todas las cartas empatan
        return null; // empate total
    }

    private boolean leGana(Jugada otra) {
        for (int i = 0; i < this.cartas.size(); i++) {
            int valorEsta = this.cartas.get(i).valorNumerico();
            int valorOtra = otra.cartas.get(i).valorNumerico();

            if (valorEsta > valorOtra) {
                return true;
            }
            if (valorEsta < valorOtra) {
                return false;
            }
            // igual sigue comparando
        }
        return false; // no gana si son todas iguales
    }


    // Asigno valores numéricos a cada tipo para facilitar comparación
    private int valorTipo(String tipo) {
        switch (tipo) {
            case "Poquer": return 3;
            case "Color": return 2;
            case "Trio": return 1;
            default: return 0; // Nada
        }
    }

}

