package ar.edu.untref.dyasc.dominio;

public class Lista {

	private static boolean iniciada = false;
	private static boolean finalizada = false;

	public String crearInicio() {
		if (!iniciada) {
			iniciada = true;
			finalizada = false;
			return "<ul>";
		}
		return "";
	}

	public String crearFin() {
		if (!finalizada) {
			finalizada = true;
			iniciada = false;
			return "</ul>";
		}
		return "";
	}
}
