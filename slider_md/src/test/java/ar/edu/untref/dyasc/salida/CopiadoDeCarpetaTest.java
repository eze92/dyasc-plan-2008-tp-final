package ar.edu.untref.dyasc.salida;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import ar.edu.untref.dyasc.salida.CopiadoDeCarpeta;
import ar.edu.untref.dyasc.salida.NoExisteDirectorioException;

public class CopiadoDeCarpetaTest {

    @Test
    public void seCopiaCarpetaDelDirectorioCorrectamente() throws IOException, NoExisteDirectorioException {
        String rutaOrigen = System.getProperty("user.dir");
        String rutaDestino = ("./target/copiaDeCarpeta");

        File carpetaOrigen = new File(rutaOrigen);
        File carpetaDestino = new File(rutaDestino);
        CopiadoDeCarpeta realizarCopia = new CopiadoDeCarpeta();
        realizarCopia.copiarArchivos(carpetaOrigen, carpetaDestino);

        Assert.assertTrue(carpetaDestino.exists());
    }

    @Test
    public void carpetaInexistenteParaCopiar() throws IOException, NoExisteDirectorioException {

        String rutaOrigen = "DirectorioIncorrecto";
        String rutaDestino = ("./target/pruebaCarpetaCopia");

        File carpetaOrigen = new File(rutaOrigen);
        File carpetaDestino = new File(rutaDestino);
        CopiadoDeCarpeta realizarCopia = new CopiadoDeCarpeta();
        realizarCopia.copiarArchivos(carpetaOrigen, carpetaDestino);

        Assert.assertFalse(carpetaDestino.exists());

    }
}