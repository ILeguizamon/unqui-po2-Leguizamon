package ar.edu.unq.po2.tp2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;

public class EmpleadoPlantaPermanenteTest {

    private EmpleadoPlantaPermanente empleado;

    @BeforeEach
    public void setUp() {
        empleado = new EmpleadoPlantaPermanente(
            "Ivan Leguizamon",
            "Dirección X",
            "Casado",
            LocalDate.of(1990, 5, 10),
            100000.0,
            2,
            5
        );
    }

    @Test
    public void testCalculoSueldoNetoEmpleadoPlantaPermanente() {
        // --- Cálculos esperados ---
        double asignacionHijos = 2 * 150.0;             // 300.0
        double asignacionConyuge = 100.0;               // por ser "Casado"
        double asignacionAntiguedad = 5 * 50.0;         // 250.0
        double salarioFamiliar = asignacionHijos + asignacionConyuge + asignacionAntiguedad; // 650.0

        double sueldoBruto = 100000.0 + salarioFamiliar; // 100650.0

        double retencionObraSocial = sueldoBruto * 0.10 + (2 * 20); // 10065.0 + 40 = 10105.0
        double retencionJubilacion = sueldoBruto * 0.15;            // 15097.5

        double retenciones = retencionObraSocial + retencionJubilacion; // 25202.5
        double sueldoNetoEsperado = sueldoBruto - retenciones; // 75447.5

        assertEquals(sueldoNetoEsperado, empleado.sueldoNeto());
    }

    @Test
    public void testEmpleadoPermanenteGeneraYGuardaRecibo() {
        empleado.generarYGuardarRecibo();

        List<ReciboDeHaberes> recibos = empleado.getRecibos();
        assertEquals(1, recibos.size());

        ReciboDeHaberes reciboGuardado = recibos.get(0);
        assertEquals("Ivan Leguizamon", reciboGuardado.getNombreEmpleado());
        assertEquals("Dirección X", reciboGuardado.getDireccionEmpleado());
        assertEquals(empleado.sueldoBruto(), reciboGuardado.getSueldoBruto());
        assertEquals(empleado.sueldoNeto(), reciboGuardado.getSueldoNeto());
    }

    @Test
    public void testGenerarYMostrarRecibo() {
        ReciboDeHaberes recibo = empleado.generarRecibo();
        System.out.println(recibo); 
    }
}
