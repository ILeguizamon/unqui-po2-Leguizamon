package ar.edu.unq.po2.observer.encuentrosDeportivos;

import java.util.ArrayList;
import java.util.List;

public class Servidor implements Observer {
	private boolean notificado;
    private List<String> deportesInteresados = new ArrayList<>();

    public Servidor() {
    	this.notificado = false;
        this.deportesInteresados = new ArrayList<String>();
    }

    @Override
    public void actualizar(Partido partido) {
        if (deportesInteresados.contains(partido.getDeporte())) {
        	notificado = true;
            System.out.println("Servidor recibió: " + partido.getResultado());
        }
    }

	public List<String> getDeportesInteresados() {
		return deportesInteresados;
	}

	public void setDeportesInteresados(List<String> deportesInteresados) {
		this.deportesInteresados = deportesInteresados;
	}
    
	public boolean fueNotificado() {
        return notificado;
    }

    public void limpiarNotificado() {
        notificado = false;
    }
    
}
