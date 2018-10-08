package ar.edu.untref.dyasc.dominio;

public class TituloH2 extends Componente {

	private Componente siguienteComponente;
	private String componenteActual;

	public TituloH2(Componente siguienteComponente, String componenteActual) {
		super(siguienteComponente, componenteActual);

		this.siguienteComponente = siguienteComponente;
		this.componenteActual = componenteActual;
	}

	@Override
	void parsearMarkdown() {

		String etiqueta = this.componenteActual.substring(0, 3);

		if (etiqueta.equals("## ")) {
			String textoComponente = this.componenteActual.substring(3);
			String nuevoContenido = "<h2>" + textoComponente + "</h2>";
			agregarNuevoContenido(nuevoContenido);
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}
}
