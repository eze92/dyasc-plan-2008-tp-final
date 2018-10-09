package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Test;

public class ComponenteSeccionDebe {

	private static final String COMPONENTE_SOLO_SECCION = "---";

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_seccion_cuando_solo_contiene_una_seccion() {

		Seccion seccion = new Seccion(null, COMPONENTE_SOLO_SECCION);
		seccion.parsearMarkdown();

		String obtenido = seccion.getNuevoContenido();

		String esperado = "<section></section>";
		Assert.assertEquals(esperado, obtenido);
	}
}
