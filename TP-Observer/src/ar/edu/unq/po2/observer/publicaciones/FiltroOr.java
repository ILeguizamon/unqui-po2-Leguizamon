package ar.edu.unq.po2.observer.publicaciones;

import java.util.List;

public class FiltroOr implements FiltroInteres {
    private List<FiltroInteres> filtros;

    public FiltroOr(List<FiltroInteres> filtros) {
        // Validar que no sea null ni vacío
        if (filtros == null || filtros.isEmpty()) {
            throw new IllegalArgumentException("Debe haber al menos un filtro");
        }
        this.filtros = filtros;
    }

    @Override
    public boolean cumple(Articulo articulo) {
        return filtros.stream().anyMatch(f -> f.cumple(articulo));
    }
}


