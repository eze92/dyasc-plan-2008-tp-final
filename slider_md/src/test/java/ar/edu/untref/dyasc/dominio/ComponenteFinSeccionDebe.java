package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Test;

public class ComponenteFinSeccionDebe {

	private static final String COMPONENTE_FINALIZACION = "FIN";

	private Contexto contexto = new Contexto();

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_de_finalizacion_de_seccion() {

		String[] contenidoOriginal = { COMPONENTE_FINALIZACION };
		contexto.setContenidoOriginal(contenidoOriginal);
		contexto.seccionAbierta(true);

		FinSeccion seccion = new FinSeccion(null, COMPONENTE_FINALIZACION, contexto);
		seccion.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "</section>";
		Assert.assertEquals(esperado, obtenido);
	}

}
