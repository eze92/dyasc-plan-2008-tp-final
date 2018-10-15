package ar.edu.untref.dyasc.dominio;

public class Seccion extends Componente {

	private static final String FIN_SECCION = "</section>";
	private static final String SECCION_INTERMEDIA = "</section><section>";
	private static final String INICIO_FIN = "<section></section>";
	private static final String INICIO_SECCION = "<section>";

	private Componente siguienteComponente;
	private String expresionActual;
	private Contexto contexto;

	public Seccion(Componente siguienteComponente, String expresionActual, Contexto contexto) {
		super(siguienteComponente, expresionActual);

		this.siguienteComponente = siguienteComponente;
		this.expresionActual = expresionActual;
		this.contexto = contexto;
	}

	@Override
	void parsearMarkdown() {
		if (this.expresionActual.startsWith("---")) {
			contexto.agregarNuevoContenido(obtenerEtiqueta());
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}

	private String obtenerEtiqueta() {

		String etiqueta = "";

		if (contexto.soloSeccion()) {
			etiqueta = INICIO_FIN;
		} else {

			boolean seccionAbierta = false;

			if (contexto.haySeccionAbierta()) {
				etiqueta = SECCION_INTERMEDIA;
				seccionAbierta = true;
			} else if (contexto.enFinDeArchivo()) {
				etiqueta = FIN_SECCION;
				seccionAbierta = false;
			} else {
				etiqueta = INICIO_SECCION;
				seccionAbierta = true;
			}

			contexto.seccionAbierta(seccionAbierta);
		}
		return etiqueta;
	}
}
