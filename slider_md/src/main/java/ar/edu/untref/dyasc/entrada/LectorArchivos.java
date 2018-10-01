package ar.edu.untref.dyasc.entrada;

import java.io.File;

public class LectorArchivos {

	public String obtenerNombre(String nombreArchivo) {
		File file = new File("target/" + nombreArchivo);
		if (file.exists() && !file.isDirectory()) {
			String nombreCompleto = file.getName();
			return nombreCompleto.substring(0, nombreCompleto.length() - 3);
		}
		return "Archivo no encontrado.";
	}
}
