package ar.edu.unq.po2.observer.publicaciones;

public class FiltroPorTipoArticulo implements FiltroInteres {
    private String tipo;

    public FiltroPorTipoArticulo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean cumple(Articulo articulo) {
        return articulo.getTipoArticulo().equalsIgnoreCase(tipo);
    }
}

