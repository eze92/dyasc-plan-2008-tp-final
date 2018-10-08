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

		String etiqueta = this.componenteActual.substring(0, 2);

		if (etiqueta.equals("* ")) {

			int posicionActual = getContenidoOriginal().indexOf(componenteActual);
			String lineaSiguiente = getContenidoOriginal().get(posicionActual + 1);

			String textoComponente = this.componenteActual.substring(2);
			String nuevoContenido = "<ul><li>" + textoComponente + "</li></ul>";

			if (lineaSiguiente.contains("*")) {
				nuevoContenido = "<ul><li>" + textoComponente + "</li>";
			}

			agregarNuevoContenido(nuevoContenido);
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}
}
