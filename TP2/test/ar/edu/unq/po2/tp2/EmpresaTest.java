package ar.edu.unq.po2.tp2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmpresaTest {

    private Empresa empresa;
    private Empleado empleadoPermanente;
    private Empleado empleadoTemporario;
    private Empleado empleadoContratado;

    @BeforeEach
    public void setUp() {
        empresa = new Empresa("DataCorp", "30-71598236-5");

        empleadoPermanente = new EmpleadoPlantaPermanente(
                "Ivan Leguizamon",
                "Calle Falsa 123",
                "Casado",
                LocalDate.of(1990, 5, 10),
                100000.0,
                2,
                5
        );

        empleadoTemporario = new EmpleadoPlantaTemporaria(
                "Juana Diaz",
                "Calle Falsa 456",
                "Soltera",
                LocalDate.of(1970, 4, 20),
                80000.0,
                LocalDate.of(2025, 12, 31),
                10
        );

        empleadoContratado = new EmpleadoContratado(
                "Carlos Perez",
                "Calle Falsa 789",
                "Soltero",
                LocalDate.of(1985, 1, 15),
                75000.0,
                2025,
                "Transferencia"
        );

        empresa.agregarEmpleado(empleadoPermanente);
        empresa.agregarEmpleado(empleadoTemporario);
        empresa.agregarEmpleado(empleadoContratado);
    }
    
    @Test
    public void testEmpresaAgregaEmpleadosYCuentaCorrectamente() {
        int cantidad = empresa.getEmpleados().size();
        System.out.println("Cantidad de empleados en la empresa: " + cantidad);
        assertEquals(3, cantidad);
    }
    
    
    // ------------------- EJERCICIO 1 C) - CÁLCULO DEL TOTAL DE SUELDOS NETOS ------------------------
    @Test
    public void testEmpresaCalculaCorrectamenteTotales() {
        empresa.generarRecibosParaTodos();

        double totalBrutoEsperado = 0.0;
        double totalNetoEsperado = 0.0;
        double totalRetencionesEsperado = 0.0;

        for (Empleado empleado : empresa.getEmpleados()) {
            totalBrutoEsperado += empleado.sueldoBruto();
            totalNetoEsperado += empleado.sueldoNeto();
            totalRetencionesEsperado += empleado.retenciones();
        }

        double brutoCalculado = empresa.totalSueldosBrutos();
        double netoCalculado = empresa.totalSueldosNetos();
        double retencionesCalculadas = empresa.totalRetenciones();

        System.out.println("Total Sueldos Brutos Esperado: " + totalBrutoEsperado + " | Calculado: " + brutoCalculado);
        System.out.println("Total Sueldos Netos Esperado: " + totalNetoEsperado + " | Calculado: " + netoCalculado);
        System.out.println("Total Retenciones Esperadas: " + totalRetencionesEsperado + " | Calculadas: " + retencionesCalculadas);

        assertEquals(totalBrutoEsperado, brutoCalculado);
        assertEquals(totalNetoEsperado, netoCalculado);
        assertEquals(totalRetencionesEsperado, retencionesCalculadas);
    }
    
    
    // ------------------- EJERCICIO 1 C) - LIQUIDACIÓN DE SUELDOS ------------------------
    @Test
    public void testEmpresaGeneraRecibosParaTodos() {
        empresa.generarRecibosParaTodos();

        for (Empleado empleado : empresa.getEmpleados()) {
            List<ReciboDeHaberes> recibos = empleado.getRecibos();
            System.out.println("Empleado: " + empleado.getNombre() + " tiene " + recibos.size() + " recibo/s.");
            assertEquals(1, recibos.size(), "El empleado " + empleado.getNombre() + " debería tener un recibo");
        }
    }

}

