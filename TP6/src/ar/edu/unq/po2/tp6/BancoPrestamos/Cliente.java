package ar.edu.unq.po2.tp6.BancoPrestamos;

public class Cliente {
	private String nombre;
	private String apellido;
	private String direccion;
	private int edad;
	private double sueldoNetoMensual;
	
	public Cliente(String nombre, String apellido, String direccion, int edad, double sueldoNetoMensual) {
		this.nombre = nombre;
		this.apellido =apellido;
		this.direccion = direccion;
		this.edad = edad;
		this.sueldoNetoMensual = sueldoNetoMensual;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getSueldoNetoMensual() {
		return sueldoNetoMensual;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public Object getApellido() {
		// TODO Auto-generated method stub
		return apellido;
	}

	public Object getDireccion() {
		// TODO Auto-generated method stub
		return direccion;
	}
	
	public double sueldoNetoAnual() {
		return (getSueldoNetoMensual() * 12);
	}
	
	public void solicitarCredito(Banco banco, SolicitudDeCredito solicitud) {
		banco.registrarSolicitudDeCredito(solicitud);
	}
}
