package ar.edu.untref.dyasc.entrada;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LectorArchivos {

	private static final String RUTA_UBICACION_ARCHIVOS = "../documentos/";

	public String obtenerNombre(String nombreArchivo) {

		File file = new File(RUTA_UBICACION_ARCHIVOS + nombreArchivo);

		if (file.exists() && !file.isDirectory()) {
			String nombreConExtension = file.getName();

			if (nombreValido(nombreConExtension)) {
				return nombreConExtension.substring(0, nombreConExtension.length() - 3);
			}
			return "Opcion no valida.";
		}
		return "Archivo no encontrado.";
	}

	public String leer(String nombreArchivo) {

		StringBuilder contenido = new StringBuilder();

		try (Stream<String> lineas = Files.lines(Paths.get(RUTA_UBICACION_ARCHIVOS + nombreArchivo))) {
			lineas.forEach(linea -> contenido.append(linea).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (contenido.length() > 0) {
			contenido.delete(contenido.length() - 1, contenido.length());
		}
		return contenido.toString();
	}

	public boolean nombreValido(String nombreArchivo) {
		return (nombreArchivo.matches("[a-z.A-Z_-]+")) ? true : false;
	}
}
