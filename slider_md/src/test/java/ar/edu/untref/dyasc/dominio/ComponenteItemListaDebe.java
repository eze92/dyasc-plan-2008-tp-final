package ar.edu.untref.dyasc.dominio;

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
	private static final String COMPONENTE_SECCION = "---";

	@Mock Seccion componenteSeccion;

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

	@Test
	public void verificar_que_se_llama_a_otro_componente_cuando_la_etiqueta_no_corresponde_a_un_item_de_lista() {

		componenteItemLista = new ItemLista(componenteSeccion, COMPONENTE_SECCION);
		componenteItemLista.parsearMarkdown();

		Mockito.verify(componenteSeccion).parsearMarkdown();
	}
}
