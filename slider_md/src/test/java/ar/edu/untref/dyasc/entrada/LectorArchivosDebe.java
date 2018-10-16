package ar.edu.untref.dyasc.entrada;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.entrada.ExepcionArchivoNoEncontrado;
import ar.edu.untref.dyasc.entrada.LectorArchivos;

public class LectorArchivosDebe {

	private static final String EJEMPLO_VACIO = "ejemplo_vacio.md";
	private static final String EJEMPLO_CON_VARIAS_LINEAS = "seccion_titulo.md";
	private static final String EJEMPLO_CON_UNA_LINEA = "seccion.md";

	private static final String UBICACION_ARCHIVOS = "./archivosDePrueba/";

	private LectorArchivos lectorArchivos;

	@Before
	public void inicializar() {
		lectorArchivos = new LectorArchivos();
	}

	@Test
	public void leer_el_contenido_de_un_archivo_vacio() throws ExepcionArchivoNoEncontrado {

		String obtenido = lectorArchivos.leer(UBICACION_ARCHIVOS, EJEMPLO_VACIO);

		String esperado = "";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void leer_un_archivo_con_una_linea_de_contenido() throws ExepcionArchivoNoEncontrado {

		String obtenido = lectorArchivos.leer(UBICACION_ARCHIVOS, EJEMPLO_CON_UNA_LINEA);

		String esperado = "---";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void leer_un_archivo_con_varias_lineas_de_contenido() throws ExepcionArchivoNoEncontrado {

		String obtenido = lectorArchivos.leer(UBICACION_ARCHIVOS, EJEMPLO_CON_VARIAS_LINEAS);

		String esperado = "---\n# h1";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test(expected = ExepcionArchivoNoEncontrado.class)
	public void devolver_un_error_cuando_el_archivo_no_fue_encontrado() throws ExepcionArchivoNoEncontrado {
		lectorArchivos.leer(UBICACION_ARCHIVOS, "");
	}
}
