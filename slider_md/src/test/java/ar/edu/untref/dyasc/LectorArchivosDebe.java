package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.entrada.LectorArchivos;

public class LectorArchivosDebe {

	private static final String EJEMPLO_VACIO = "ejemplo_vacio.md";
	private static final String EJEMPLO_CON_UNA_LINEA = "ejemplo_con_una_linea.md";
	private static final String EJEMPLO_CON_VARIAS_LINEAS = "ejemplo_con_varias_lineas.md";

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
	public void devolver_el_nombre_del_archivo_localizado() {

		String obtenido = lectorArchivos.obtenerNombre(EJEMPLO_CON_UNA_LINEA);

		String esperado = "ejemplo_con_una_linea";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void leer_el_contenido_de_un_archivo_vacio() {

		String obtenido = lectorArchivos.leer(EJEMPLO_VACIO);

		String esperado = "";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void leer_un_archivo_con_una_linea_de_contenido() {

		String obtenido = lectorArchivos.leer(EJEMPLO_CON_UNA_LINEA);

		String esperado = "---";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void leer_un_archivo_con_varias_lineas_de_contenido() {

		String obtenido = lectorArchivos.leer(EJEMPLO_CON_VARIAS_LINEAS);

		String esperado = "---\n# h1\n---";
		Assert.assertEquals(esperado, obtenido);
	}
}
