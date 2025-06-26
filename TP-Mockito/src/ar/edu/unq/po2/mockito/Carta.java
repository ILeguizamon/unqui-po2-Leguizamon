package ar.edu.unq.po2.mockito;

public class Carta {
	private String palo;
	private String numero;
	
	public Carta(String palo, String numero) {
		super();
		this.palo = palo;
		this.numero = numero;
	}

	public String getPalo() {
		return palo;
	}

	public String getNumero() {
		return numero;
	}

	public boolean mismoValorQue(Carta otra) {
	    return this.getNumero().equals(otra.getNumero());
	}
	
	public boolean mismoPaloQue(Carta otra) {
	    return this.getPalo().equals(otra.getPalo());
	}
	
	public boolean esMayorQue(Carta otraCarta) {
        return this.valorNumerico() > otraCarta.valorNumerico();
    }
	
	public int valorNumerico() {
	    switch (this.getNumero()) {
	        case "A":
	            return 14;
	        case "J":
	            return 11;
	        case "Q":
	            return 12;
	        case "K":
	            return 13;
	        default:
	            return Integer.parseInt(this.getNumero());
	    }
	}

}
