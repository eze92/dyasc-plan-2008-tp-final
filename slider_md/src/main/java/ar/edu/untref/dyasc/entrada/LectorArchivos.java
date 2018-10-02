package ar.edu.untref.dyasc.entrada;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LectorArchivos {

	private static final String RUTA_UBICACION_ARCHIVOS = "../documentos/";

	public String leer(String nombreArchivo) throws ExepcionArchivoNoEncontrado {

		String rutaArchivo = RUTA_UBICACION_ARCHIVOS + nombreArchivo;
		File file = new File(rutaArchivo);

		if (file.exists() && !file.isDirectory()) {
			return lecturaArchivo(nombreArchivo, rutaArchivo);
		} else {
			throw new ExepcionArchivoNoEncontrado();
		}
	}

	private String lecturaArchivo(String nombreArchivo, String rutaArchivo) {

		StringBuilder contenido = new StringBuilder();

		try (Stream<String> lineas = Files.lines(Paths.get(rutaArchivo))) {
			lineas.forEach(linea -> contenido.append(linea).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (contenido.length() > 0) {
			contenido.delete(contenido.length() - 1, contenido.length());
		}
		return contenido.toString();
	}
}
