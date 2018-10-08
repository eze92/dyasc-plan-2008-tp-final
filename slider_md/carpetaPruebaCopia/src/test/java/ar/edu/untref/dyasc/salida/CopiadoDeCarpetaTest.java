package ar.edu.untref.dyasc.salida;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import junit.framework.Assert;

public class CopiadoDeCarpetaTest {

	@Test
	public void seCopiaCarpetaDelDirectorioCorrectamente() throws IOException{
		String rutaOrigen = System.getProperty("user.dir");
		String rutaDestino = (rutaOrigen + "/carpetaPruebaCopia");

		File carpetaOrigen = new File(rutaOrigen);
		File carpetaDestino = new File(rutaDestino);
		CopiadoDeCarpeta realizarCopia = new CopiadoDeCarpeta();
		realizarCopia.copiarArchivos(carpetaOrigen, carpetaDestino);

		Assert.assertTrue(carpetaDestino.exists());
	}
}