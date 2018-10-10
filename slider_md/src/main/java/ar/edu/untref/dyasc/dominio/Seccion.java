package ar.edu.untref.dyasc.dominio;

public class Seccion extends Componente {

	private Componente siguienteComponente;
	private String componenteActual;
	private boolean seccionAbierta = false;

	public Seccion(Componente siguienteComponente, String componenteActual) {
		super(siguienteComponente, componenteActual);

		this.siguienteComponente = siguienteComponente;
		this.componenteActual = componenteActual;
	}

	@Override
	void parsearMarkdown() {
		int posicionActual = getContenidoOriginal().indexOf(componenteActual);

		if (this.componenteActual.startsWith("---") || posicionActual == getContenidoOriginal().size() - 1) {
			agregarNuevoContenido(obtenerSeccion(posicionActual));
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}

	private String obtenerSeccion(int posicionActual) {

		String inicioSeccion = "<section>";
		String seccionIntermedia = "<section></section>";
		String finSeccion = "</section>";

		if (getContenidoOriginal().size() == 1) {
			return seccionIntermedia;
		} else if (posicionActual == 0) {
			seccionAbierta = true;
			return inicioSeccion;
		} else if (posicionActual == getContenidoOriginal().size() - 1) {
			seccionAbierta = false;
			return finSeccion;
		} else if (seccionAbierta) {
			seccionAbierta = true;
			return seccionIntermedia;
		} else {
			seccionAbierta = true;
			return inicioSeccion;
		}
	}
}
