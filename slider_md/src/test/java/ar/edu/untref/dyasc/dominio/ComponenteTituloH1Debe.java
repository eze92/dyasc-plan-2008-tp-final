package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComponenteTituloH1Debe {

	private static final String COMPONETE_H1 = "# Texto h1";

	private Componente componente;

	@Before
	public void inicializar() {
		componente = new TituloH1(COMPONETE_H1);
	}

	@Test
	public void devolver_la_etiqueta_correspondiente_al_componente_h1() {

		String obtenido = componente.parsearMarkdown();
		String esperado = "<h1>Texto h1</h1>";

		Assert.assertEquals(esperado, obtenido);
	}
}
