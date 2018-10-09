package ar.edu.untref.dyasc.salida;

import java.io.File;
import java.io.IOException;

public class GeneradorDeSalida {

    public void crearCarpetaConArchivo(String rutaArchivo, String rutaSalida)
            throws IOException, NoExisteDirectorioException {

        File archivo = new File(rutaArchivo);

        File copiaDirectorio = new File(System.getProperty("user.dir"), "/plantilla/");
        String directorio = "";
        if (rutaArchivo.contains(".")) {
            if (rutaSalida.equals("")) {
                directorio = rutaArchivo.substring(0, rutaArchivo.lastIndexOf('.'));
            } else {
                directorio = rutaSalida;
            }
        }

        File generarDirectorio = new File(directorio);
        CopiadoDeCarpeta copiarDirectorio = new CopiadoDeCarpeta();

        if (archivo.exists()) {
            copiarDirectorio.copiarArchivos(copiaDirectorio, generarDirectorio);
        }
    }
}
