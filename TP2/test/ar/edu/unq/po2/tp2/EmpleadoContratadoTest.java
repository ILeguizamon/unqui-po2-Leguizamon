package ar.edu.unq.po2.tp2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;

public class EmpleadoContratadoTest {

    private EmpleadoContratado empleado;

    @BeforeEach
    public void setUp() {
        empleado = new EmpleadoContratado(
            "Ivan Leguizamón",
            "Dirección Z",
            "Soltero",
            LocalDate.of(1995, 8, 15),
            75000.0,
            1234,
            "Transferencia Bancaria"
        );
    }

    @Test
    public void testCalculoSueldoNetoEmpleadoContratado() {
        double sueldoBrutoEsperado = 75000.0;
        double retencionesEsperadas = 50.0;
        double sueldoNetoEsperado = sueldoBrutoEsperado - retencionesEsperadas;

        assertEquals(sueldoBrutoEsperado, empleado.sueldoBruto());
        assertEquals(retencionesEsperadas, empleado.retenciones());
        assertEquals(sueldoNetoEsperado, empleado.sueldoNeto());
    }

    @Test
    public void testEmpleadoContratadoGeneraYGuardaRecibo() {
        empleado.generarYGuardarRecibo();

        List<ReciboDeHaberes> recibos = empleado.getRecibos();
        assertEquals(1, recibos.size());

        ReciboDeHaberes recibo = recibos.get(0);
        assertEquals("Ivan Leguizamón", recibo.getNombreEmpleado());
        assertEquals("Dirección Z", recibo.getDireccionEmpleado());
        assertEquals(empleado.sueldoBruto(), recibo.getSueldoBruto());
        assertEquals(empleado.sueldoNeto(), recibo.getSueldoNeto());
        
        LocalDate fechaActual = LocalDate.now();
        assertEquals(fechaActual, recibo.getFechaEmision()); 
    }

    @Test
    public void testGenerarYMostrarRecibo() {
        ReciboDeHaberes recibo = empleado.generarRecibo();
        System.out.println(recibo); 
    }
}

