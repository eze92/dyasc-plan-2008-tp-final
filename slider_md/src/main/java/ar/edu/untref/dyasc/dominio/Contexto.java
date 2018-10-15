package ar.edu.untref.dyasc.dominio;

public class Contexto {

	private String[] contenidoOriginal;
	private String nuevoContenido = "";

	private boolean seccionAbierta = false;
	private boolean listaAbierta = false;

	public boolean hayListaAbierta() {
		return listaAbierta;
	}

	public void listaAbierta(boolean listaAbierta) {
		this.listaAbierta = listaAbierta;
	}

	public boolean haySeccionAbierta() {
		return seccionAbierta;
	}

	public void seccionAbierta(boolean seccionAbierta) {
		this.seccionAbierta = seccionAbierta;
	}

	public void agregarNuevoContenido(String nuevoComponente) {
		this.nuevoContenido += nuevoComponente;
	}

	public void setContenidoOriginal(String[] contenidoOriginal) {
		this.contenidoOriginal = contenidoOriginal;
	}

	public String getNuevoContenido() {
		return nuevoContenido;
	}

	public String[] getContenidoOriginal() {
		return contenidoOriginal;
	}

	public boolean soloSeccion() {
		return contenidoOriginal.length == 1;
	}
}
