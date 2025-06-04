package ar.edu.unq.po2.tp6.BancoPrestamos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BancoTest {

    private Banco banco;
    private Cliente clienteA;
    private Cliente clienteB;
    private SolicitudDeCredito solicitudAceptable;
    private SolicitudDeCredito solicitudNoAceptable;
    private SolicitudDeCreditoHipotecario solicitudHipotecaria;
    private PropiedadInmobiliaria propiedad;

    @BeforeEach
    public void setUp() {
        banco = new Banco();
        clienteA = new Cliente("Ivann", "Leguizamon", "Quilmes", 24, 20000);
        clienteB = new Cliente("Juan", "Perez", "Avellaneda", 40, 1000); // Sueldo bajo para que no sea aceptado
        propiedad = new PropiedadInmobiliaria("Casa en Quilmes", "Quilmes 1234", 100000);

        solicitudAceptable = new SolicitudDeCreditoPersonal(clienteA, 10000, 12);
        solicitudNoAceptable = new SolicitudDeCreditoPersonal(clienteB, 8000, 12);
        solicitudHipotecaria = new SolicitudDeCreditoHipotecario(clienteA, 30000, 12, propiedad);
    }

    @Test
    public void testAgregarCliente() {
        banco.agregarCliente(clienteA);
        
        assertTrue(banco.getClientes().contains(clienteA));
    }

    @Test
    public void testRegistrarSolicitud() {
        banco.registrarSolicitudDeCredito(solicitudAceptable);
        
        assertTrue(banco.getSolicitudesDeCredito().contains(solicitudAceptable));
    }

    @Test
    public void testMontoTotalDesembolsado() {
        banco.registrarSolicitudDeCredito(solicitudAceptable);
        banco.registrarSolicitudDeCredito(solicitudNoAceptable);
        
        // Solo la solicitud de clienteA es aceptable
        assertEquals(10000, banco.montoTotalDesembolsado(), 0.01);
    }
    
    @Test
    public void testSolicitudDeCreditoHipotecarioAceptada() {
        clienteA.solicitarCredito(banco, solicitudHipotecaria);
        
        assertTrue(solicitudHipotecaria.esAceptable());
        assertTrue(banco.getSolicitudesDeCredito().contains(solicitudHipotecaria));
    }

}
