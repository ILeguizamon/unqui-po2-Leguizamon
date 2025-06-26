package ar.edu.unq.po2.observer.publicaciones;

public class FiltroPorAutor implements FiltroInteres {
    private String autor;

    public FiltroPorAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public boolean cumple(Articulo articulo) {
        return articulo.getAutores().stream()   // convierte la lista de autores en un stream
                       .anyMatch(a -> a.equalsIgnoreCase(autor)); // verifica si algún autor coincide (ignorando mayúsculas/minúsculas)
    }
}

