package ar.edu.unq.po2.AyTm.palabrasOrdenadas;

import javax.swing.DefaultListModel;

public class ListaDePalabrasAdapter extends DefaultListModel<String> {
    private ListaDePalabrasOrdenadas listaOrdenada;

    public ListaDePalabrasAdapter() {
        this.listaOrdenada = new ListaDePalabrasOrdenadas();
    }

    public void agregarPalabra(String palabra) {
        listaOrdenada.agregarPalabra(palabra);
        this.actualizarModelo();
    }

    private void actualizarModelo() {
        this.clear();
        for (int i = 0; i < listaOrdenada.cantidadDePalabras(); i++) {
            this.addElement(listaOrdenada.getPalabraDePosicion(i));
        }
    }
}
