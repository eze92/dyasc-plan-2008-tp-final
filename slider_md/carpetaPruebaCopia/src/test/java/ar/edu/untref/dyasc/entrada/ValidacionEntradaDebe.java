package ar.edu.untref.dyasc.entrada;

import org.junit.Assert;
import org.junit.Test;



public class ValidacionEntradaDebe {

	private static final String MODO_DEFAULT = "--mode=default";

	private static final String[] NOMBRE_VALIDO = { MODO_DEFAULT, "ejemplo_valido.md" };
	private static final String[] NOMBRE_CON_CARACTERES_INVALIDOS = { MODO_DEFAULT, "ejemplo_ñÑ.md" };
	private static final String[] NOMBRE_SIN_EXTENSION = { MODO_DEFAULT, "ejemplo_sin_extension" };

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
}
