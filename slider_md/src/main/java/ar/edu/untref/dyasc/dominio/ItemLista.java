package ar.edu.untref.dyasc.dominio;

public class ItemLista extends Componente {

	private Componente siguienteComponente;
	private String componenteActual;

	public ItemLista(Componente siguienteComponente, String componenteActual) {
		super(siguienteComponente, componenteActual);

		this.siguienteComponente = siguienteComponente;
		this.componenteActual = componenteActual;
	}

	@Override
	void parsearMarkdown() {
		String textoComponente = this.componenteActual.substring(2);
		String nuevoContenido = "<ul><li>" + textoComponente + "</li></ul>";
		agregarNuevoContenido(nuevoContenido);
	}
}
