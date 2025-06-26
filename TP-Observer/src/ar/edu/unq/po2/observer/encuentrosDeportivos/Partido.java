package ar.edu.unq.po2.observer.encuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;

class Partido {
    private String resultado;
    private List<String> contrincantes;
    private String deporte;

    public Partido(String resultado, String deporte) {
        this.resultado = resultado;
        this.contrincantes = new ArrayList<String>();
        this.deporte = deporte;
    }

    public String getResultado() { 
    	return resultado; 
    }
    
    public List<String> getContrincantes() {
    	return contrincantes; 
    }
    
    public String getDeporte() {
    	return deporte; 
    }
    
    public void agregarContrincante(String contrincante) {
    	this.contrincantes.add(contrincante);
    }
}
