package ar.edu.untref.dyasc.entrada;

public class ExepcionArchivoNoEncontrado extends Exception {

	private static final long serialVersionUID = 1L;

	private static String mensaje = "Archivo no encontrado.";

	public ExepcionArchivoNoEncontrado() {
		super(mensaje);
	}
}
