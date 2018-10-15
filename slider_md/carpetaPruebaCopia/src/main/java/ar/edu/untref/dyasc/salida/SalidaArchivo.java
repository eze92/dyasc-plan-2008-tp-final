package ar.edu.untref.dyasc.salida;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SalidaArchivo {

	public SalidaArchivo() {
	}

	public void escribir(String archivo, String contenidoSalida) throws IOException {

		FileWriter escribirArchivo = new FileWriter(archivo);
		BufferedWriter salidaArchivo = new BufferedWriter(escribirArchivo);
		salidaArchivo.write(contenidoSalida);

		salidaArchivo.flush();
		salidaArchivo.close();
	}
}
