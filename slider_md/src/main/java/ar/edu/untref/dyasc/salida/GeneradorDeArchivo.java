package ar.edu.untref.dyasc.salida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneradorDeArchivo {

	public void generarArchivoEnDirectorio(String rutaArchivo, String nuevaCadena) throws IOException {

		SalidaArchivo modificarArchivo = new SalidaArchivo();

		List<String> lineas = new ArrayList<String>();
		String unaLinea = null;
		String directorio = (System.getProperty("user.dir") + "/" + rutaArchivo + "/index.html");
		File directorioArchivo = new File(directorio);
		FileReader lectorDeArchivo = new FileReader(directorioArchivo);
		BufferedReader lectorDeLineasDeArchivo = new BufferedReader(lectorDeArchivo);

		while ((unaLinea = lectorDeLineasDeArchivo.readLine()) != null) {
			if (unaLinea.contains(("[este-es-el-texto-a-reemplazar]"))) {
				unaLinea = unaLinea.replace("[este-es-el-texto-a-reemplazar]", nuevaCadena);
			}
			lineas.add(unaLinea + "\n");
		}
		lectorDeArchivo.close();
		lectorDeLineasDeArchivo.close();

		modificarArchivo.imprimir(directorio, lineas);
	}

	public boolean existeArchivo(String ruta) {
		boolean existeEnLaRutaEspecificada = false;
		File archivo = new File(ruta);
		if (archivo.exists()) {
			existeEnLaRutaEspecificada = true;
		} else {
			existeEnLaRutaEspecificada = false;
		}
		return existeEnLaRutaEspecificada;
	}
}
