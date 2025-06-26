package ar.edu.unq.po2.AyTm.palabrasOrdenadas;

import java.util.*;

public class ListaDePalabrasOrdenadas {
    private List<String> palabras;
    private final Comparator<String> comparador;

    public ListaDePalabrasOrdenadas() {
        this.palabras = new LinkedList<>();
        this.comparador = new Comparator<String>() {
            @Override
            public int compare(String palabraA, String palabraB) {
                return palabraA.compareToIgnoreCase(palabraB);
            }
        };
    }

    public void agregarPalabra(String palabra) {
        this.palabras.add(palabra);
        Collections.sort(this.palabras, this.comparador);
    }

    public Integer cantidadDePalabras() {
        return this.palabras.size();
    }

    public String getPalabraDePosicion(int posicion) {
        return this.palabras.get(posicion);
    }
}
