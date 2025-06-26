package ar.edu.unq.po2.AyTm.elementosSimilares;

import java.util.ArrayList;
import java.util.List;

public class FiltroLinkEnComun implements Filtro {

    @Override
    public List<WikipediaPage> getSimilarPages(WikipediaPage page, List<WikipediaPage> wikipedia) {
        List<WikipediaPage> similares = new ArrayList<>();
        List<WikipediaPage> linksDePage = page.getLinks();

        for (WikipediaPage p : wikipedia) {
            if (p != page) {
                for (WikipediaPage link : p.getLinks()) {
                    if (linksDePage.contains(link)) {
                        similares.add(p);
                        break;  // Ya hay un link común, pasamos a la siguiente página
                    }
                }
            }
        }
        return similares;
    }
}
