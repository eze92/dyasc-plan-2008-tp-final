package ar.edu.untref.dyasc.dominio;

public class Seccion extends Componente {

	private Componente siguienteComponente;
	private String componenteActual;

	public Seccion(Componente siguienteComponente, String componenteActual) {
		super(siguienteComponente, componenteActual);
		this.siguienteComponente = siguienteComponente;
		this.componenteActual = componenteActual;
	}

	@Override
	void parsearMarkdown() {
	}
}
