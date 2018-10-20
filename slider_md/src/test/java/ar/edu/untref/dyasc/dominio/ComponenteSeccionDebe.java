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
	public void agregarAlNuevoContenidoLaEtiquetaSeccionCuandoSoloContieneUnaSeccion() {

		String[] contenidoOriginal = { COMPONENTE_SECCION };
		contexto.setContenidoOriginal(contenidoOriginal);
		contexto.setExpresionActual(COMPONENTE_SECCION);

		Seccion seccion = new Seccion(componenteH1);
		seccion.setContexto(contexto);
		seccion.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "<section></section>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregarAlNuevoContenidoLaEtiquetaDeInicioSeccionCuandoLaSeccionIncluyeAOtroComponente() {

		String[] contenidoOriginal = { COMPONENTE_SECCION, COMPONENTE_H1 };
		contexto.setContenidoOriginal(contenidoOriginal);
		contexto.setExpresionActual(COMPONENTE_SECCION);

		Seccion seccion = new Seccion(componenteH1);
		seccion.setContexto(contexto);
		seccion.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "<section>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void agregarAlNuevoContenidoLaEtiquetaDeFinalizacionEInicioDeSeccionCuandoSeIncluyenDosEtiquetasDeSeccion() {

		String[] contenidoOriginal = { COMPONENTE_H1, COMPONENTE_SECCION, COMPONENTE_H1 };
		contexto.setContenidoOriginal(contenidoOriginal);
		contexto.seccionAbierta(true);
		contexto.setExpresionActual(COMPONENTE_SECCION);

		Seccion seccion = new Seccion(componenteH1);
		seccion.setContexto(contexto);
		seccion.parsearMarkdown();

		String obtenido = contexto.getNuevoContenido();

		String esperado = "</section><section>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void verificarQueSeLlamaAOtroComponenteCuandoLaEtiquetaNoCorrespondeAUnaSeccion() {

		String[] contenidoOriginal = { COMPONENTE_H1, COMPONENTE_H1 };
		contexto.setContenidoOriginal(contenidoOriginal);
		contexto.setExpresionActual(COMPONENTE_H1);

		Seccion seccion = new Seccion(componenteH1);
		seccion.setContexto(contexto);
		seccion.parsearMarkdown();

		Mockito.verify(componenteH1).parsearMarkdown();
	}
}
