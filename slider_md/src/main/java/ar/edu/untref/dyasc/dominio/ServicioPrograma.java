package ar.edu.untref.dyasc.dominio;

public class ServicioEntrada {

	private static final String EXPRESION_FINAL = "\nFIN";
	private Contexto contexto;

	public ServicioEntrada(Contexto contexto) {
		this.contexto = contexto;
	}

	public void crearContenido(String documento) {

		documento += EXPRESION_FINAL;

		String[] contenidoOriginal = documento.split("\n");
		contexto.setContenidoOriginal(contenidoOriginal);
	}

	public String obtenerSalida(Componente componente) {

		String[] contenidoOriginal = contexto.getContenidoOriginal();

		for (int i = 0; i < contenidoOriginal.length; i++) {
			contexto.setExpresionActual(contenidoOriginal[i]);
			componente.parsearMarkdown();
		}
		return contexto.getNuevoContenido();
	}
}
