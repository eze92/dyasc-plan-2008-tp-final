package ar.edu.untref.dyasc.dominio;

public class ItemLista extends Componente {

	private Componente siguienteComponente;
	private String componenteActual;
	private Lista lista;

	public ItemLista(Componente siguienteComponente, String componenteActual, Lista lista) {
		super(siguienteComponente, componenteActual);

		this.siguienteComponente = siguienteComponente;
		this.componenteActual = componenteActual;
		this.lista = lista;
	}

	@Override
	void parsearMarkdown() {

		if (this.componenteActual.startsWith("*")) {

			String nuevoContenido = lista.crearInicio(); // Agrega <ul>
			nuevoContenido += agregarItemLista(); // Agrega <li>Item</li>
			nuevoContenido += agregarFinLista(); // Agrega </ul>

			agregarNuevoContenido(nuevoContenido);
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}

	private String agregarFinLista() {

		int posicionActual = getContenidoOriginal().indexOf(componenteActual);

		boolean dentroDelRangoSuperior = posicionActual + 1 <= getContenidoOriginal().size();
		if (dentroDelRangoSuperior) {

			boolean siguienteTipoLista = getContenidoOriginal().get(posicionActual + 1).startsWith("*");
			if (!siguienteTipoLista) {
				return lista.crearFin();
			}
		} else {
			return lista.crearFin();
		}
		return "";
	}

	private String agregarItemLista() {
		String textoComponente = this.componenteActual.substring(2);
		String itemLista = "<li>" + textoComponente + "</li>";
		return itemLista;
	}
}
