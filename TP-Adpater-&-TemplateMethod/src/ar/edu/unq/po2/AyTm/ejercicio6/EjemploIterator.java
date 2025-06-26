package ar.edu.unq.po2.AyTm.ejercicio6;

import java.util.ArrayList;
import java.util.Iterator;

public class EjemploIterator {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Carlos");
        nombres.add("María");

        Iterator<String> iterator = nombres.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
