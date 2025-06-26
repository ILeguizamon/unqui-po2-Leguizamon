package ar.edu.unq.po2.AyTm.sueldosRecargados;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {

    private Empleado empleadoDePlanta;
    private Empleado pasante40hs;
    private Empleado temporarioConFamilia;
    private Empleado temporarioSinFamilia;

    @BeforeEach
    public void setUp() {
        empleadoDePlanta = new EmpleadoDePlanta(2);
        pasante40hs = new EmpleadoPasante(40);
        temporarioConFamilia = new EmpleadoTemporario(true, true, 1000, 30);
        temporarioSinFamilia = new EmpleadoTemporario(false, false, 1000, 20);
    }

    @Test
    public void testEmpleadoDePlantaCon2Hijos() {
        assertEquals(2871d, empleadoDePlanta.sueldoFinal(), 0.01);
    }

    @Test
    public void testEmpleadoPasanteCon40Horas() {
        assertEquals(1392d, pasante40hs.sueldoFinal(), 0.01);
    }

    @Test
    public void testEmpleadoTemporarioCasadoYConHijosCon30Horas() {
        assertEquals(1087.5d, temporarioConFamilia.sueldoFinal(), 0.01);
    }

    @Test
    public void testEmpleadoTemporarioSinHijosNiEsCasadoCon20Horas() {
        assertEquals(957d, temporarioSinFamilia.sueldoFinal(), 0.01);
    }
}
