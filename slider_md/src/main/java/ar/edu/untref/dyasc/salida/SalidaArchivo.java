package ar.edu.untref.dyasc.salida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

		// Copia toda la carpeta plantilla
		copiadoDeCarpeta.copiarArchivos(new File("./target/plantilla"), new File(rutaArchivo));

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
	}
}
