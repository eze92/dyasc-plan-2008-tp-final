package ar.edu.untref.dyasc.dominio;

public class TituloH1 extends Componente {

	private Componente siguienteComponente;
	private Contexto contexto;

	public TituloH1(Componente siguienteComponente, Contexto contexto) {
		super(siguienteComponente, contexto);

		this.siguienteComponente = siguienteComponente;
		this.contexto = contexto;
	}

	@Override
	void parsearMarkdown() {

		if (contexto.getExpresionActual().startsWith("# ")) {
			String textoComponente = contexto.getExpresionActual().substring(2);
			String nuevoContenido = "<h1>" + textoComponente + "</h1>";
			contexto.agregarNuevoContenido(nuevoContenido);
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}
}
