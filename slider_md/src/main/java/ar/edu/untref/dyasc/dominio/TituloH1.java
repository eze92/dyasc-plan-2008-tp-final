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
	void parsearMarkdown() {

		if (this.componenteActual.startsWith("# ")) {
			String textoComponente = this.componenteActual.substring(2);
			String nuevoContenido = "<h1>" + textoComponente + "</h1>";
			agregarNuevoContenido(nuevoContenido);
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}
}
