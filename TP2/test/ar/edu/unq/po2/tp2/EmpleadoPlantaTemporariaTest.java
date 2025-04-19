package ar.edu.unq.po2.tp2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class EmpleadoPlantaTemporariaTest {

    private EmpleadoPlantaTemporaria empleado;

    @BeforeEach
    public void setUp() {
        empleado = new EmpleadoPlantaTemporaria(
            "Ivan Leguizamon",
            "Dirección Y",
            "Soltero",
            LocalDate.of(1970, 5, 10), // Mayor de 50 años
            80000.0,
            LocalDate.of(2025, 12, 31),
            10 
        );
    }

    @Test
    public void testCalculoSueldoNetoEmpleadoPlantaTemporario() {
    	// --- Cálculos esperados ---
        double sueldoBasico = 80000.0;
        int horasExtras = 10;
        double pagoHorasExtras = horasExtras * 40.0; // 400.0
        double sueldoBruto = sueldoBasico + pagoHorasExtras; // 80400.0

        double extraEdad = 25.0; // porque tiene más de 50
        double retencionObraSocial = sueldoBruto * 0.10 + extraEdad; // 8040 + 25
        double retencionJubilacion = sueldoBruto * 0.10 + (horasExtras * 5); // 8040 + 50

        double retenciones = retencionObraSocial + retencionJubilacion;
        double sueldoNetoEsperado = sueldoBruto - retenciones;

        assertEquals(sueldoNetoEsperado, empleado.sueldoNeto());
    }

    @Test
    public void testEmpleadoTemporarioGeneraYGuardaRecibo() {
        empleado.generarYGuardarRecibo();

        assertEquals(1, empleado.getRecibos().size());

        ReciboDeHaberes recibo = empleado.getRecibos().get(0);
        assertEquals("Ivan Leguizamon", recibo.getNombreEmpleado());
        assertEquals("Dirección Y", recibo.getDireccionEmpleado());
        assertEquals(empleado.sueldoBruto(), recibo.getSueldoBruto());
        assertEquals(empleado.sueldoNeto(), recibo.getSueldoNeto());
    }

    @Test
    public void testImprimirReciboDeEmpleadoTemporario() {
        ReciboDeHaberes recibo = empleado.generarRecibo();
        System.out.println(recibo); 
    }
}

