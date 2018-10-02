package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.dyasc.entrada.Entrada;

public class ParametrosEntradaDebe {

	private static final String MODO_DEFAULT = "--mode=default";
	private static final String[] NOMBRE_VALIDO = { MODO_DEFAULT, "ejemplo_valido.md" };

	@Test
	public void obtener_el_nombre_del_archivo_cuando_los_parametros_son_validos() {

		Entrada entrada = new Entrada(NOMBRE_VALIDO);

		String obtenido = entrada.nombreArchivo();

		String esperado = "ejemplo_valido.md";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void obtener_el_modo_predeterminado_cuando_el_parametro_es_default() {

		Entrada entrada = new Entrada(NOMBRE_VALIDO);

		String obtenido = entrada.modo();

		String esperado = MODO_DEFAULT;
		Assert.assertEquals(esperado, obtenido);
	}
}
