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
		
		FinSeccion finSeccion = new FinSeccion(null, contexto);
		Imagen imagen = new Imagen(finSeccion, contexto);
		ItemLista lista = new ItemLista(imagen, contexto);
		TituloH2 tituloH2 = new TituloH2(lista, contexto);
		TituloH1 tituloH1 = new TituloH1(tituloH2, contexto);
		Seccion seccion = new Seccion(tituloH1, contexto);

		String[] contenidoOriginal = contexto.getContenidoOriginal();

		for (int i = 0; i < contenidoOriginal.length; i++) {
			contexto.setExpresionActual(contenidoOriginal[i]);
			seccion.parsearMarkdown();
		}
		return contexto.getNuevoContenido();
	}
}
