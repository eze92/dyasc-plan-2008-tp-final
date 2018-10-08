package ar.edu.untref.dyasc.dominio;

import java.util.List;

public abstract class Componente {

	private List<String> contenidoOriginal;
	private String nuevoContenido = "";
	private String componenteActual;

	public Componente(String componenteActual) {
		this.componenteActual = componenteActual;
	}

	abstract Componente siguiente(Componente componente);

	abstract String parsearMarkdown();

	void agregarComponenteAlNuevoContenido(String nuevoComponente) {
		this.nuevoContenido += nuevoComponente;
	}

	public void setContenidoOriginal(List<String> contenidoOriginal) {
		this.contenidoOriginal = contenidoOriginal;
	}
}
