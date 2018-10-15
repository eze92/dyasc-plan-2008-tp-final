package ar.edu.untref.dyasc.dominio;

public class FinSeccion extends Componente {

	private Contexto contexto;

	public FinSeccion(Componente siguienteComponente, Contexto contexto) {
		super(siguienteComponente, contexto);
		this.contexto = contexto;
	}

	@Override
	void parsearMarkdown() {
		if (contexto.getExpresionActual().equals("FIN")) {
			contexto.agregarNuevoContenido("</section>");
		}
	}
}
