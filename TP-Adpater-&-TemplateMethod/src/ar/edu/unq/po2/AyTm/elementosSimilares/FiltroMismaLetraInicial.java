package ar.edu.unq.po2.AyTm.elementosSimilares;

import java.util.ArrayList;
import java.util.List;

public class FiltroMismaLetraInicial implements Filtro {

	@Override
    public List<WikipediaPage> getSimilarPages(WikipediaPage page, List<WikipediaPage> wikipedia) {
        List<WikipediaPage> similares = new ArrayList<>();
        char primeraLetra = Character.toLowerCase(page.getTitle().charAt(0));

        for (WikipediaPage p : wikipedia) {
            if (p != page && Character.toLowerCase(p.getTitle().charAt(0)) == primeraLetra) {
                similares.add(p);
            }
        }
        return similares;
    }

}
