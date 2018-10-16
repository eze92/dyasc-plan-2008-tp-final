package ar.edu.untref.dyasc.dominio;

public class Imagen extends Componente {

	private Componente siguienteComponente;

	public Imagen(Componente siguienteComponente) {
		super(siguienteComponente);

		this.siguienteComponente = siguienteComponente;
	}

	@Override
	void parsearMarkdown() {

		if (getContexto().getExpresionActual().startsWith("i:")) {
			String textoComponente = getContexto().getExpresionActual().substring(2);
			String nuevoContenido = "<img src=\"" + textoComponente + "\"/>";
			getContexto().agregarNuevoContenido(nuevoContenido);
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}
}
