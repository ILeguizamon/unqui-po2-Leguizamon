package ar.edu.unq.po2.tp7.composite.sistemaDeArchivos;

import java.time.LocalDate;
import java.util.List;

public class Archive implements FyleSystem {

	private String nombre;
	private int espacioEnDisco;
	private LocalDate ultimaFechaModificacion;
	
	public Archive(String nombre, int espacioEnDisco, LocalDate ultimaFechaModificacion) {
	    this.nombre = nombre;
	    this.espacioEnDisco = espacioEnDisco;
	    this.ultimaFechaModificacion = ultimaFechaModificacion;
	}
	 
	@Override
	public int totalSize() {
		// TODO Auto-generated method stub
		return espacioEnDisco;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEspacioEnDisco() {
		return espacioEnDisco;
	}

	public LocalDate getUltimaFechaModificacion() {
		return ultimaFechaModificacion;
	}

	@Override
	public void printStructure() {
		System.out.println(getNombre());

	}

	@Override
	public FyleSystem lastModified() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public FyleSystem oldestElement() {
		// TODO Auto-generated method stub
		return this;
	}
	
	
	
	@Override
	public LocalDate getFechaDeModificacion() {
	    return this.ultimaFechaModificacion;
	}


}
