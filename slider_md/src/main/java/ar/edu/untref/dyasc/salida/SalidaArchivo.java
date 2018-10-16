package ar.edu.untref.dyasc.salida;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import ar.edu.untref.dyasc.entrada.LectorArchivos;

public class SalidaArchivo extends Salida {

	private static final String TEXTO_A_REEMPLAZAR = "[este-es-el-texto-a-reemplazar]";
	private static final String RUTA_PLANTILLA = "./plantilla/";
	private static final String RUTA_INDEX = "./plantilla/index.html";
	private static final String UBICACION_ARCHIVO_MD = "../archivosDePrueba/";

	private String nombreCarpeta;
	private String nombreArchivo;

	private CopiadoDeArchivos copiadoDeCarpeta = new CopiadoDeArchivos();
	private LectorArchivos lectorArchivos = new LectorArchivos();

	public SalidaArchivo(String nombreCarpeta, String nombreArchivo) {
		this.nombreCarpeta = nombreCarpeta;
		this.nombreArchivo = nombreArchivo;
	}

	@Override
	public void imprimir(String contenidoSalida) throws IOException, NoExisteDirectorioException {

		copiarArchivos();

		String contenidoOriginal = lectorArchivos.transformarContenidoAString(RUTA_INDEX);
		String contenidoFinal = contenidoOriginal.replace(TEXTO_A_REEMPLAZAR, contenidoSalida);

		Files.write(Paths.get("./" + nombreCarpeta + "/index.html"), contenidoFinal.getBytes());
	}

	private void copiarArchivos() throws IOException, NoExisteDirectorioException {

		copiadoDeCarpeta.copiarCarpeta(new File(RUTA_PLANTILLA), new File("./" + nombreCarpeta));

		Files.copy(Paths.get(UBICACION_ARCHIVO_MD + nombreArchivo), Paths.get("./" + nombreArchivo),
				StandardCopyOption.REPLACE_EXISTING);
	}
}
