package ar.edu.unq.po2.AyTm.ejercicio6;

import java.util.Enumeration;
import java.util.Vector;

public class Ejemplo {
    public static void main(String[] args) {
        Vector<String> nombres = new Vector<>();
        nombres.add("Ana");
        nombres.add("Luis");

        Enumeration<String> enumNombres = nombres.elements();

        while (enumNombres.hasMoreElements()) {
            System.out.println(enumNombres.nextElement());
        }
    }
}

