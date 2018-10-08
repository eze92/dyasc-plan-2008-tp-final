package ar.edu.untref.dyasc.dominio;

public class Imagen extends Componente {

	private String componenteActual;

	public Imagen(Componente siguienteComponente, String componenteActual) {
		super(siguienteComponente, componenteActual);
		this.componenteActual = componenteActual;
	}

	@Override
	void parsearMarkdown() {
		String textoComponente = this.componenteActual.substring(2);
		String nuevoContenido = "<img src=\"" + textoComponente + "\"/>";
		agregarNuevoContenido(nuevoContenido);
	}
}
