package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.dyasc.entrada.Entrada;

public class EntradaDebe {

	private static final String[] NOMBRE_VALIDO = { "--mode=default", "ejemplo_valido.md" };
	private static final String[] NOMBRE_CON_CARACTERES_INVALIDOS = { "--mode=default", "ejemplo_ñÑ.md" };
	private static final String[] NOMBRE_SIN_EXTENSION = { "--mode=default", "ejemplo_sin_extension" };

	@Test
	public void devolver_verdadero_para_un_nombre_de_archivo_valido() {

		Entrada entrada = new Entrada(NOMBRE_VALIDO);

		boolean valido = entrada.nombreValido();

		Assert.assertTrue(valido);
	}

	@Test
	public void devolver_falso_para_un_nombre_de_archivo_con_caracteres_invalidos() {

		Entrada entrada = new Entrada(NOMBRE_CON_CARACTERES_INVALIDOS);

		boolean valido = entrada.nombreValido();

		Assert.assertFalse(valido);
	}

	@Test
	public void devolver_verdadero_para_un_nombre_de_archivo_sin_extension() {

		Entrada entrada = new Entrada(NOMBRE_SIN_EXTENSION);

		boolean valido = entrada.nombreValido();

		Assert.assertTrue(valido);
	}

	@Test
	public void obtener_el_nombre_del_archivo_cuando_los_parametros_son_validos() {

		Entrada entrada = new Entrada(NOMBRE_VALIDO);

		String obtenido = entrada.nombreArchivo();

		String esperado = "ejemplo_valido.md";
		Assert.assertEquals(esperado, obtenido);
	}
}
