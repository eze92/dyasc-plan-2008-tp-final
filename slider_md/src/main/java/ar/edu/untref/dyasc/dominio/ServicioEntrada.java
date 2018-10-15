package ar.edu.untref.dyasc.dominio;

public class ServicioEntrada {

	private Contexto contexto;

	public ServicioEntrada(Contexto contexto) {
		this.contexto = contexto;
	}

	public void crearContenido(String documento) {

		String[] contenidoOriginal = documento.split("\n");
		contexto.setContenidoOriginal(contenidoOriginal);
	}
}
