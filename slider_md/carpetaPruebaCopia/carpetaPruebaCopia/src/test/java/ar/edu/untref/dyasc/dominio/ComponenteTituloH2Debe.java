package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComponenteTituloH2Debe {

	private static final String COMPONENTE_H2 = "## Titulo h2";
	private static final String OTRO_COMPONENTE_H2 = "## Otro titulo h2";
	private static final String COMPONENTE_IMAGEN = "i:imagen.png";

	@Mock
	Imagen componenteImagen;

	private TituloH2 componenteH2;
	private Contexto contexto;

	@Before
	public void inicializar() {
		contexto = new Contexto();
	}

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_h2_con_el_texto_correspondiente() {

		contexto.setExpresionActual(COMPONENTE_H2);
		componenteH2 = new TituloH2(null);
		componenteH2.setContexto(contexto);

		componenteH2.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "<h2>Titulo h2</h2>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_h2_para_un_componente_con_diferente_texto() {

		contexto.setExpresionActual(OTRO_COMPONENTE_H2);
		componenteH2 = new TituloH2(null);
		componenteH2.setContexto(contexto);

		componenteH2.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "<h2>Otro titulo h2</h2>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void verificar_que_se_llama_a_otro_componente_cuando_la_etiqueta_no_corresponde_a_h2() {

		contexto.setExpresionActual(COMPONENTE_IMAGEN);
		componenteH2 = new TituloH2(componenteImagen);
		componenteH2.setContexto(contexto);

		componenteH2.parsearMarkdown();

		Mockito.verify(componenteImagen).parsearMarkdown();
	}
}
