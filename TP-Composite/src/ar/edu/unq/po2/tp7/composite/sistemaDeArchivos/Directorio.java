package ar.edu.unq.po2.tp7.composite.sistemaDeArchivos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Directorio implements FyleSystem {
	
	private String nombre;
	private LocalDate fechaDeCreacion;
	private List<FyleSystem> contenido;
	
	public Directorio(String nombre, LocalDate fechaDeCreacion) {
		this.nombre = nombre;
		this.fechaDeCreacion = fechaDeCreacion;
		this.contenido = new ArrayList<FyleSystem>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void agregarContenido(FyleSystem contenido) {
		this.getContenido().add(contenido);
	}

	public void quitarContenido(FyleSystem contenido) {
		this.getContenido().remove(contenido);
	}

	@Override
	public int totalSize() {
	    int total = 0;
	    for (FyleSystem elemento : contenido) {
	        total += elemento.totalSize();
	    }
	    return total;
	}


	@Override
	public void printStructure() {
		// TODO Auto-generated method stub
	}

	@Override
	public FyleSystem lastModified() {
	    FyleSystem ultimoModificado = this; // El directorio actual es candidato inicial
	    LocalDate fechaUltimaModificacion = this.getFechaDeCreacion();

	    for (FyleSystem elemento : contenido) {
	        FyleSystem candidato = elemento.lastModified();
	        LocalDate fechaCandidato = candidato.getFechaDeModificacion();

	        if (fechaCandidato.isAfter(fechaUltimaModificacion)) {
	            ultimoModificado = candidato;
	            fechaUltimaModificacion = fechaCandidato;
	        }
	    }

	    return ultimoModificado;
	}
	
	// misma estructura que la anterior
	@Override
	public FyleSystem oldestElement() {
	    FyleSystem masAntiguo = this; // El directorio actual es candidato inicial
	    LocalDate fechaMasAntigua = this.getFechaDeModificacion();

	    for (FyleSystem elemento : contenido) {
	        FyleSystem candidato = elemento.oldestElement();
	        LocalDate fechaCandidato = candidato.getFechaDeModificacion();

	        if (fechaCandidato.isBefore(fechaMasAntigua)) {
	            masAntiguo = candidato;
	            fechaMasAntigua = fechaCandidato;
	        }
	    }

	    return masAntiguo;
	}


	public List<FyleSystem> getContenido() {
		return contenido;
	}
	
	
	
	@Override
	public LocalDate getFechaDeModificacion() {
	    return this.fechaDeCreacion;
	}

}
