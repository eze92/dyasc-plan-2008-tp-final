package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServicioEntradaDebe {

	private static final String SECCION = "---";
	private static final String H1 = "# titulo";
	private static final String FIN = "FIN";

	private static final String ARCHIVO = "---\n# titulo";

	private Contexto contexto;
	private ServicioEntrada servicioEntrada;

	private Componente seccion;

	@Before
	public void inicializar() {

		contexto = new Contexto();

		servicioEntrada = new ServicioEntrada(contexto);
		servicioEntrada.crearContenido(ARCHIVO);

		FinSeccion finSeccion = new FinSeccion(null, contexto);
		Imagen imagen = new Imagen(finSeccion, contexto);
		ItemLista lista = new ItemLista(imagen, contexto);
		TituloH2 tituloH2 = new TituloH2(lista, contexto);
		TituloH1 tituloH1 = new TituloH1(tituloH2, contexto);
		seccion = new Seccion(tituloH1, contexto);
	}

	@Test
	public void separar_el_contenido_en_un_array_mediante_el_salto_de_linea() {

		String[] obtenido = contexto.getContenidoOriginal();

		String[] esperado = { SECCION, H1, FIN };
		Assert.assertArrayEquals(esperado, obtenido);
	}

	@Test
	public void generar_la_salida_en_formato_string() {

		String obtenido = servicioEntrada.obtenerSalida(seccion);

		String esperado = "<section>" + "<h1>titulo</h1>" + "</section>";
		Assert.assertEquals(esperado, obtenido);
	}
}
