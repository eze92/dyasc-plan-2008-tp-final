package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Test;

public class ComponenteItemListaDebe {

	private static final String ITEM_LISTA = "* Item 1";
	private static final String ITEM_LISTA_2 = "* Item 2";

	private ItemLista componenteItemLista;

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_lista_con_un_solo_item() {

		componenteItemLista = new ItemLista(null, ITEM_LISTA);
		componenteItemLista.parsearMarkdown();

		String obtenido = componenteItemLista.getNuevoContenido();

		String esperado = "<ul>" + 
							"<li>Item 1</li>" + 
						  "</ul>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_lista_con_un_solo_item_y_diferente_contenido() {

		componenteItemLista = new ItemLista(null, ITEM_LISTA_2);
		componenteItemLista.parsearMarkdown();

		String obtenido = componenteItemLista.getNuevoContenido();

		String esperado = "<ul>" + 
							"<li>Item 2</li>" + 
						  "</ul>";
		Assert.assertEquals(esperado, obtenido);
	}
}
