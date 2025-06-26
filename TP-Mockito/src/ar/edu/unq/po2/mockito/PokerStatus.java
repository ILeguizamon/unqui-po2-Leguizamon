package ar.edu.unq.po2.mockito;

import java.util.List;

public class PokerStatus {

    public String verificar(Carta c1, Carta c2, Carta c3, Carta c4, Carta c5) {
        
    	if(esJugadaDePoquer(c1, c2, c3, c4, c5)) {
    		return "Poquer";
    	}
        if (esJugadaDeColor(c1, c2, c3, c4, c5)) {
            return "Color";
        }
        if (esJugadaDeTrio(c1, c2, c3, c4, c5)) {
            return "Trio";
        }
        return "Nada";
        
    }

    private boolean esJugadaDeTrio(Carta c1, Carta c2, Carta c3, Carta c4, Carta c5) {
        List<Carta> cartas = List.of(c1, c2, c3, c4, c5);

        for (Carta carta : cartas) {
            int contador = 0;
            for (Carta otraCarta : cartas) {
                if (carta.mismoValorQue(otraCarta)) {
                    contador++;
                }
            }
            if (contador == 3) {
                return true;
            }
        }
        return false;
    }


	private boolean esJugadaDeColor(Carta c1, Carta c2, Carta c3, Carta c4, Carta c5) {
		return c1.mismoPaloQue(c2) && c2.mismoPaloQue(c3) && c3.mismoPaloQue(c4) && c4.mismoPaloQue(c5);
    }

	private boolean esJugadaDePoquer(Carta c1, Carta c2, Carta c3, Carta c4, Carta c5) {
    	List<Carta> cartas = List.of(c1, c2, c3, c4, c5);
        
        for (Carta carta : cartas) {
            int contador = 0;
            for (Carta otraCarta : cartas) {
                if (carta.mismoValorQue(otraCarta)) {
                    contador++;
                }
            }
            if (contador == 4) {
                return true;
            }
        }
        
        return false;
    }

}
