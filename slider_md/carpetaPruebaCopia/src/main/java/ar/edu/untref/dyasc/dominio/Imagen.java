package ar.edu.untref.dyasc.dominio;

public class Imagen extends Componente {

	private Componente siguienteComponente;
	private Contexto contexto;

	public Imagen(Componente siguienteComponente, Contexto contexto) {
		super(siguienteComponente, contexto);

		this.siguienteComponente = siguienteComponente;
		this.contexto = contexto;
	}

	@Override
	void parsearMarkdown() {

		if (contexto.getExpresionActual().startsWith("i:")) {
			String textoComponente = contexto.getExpresionActual().substring(2);
			String nuevoContenido = "<img src=\"" + textoComponente + "\"/>";
			contexto.agregarNuevoContenido(nuevoContenido);
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}
}
