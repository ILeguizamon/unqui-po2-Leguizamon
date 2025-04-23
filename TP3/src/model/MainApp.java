package model;

import model.gui.InterfazUsuario;
import model.stack.ColeccionElementos;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema");

        // Crear un objeto de InterfazUsuario para mostrar un mensaje
        InterfazUsuario interfaz = new InterfazUsuario();
        interfaz.mostrarMensaje();

        // Crear una colección de elementos
        ColeccionElementos coleccion = new ColeccionElementos();
        coleccion.agregarElemento("Elemento 1");
        coleccion.agregarElemento("Elemento 2");
        coleccion.mostrarElementos();
    }
}
