package ar.edu.untref.dyasc.integracion;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Contexto;
import ar.edu.untref.dyasc.dominio.ServicioPrograma;
import ar.edu.untref.dyasc.entrada.Entrada;
import ar.edu.untref.dyasc.entrada.ExepcionArchivoNoEncontrado;
import ar.edu.untref.dyasc.entrada.LectorArchivos;

public class TestIntegracion {

	private static final String MODO_DEFAULT = "--mode=default";

	private static final String UBICACION_ARCHIVOS = "./archivosDePrueba/";

	@Test
	public void prueba_para_el_archivo_que_contiene_solo_seccion() throws ExepcionArchivoNoEncontrado {

		String[] argumentos = { MODO_DEFAULT, "seccion.md" };
		Entrada entrada = new Entrada(argumentos);

		LectorArchivos lectorArchivos = new LectorArchivos();
		String documento = lectorArchivos.leer(UBICACION_ARCHIVOS, entrada.nombreArchivo());

		Contexto contexto = new Contexto();
		ServicioPrograma servicioPrograma = new ServicioPrograma(contexto);
		servicioPrograma.crearContenido(documento);

		String obtenido = servicioPrograma.obtenerSalida();

		String esperado = "<section>\n</section>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void prueba_para_el_archivo_que_contiene_solo_lista() throws ExepcionArchivoNoEncontrado {

		String[] argumentos = { MODO_DEFAULT, "lista.md" };
		Entrada entrada = new Entrada(argumentos);

		LectorArchivos lectorArchivos = new LectorArchivos();
		String documento = lectorArchivos.leer(UBICACION_ARCHIVOS, entrada.nombreArchivo());

		Contexto contexto = new Contexto();
		ServicioPrograma servicioPrograma = new ServicioPrograma(contexto);
		servicioPrograma.crearContenido(documento);

		String obtenido = servicioPrograma.obtenerSalida();

		String esperado = "<ul>\n" + "<li>item 1</li>\n" + "<li>item 2</li>\n" + "<li>item 3</li>\n"
				+ "<li>item 4</li>\n" + "<li>item 5</li>\n" + "</ul>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void prueba_para_el_archivo_que_no_tiene_contenido() throws ExepcionArchivoNoEncontrado {

		String[] argumentos = { MODO_DEFAULT, "ejemplo_vacio.md" };
		Entrada entrada = new Entrada(argumentos);

		LectorArchivos lectorArchivos = new LectorArchivos();
		String documento = lectorArchivos.leer(UBICACION_ARCHIVOS, entrada.nombreArchivo());

		Contexto contexto = new Contexto();
		ServicioPrograma servicioPrograma = new ServicioPrograma(contexto);
		servicioPrograma.crearContenido(documento);

		String obtenido = servicioPrograma.obtenerSalida();

		String esperado = "";
		Assert.assertEquals(esperado, obtenido);
	}
}
