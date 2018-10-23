package ar.edu.untref.dyasc.integracion;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.dyasc.dominio.Contexto;
import ar.edu.untref.dyasc.dominio.ServicioPrograma;
import ar.edu.untref.dyasc.entrada.Entrada;
import ar.edu.untref.dyasc.entrada.ExepcionArchivoNoEncontrado;
import ar.edu.untref.dyasc.entrada.LectorArchivos;

public class TestIntegracionConParametrosValidos {

	private static final String MODO_DEFAULT = "--mode=default";

	private static final String UBICACION_ARCHIVOS = "./archivosDePrueba/";

	@Test
	public void pruebaParaElArchivoQueContieneSoloSeccion() throws ExepcionArchivoNoEncontrado {

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
	public void pruebaParaElArchivoQueContieneSoloLista() throws ExepcionArchivoNoEncontrado {

		String[] argumentos = { MODO_DEFAULT, "lista.md" };
		Entrada entrada = new Entrada(argumentos);

		LectorArchivos lectorArchivos = new LectorArchivos();
		String documento = lectorArchivos.leer(UBICACION_ARCHIVOS, entrada.nombreArchivo());

		Contexto contexto = new Contexto();
		ServicioPrograma servicioPrograma = new ServicioPrograma(contexto);
		servicioPrograma.crearContenido(documento);

		String obtenido = servicioPrograma.obtenerSalida();

		String esperado = "<ul>\n" +
							"<li>item 1</li>\n" +
							"<li>item 2</li>\n" +
							"<li>item 3</li>\n" +
							"<li>item 4</li>\n" +
							"<li>item 5</li>\n" +
						  "</ul>\n";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void pruebaParaElArchivoQueNoTieneContenido() throws ExepcionArchivoNoEncontrado {

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

	@Test
	public void pruebaParaElArchivoQueContieneSeccionMasTitulo() throws ExepcionArchivoNoEncontrado {

		String[] argumentos = { MODO_DEFAULT, "seccion_titulo.md" };
		Entrada entrada = new Entrada(argumentos);

		LectorArchivos lectorArchivos = new LectorArchivos();
		String documento = lectorArchivos.leer(UBICACION_ARCHIVOS, entrada.nombreArchivo());

		Contexto contexto = new Contexto();
		ServicioPrograma servicioPrograma = new ServicioPrograma(contexto);
		servicioPrograma.crearContenido(documento);

		String obtenido = servicioPrograma.obtenerSalida();

		String esperado = "<section>\n<h1>h1</h1>\n</section>";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void pruebaParaElArchivoQueContieneTodasLasExpresiones() throws ExepcionArchivoNoEncontrado {

		String[] argumentos = { MODO_DEFAULT, "mipresentacion.md" };
		Entrada entrada = new Entrada(argumentos);

		LectorArchivos lectorArchivos = new LectorArchivos();
		String documento = lectorArchivos.leer(UBICACION_ARCHIVOS, entrada.nombreArchivo());

		Contexto contexto = new Contexto();
		ServicioPrograma servicioPrograma = new ServicioPrograma(contexto);
		servicioPrograma.crearContenido(documento);

		String obtenido = servicioPrograma.obtenerSalida();

		String esperado = "<section>\n" +
							"<h1>slider 1: titulo 1</h1>\n" +
						  "</section><section>\n" +
							"<h2>slider 2: titulo 2</h2>\n" +
						  "</section><section>\n" +
							"<ul>\n" +
								"<li>item 1</li>\n" +
								"<li>item 2</li>\n" +
								"<li>item 3</li>\n" +
							"</ul>\n" +
						  "</section><section>\n" +
							"<img src=\"imagen.png\"/>\n" +
							"<h1>titulo 1</h1>\n" +
							"<h2>titulo 2</h2>\n" +
						  "</section>";
		Assert.assertEquals(esperado, obtenido);
	}
}
