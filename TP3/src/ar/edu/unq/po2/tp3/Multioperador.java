package ar.edu.unq.po2.tp3;

import java.util.ArrayList;
import java.util.List;


public class Multioperador {
    ArrayList<Integer> lista;  // Lista para guardar los números enteros

    // --------------------- CONSTRUCTOR ---------------------
    public Multioperador() {
        this.lista = new ArrayList<Integer>();  // Inicializa la lista vacía al crear el objeto.
    }

    // --------------------- MÉTODOS ---------------------

    public List<Integer> getNumeros() {
        return lista;
    }

    public void agregarNumero(int x) {
        getNumeros().add(x);
    }

    public int sumarTodosLosNumeros() {
        int sumaTotal = 0;

        for (int numero : getNumeros()) {
            sumaTotal += numero;
        }
        return sumaTotal;
    }

    public int restarTodosLosNumeros() {
        int restaTotal = 0;

        for (int numero : getNumeros()) {
            restaTotal -= numero;
        }
        return restaTotal;
    }

    public int multiplicarTodosLosNumeros() {
        int multTotal = 1;

        for (int numero : getNumeros()) {
            multTotal *= numero;
        }
        return multTotal;
    }
}
