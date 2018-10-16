package ar.edu.untref.dyasc.dominio;

public class TituloH2 extends Componente {

	private Componente siguienteComponente;

	public TituloH2(Componente siguienteComponente) {
		super(siguienteComponente);

		this.siguienteComponente = siguienteComponente;
	}

	@Override
	void parsearMarkdown() {

		if (getContexto().getExpresionActual().startsWith("## ")) {
			String textoComponente = getContexto().getExpresionActual().substring(3);
			String nuevoContenido = "<h2>" + textoComponente + "</h2>";
			getContexto().agregarNuevoContenido(nuevoContenido);
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}
}
