package ar.edu.unq.po2.observer.publicaciones;

import java.util.ArrayList;
import java.util.List;

public class MiembroLaboratorio implements Observer {
    private FiltroInteres filtro; // puede ser por palabra clave, conferencia, etc.
    private List<Articulo> articulosRecibidos; 

    public MiembroLaboratorio(FiltroInteres filtro) {
        this.filtro = filtro;
        this.articulosRecibidos = new ArrayList<Articulo>();
    }
    
    public List<Articulo> getEstado() {
        return articulosRecibidos;
    }
    
    @Override
    public void actualizar(Articulo articulo) {
        if (filtro.cumple(articulo)) {
        	articulosRecibidos.add(articulo); // Guarda el artículo
            System.out.println(" recibió un artículo de interés: " + articulo.getTitulo());
        }
    }
    
    
}
