package ar.edu.untref.dyasc.dominio;

public class FinSeccion extends Componente {

	private Contexto contexto;
	private String expresionActual;

	public FinSeccion(Componente siguienteComponente, String expresionActual, Contexto contexto) {
		super(siguienteComponente, expresionActual);

		this.expresionActual = expresionActual;
		this.contexto = contexto;
	}

	@Override
	void parsearMarkdown() {
		if (this.expresionActual.equals("FIN")) {
			contexto.agregarNuevoContenido("</section>");
		}
	}
}
