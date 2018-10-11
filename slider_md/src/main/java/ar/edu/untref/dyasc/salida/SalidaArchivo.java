package ar.edu.untref.dyasc.salida;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SalidaArchivo {


    public SalidaArchivo() {
    }

    public void imprimir(String archivo, List<String> componente) throws IOException {

        FileWriter escribirArchivo = new FileWriter(archivo);
        BufferedWriter salidaArchivo = new BufferedWriter(escribirArchivo);
        for (String PalabrasPorLinea : componente) {
            salidaArchivo.write(PalabrasPorLinea);
        }
        salidaArchivo.flush();
        salidaArchivo.close();

    }
}
