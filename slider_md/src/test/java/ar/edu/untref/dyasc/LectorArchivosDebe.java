package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.entrada.LectorArchivos;

public class LectorArchivosDebe {

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
}
