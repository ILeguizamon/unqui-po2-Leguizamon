package ar.edu.unq.po2.observer.publicaciones;

public class FiltroPorTitulo implements FiltroInteres{
	private String titulo;
	
	public FiltroPorTitulo(String titulo) {
        this.titulo = titulo;
    }
	
	@Override
	public boolean cumple(Articulo articulo) {
		// TODO Auto-generated method stub
		return articulo.getTitulo().equalsIgnoreCase(titulo);
	}
	
	
}
