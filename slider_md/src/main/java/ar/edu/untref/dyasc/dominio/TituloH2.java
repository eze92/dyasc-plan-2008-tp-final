package ar.edu.untref.dyasc.dominio;

public class TituloH2 extends Componente {

	private Componente siguienteComponente;
	private String componenteActual;
	private Contexto contexto;

	public TituloH2(Componente siguienteComponente, String componenteActual, Contexto contexto) {
		super(siguienteComponente, componenteActual, contexto);

		this.siguienteComponente = siguienteComponente;
		this.componenteActual = componenteActual;
		this.contexto = contexto;
	}

	@Override
	void parsearMarkdown() {

		if (this.componenteActual.startsWith("## ")) {
			String textoComponente = this.componenteActual.substring(3);
			String nuevoContenido = "<h2>" + textoComponente + "</h2>";
			contexto.agregarNuevoContenido(nuevoContenido);
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}
}
