package ar.edu.unq.po2.tp4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrabajadorTest {
	Trabajador trabajador;
	Ingreso ingreso1;
	Ingreso ingreso2;
	IngresoPorHorasExtras ingresoHorasExtras;
	
	@BeforeEach
	public void setUp() {
		trabajador = new Trabajador();
		ingreso1 = new Ingreso(10, "concepto1", 100d);
		ingreso2 = new Ingreso(11, "concepto2", 110d);
		ingresoHorasExtras = new IngresoPorHorasExtras(12, "concepto3", 115d, 8);
		
		trabajador.agregarIngreso(ingreso1);
		trabajador.agregarIngreso(ingreso2);
		trabajador.agregarIngreso(ingresoHorasExtras);
	}
	
	@Test
	public void testVerificaSiElTrabajadorTiene3Ingresos() {
		
		assertEquals(3, trabajador.getIngresos().size());
		assertTrue(trabajador.getIngresos().contains(ingreso1)); // contains(): Sirve para verificar si un elemento específico está dentro de una lista.
		assertTrue(trabajador.getIngresos().contains(ingreso2));
		assertTrue(trabajador.getIngresos().contains(ingresoHorasExtras));
	}
	
	@Test
	public void testTrabajadorConoceSuIngresoTotal() {
		double ingresoTotal = 325d;
		
		assertEquals(ingresoTotal, trabajador.getTotalPercibido());
	}
	
	@Test
	public void testTrabajadorConoceSuMontoImponibleTotal() {
		double montoImponibleTotal = 210d;
		
		assertEquals(montoImponibleTotal, trabajador.getMontoImponible());
	}
	
	@Test
	public void testTrabajadorConoceSuMontoDeImpuestoAPagar() {
		double impuestoTotal = 4.2;
		
		assertEquals(impuestoTotal, trabajador.getImpuestoAPagar(), 0.01);
	}
}
