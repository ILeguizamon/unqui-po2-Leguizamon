package ar.edu.unq.po2.AyTm.elementosSimilares;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

public class FiltrosWikipediaTest {

    private WikipediaPageConcrete p1, p2, p3, p4, p5;
    private List<WikipediaPage> todas;

    @BeforeEach
    public void setup() {
        // Páginas sin links ni infobox
        p1 = new WikipediaPageConcrete("La Plata", new ArrayList<>(), new HashMap<>());
        p2 = new WikipediaPageConcrete("Lucas Art", new ArrayList<>(), new HashMap<>());
        p3 = new WikipediaPageConcrete("Buenos Aires", new ArrayList<>(), new HashMap<>());
        p4 = new WikipediaPageConcrete("Lobo", new ArrayList<>(), new HashMap<>());
        p5 = new WikipediaPageConcrete("Mar del Plata", new ArrayList<>(), new HashMap<>());

        // Links para filtro LinkEnComun
        // p1 y p3 tienen link a p2 ("Lucas Art")
        p1.getLinks().add(p2);
        p3.getLinks().add(p2);
        // p4 y p5 no tienen links en común

        // Infobox para filtro PropiedadEnComun
        // p1 y p2 comparten propiedad "new_day"
        p1.getInfobox().put("new_day", p3);
        p2.getInfobox().put("new_day", p4);
        // p3 y p5 tienen propiedades diferentes
        p3.getInfobox().put("death_place", p4);
        p5.getInfobox().put("foundation_date", p1);

        // Lista general para los tests
        todas = Arrays.asList(p1, p2, p3, p4, p5);
    }

    @Test
    public void testFiltroMismaLetraInicial() {
        Filtro filtro = new FiltroMismaLetraInicial();
        List<WikipediaPage> similares = filtro.getSimilarPages(p1, todas);

        assertTrue(similares.contains(p2));
        assertTrue(similares.contains(p4));
        assertFalse(similares.contains(p3));
        assertFalse(similares.contains(p5));
    }

    @Test
    public void testFiltroLinkEnComun() {
        Filtro filtro = new FiltroLinkEnComun();
        List<WikipediaPage> similares = filtro.getSimilarPages(p1, todas);

        assertTrue(similares.contains(p3));  // p3 y p1 tienen link en común a p2
        assertFalse(similares.contains(p4));
        assertFalse(similares.contains(p2));  // no debe incluirse la misma página ni p2 que es link
    }

    @Test
    public void testFiltroPropiedadEnComun() {
        Filtro filtro = new FiltroPropiedadEnComun();
        List<WikipediaPage> similares = filtro.getSimilarPages(p1, todas);

        assertTrue(similares.contains(p2));  // ambos tienen "new_day"
        assertFalse(similares.contains(p3));
        assertFalse(similares.contains(p4));
        assertFalse(similares.contains(p5));
    }
}

