package model.stack;

import java.util.ArrayList;
import java.util.List;

public class ColeccionElementos {
    private List<String> elementos;

    public ColeccionElementos() {
        elementos = new ArrayList<>();
    }

    public void agregarElemento(String elemento) {
        elementos.add(elemento);  // Agrega el elemento a la lista
    }

    public void mostrarElementos() {
        System.out.println("Elementos en la colección: " + elementos);
    }
}
