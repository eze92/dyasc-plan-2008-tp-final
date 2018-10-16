package ar.edu.untref.dyasc.salida;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import ar.edu.untref.dyasc.entrada.LectorArchivos;

public class SalidaArchivo extends Salida {

	private static final String TEXTO_A_REEMPLAZAR = "[este-es-el-texto-a-reemplazar]";
	private static final String RUTA_PLANTILLA = "./plantilla/";
	private static final String RUTA_INDEX = "./plantilla/index.html";

	private String nombreCarpeta;
	private CopiadoDeCarpeta copiadoDeCarpeta = new CopiadoDeCarpeta();
	private LectorArchivos lectorArchivos = new LectorArchivos();

	public SalidaArchivo(String archivo) {
		this.nombreCarpeta = archivo;
	}

	@Override
	public void imprimir(String contenidoSalida) throws IOException, NoExisteDirectorioException {

		copiadoDeCarpeta.copiarArchivos(new File(RUTA_PLANTILLA), new File("./" + nombreCarpeta));

		String contenidoOriginal = lectorArchivos.transformarContenidoAString(RUTA_INDEX);
		String contenidoFinal = contenidoOriginal.replace(TEXTO_A_REEMPLAZAR, contenidoSalida);

		Files.write(Paths.get("./" + nombreCarpeta + "/index.html"), contenidoFinal.getBytes());
	}
}
