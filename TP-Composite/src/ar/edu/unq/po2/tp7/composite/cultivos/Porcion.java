package ar.edu.unq.po2.tp7.composite.cultivos;

public abstract class Porcion {
	protected int subDivisiones;
    
    public Porcion() {
    	this.subDivisiones = 1;
    }
    
    public int getSubDivisiones() {
		return subDivisiones;
	}

	public abstract double gananciaAnual();
    
    public void agregarDivision() {
    	this.subDivisiones = this.subDivisiones + 1;
    }
}

