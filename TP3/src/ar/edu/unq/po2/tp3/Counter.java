package ar.edu.unq.po2.tp3;

import java.util.ArrayList;
import java.util.List;

public class Counter {
    private ArrayList<Integer> listaDeNumeros;
    
    // ---------------- CONSTRUCTOR -----------------------------
    public Counter() {
        this.listaDeNumeros = new ArrayList<Integer>();
    }
    
    // ---------------- MÉTODOS -----------------------------
    public int cantidadDeImpares() {
        ArrayList<Integer> listaImpares = new ArrayList<Integer>();
        for (int numero : getNumeros()) {
            if (numero % 2 != 0) {
                listaImpares.add(numero);
            }
        }
        return listaImpares.size();
    }
    
    public int cantidadDePares() {
        ArrayList<Integer> listaPares = new ArrayList<Integer>();
        for (int numero : getNumeros()) {
            if (numero % 2 == 0) {
                listaPares.add(numero);
            }
        }
        return listaPares.size();
    }
    
    public int cantidadDeMultiplos(int x) {
        int count = 0;
        for (int numero : getNumeros()) {
            if (numero % x == 0) {
                count++;
            }
        }
        return count;
    }
    
    public void agregarNumero(int numero) {
        getNumeros().add(numero);
    }
    
    public List<Integer> getNumeros() {
        return listaDeNumeros;
    }
    
    // ---------------- EJERCICIO 2 (Desarmando números) -----------------------------
    public int numeroConMasDigitosPares(List<Integer> list) {
        int numeroConMasPares = list.get(0);
        int maxPares = contarDigitosPares(numeroConMasPares);

        for (int num : list) {
            int pares = contarDigitosPares(num);
            if (pares > maxPares) {
                maxPares = pares;
                numeroConMasPares = num;
            }
        }

        return numeroConMasPares;
    }

    public int contarDigitosPares(int num) {
        int contador = 0;
        while (num > 0) {
            int digito = num % 10;
            if (digito % 2 == 0) {
                contador++;
            }
            num /= 10;
        }
        return contador;
    }

    // ---------------- EJERCICIO 3 (Múltiplos entre 0 y 1000) -----------------------------
    public int maxMultiploEntre0y1000(int x, int y) {
        int maxMultiplo = 0;
        int num = 1000;

        while (num > 0) {
            if (num % x == 0 && num % y == 0) {
                maxMultiplo = num;
                break;
            }
            num--;
        }

        if (maxMultiplo == 0) {
            return -1;
        } else {
            return maxMultiplo;
        }
    }
}
