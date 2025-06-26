package ar.edu.unq.po2.observer.publicaciones;

import java.util.List;

public class Articulo {
    private String titulo;
    private String conferencia;
    private String lugarPublicacion;
    private String tipoArticulo;
    private String filiacion;
    private List<String> autores;
    private List<String> palabrasClave;
    
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getConferencia() {
		return conferencia;
	}
	public void setConferencia(String conferencia) {
		this.conferencia = conferencia;
	}
	public List<String> getAutores() {
		return autores;
	}
	public void setAutores(List<String> autores) {
		this.autores = autores;
	}
	public String getFiliacion() {
		return filiacion;
	}
	public void setFiliacion(String filiacion) {
		this.filiacion = filiacion;
	}
	public List<String> getPalabrasClave() {
		return palabrasClave;
	}
	public void setPalabrasClave(List<String> palabrasClave) {
		this.palabrasClave = palabrasClave;
	}
	public String getLugarPublicacion() {
		return lugarPublicacion;
	}
	public void setLugarPublicacion(String lugarPublicacion) {
		this.lugarPublicacion = lugarPublicacion;
	}
	public String getTipoArticulo() {
		return tipoArticulo;
	}
	public void setTipoArticulo(String tipoArticulo) {
		this.tipoArticulo = tipoArticulo;
	}

    
}

