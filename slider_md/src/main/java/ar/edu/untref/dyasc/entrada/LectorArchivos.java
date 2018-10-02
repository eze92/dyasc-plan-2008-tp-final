package ar.edu.untref.dyasc.entrada;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LectorArchivos {

	public String obtenerNombre(String nombreArchivo) {

		File file = new File("../documentos/" + nombreArchivo);

		if (file.exists() && !file.isDirectory()) {
			String nombreCompleto = file.getName();
			return nombreCompleto.substring(0, nombreCompleto.length() - 3);
		}
		return "Archivo no encontrado.";
	}

	public String leer(String nombreArchivo) {

		StringBuilder contenido = new StringBuilder();

		try (Stream<String> lineas = Files.lines(Paths.get("../documentos/" + nombreArchivo))) {
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
