package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServicioProgramaDebe {

	private static final String SECCION = "---";
	private static final String H1 = "# titulo";
	private static final String FIN = "FIN";

	private static final String ARCHIVO = "---\n# titulo";

	private Contexto contexto;
	private ServicioPrograma servicioEntrada;

	@Before
	public void inicializar() {

		contexto = new Contexto();

		servicioEntrada = new ServicioPrograma(contexto);
		servicioEntrada.crearContenido(ARCHIVO);
	}

	@Test
	public void separarElContenidoEnUnArrayMedianteElSaltoDeLinea() {

		String[] obtenido = contexto.getContenidoOriginal();

		String[] esperado = { SECCION, H1, FIN };
		Assert.assertArrayEquals(esperado, obtenido);
	}

	@Test
	public void generarLaSalidaEnFormatoString() {

		String obtenido = servicioEntrada.obtenerSalida();

		String esperado = "<section>\n" + "<h1>titulo</h1>\n" + "</section>";
		Assert.assertEquals(esperado, obtenido);
	}
}
