package ar.edu.untref.dyasc.dominio;

import java.util.List;

public abstract class Componente {

	private List<String> contenidoOriginal;
	private String nuevoContenido = "";

	public Componente(Componente siguienteComponente, String componenteActual) {
	}

	abstract void parsearMarkdown();

	void agregarNuevoContenido(String nuevoComponente) {
		this.nuevoContenido += nuevoComponente;
	}

	public void setContenidoOriginal(List<String> contenidoOriginal) {
		this.contenidoOriginal = contenidoOriginal;
	}

	public String getNuevoContenido() {
		return nuevoContenido;
	}

	public List<String> getContenidoOriginal() {
		return contenidoOriginal;
	}
}
