package ar.edu.untref.dyasc.dominio;

public class Seccion extends Componente {

	private static final String SECCION_INTERMEDIA = "</section><section>";
	private static final String INICIO_FIN = "<section></section>";
	private static final String INICIO_SECCION = "<section>";

	private Componente siguienteComponente;
	private String expresionActual;
	private Contexto contexto;

	public Seccion(Componente siguienteComponente, String expresionActual, Contexto contexto) {
		super(siguienteComponente, expresionActual, contexto);

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

			if (contexto.haySeccionAbierta()) {
				etiqueta = SECCION_INTERMEDIA;
			} else {
				etiqueta = INICIO_SECCION;
			}

			contexto.seccionAbierta(true);
		}
		return etiqueta;
	}
}
