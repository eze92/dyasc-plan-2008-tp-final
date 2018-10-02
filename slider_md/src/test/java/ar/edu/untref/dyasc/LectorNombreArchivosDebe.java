package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.entrada.LectorArchivos;

public class LectorNombreArchivosDebe {

	private static final String EJEMPLO_CON_UNA_LINEA = "ejemplo_con_una_linea.md";
	private static final String EJEMPLO_NOMBRE_ARCHIVO_INVALIDO = "ejemplo_inválido_ñÑ.md";

	private LectorArchivos lectorArchivos;

	@Before
	public void inicializar() {
		lectorArchivos = new LectorArchivos();
	}

	@Test
	public void devolver_un_mensaje_cuando_el_archivo_no_fue_encontrado() {

		String obtenido = lectorArchivos.obtenerNombre("");

		String esperado = "Archivo no encontrado.";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void devolver_verdadero_para_un_nombre_del_archivo_valido() {

		boolean valido = lectorArchivos.nombreValido(EJEMPLO_CON_UNA_LINEA);

		Assert.assertTrue(valido);
	}

	@Test
	public void devolver_falso_para_un_nombre_del_archivo_invalido() {

		boolean valido = lectorArchivos.nombreValido(EJEMPLO_NOMBRE_ARCHIVO_INVALIDO);

		Assert.assertFalse(valido);
	}
}
