package ar.edu.unq.po2.tp7.composite.cultivos;

public class PorcionDeTrigo extends Porcion { 

    public PorcionDeTrigo() {
        this.subDivisiones =  1;
    }

	@Override
	public double gananciaAnual() {
		if (this.getSubDivisiones() == 1) {
			return this.gananciaTotal();
		}
		return this.gananciaTotal() / this.getSubDivisiones();
	}

	private double gananciaTotal() {
		return 300;
	}
}
