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
public class ComponenteSeccionDebe {

	private static final String COMPONENTE_SECCION = "---";
	private static final String COMPONENTE_H1 = "# Titulo h1";
	private static final String COMPONENTE_SECCION_2 = "---";

	@Mock
	TituloH1 componenteH1;

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_seccion_cuando_solo_contiene_una_seccion() {

		List<String> contenidoOriginal = new LinkedList<>();
		contenidoOriginal.add(COMPONENTE_SECCION);

		Seccion seccion = new Seccion(componenteH1, COMPONENTE_SECCION);
		seccion.setContenidoOriginal(contenidoOriginal);
		seccion.parsearMarkdown();

		String obtenido = seccion.getNuevoContenido();

		String esperado = "<section></section>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_de_inicio_seccion_cuando_la_seccion_incluye_a_otro_componente() {

		List<String> contenidoOriginal = new LinkedList<>();
		contenidoOriginal.add(COMPONENTE_SECCION);
		contenidoOriginal.add(COMPONENTE_H1);

		Seccion seccion = new Seccion(componenteH1, COMPONENTE_SECCION);
		seccion.setContenidoOriginal(contenidoOriginal);
		seccion.parsearMarkdown();

		String obtenido = seccion.getNuevoContenido();

		String esperado = "<section>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_de_finalizacion_e_inicio_de_seccion_cuando_se_incluyen_dos_etiquetas_de_seccion() {

		List<String> contenidoOriginal = new LinkedList<>();
		contenidoOriginal.add(COMPONENTE_SECCION);
		contenidoOriginal.add(COMPONENTE_H1);
		contenidoOriginal.add(COMPONENTE_SECCION_2);
		contenidoOriginal.add(COMPONENTE_H1);

		Seccion seccion = new Seccion(componenteH1, COMPONENTE_SECCION_2);
		seccion.setContenidoOriginal(contenidoOriginal);
		seccion.parsearMarkdown();

		String obtenido = seccion.getNuevoContenido();

		String esperado = "</section><section>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void verificar_que_se_llama_a_otro_componente_cuando_la_etiqueta_no_corresponde_a_una_seccion() {

		List<String> contenidoOriginal = new LinkedList<>();
		contenidoOriginal.add(COMPONENTE_H1);
		contenidoOriginal.add(COMPONENTE_H1);

		Seccion componenteSeccion = new Seccion(componenteH1, COMPONENTE_H1);
		componenteSeccion.setContenidoOriginal(contenidoOriginal);
		componenteSeccion.parsearMarkdown();

		Mockito.verify(componenteH1).parsearMarkdown();
	}
}
