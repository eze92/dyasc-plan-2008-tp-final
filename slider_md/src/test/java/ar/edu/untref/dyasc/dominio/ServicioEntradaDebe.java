package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServicioEntradaDebe {

	private static final String SECCION = "---";
	private static final String H1 = "# h1";

	private static final String ARCHIVO = "---\n# h1";

	private Contexto contexto;
	private ServicioEntrada servicioEntrada;

	@Before
	public void inicializar() {
		contexto = new Contexto();
		servicioEntrada = new ServicioEntrada(contexto);
	}

	@Test
	public void separar_el_contenido_en_un_array_mediante_el_salto_de_linea() {

		servicioEntrada.crearContenido(ARCHIVO);

		String[] obtenido = contexto.getContenidoOriginal();

		String[] esperado = { SECCION, H1 };
		Assert.assertArrayEquals(esperado, obtenido);
	}
}
