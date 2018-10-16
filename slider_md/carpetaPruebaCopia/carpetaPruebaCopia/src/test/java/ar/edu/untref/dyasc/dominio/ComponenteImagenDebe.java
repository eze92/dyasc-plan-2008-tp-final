package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComponenteImagenDebe {

	private static final String COMPONENTE_IMAGEN = "i:imagen.png";
	private static final String OTRO_COMPONENTE_IMAGEN = "i:otra_imagen.png";
	private static final String COMPONENTE_LISTA = "* Item 1";

	@Mock
	ItemLista componenteLista;

	private Imagen componenteImagen;
	private Contexto contexto;

	@Before
	public void inicializar() {
		contexto = new Contexto();
	}

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_imagen_con_el_nombre_correspondiente() {

		contexto.setExpresionActual(COMPONENTE_IMAGEN);
		componenteImagen = new Imagen(null);
		componenteImagen.setContexto(contexto);
		componenteImagen.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "<img src=\"imagen.png\"/>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_imagen_para_un_componente_con_diferente_texto() {

		contexto.setExpresionActual(OTRO_COMPONENTE_IMAGEN);
		componenteImagen = new Imagen(null);
		componenteImagen.setContexto(contexto);
		componenteImagen.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "<img src=\"otra_imagen.png\"/>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void verificar_que_se_llama_a_otro_componente_cuando_la_etiqueta_no_corresponde_a_h1() {

		contexto.setExpresionActual(COMPONENTE_LISTA);
		componenteImagen = new Imagen(componenteLista);
		componenteImagen.setContexto(contexto);
		componenteImagen.parsearMarkdown();

		Mockito.verify(componenteLista).parsearMarkdown();
	}
}
