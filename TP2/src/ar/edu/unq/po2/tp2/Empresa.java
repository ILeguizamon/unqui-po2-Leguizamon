package ar.edu.unq.po2.tp2;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private String cuit;
    private List<Empleado> empleados;

    
    // ---------------- CONSTRUCTOR -----------------------------
    public Empresa(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.empleados = new ArrayList<>();
    }

    // ---------------- MÉTODOS -----------------------------
    
	    // ---------------- GETTERS -----------------------------
		    public String getNombre() {
		        return nombre;
		    }
		
		    public String getCuit() {
		        return cuit;
		    }
		
		    public List<Empleado> getEmpleados() {
		        return empleados;
		    }

	    // ---------------- MÉTODOS  -----------------
		    public void agregarEmpleado(Empleado empleado) {
		        empleados.add(empleado);
		    }
		
		    public void generarRecibosParaTodos() {
		        for (Empleado empleado : empleados) {
		            empleado.generarYGuardarRecibo();
		        }
		    }
		
		    public void mostrarRecibos() {
		        for (Empleado empleado : empleados) {
		            System.out.println("Empleado: " + empleado.getNombre());
		            for (ReciboDeHaberes recibo : empleado.getRecibos()) {
		                System.out.println(recibo);
		            }
		        }
		    }
		
		    public double totalSueldosNetos() {
		    	double total = 0.0;
		        for (Empleado empleado : empleados) {
		            total += empleado.sueldoNeto();
		        }
		        return total;
		    }
		
		    public double totalSueldosBrutos() {
		    	double total = 0.0;
		        for (Empleado empleado : empleados) {
		            total += empleado.sueldoBruto();
		        }
		        return total;
		    }
		
		    public double totalRetenciones() {
		    	double total = 0.0;
		        for (Empleado empleado : empleados) {
		            total += empleado.retenciones();
		        }
		        return total;
		    }
}
