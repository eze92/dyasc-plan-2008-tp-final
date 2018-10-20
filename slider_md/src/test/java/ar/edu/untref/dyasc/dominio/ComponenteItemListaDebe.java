package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComponenteItemListaDebe {

	private static final String ITEM_LISTA = "* Item 1";
	private static final String ITEM_LISTA_2 = "* Item 2";
	private static final String ITEM_LISTA_3 = "* Item 3";
	private static final String COMPONENTE_SECCION = "---";

	@Mock
	Seccion componenteSeccion;

	private Contexto contexto;

	@Before
	public void inicializar() {
		contexto = new Contexto();
	}

	@Test
	public void agregarAlNuevoContenidoLaEtiquetaListaConUnSoloItem() {

		String[] contenidoOriginal = { ITEM_LISTA, COMPONENTE_SECCION };
		contexto.setContenidoOriginal(contenidoOriginal);
		contexto.setExpresionActual(ITEM_LISTA);
		contexto.setPosicionActual(0);

		ItemLista componenteItemLista = new ItemLista(null);
		componenteItemLista.setContexto(contexto);
		componenteItemLista.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "<ul>\n" + 
							"<li>Item 1</li>\n" + 
						  "</ul>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregarAlNuevoContenidoLaEtiquetaListaConUnSoloItemYDiferenteContenido() {

		String[] contenidoOriginal = { ITEM_LISTA_2, COMPONENTE_SECCION };
		contexto.setContenidoOriginal(contenidoOriginal);
		contexto.setExpresionActual(ITEM_LISTA_2);
		contexto.setPosicionActual(0);

		ItemLista componenteItemLista = new ItemLista(null);
		componenteItemLista.setContexto(contexto);
		componenteItemLista.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "<ul>\n" + 
							"<li>Item 2</li>\n" + 
						  "</ul>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregarAlNuevoContenidoLaEtiquetaInicialDeLaListaCuandoHayMasDeUnItemDeLista() {

		String[] contenidoOriginal = { ITEM_LISTA, ITEM_LISTA_2, COMPONENTE_SECCION };
		contexto.setContenidoOriginal(contenidoOriginal);
		contexto.setExpresionActual(ITEM_LISTA);
		contexto.setPosicionActual(0);

		ItemLista componenteItemLista = new ItemLista(null);
		componenteItemLista.setContexto(contexto);
		componenteItemLista.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "<ul>\n" + 
							"<li>Item 1</li>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregarAlNuevoContenidoLaEtiquetaFinalDeLaListaCuandoHayDosItemsDeLista() {

		String[] contenidoOriginal = { ITEM_LISTA, ITEM_LISTA_2, COMPONENTE_SECCION };
		contexto.setContenidoOriginal(contenidoOriginal);
		contexto.listaAbierta(true);
		contexto.setExpresionActual(ITEM_LISTA_2);
		contexto.setPosicionActual(1);

		ItemLista componenteItemLista = new ItemLista(null);
		componenteItemLista.setContexto(contexto);
		componenteItemLista.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "<li>Item 2</li>\n" + 
						"</ul>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregarAlNuevoContenidoLaEtiquetaIntermediaCuandoHayMasDeDosItemsDeLista() {

		String[] contenidoOriginal = { ITEM_LISTA, ITEM_LISTA_2, ITEM_LISTA_3, COMPONENTE_SECCION };
		contexto.setContenidoOriginal(contenidoOriginal);
		contexto.listaAbierta(true);
		contexto.setExpresionActual(ITEM_LISTA_2);
		contexto.setPosicionActual(1);

		ItemLista componenteItemLista = new ItemLista(null);
		componenteItemLista.setContexto(contexto);
		componenteItemLista.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "<li>Item 2</li>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void verificarQueSeLlamaAOtroComponenteCuandoLaEtiquetaNoCorrespondeAUnItemDeLista() {

		contexto.setExpresionActual(COMPONENTE_SECCION);
		ItemLista componenteItemLista = new ItemLista(componenteSeccion);
		componenteItemLista.setContexto(contexto);
		componenteItemLista.parsearMarkdown();

		Mockito.verify(componenteSeccion).parsearMarkdown();
	}
}
