package ar.edu.untref.dyasc.dominio;

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

	@Mock
	TituloH1 componenteH1;

	@Test
	public void agregar_al_nuevo_contenido_la_etiqueta_seccion_cuando_solo_contiene_una_seccion() {

		Seccion seccion = new Seccion(null, COMPONENTE_SECCION);
		seccion.parsearMarkdown();

		String obtenido = seccion.getNuevoContenido();

		String esperado = "<section></section>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void verificar_que_se_llama_a_otro_componente_cuando_la_etiqueta_no_corresponde_a_una_seccion() {

		Seccion componenteSeccion = new Seccion(componenteH1, COMPONENTE_H1);
		componenteSeccion.parsearMarkdown();

		Mockito.verify(componenteH1).parsearMarkdown();
	}
}
