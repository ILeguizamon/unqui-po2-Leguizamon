package ar.edu.unq.po2.tp5.mercadoCentral;

public abstract class Factura implements Cobrable {

    private Agencia agencia;

    public Factura(Agencia agencia) {
        this.agencia = agencia;
    }

    public void registrarPago() {
        this.agencia.registrarPago(this);
    }
    
    public abstract double getMonto();
}

