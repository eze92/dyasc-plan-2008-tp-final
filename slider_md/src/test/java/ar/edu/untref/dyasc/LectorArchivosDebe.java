package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.entrada.LectorArchivos;

public class LectorArchivosDebe {

	private static final String EJEMPLO_VACIO = "ejemplo_vacio.md";
	private static final String EJEMPLO_CON_CONTENIDO = "ejemplo_con_contenido.md";

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

		String obtenido = lectorArchivos.obtenerNombre(EJEMPLO_CON_CONTENIDO);

		String esperado = "ejemplo_con_contenido";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void leer_el_contenido_de_un_archivo_vacio() {

		String obtenido = lectorArchivos.leer(EJEMPLO_VACIO);

		String esperado = "";
		Assert.assertEquals(esperado, obtenido);
	}
}
