package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TituloH1Debe {

	private static final String COMPONENTE_H1 = "# Texto h1";
	private static final String OTRO_COMPONENTE_H1 = "# Otro texto h1";
	private static final String COMPONENTE_H2 = "## Texto h2";

	@Mock
	Componente componenteH2;

	private Componente componenteH1;
	private Contexto contexto;

	@Before
	public void inicializar() {
		contexto = new Contexto();
	}

	@Test
	public void agregarAlNuevoContenidoLaEtiquetaH1ConElTextoCorrespondiente() {

		contexto.setExpresionActual(COMPONENTE_H1);
		componenteH1 = new TituloH1(null);
		componenteH1.setContexto(contexto);

		componenteH1.parsearMarkdown();
		String obtenido = contexto.getNuevoContenido();

		String esperado = "<h1>Texto h1</h1>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregarAlNuevoContenidoLaEtiquetaH1ParaUnComponenteConDiferenteTexto() {

		contexto.setExpresionActual(OTRO_COMPONENTE_H1);
		componenteH1 = new TituloH1(null);
		componenteH1.setContexto(contexto);

		componenteH1.parsearMarkdown();
		String obtenido = contexto.getNuevoContenido();

		String esperado = "<h1>Otro texto h1</h1>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void verificarQueSeLlamaAOtroComponenteCuandoLaEtiquetaNoCorrespondeAH1() {

		contexto.setExpresionActual(COMPONENTE_H2);
		componenteH1 = new TituloH1(componenteH2);
		componenteH1.setContexto(contexto);

		componenteH1.parsearMarkdown();

		Mockito.verify(componenteH2).parsearMarkdown();
	}
}
