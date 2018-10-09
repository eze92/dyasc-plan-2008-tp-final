package ar.edu.untref.dyasc.dominio;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
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

	@Mock Seccion componenteSeccion;

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_lista_con_un_solo_item() {

		List<String> contenidoOriginal = new LinkedList<>();
		contenidoOriginal.add(ITEM_LISTA);
		contenidoOriginal.add(COMPONENTE_SECCION);

		ItemLista componenteItemLista = new ItemLista(null, ITEM_LISTA);
		componenteItemLista.setContenidoOriginal(contenidoOriginal);
		componenteItemLista.parsearMarkdown();

		String obtenido = componenteItemLista.getNuevoContenido();

		String esperado = "<ul>" +
							"<li>Item 1</li>" +
						  "</ul>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_lista_con_un_solo_item_y_diferente_contenido() {

		List<String> contenidoOriginal = new LinkedList<>();
		contenidoOriginal.add(ITEM_LISTA_2);
		contenidoOriginal.add(COMPONENTE_SECCION);

		ItemLista componenteItemLista = new ItemLista(null, ITEM_LISTA_2);
		componenteItemLista.setContenidoOriginal(contenidoOriginal);
		componenteItemLista.parsearMarkdown();

		String obtenido = componenteItemLista.getNuevoContenido();

		String esperado = "<ul>" +
							"<li>Item 2</li>" +
						  "</ul>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_inicial_de_la_lista_cuando_hay_mas_de_un_item_de_lista() {

		List<String> contenidoOriginal = new LinkedList<>();
		contenidoOriginal.add(ITEM_LISTA);
		contenidoOriginal.add(ITEM_LISTA_2);
		contenidoOriginal.add(COMPONENTE_SECCION);

		ItemLista componenteItemLista = new ItemLista(null, ITEM_LISTA);
		componenteItemLista.setContenidoOriginal(contenidoOriginal);
		componenteItemLista.parsearMarkdown();

		String obtenido = componenteItemLista.getNuevoContenido();

		String esperado = "<ul>" +
							"<li>Item 1</li>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_final_de_la_lista_cuando_hay_dos_items_de_lista() {

		List<String> contenidoOriginal = new LinkedList<>();
		contenidoOriginal.add(ITEM_LISTA);
		contenidoOriginal.add(ITEM_LISTA_2);
		contenidoOriginal.add(COMPONENTE_SECCION);

		ItemLista componenteItemLista = new ItemLista(null, ITEM_LISTA_2);
		componenteItemLista.setContenidoOriginal(contenidoOriginal);
		componenteItemLista.parsearMarkdown();

		String obtenido = componenteItemLista.getNuevoContenido();

		String esperado = "<li>Item 2</li>" +
						"</ul>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_intermedia_cuando_hay_mas_de_dos_items_de_lista() {

		List<String> contenidoOriginal = new LinkedList<>();
		contenidoOriginal.add(ITEM_LISTA);
		contenidoOriginal.add(ITEM_LISTA_2);
		contenidoOriginal.add(ITEM_LISTA_3);
		contenidoOriginal.add(COMPONENTE_SECCION);

		ItemLista componenteItemLista = new ItemLista(null, ITEM_LISTA_2);
		componenteItemLista.setContenidoOriginal(contenidoOriginal);
		componenteItemLista.parsearMarkdown();

		String obtenido = componenteItemLista.getNuevoContenido();

		String esperado = "<li>Item 2</li>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void verificar_que_se_llama_a_otro_componente_cuando_la_etiqueta_no_corresponde_a_un_item_de_lista() {

		ItemLista componenteItemLista = new ItemLista(componenteSeccion, COMPONENTE_SECCION);
		componenteItemLista.parsearMarkdown();

		Mockito.verify(componenteSeccion).parsearMarkdown();
	}
}
