package ar.edu.untref.dyasc.dominio;

public class Imagen extends Componente {

	private String componenteActual;
	private Componente siguienteComponente;
	private Contexto contexto;

	public Imagen(Componente siguienteComponente, String componenteActual, Contexto contexto) {
		super(siguienteComponente, componenteActual, contexto);

		this.siguienteComponente = siguienteComponente;
		this.componenteActual = componenteActual;
		this.contexto = contexto;
	}

	@Override
	void parsearMarkdown() {

		if (this.componenteActual.startsWith("i:")) {
			String textoComponente = this.componenteActual.substring(2);
			String nuevoContenido = "<img src=\"" + textoComponente + "\"/>";
			contexto.agregarNuevoContenido(nuevoContenido);
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}
}
