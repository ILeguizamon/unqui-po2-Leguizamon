package ar.edu.unq.po2.AyTm.elementosSimilares;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FiltroPropiedadEnComun implements Filtro{

	@Override
    public List<WikipediaPage> getSimilarPages(WikipediaPage page, List<WikipediaPage> wikipedia) {
        List<WikipediaPage> similares = new ArrayList<>();
        Map<String, WikipediaPage> propiedades = page.getInfobox();

        for (WikipediaPage p : wikipedia) {
            if (p != page) {
                for (String clave : p.getInfobox().keySet()) {
                    if (propiedades.containsKey(clave)) {
                        similares.add(p);
                        break;  // Ya encontró propiedad común
                    }
                }
            }
        }
        return similares;
    }
}
