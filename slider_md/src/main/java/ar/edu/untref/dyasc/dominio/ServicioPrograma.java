package ar.edu.untref.dyasc.dominio;

public class ServicioPrograma {

	private static final String EXPRESION_FINAL = "\nFIN";
	private Contexto contexto;

	public ServicioPrograma(Contexto contexto) {
		this.contexto = contexto;
	}

	public void crearContenido(String documento) {

		documento += EXPRESION_FINAL;

		String[] contenidoOriginal = documento.split("\n");
		contexto.setContenidoOriginal(contenidoOriginal);
	}

	public String obtenerSalida() {

		FinSeccion finSeccion = new FinSeccion(null);
		Imagen imagen = new Imagen(finSeccion);
		ItemLista lista = new ItemLista(imagen);
		TituloH2 h2 = new TituloH2(lista);
		TituloH1 h1 = new TituloH1(h2);
		Seccion seccion = new Seccion(h1);
		seccion.setContexto(contexto);

		String[] contenidoOriginal = contexto.getContenidoOriginal();

		for (int i = 0; i < contenidoOriginal.length; i++) {
			contexto.setPosicionActual(i);
			contexto.setExpresionActual(contenidoOriginal[i]);
			seccion.parsearMarkdown();
		}
		return contexto.getNuevoContenido();
	}
}
