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

		if (this.componenteActual.startsWith("*")) {

			String nuevoContenido = agregarInicioLista(); // Agrega <ul>
			nuevoContenido += agregarItemLista(); // Agrega <li>Item</li>
			nuevoContenido += agregarFinLista(); // Agrega </ul>

			agregarNuevoContenido(nuevoContenido);
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}

	private String agregarItemLista() {
		String textoComponente = this.componenteActual.substring(2);
		String itemLista = "<li>" + textoComponente + "</li>";
		return itemLista;
	}

	private String agregarInicioLista() {

		int posicionActual = getContenidoOriginal().indexOf(componenteActual);

		boolean dentroDelRangoInferior = posicionActual - 1 >= 0;
		if (dentroDelRangoInferior) {

			boolean anteriorEsTipoLista = getContenidoOriginal().get(posicionActual - 1).startsWith("*");
			if (!anteriorEsTipoLista) {
				return "<ul>";
			}
		} else {
			return "<ul>";
		}

		return "";
	}

	private String agregarFinLista() {

		int posicionActual = getContenidoOriginal().indexOf(componenteActual);

		boolean dentroDelRangoSuperior = posicionActual + 1 <= getContenidoOriginal().size();
		if (dentroDelRangoSuperior) {

			boolean siguienteEsTipoLista = getContenidoOriginal().get(posicionActual + 1).startsWith("*");
			if (!siguienteEsTipoLista) {
				return "</ul>";
			}
		} else {
			return "</ul>";
		}
		return "";
	}
}
