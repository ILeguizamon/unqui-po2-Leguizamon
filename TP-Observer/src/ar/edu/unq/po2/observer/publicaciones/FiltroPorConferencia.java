package ar.edu.unq.po2.observer.publicaciones;

public class FiltroPorConferencia implements FiltroInteres {
    private String conferencia;

    public FiltroPorConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    @Override
    public boolean cumple(Articulo articulo) {
        return articulo.getConferencia().equalsIgnoreCase(conferencia);
    } 
}
