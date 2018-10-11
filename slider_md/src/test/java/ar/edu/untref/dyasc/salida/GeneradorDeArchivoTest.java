package ar.edu.untref.dyasc.salida;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class GeneradorDeArchivoTest {

    @Test
    public void VerificarQueElArchivoNoExiste() throws IOException {
        GeneradorDeArchivo generarArchivo = new GeneradorDeArchivo();
        String ruta = System.getProperty("user.dir") + ("/index.md");

        Assert.assertTrue(generarArchivo.existeArchivo(ruta) == false);
    }
}
