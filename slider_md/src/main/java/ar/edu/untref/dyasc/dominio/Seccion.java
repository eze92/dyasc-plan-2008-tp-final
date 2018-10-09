package ar.edu.untref.dyasc.dominio;

public class Seccion extends Componente {

	private Componente siguienteComponente;
	private String componenteActual;

	public Seccion(Componente siguienteComponente, String componenteActual) {
		super(siguienteComponente, componenteActual);
		this.siguienteComponente = siguienteComponente;
		this.componenteActual = componenteActual;
	}

	@Override
	void parsearMarkdown() {
		if (this.componenteActual.startsWith("---")) {
			agregarNuevoContenido(obtenerSeccion());
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}

	private String obtenerSeccion() {

		int posicionActual = getContenidoOriginal().indexOf(componenteActual);

		if (posicionActual == 0 && posicionActual == getContenidoOriginal().size() - 1) {
			return "<section></section>";
		} else if (posicionActual == 0) {
			return "<section>";
		} else if (posicionActual == getContenidoOriginal().size() - 1) {
			return "</section>";
		} else {
			boolean anteriorEsTipoSeccion = getContenidoOriginal().get(posicionActual - 1).startsWith("---");
			if (!anteriorEsTipoSeccion) {
				return "</section><section>";
			}
		}
		return "<section>";
	}
}
