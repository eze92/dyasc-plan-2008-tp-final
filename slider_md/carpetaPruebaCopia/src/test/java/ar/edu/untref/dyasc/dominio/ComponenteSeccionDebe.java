package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComponenteSeccionDebe {

	private static final String COMPONENTE_SECCION = "---";
	private static final String COMPONENTE_H1 = "# Titulo h1";

	private Contexto contexto;

	@Mock
	TituloH1 componenteH1;

	@Before
	public void inicializar() {
		contexto = new Contexto();
	}

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_seccion_cuando_solo_contiene_una_seccion() {

		String[] contenidoOriginal = { COMPONENTE_SECCION };
		contexto.setContenidoOriginal(contenidoOriginal);
		contexto.setExpresionActual(COMPONENTE_SECCION);

		Seccion seccion = new Seccion(componenteH1);
		seccion.setContexto(contexto);
		seccion.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "<section></section>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_de_inicio_seccion_cuando_la_seccion_incluye_a_otro_componente() {

		String[] contenidoOriginal = { COMPONENTE_SECCION, COMPONENTE_H1 };
		contexto.setContenidoOriginal(contenidoOriginal);
		contexto.setExpresionActual(COMPONENTE_SECCION);

		Seccion seccion = new Seccion(componenteH1);
		seccion.setContexto(contexto);
		seccion.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "<section>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_de_finalizacion_e_inicio_de_seccion_cuando_se_incluyen_dos_etiquetas_de_seccion() {

		String[] contenidoOriginal = { COMPONENTE_H1, COMPONENTE_SECCION, COMPONENTE_H1 };
		contexto.setContenidoOriginal(contenidoOriginal);
		contexto.seccionAbierta(true);
		contexto.setExpresionActual(COMPONENTE_SECCION);

		Seccion seccion = new Seccion(componenteH1);
		seccion.setContexto(contexto);
		seccion.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "</section><section>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void verificar_que_se_llama_a_otro_componente_cuando_la_etiqueta_no_corresponde_a_una_seccion() {

		String[] contenidoOriginal = { COMPONENTE_H1, COMPONENTE_H1 };
		contexto.setContenidoOriginal(contenidoOriginal);
		contexto.setExpresionActual(COMPONENTE_H1);

		Seccion seccion = new Seccion(componenteH1);
		seccion.setContexto(contexto);
		seccion.parsearMarkdown();

		Mockito.verify(componenteH1).parsearMarkdown();
	}
}
