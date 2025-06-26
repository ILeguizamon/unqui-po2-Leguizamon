package ar.edu.unq.po2.observer.encuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;

public class AplicacionMovil implements Observer {
	private Boolean fueNotificada;
    private List<String> deportes;
    private List<String> contrincantes;

    public AplicacionMovil() {
    	this.fueNotificada = false;
        this.deportes = new ArrayList<String>();
        this.contrincantes = new ArrayList<>();
    }

    @Override
    public void actualizar(Partido partido) {
        if (this.esPartidoInteresante(partido) || this.esAlgunContrincanteInteresante(partido)) {
            System.out.println("App móvil recibió: " + partido.getResultado());
            fueNotificada = true; 
        } else {
            fueNotificada = false;
        }
    }

    public boolean fueNotificada() {
        return fueNotificada; 
    }

    private boolean esPartidoInteresante(Partido partido) {
        return deportes.contains(partido.getDeporte());
    }

    private boolean esAlgunContrincanteInteresante(Partido partido) {
        return partido.getContrincantes().stream()
            .anyMatch(contrincantes::contains);
    }

	public List<String> getDeportes() {
		return deportes;
	}

	public void setDeportes(List<String> deportes) {
		this.deportes = deportes;
	}

	public List<String> getContrincantes() {
		return contrincantes;
	}

	public void setContrincantes(List<String> contrincantes) {
		this.contrincantes = contrincantes;
	}
    
    
}
