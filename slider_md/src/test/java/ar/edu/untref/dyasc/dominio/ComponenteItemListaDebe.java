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
	public void agregar_al_nuevo_contenido_la_etiqueta_lista_con_un_solo_item() {

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
	public void agregar_al_nuevo_contenido_la_etiqueta_lista_con_un_solo_item_y_diferente_contenido() {

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
	public void agregar_al_nuevo_contenido_la_etiqueta_inicial_de_la_lista_cuando_hay_mas_de_un_item_de_lista() {

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
	public void agregar_al_nuevo_contenido_la_etiqueta_final_de_la_lista_cuando_hay_dos_items_de_lista() {

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
	public void agregar_al_nuevo_contenido_la_etiqueta_intermedia_cuando_hay_mas_de_dos_items_de_lista() {

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
	public void verificar_que_se_llama_a_otro_componente_cuando_la_etiqueta_no_corresponde_a_un_item_de_lista() {

		contexto.setExpresionActual(COMPONENTE_SECCION);
		ItemLista componenteItemLista = new ItemLista(componenteSeccion);
		componenteItemLista.setContexto(contexto);
		componenteItemLista.parsearMarkdown();

		Mockito.verify(componenteSeccion).parsearMarkdown();
	}
}
