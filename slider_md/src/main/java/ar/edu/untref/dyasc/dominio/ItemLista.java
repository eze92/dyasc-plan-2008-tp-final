package ar.edu.untref.dyasc.dominio;

public class ItemLista extends Componente {

	private static final String CIERRE_LISTA = "</ul>";
	private static final String INICIO_LISTA = "<ul>";

	private Componente siguienteComponente;
	private Contexto contexto;

	public ItemLista(Componente siguienteComponente, Contexto contexto) {
		super(siguienteComponente, contexto);

		this.siguienteComponente = siguienteComponente;
		this.contexto = contexto;
	}

	@Override
	void parsearMarkdown() {

		if (contexto.getExpresionActual().startsWith("*")) {

			String nuevoContenido = "";

			if (!contexto.hayListaAbierta()) {
				nuevoContenido = INICIO_LISTA;
				contexto.listaAbierta(true);
			}

			nuevoContenido += agregarItemLista();

			if (contexto.hayListaAbierta()) {
				nuevoContenido += agregarFinLista();
				contexto.listaAbierta(false);
			}

			contexto.agregarNuevoContenido(nuevoContenido);
		} else {
			this.siguienteComponente.parsearMarkdown();
		}
	}

	private String agregarItemLista() {
		String textoComponente = contexto.getExpresionActual().substring(2);
		String itemLista = "<li>" + textoComponente + "</li>";
		return itemLista;
	}

	private String agregarFinLista() {

		boolean dentroDelRangoSuperior = contexto.getPosicionActual() + 1 <= contexto.getContenidoOriginal().length;
		if (dentroDelRangoSuperior) {

			boolean siguienteEsTipoLista = contexto.getContenidoOriginal()[contexto.getPosicionActual() + 1].startsWith("*");
			if (!siguienteEsTipoLista) {
				return CIERRE_LISTA;
			}
		} else {
			return CIERRE_LISTA;
		}

		return "";
	}
}
