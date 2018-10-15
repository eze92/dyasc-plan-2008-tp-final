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
	public void separar_el_contenido_en_un_array_mediante_el_salto_de_linea() {

		String[] obtenido = contexto.getContenidoOriginal();

		String[] esperado = { SECCION, H1, FIN };
		Assert.assertArrayEquals(esperado, obtenido);
	}

	@Test
	public void generar_la_salida_en_formato_string() {

		String obtenido = servicioEntrada.obtenerSalida();

		String esperado = "<section>" + "<h1>titulo</h1>" + "</section>";
		Assert.assertEquals(esperado, obtenido);
	}
}
