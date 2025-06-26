package ar.edu.unq.po2.observer.publicaciones;

public class FiltroPorLugarPublicacion implements FiltroInteres {
    private String lugar;

    public FiltroPorLugarPublicacion(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public boolean cumple(Articulo articulo) {
        return articulo.getLugarPublicacion().equalsIgnoreCase(lugar);
    }
}

