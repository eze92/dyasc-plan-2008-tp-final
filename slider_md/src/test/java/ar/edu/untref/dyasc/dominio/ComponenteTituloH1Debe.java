package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Test;

public class ComponenteTituloH1Debe {

	private static final String COMPONETE_H1 = "# Texto h1";
	private static final String OTRO_COMPONETE_H1 = "# Otro texto h1";

	private Componente componenteH1;

	@Test
	public void devolver_la_etiqueta_h1_con_el_texto_correspondiente() {

		componenteH1 = new TituloH1(null, COMPONETE_H1);

		String obtenido = componenteH1.parsearMarkdown();
		String esperado = "<h1>Texto h1</h1>";

		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void devolver_la_etiqueta_h1_para_un_componente_con_diferente_texto() {

		componenteH1 = new TituloH1(null, OTRO_COMPONETE_H1);

		String obtenido = componenteH1.parsearMarkdown();
		String esperado = "<h1>Otro texto h1</h1>";

		Assert.assertEquals(esperado, obtenido);
	}
}
