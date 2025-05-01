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
        empresa = new Empresa("DataCorp", "28-26352718-9");

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
    
    // ------- EJERCICIOS 1 C) y EJERCICIO 2 D) ----------
    @Test
    public void testEmpresaGeneraRecibosParaTodos() {
        empresa.liquidacionDeSueldos();

        List<ReciboDeHaberes> recibos = empresa.getReciboDeHaberes();

        assertEquals(3, recibos.size());

        boolean encontradoIvan = false;
        boolean encontradoJuana = false;
        boolean encontradoCarlos = false;

        for (ReciboDeHaberes recibo : recibos) {
            if (recibo.getNombreEmpleado().equals("Ivan Leguizamon")) {
                encontradoIvan = true;
            }
            if (recibo.getNombreEmpleado().equals("Juana Diaz")) {
                encontradoJuana = true;
            }
            if (recibo.getNombreEmpleado().equals("Carlos Perez")) {
                encontradoCarlos = true;
            }
        }

        assertTrue(encontradoIvan);
        assertTrue(encontradoJuana);
        assertTrue(encontradoCarlos);
    }

    @Test
    public void testEmpresaCalculaCorrectamenteTotales() {
        empresa.liquidacionDeSueldos();

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

        assertEquals(totalBrutoEsperado, brutoCalculado);
        assertEquals(totalNetoEsperado, netoCalculado);
        assertEquals(totalRetencionesEsperado, retencionesCalculadas);
    }

    @Test
    public void testLiquidacionDeSueldos() {
        empresa.liquidacionDeSueldos();

        List<ReciboDeHaberes> recibos = empresa.getReciboDeHaberes();

        for (ReciboDeHaberes recibo : recibos) {
            System.out.println("=== Recibo de " + recibo.getNombreEmpleado() + " ===");
            System.out.println("Sueldo bruto: $" + recibo.getSueldoBruto());
            System.out.println("Sueldo neto: $" + recibo.getSueldoNeto());
            System.out.println("Fecha de emisión: " + recibo.getFechaEmision());
            
            for (Concepto concepto : recibo.getConceptos()) {
                System.out.println(concepto.getDescripcion() + ": $" + concepto.getMonto());
            }

            System.out.println("-------------------------------------------");
        }

        assertEquals(3, recibos.size(), "Debe generarse un recibo por cada empleado");
    }
}
