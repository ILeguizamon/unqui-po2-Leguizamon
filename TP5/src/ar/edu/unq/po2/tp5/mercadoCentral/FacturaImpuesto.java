package ar.edu.unq.po2.tp5.mercadoCentral;

public class FacturaImpuesto extends Factura {
private double tasaFija;
	
    // ---------------- CONSTRUCTOR -----------------------------
	public FacturaImpuesto(Agencia agencia, double tasaFija) {
		super(agencia);
		this.tasaFija = tasaFija;
	}
	
    // ---------------- GETTERS -----------------------------

	public double getTasaFija() {
		return tasaFija;
	}
	
	@Override
	public double getMonto() {
		return getTasaFija();
	}
}

