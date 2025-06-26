package ar.edu.unq.po2.observer.publicaciones;

public class FiltroPorFiliacion implements FiltroInteres {
    private String filiacion;

    public FiltroPorFiliacion(String filiacion) {
        this.filiacion = filiacion;
    }

    @Override
    public boolean cumple(Articulo articulo) {
        return articulo.getFiliacion().equalsIgnoreCase(filiacion);
    }
}

