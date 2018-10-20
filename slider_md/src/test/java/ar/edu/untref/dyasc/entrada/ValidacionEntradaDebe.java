package ar.edu.untref.dyasc.entrada;

import org.junit.Assert;
import org.junit.Test;



public class ValidacionEntradaDebe {

	private static final String MODO_DEFAULT = "--mode=default";

	private static final String[] NOMBRE_VALIDO = { MODO_DEFAULT, "ejemplo_valido.md" };
	private static final String[] NOMBRE_CON_CARACTERES_INVALIDOS = { MODO_DEFAULT, "ejemplo_ñÑ.md" };
	private static final String[] NOMBRE_SIN_EXTENSION = { MODO_DEFAULT, "ejemplo_sin_extension" };

	@Test
	public void devolverVerdaderoParaUnNombreDeArchivoValido() {

		Entrada entrada = new Entrada(NOMBRE_VALIDO);

		boolean valido = entrada.nombreValido();

		Assert.assertTrue(valido);
	}

	@Test
	public void devolverFalsoParaUnNombreDeArchivoConCaracteresInvalidos() {

		Entrada entrada = new Entrada(NOMBRE_CON_CARACTERES_INVALIDOS);

		boolean valido = entrada.nombreValido();

		Assert.assertFalse(valido);
	}

	@Test
	public void devolverVerdaderoParaUnNombreDeArchivoSinExtension() {

		Entrada entrada = new Entrada(NOMBRE_SIN_EXTENSION);

		boolean valido = entrada.nombreValido();

		Assert.assertTrue(valido);
	}
}
