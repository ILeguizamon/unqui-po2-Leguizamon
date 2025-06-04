package ar.edu.unq.po2.tp5.mercadoCentral;

public class FacturaServicio extends Factura {

    private double costoPorUnidad;
    private int unidadesConsumidas;

    // ---------------- CONSTRUCTOR -----------------------------
    public FacturaServicio(Agencia agencia, double costoPorUnidad, int unidadesConsumidas) {
        super(agencia);
        this.costoPorUnidad = costoPorUnidad;
        this.unidadesConsumidas = unidadesConsumidas;
    }

    // ---------------- GETTERS -----------------------------
    public double getCostoPorUnidad() {
        return costoPorUnidad;
    }

    public int getUnidadesConsumidas() {
        return unidadesConsumidas;
    }

    @Override
    public double getMonto() {
        return getCostoPorUnidad() * getUnidadesConsumidas();
    }
}
