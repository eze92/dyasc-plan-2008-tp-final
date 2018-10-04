package salida;

import java.io.File;
import java.io.IOException;

public class GeneradorDeSalida {

    public void crearCarpetaConArchivo(String rutaArchivo, String tieneOutput) throws IOException{
        File existeArchivoEnRuta = new File(rutaArchivo);
        File copiaDirectorio = new File(System.getProperty("user.dir"), "/plantilla/");
        String directorio = "";
        if (rutaArchivo.contains(".")) {
            if (tieneOutput.equals("")) {
                directorio = rutaArchivo.substring(0, rutaArchivo.lastIndexOf('.'));
            } else {
                directorio = tieneOutput;
            }
       
        }

        File generarDirectorio = new File(directorio);
        CopiadoDeCarpeta copiarDirectorio = new CopiadoDeCarpeta();
        if (existeArchivoEnRuta.exists()) {
            copiarDirectorio.copiarArchivos(copiaDirectorio, generarDirectorio);

            } 
        }
    }
