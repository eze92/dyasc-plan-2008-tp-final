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
	public void agregarAlNuevoContenidoLaEtiquetaImagenConElNombreCorrespondiente() {

		contexto.setExpresionActual(COMPONENTE_IMAGEN);
		componenteImagen = new Imagen(null);
		componenteImagen.setContexto(contexto);
		componenteImagen.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "<img src=\"imagen.png\"/>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregarAlNuevoContenidoLaEtiquetaImagenParaUnComponenteConDiferenteTexto() {

		contexto.setExpresionActual(OTRO_COMPONENTE_IMAGEN);
		componenteImagen = new Imagen(null);
		componenteImagen.setContexto(contexto);
		componenteImagen.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "<img src=\"otra_imagen.png\"/>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void verificarQueSeLlamaAOtroComponenteCuandoLaEtiquetaNoCorrespondeAH1() {

		contexto.setExpresionActual(COMPONENTE_LISTA);
		componenteImagen = new Imagen(componenteLista);
		componenteImagen.setContexto(contexto);
		componenteImagen.parsearMarkdown();

		Mockito.verify(componenteLista).parsearMarkdown();
	}
}
