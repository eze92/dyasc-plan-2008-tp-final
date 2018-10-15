package ar.edu.untref.dyasc.dominio;

public class TituloH2 extends Componente {

	private Componente siguienteComponente;
	private Contexto contexto;

	public TituloH2(Componente siguienteComponente, Contexto contexto) {
		super(siguienteComponente, contexto);

		this.siguienteComponente = siguienteComponente;
		this.contexto = contexto;
	}

	@Override
	void parsearMarkdown() {

		if (contexto.getExpresionActual().startsWith("## ")) {
			String textoComponente = contexto.getExpresionActual().substring(3);
			String nuevoContenido = "<h2>" + textoComponente + "</h2>";
			contexto.agregarNuevoContenido(nuevoContenido);
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}
}
