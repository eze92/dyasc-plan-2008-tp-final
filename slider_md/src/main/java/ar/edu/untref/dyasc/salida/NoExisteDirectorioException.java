package ar.edu.untref.dyasc.salida;

@SuppressWarnings("serial")
public class NoExisteDirectorioException extends Exception {

    private static String msg = "No existe el directorio especificado";

    public NoExisteDirectorioException() {
        super(msg);
    }

}
