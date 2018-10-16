package ar.edu.untref.dyasc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ar.edu.untref.dyasc.dominio.Contexto;
import ar.edu.untref.dyasc.dominio.ServicioPrograma;
import ar.edu.untref.dyasc.entrada.Entrada;
import ar.edu.untref.dyasc.entrada.ExepcionArchivoNoEncontrado;
import ar.edu.untref.dyasc.entrada.LectorArchivos;
import ar.edu.untref.dyasc.salida.NoExisteDirectorioException;
import ar.edu.untref.dyasc.salida.Salida;
import ar.edu.untref.dyasc.salida.SalidaArchivo;
import ar.edu.untref.dyasc.salida.SalidaPantalla;

public class Programa {

	private static final String MODO_SALIDA = "--output";
	private static final String MODO_DEFAULT = "--mode=default";
	private static final String MODO_PANTALLA = "--mode=no-output";

	private static final String UBICACION_ARCHIVOS = "../archivosDePrueba/";

	public static void main(String[] args)
			throws ExepcionArchivoNoEncontrado, IOException, NoExisteDirectorioException {

		Entrada entrada = new Entrada(args);

		if (entrada.nombreValido()) {

			// Lectura
			LectorArchivos lectorArchivos = new LectorArchivos();
			String documento = lectorArchivos.leer(UBICACION_ARCHIVOS, entrada.nombreArchivo());

			// Parseo
			Contexto contexto = new Contexto();
			ServicioPrograma servicioPrograma = new ServicioPrograma(contexto);
			servicioPrograma.crearContenido(documento);

			String contenidoSalida = servicioPrograma.obtenerSalida();

			// Salida
			Map<String, Salida> salidas = new HashMap<>();

			salidas.put(MODO_PANTALLA, new SalidaPantalla());
			salidas.put(MODO_DEFAULT, new SalidaArchivo(entrada.nombreCarpeta(), entrada.nombreArchivo()));
			salidas.put(MODO_SALIDA, new SalidaArchivo(entrada.nombreCarpeta(), entrada.nombreArchivo()));

			salidas.get(entrada.modo()).imprimir(contenidoSalida);
		}
	}
}
