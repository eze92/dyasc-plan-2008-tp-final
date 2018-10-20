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
	public void obtenerElNombreDelArchivoCuandoLosParametrosSonValidos() {

		Entrada entrada = new Entrada(EJEMPLO_PREDETERMINADO);

		String obtenido = entrada.nombreArchivo();

		String esperado = "ejemplo_valido.md";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void obtenerElModoPredeterminadoCuandoElParametroEsDefault() throws ExepcionArchivoNoEncontrado {

		Entrada entrada = new Entrada(EJEMPLO_PREDETERMINADO);

		String obtenido = entrada.modo();

		String esperado = MODO_DEFAULT;
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void obtenerElModoSalidaCuandoElParametroEsOutput() throws ExepcionArchivoNoEncontrado {

		Entrada entrada = new Entrada(EJEMPLO_CON_SALIDA);

		String obtenido = entrada.modo();

		String esperado = "--output";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void obtenerElModoPantallaCuandoElParametroEsNoOutput() throws ExepcionArchivoNoEncontrado {

		Entrada entrada = new Entrada(EJEMPLO_SIN_SALIDA);

		String obtenido = entrada.modo();

		String esperado = MODO_SIN_SALIDA;
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void obtenerElMombreDeLaCarpetaParaElModoPredeterminado() {

		Entrada entrada = new Entrada(EJEMPLO_PREDETERMINADO);

		String obtenido = entrada.nombreCarpeta();

		String esperado = "ejemplo_valido";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void obtenerElNombreDeLaCarpetaParaElModoPredeterminadoSinExtension() {

		Entrada entrada = new Entrada(EJEMPLO_PREDETERMINADO_SIN_EXTENSION);

		String obtenido = entrada.nombreCarpeta();

		String esperado = "ejemplo_valido";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void obtenerElNombreDeLaCarpetaParaElModoSalida() {

		Entrada entrada = new Entrada(EJEMPLO_CON_SALIDA);

		String obtenido = entrada.nombreCarpeta();

		String esperado = "nombre_de_archivo";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test(expected = ExepcionArchivoNoEncontrado.class)
	public void devolverUnMensajeDeErrorCuandoElParametroEsOutputYNoContieneReferenciaAUnArchivoMarkdown()
			throws ExepcionArchivoNoEncontrado {

		Entrada entrada = new Entrada(EJEMPLO_CON_SALIDA_SIN_ARCHIVO);

		entrada.modo();
	}
}
