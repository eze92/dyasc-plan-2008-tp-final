package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.dyasc.entrada.Entrada;

public class ParametrosEntradaDebe {

	private static final String MODO_DEFAULT = "--mode=default";
	private static final String MODO_SIN_SALIDA = "--mode=no-output";
	private static final String MODO_SALIDA = "--output=nombre_de_archivo";

	private static final String[] EJEMPLO_PREDETERMINADO = { MODO_DEFAULT, "ejemplo_valido.md" };
	private static final String[] EJEMPLO_CON_SALIDA = { MODO_SALIDA, "ejemplo_valido.md" };
	private static final String[] EJEMPLO_SIN_SALIDA = { MODO_SIN_SALIDA, "ejemplo_valido.md" };

	@Test
	public void obtener_el_nombre_del_archivo_cuando_los_parametros_son_validos() {

		Entrada entrada = new Entrada(EJEMPLO_PREDETERMINADO);

		String obtenido = entrada.nombreArchivo();

		String esperado = "ejemplo_valido.md";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void obtener_el_modo_predeterminado_cuando_el_parametro_es_default() {

		Entrada entrada = new Entrada(EJEMPLO_PREDETERMINADO);

		String obtenido = entrada.modo();

		String esperado = MODO_DEFAULT;
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void obtener_el_modo_salida_cuando_el_parametro_es_output() {

		Entrada entrada = new Entrada(EJEMPLO_CON_SALIDA);

		String obtenido = entrada.modo();

		String esperado = "--output";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void obtener_el_modo_pantalla_cuando_el_parametro_es_no_output() {

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
}
