package ar.edu.untref.dyasc.dominio;

public class Seccion extends Componente {

	private static final String SECCION_INTERMEDIA = "</section><section>";
	private static final String INICIO_FIN = "<section></section>";
	private static final String INICIO_SECCION = "<section>";

	private Componente siguienteComponente;

	public Seccion(Componente siguienteComponente) {
		super(siguienteComponente);

		this.siguienteComponente = siguienteComponente;
	}

	@Override
	void parsearMarkdown() {
		if (getContexto().getExpresionActual().startsWith("---")) {
			getContexto().agregarNuevoContenido(obtenerEtiqueta());
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}

	private String obtenerEtiqueta() {

		String etiqueta = "";

		if (getContexto().soloSeccion()) {
			etiqueta = INICIO_FIN;
		} else {

			if (getContexto().haySeccionAbierta()) {
				etiqueta = SECCION_INTERMEDIA;
			} else {
				etiqueta = INICIO_SECCION;
			}

			getContexto().seccionAbierta(true);
		}
		return etiqueta;
	}
}
