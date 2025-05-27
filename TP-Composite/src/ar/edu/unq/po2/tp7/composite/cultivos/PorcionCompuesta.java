package ar.edu.unq.po2.tp7.composite.cultivos;

import java.util.ArrayList;
import java.util.List;

public class PorcionCompuesta extends Porcion {
    private List<Porcion> subPorciones;
    
    public PorcionCompuesta() {
        this.subPorciones = new ArrayList<>();
        this.subDivisiones = 1; 
    }

    public void agregarSubPorcion(Porcion p) {
        if (this.getSubPorciones().size() < 4) {
            subPorciones.add(p);
            this.agregarDivision();  // actualiza contador
        } else {
            throw new IllegalStateException("Una porción compuesta solo puede tener hasta 4 sub-porciones.");
        }
    }
    
    public List<Porcion> getSubPorciones() {
		return subPorciones;
	}


	@Override
    public double gananciaAnual() {
        double totalGanancia = 0d;
        int cantidad = subPorciones.size();

        for (Porcion p : subPorciones) {
            p.subDivisiones = cantidad; // asigna la cantidad de divisiones a cada subporción
            totalGanancia += p.gananciaAnual();
        }

        return totalGanancia;
    }
}

