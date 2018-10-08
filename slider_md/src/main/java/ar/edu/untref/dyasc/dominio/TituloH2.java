package ar.edu.untref.dyasc.dominio;

public class TituloH2 extends Componente {

	private Componente siguienteComponente;

	public TituloH2(Componente siguienteComponente, String componenteActual) {
		super(siguienteComponente, componenteActual);
		this.siguienteComponente = siguienteComponente;
	}

	@Override
	void parsearMarkdown() {
	}
}
