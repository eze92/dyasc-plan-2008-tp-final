package ar.edu.untref.dyasc.dominio;

public class Imagen extends Componente {

	private String componenteActual;

	public Imagen(Componente siguienteComponente, String componenteActual) {
		super(siguienteComponente, componenteActual);
		this.componenteActual = componenteActual;
	}

	@Override
	void parsearMarkdown() {
		agregarNuevoContenido("<img src=\"imagen.png\"/>");
	}
}
