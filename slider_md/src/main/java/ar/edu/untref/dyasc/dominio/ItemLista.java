package ar.edu.untref.dyasc.dominio;

public class ItemLista extends Componente {

	private static final String CIERRE_LISTA = "</ul>";
	private static final String INICIO_LISTA = "<ul>";

	private Componente siguienteComponente;
	private String componenteActual;
	private Contexto contexto;
	private int posicionActual;

	public ItemLista(Componente siguienteComponente, String componenteActual, Contexto contexto, int posicionActual) {
		super(siguienteComponente, componenteActual, contexto);

		this.siguienteComponente = siguienteComponente;
		this.componenteActual = componenteActual;
		this.contexto = contexto;
		this.posicionActual = posicionActual;
	}

	@Override
	void parsearMarkdown() {

		if (this.componenteActual.startsWith("*")) {

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
		String textoComponente = this.componenteActual.substring(2);
		String itemLista = "<li>" + textoComponente + "</li>";
		return itemLista;
	}

	private String agregarFinLista() {

		boolean dentroDelRangoSuperior = posicionActual + 1 <= contexto.getContenidoOriginal().length;
		if (dentroDelRangoSuperior) {

			boolean siguienteEsTipoLista = contexto.getContenidoOriginal()[posicionActual + 1].startsWith("*");
			if (!siguienteEsTipoLista) {
				return CIERRE_LISTA;
			} else {
				return "";
			}
		} else {
			return CIERRE_LISTA;
		}
	}
}
