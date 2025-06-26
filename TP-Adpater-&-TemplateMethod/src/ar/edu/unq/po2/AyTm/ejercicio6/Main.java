package ar.edu.unq.po2.AyTm.ejercicio6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("perro");
        lista.add("gato");
        lista.add("paloma");

        Iterator<String> iterator = lista.iterator();
        Enumeration<String> enumeration = new IteratorToEnumerationAdapter<>(iterator);

        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}

