package ar.edu.unq.po2.observer.publicaciones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RepositorioPublicacionesTest {

    private RepositorioPublicaciones repositorio;
    private Articulo articuloSmalltalk;
    private Articulo articuloJava;

    private MiembroLaboratorio miembroFiltroSmalltalk;
    private MiembroLaboratorio miembroFiltroJava;
    private MiembroLaboratorio miembroFiltroAnd;

    @BeforeEach
    public void setUp() {
        repositorio = new RepositorioPublicaciones();

        articuloSmalltalk = new Articulo();
        articuloSmalltalk.setTitulo("Reflexiones en Smalltalk");
        articuloSmalltalk.setConferencia("Smalltalk");
        articuloSmalltalk.setLugarPublicacion("Buenos Aires");
        articuloSmalltalk.setTipoArticulo("Workshop");
        articuloSmalltalk.setAutores(List.of("Juan Pérez"));
        articuloSmalltalk.setFiliacion("UNQ");
        articuloSmalltalk.setPalabrasClave(List.of("POO", "Reflexión"));

        articuloJava = new Articulo();
        articuloJava.setTitulo("Java Avanzado");
        articuloJava.setConferencia("JavaConf");
        articuloJava.setLugarPublicacion("Córdoba");
        articuloJava.setTipoArticulo("Paper");
        articuloJava.setAutores(List.of("Ana Gómez"));
        articuloJava.setFiliacion("UBA");
        articuloJava.setPalabrasClave(List.of("Streams", "Lambdas"));

        // Filtros individuales
        FiltroInteres filtroSmalltalk = new FiltroPorConferencia("Smalltalk");
        FiltroInteres filtroJava = new FiltroPorConferencia("JavaConf");

        // Filtro compuesto: conferencia Smalltalk Y tipo Workshop
        FiltroInteres filtroAnd = new FiltroAnd(List.of(
                new FiltroPorConferencia("Smalltalk"),
                new FiltroPorTipoArticulo("Workshop")
        ));

        // Observadores
        miembroFiltroSmalltalk = new MiembroLaboratorio(filtroSmalltalk);
        miembroFiltroJava = new MiembroLaboratorio(filtroJava);
        miembroFiltroAnd = new MiembroLaboratorio(filtroAnd);

        // Suscribirlos al repositorio
        repositorio.agregarObservador(miembroFiltroSmalltalk);
        repositorio.agregarObservador(miembroFiltroJava);
        repositorio.agregarObservador(miembroFiltroAnd);
    }

    @Test
    public void testMiembroRecibeArticuloDeSuInteres() {
        repositorio.agregarArticulo(articuloSmalltalk);

        assertEquals(1, miembroFiltroSmalltalk.getEstado().size());
        assertEquals("Reflexiones en Smalltalk", miembroFiltroSmalltalk.getEstado().get(0).getTitulo());
    }

    @Test
    public void testMiembroNoRecibeArticuloQueNoEsDeSuInteres() {
        repositorio.agregarArticulo(articuloSmalltalk);

        assertTrue(miembroFiltroJava.getEstado().isEmpty());
    }

    @Test
    public void testFiltroAndCumpleAmbosCriterios() {
        repositorio.agregarArticulo(articuloSmalltalk); // Smalltalk + Workshop

        assertEquals(1, miembroFiltroAnd.getEstado().size());
    }

    @Test
    public void testFiltroAndNoCumpleSiFaltaUno() {
        repositorio.agregarArticulo(articuloJava); // JavaConf + Paper

        assertTrue(miembroFiltroAnd.getEstado().isEmpty());
    }
    
    @Test
    public void testFiltroPorFiliacion() {
        FiltroInteres filtroFiliacion = new FiltroPorFiliacion("UNQ");
        MiembroLaboratorio miembroFiltroFiliacion = new MiembroLaboratorio(filtroFiliacion);
        repositorio.agregarObservador(miembroFiltroFiliacion);

        repositorio.agregarArticulo(articuloSmalltalk); // Filiación: UNQ

        List<Articulo> articulosRecibidos = miembroFiltroFiliacion.getEstado();
        assertEquals(1, articulosRecibidos.size());
        assertEquals("Reflexiones en Smalltalk", articulosRecibidos.get(0).getTitulo());
    }

    
    @Test
    public void testFiltroPorAutorYLugarDePublicacion() {
        FiltroInteres filtroAutorYLugar = new FiltroAnd(List.of(
                new FiltroPorAutor("Juan Pérez"),
                new FiltroPorLugarPublicacion("Buenos Aires")
        ));
        MiembroLaboratorio miembroFiltroAutorLugar = new MiembroLaboratorio(filtroAutorYLugar);
        repositorio.agregarObservador(miembroFiltroAutorLugar);

        repositorio.agregarArticulo(articuloSmalltalk); // Juan Pérez + Buenos Aires

        List<Articulo> articulosRecibidos = miembroFiltroAutorLugar.getEstado();
        assertEquals(1, articulosRecibidos.size());
        assertEquals("Reflexiones en Smalltalk", articulosRecibidos.get(0).getTitulo());
    }

    
    @Test
    public void testFiltroOrCumpleSiUnoCumple() {
        FiltroInteres filtroOr = new FiltroOr(List.of(
                new FiltroPorConferencia("JavaConf"),
                new FiltroPorTipoArticulo("Workshop")
        ));
        MiembroLaboratorio miembroFiltroOr = new MiembroLaboratorio(filtroOr);
        repositorio.agregarObservador(miembroFiltroOr);

        repositorio.agregarArticulo(articuloJava); // cumple JavaConf
        repositorio.agregarArticulo(articuloSmalltalk); // cumple Workshop

        List<Articulo> articulosRecibidos = miembroFiltroOr.getEstado();
        assertEquals(2, articulosRecibidos.size());
        assertTrue(articulosRecibidos.stream().anyMatch(a -> a.getTitulo().equals("Java Avanzado")));
        assertTrue(articulosRecibidos.stream().anyMatch(a -> a.getTitulo().equals("Reflexiones en Smalltalk")));
    }
    
    @Test
    public void testFiltroAnidadoAndDentroDeAndYOr() {
        FiltroInteres filtroInternoAnd = new FiltroAnd(List.of( // Si cumple ambos criteorios el articulo cumple el filtro.
                new FiltroPorConferencia("Smalltalk"),
                new FiltroPorTipoArticulo("Workshop")
        ));
        FiltroInteres filtroInternoOr = new FiltroOr(List.of( // Si cumple al menos 1 de los criterios cumple el filtro.
                new FiltroPorPalabraClave("POO"),
                new FiltroPorConferencia("JavaConf")
        ));

        FiltroInteres filtroCompuesto = new FiltroAnd(List.of(filtroInternoAnd, filtroInternoOr));

        MiembroLaboratorio miembroAnidado = new MiembroLaboratorio(filtroCompuesto);
        repositorio.agregarObservador(miembroAnidado);

        repositorio.agregarArticulo(articuloSmalltalk); // Smalltalk + Workshop + POO -> cumple

        List<Articulo> articulosRecibidos = miembroAnidado.getEstado();
        assertEquals(1, articulosRecibidos.size());
        assertEquals("Reflexiones en Smalltalk", articulosRecibidos.get(0).getTitulo());
    }


}


