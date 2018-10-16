package ar.edu.untref.dyasc.dominio;

public class FinSeccion extends Componente {

	public FinSeccion(Componente siguienteComponente) {
		super(siguienteComponente);
	}

	@Override
	void parsearMarkdown() {
		if (getContexto().getExpresionActual().equals("FIN") && getContexto().haySeccionAbierta()) {
			getContexto().agregarNuevoContenido("</section>");
		}
	}
}
