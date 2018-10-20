package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Test;

public class ComponenteFinSeccionDebe {

	private static final String COMPONENTE_FINALIZACION = "FIN";

	private Contexto contexto = new Contexto();

	@Test
	public void agregarAlNuevoContenidoLaEtiquetaDeFinalizacionDeSeccion() {

		String[] contenidoOriginal = { COMPONENTE_FINALIZACION };
		contexto.setContenidoOriginal(contenidoOriginal);
		contexto.seccionAbierta(true);
		contexto.setExpresionActual(COMPONENTE_FINALIZACION);

		FinSeccion finSeccion = new FinSeccion(null);
		finSeccion.setContexto(contexto);
		finSeccion.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "</section>";
		Assert.assertEquals(esperado, obtenido);
	}

}
