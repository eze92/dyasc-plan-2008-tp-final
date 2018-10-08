package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
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

	@Mock ItemLista componenteLista;

	private Imagen componenteImagen;

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_imagen_con_el_nombre_correspondiente() {

		componenteImagen = new Imagen(null, COMPONENTE_IMAGEN);
		componenteImagen.parsearMarkdown();

		String obtenido = componenteImagen.getNuevoContenido();

		String esperado = "<img src=\"imagen.png\"/>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_imagen_para_un_componente_con_diferente_texto() {

		componenteImagen = new Imagen(null, OTRO_COMPONENTE_IMAGEN);
		componenteImagen.parsearMarkdown();

		String obtenido = componenteImagen.getNuevoContenido();

		String esperado = "<img src=\"otra_imagen.png\"/>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void verificar_que_se_llama_a_otro_componente_cuando_la_etiqueta_no_corresponde_a_h1() {

		componenteImagen = new Imagen(componenteLista, COMPONENTE_LISTA);
		componenteImagen.parsearMarkdown();

		Mockito.verify(componenteLista).parsearMarkdown();
	}
}
