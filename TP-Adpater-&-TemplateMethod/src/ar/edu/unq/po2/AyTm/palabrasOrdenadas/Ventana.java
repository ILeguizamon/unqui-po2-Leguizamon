package ar.edu.unq.po2.AyTm.palabrasOrdenadas;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana(ListaDePalabrasAdapter adaptador) {
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setBounds(new Rectangle(180, 180));
        this.setVisible(true);

        JLabel label = new JLabel("Lista de palabras");
        label.setBounds(new Rectangle(40, 40));
        this.add(label);

        // Agregamos palabras al adaptador
        adaptador.agregarPalabra("casa");
        adaptador.agregarPalabra("arbol");
        adaptador.agregarPalabra("perro");
        adaptador.agregarPalabra("telefono");
        adaptador.agregarPalabra("brazo");

        JList<String> lista = new JList<>(adaptador);
        lista.setBounds(new Rectangle(110, 160));
        this.add(lista);
    }

    public static void main(String[] args) {
        new Ventana(new ListaDePalabrasAdapter());
    }
}
