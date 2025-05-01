package ar.edu.unq.po2.tp2;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nombre;
    private String cuit;
    private List<Empleado> empleados;
    private List<ReciboDeHaberes> recibosDeHaberes; // Lista de reciboDeHaberes en Empresa (Corrección)

    // ---------------- CONSTRUCTOR -----------------------------
    public Empresa(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.empleados = new ArrayList<Empleado>();
        this.recibosDeHaberes = new ArrayList<ReciboDeHaberes>();
    }
    
    // ---------------- GETTERS -----------------------------
    public List<Empleado> getEmpleados() {
        return empleados;
    }
    
    public List<ReciboDeHaberes> getReciboDeHaberes() {
        return recibosDeHaberes;
    }

    // ---------------- MÉTODOS -----------------------------
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
    
    public void agregarReciboDeHaberes(ReciboDeHaberes recibo) {
        recibosDeHaberes.add(recibo);
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
    
    // ------- NUEVO ------
    public void liquidacionDeSueldos() {
        System.out.println("---- Liquidación de Sueldos ----");
        
        for (Empleado empleado : this.getEmpleados()) {
            ReciboDeHaberes recibo = new ReciboDeHaberes(empleado);
            
            this.agregarReciboDeHaberes(recibo);

            System.out.println("Empleado: " + recibo.getNombreEmpleado());
            System.out.println("Dirección: " + recibo.getDireccionEmpleado());
            System.out.println("Fecha de emisión: " + recibo.getFechaEmision());
            System.out.println("Sueldo Bruto: $" + recibo.getSueldoBruto());
            System.out.println("Sueldo Neto: $" + recibo.getSueldoNeto());
            System.out.println("Conceptos:");
            
            for (Concepto concepto : recibo.getConceptos()) {
                System.out.println(" - " + concepto.getDescripcion() + ": $" + concepto.getMonto());
            }
            
            System.out.println("-----------------------------------\n");
        }
    }

}
