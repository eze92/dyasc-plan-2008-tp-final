package ar.edu.untref.dyasc.entrada;

import org.junit.Assert;
import org.junit.Test;

public class ParametrosEntradaDebe {

	private static final String MODO_DEFAULT = "--mode=default";
	private static final String MODO_SIN_SALIDA = "--mode=no-output";
	private static final String MODO_SALIDA = "--output=nombre_de_archivo";

	private static final String[] EJEMPLO_PREDETERMINADO = { MODO_DEFAULT, "ejemplo_valido.md" };
	private static final String[] EJEMPLO_PREDETERMINADO_SIN_EXTENSION = { MODO_DEFAULT, "ejemplo_valido" };
	private static final String[] EJEMPLO_CON_SALIDA = { MODO_SALIDA, "ejemplo_valido.md" };
	private static final String[] EJEMPLO_SIN_SALIDA = { MODO_SIN_SALIDA, "ejemplo_valido.md" };
	private static final String[] EJEMPLO_CON_SALIDA_SIN_ARCHIVO = { MODO_SALIDA };

	@Test
	public void obtener_el_nombre_del_archivo_cuando_los_parametros_son_validos() {

		Entrada entrada = new Entrada(EJEMPLO_PREDETERMINADO);

		String obtenido = entrada.nombreArchivo();

		String esperado = "ejemplo_valido.md";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void obtener_el_modo_predeterminado_cuando_el_parametro_es_default() throws ExepcionArchivoNoEncontrado {

		Entrada entrada = new Entrada(EJEMPLO_PREDETERMINADO);

		String obtenido = entrada.modo();

		String esperado = MODO_DEFAULT;
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void obtener_el_modo_salida_cuando_el_parametro_es_output() throws ExepcionArchivoNoEncontrado {

		Entrada entrada = new Entrada(EJEMPLO_CON_SALIDA);

		String obtenido = entrada.modo();

		String esperado = "--output";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void obtener_el_modo_pantalla_cuando_el_parametro_es_no_output() throws ExepcionArchivoNoEncontrado {

		Entrada entrada = new Entrada(EJEMPLO_SIN_SALIDA);

		String obtenido = entrada.modo();

		String esperado = MODO_SIN_SALIDA;
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void obtener_el_nombre_de_la_carpeta_para_el_modo_predeterminado() {

		Entrada entrada = new Entrada(EJEMPLO_PREDETERMINADO);

		String obtenido = entrada.nombreCarpeta();

		String esperado = "ejemplo_valido";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void obtener_el_nombre_de_la_carpeta_para_el_modo_predeterminado_sin_extension() {

		Entrada entrada = new Entrada(EJEMPLO_PREDETERMINADO_SIN_EXTENSION);

		String obtenido = entrada.nombreCarpeta();

		String esperado = "ejemplo_valido";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void obtener_el_nombre_de_la_carpeta_para_el_modo_salida() {

		Entrada entrada = new Entrada(EJEMPLO_CON_SALIDA);

		String obtenido = entrada.nombreCarpeta();

		String esperado = "nombre_de_archivo";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test(expected = ExepcionArchivoNoEncontrado.class)
	public void devolver_un_mensaje_de_error_cuando_el_parametro_es_output_y_no_contiene_referencia_a_un_archivo_markdown()
			throws ExepcionArchivoNoEncontrado {

		Entrada entrada = new Entrada(EJEMPLO_CON_SALIDA_SIN_ARCHIVO);

		entrada.modo();
	}
}
