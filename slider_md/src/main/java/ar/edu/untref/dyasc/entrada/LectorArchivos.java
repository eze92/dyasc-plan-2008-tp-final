package ar.edu.untref.dyasc.entrada;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

		try (Stream<String> lineas = Files.lines(Paths.get("../documentos/" + nombreArchivo), StandardCharsets.UTF_8)) {
			lineas.forEach(s -> contenido.append(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contenido.toString();
	}
}
