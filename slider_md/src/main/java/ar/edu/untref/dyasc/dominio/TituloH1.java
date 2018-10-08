package ar.edu.untref.dyasc.dominio;

public class TituloH1 extends Componente {

	private Componente siguienteComponente;
	private String componenteActual;

	public TituloH1(Componente siguienteComponente, String componenteActual) {
		super(siguienteComponente, componenteActual);

		this.siguienteComponente = siguienteComponente;
		this.componenteActual = componenteActual;
	}

	@Override
	String parsearMarkdown() {
		String textoComponente = this.componenteActual.substring(2);
		return "<h1>" + textoComponente + "</h1>";
	}
}
