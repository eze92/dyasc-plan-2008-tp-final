package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComponenteTituloH1Debe {

	private static final String COMPONENTE_H1 = "# Texto h1";
	private static final String OTRO_COMPONETE_H1 = "# Otro texto h1";
	private static final String COMPONENTE_H2 = "## Texto h2";

	@Mock Componente componenteH2;

	private Componente componenteH1;

	@Test
	public void devolver_la_etiqueta_h1_con_el_texto_correspondiente() {

		componenteH1 = new TituloH1(null, COMPONENTE_H1);

		componenteH1.parsearMarkdown();
		String obtenido = componenteH1.getNuevoContenido();

		String esperado = "<h1>Texto h1</h1>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void devolver_la_etiqueta_h1_para_un_componente_con_diferente_texto() {

		componenteH1 = new TituloH1(null, OTRO_COMPONETE_H1);

		componenteH1.parsearMarkdown();
		String obtenido = componenteH1.getNuevoContenido();

		String esperado = "<h1>Otro texto h1</h1>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void verificar_que_se_llama_a_otro_componente_cuando_la_etiqueta_no_corresponde_a_h1() {

		componenteH1 = new TituloH1(componenteH2, COMPONENTE_H2);
		componenteH1.parsearMarkdown();

		Mockito.verify(componenteH2).parsearMarkdown();
	}
}
