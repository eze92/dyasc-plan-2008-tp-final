package ar.edu.untref.dyasc.dominio;

public class ItemLista extends Componente {

	private static final String CIERRE_LISTA = "</ul>\n";
	private static final String INICIO_LISTA = "<ul>\n";

	private Componente siguienteComponente;

	public ItemLista(Componente siguienteComponente) {
		super(siguienteComponente);
		this.siguienteComponente = siguienteComponente;
	}

	@Override
	void parsearMarkdown() {

		if (getContexto().getExpresionActual().startsWith("*")) {

			String nuevoContenido = "";

			if (!getContexto().hayListaAbierta()) {
				nuevoContenido = INICIO_LISTA;
				getContexto().listaAbierta(true);
			}

			nuevoContenido += agregarItemLista();

			if (getContexto().hayListaAbierta()) {
				nuevoContenido += agregarFinLista();
			}

			getContexto().agregarNuevoContenido(nuevoContenido);
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}

	private String agregarItemLista() {
		String textoComponente = getContexto().getExpresionActual().substring(2);
		String itemLista = "<li>" + textoComponente + "</li>\n";
		return itemLista;
	}

	private String agregarFinLista() {

		boolean siguienteEsTipoLista = getContexto().getContenidoOriginal()[getContexto().getPosicionActual() + 1]
				.startsWith("*");
		if (!siguienteEsTipoLista) {
			getContexto().listaAbierta(false);
			return CIERRE_LISTA;
		}

		return "";
	}
}
