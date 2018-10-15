package ar.edu.untref.dyasc.salida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SalidaArchivo extends Salida {

	private String rutaArchivo;
	private CopiadoDeCarpeta copiadoDeCarpeta = new CopiadoDeCarpeta();

	public SalidaArchivo(String archivo) {
		this.rutaArchivo = archivo;
	}

	@Override
	public void imprimir(String contenidoSalida) throws IOException, NoExisteDirectorioException {

		String contenidoFinal = "";
		String directorio = (System.getProperty("user.dir") + "/" + rutaArchivo + "/index.html");

		// Copia toda la carpeta plantilla (Tengo entendido que es siempre la misma carpeta origen)
		copiadoDeCarpeta.copiarArchivos(new File("./target/plantilla"), new File(rutaArchivo));

		
		// Reemplaza lo que esta en el index
		// No veo entiendo para que se hace un replace si despues se escribe mas abajo el archivo
		File directorioArchivo = new File(directorio);
		FileReader lectorDeArchivo = new FileReader(directorioArchivo);
		BufferedReader lectorDeLineasDeArchivo = new BufferedReader(lectorDeArchivo);

		while ((contenidoFinal = lectorDeLineasDeArchivo.readLine()) != null) {
			if (contenidoFinal.contains(("[este-es-el-texto-a-reemplazar]"))) {
				contenidoFinal = contenidoFinal.replace("[este-es-el-texto-a-reemplazar]", contenidoSalida);
			}
		}
		lectorDeArchivo.close();
		lectorDeLineasDeArchivo.close();
		// ------------------------------------------------------------

		// Escribe el index
		FileWriter escribirArchivo = new FileWriter(rutaArchivo);
		BufferedWriter salidaArchivo = new BufferedWriter(escribirArchivo);
		salidaArchivo.write(contenidoSalida);

		salidaArchivo.flush();
		salidaArchivo.close();
	}
}
