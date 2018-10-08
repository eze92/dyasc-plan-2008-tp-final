package ar.edu.untref.dyasc.dominio;

public class Imagen extends Componente {

	private String componenteActual;
	private Componente siguienteComponente;

	public Imagen(Componente siguienteComponente, String componenteActual) {
		super(siguienteComponente, componenteActual);

		this.siguienteComponente = siguienteComponente;
		this.componenteActual = componenteActual;
	}

	@Override
	void parsearMarkdown() {

		String etiqueta = this.componenteActual.substring(0, 2);

		if (etiqueta.equals("i:")) {
			String textoComponente = this.componenteActual.substring(2);
			String nuevoContenido = "<img src=\"" + textoComponente + "\"/>";
			agregarNuevoContenido(nuevoContenido);
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}
}
