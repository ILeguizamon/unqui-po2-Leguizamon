package ar.edu.unq.po2.observer.publicaciones;

public class FiltroPorPalabraClave implements FiltroInteres {
    private String palabraClave;

    public FiltroPorPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    @Override
    public boolean cumple(Articulo articulo) {
        return articulo.getPalabrasClave().stream()
                       .anyMatch(p -> p.equalsIgnoreCase(palabraClave));
    }
}
