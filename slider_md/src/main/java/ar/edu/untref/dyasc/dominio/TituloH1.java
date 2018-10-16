package ar.edu.untref.dyasc.dominio;

public class TituloH1 extends Componente {

	private Componente siguienteComponente;

	public TituloH1(Componente siguienteComponente) {
		super(siguienteComponente);

		this.siguienteComponente = siguienteComponente;
	}

	@Override
	void parsearMarkdown() {

		if (getContexto().getExpresionActual().startsWith("# ")) {
			String textoComponente = getContexto().getExpresionActual().substring(2);
			String nuevoContenido = "<h1>" + textoComponente + "</h1>\n";
			getContexto().agregarNuevoContenido(nuevoContenido);
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}
}
