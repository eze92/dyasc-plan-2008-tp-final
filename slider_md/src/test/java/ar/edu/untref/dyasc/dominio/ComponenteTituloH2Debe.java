package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Test;

public class ComponenteTituloH2Debe {

	private static final String COMPONENTE_H2 = "## Titulo h2";

	private TituloH2 componenteH2;

	@Test
	public void devolver_la_etiqueta_h2_con_el_texto_correspondiente() {

		componenteH2 = new TituloH2(null, COMPONENTE_H2);
		componenteH2.parsearMarkdown();

		String obtenido = componenteH2.getNuevoContenido();

		String esperado = "<h2>Titulo h2</h2>";
		Assert.assertEquals(esperado, obtenido);
	}
}
