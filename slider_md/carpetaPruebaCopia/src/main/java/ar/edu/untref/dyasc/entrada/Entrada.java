package ar.edu.untref.dyasc.entrada;

public class Entrada {

	private static final String MODO_SALIDA = "--output";
	private static final String MODO_DEFAULT = "--mode=default";
	private static final String MODO_PANTALLA = "--mode=no-output";

	private String[] argumentos;
	private String nombreArchivo;
	private boolean modoSalida = false;

	public Entrada(String[] argumentos) {
		this.argumentos = argumentos;
		this.nombreArchivo = argumentos[argumentos.length - 1];
	}

	public boolean nombreValido() {
		if (nombreArchivo.matches("[a-z.A-Z0-9_-]+")) {
			return true;
		} else {
			return false;
		}
	}

	public String nombreArchivo() {
		return nombreArchivo;
	}

	public String modo() {

		nombreArchivo = nombreCarpeta() + "/" + nombreArchivo;

		if (argumentos[0].contains(MODO_SALIDA)) {
			return MODO_SALIDA;
		} else if (argumentos[0].contains(MODO_DEFAULT)) {
			return MODO_DEFAULT;
		} else if (argumentos[0].contains(MODO_PANTALLA)) {
			return MODO_PANTALLA;
		}

		return MODO_DEFAULT;
	}

	public String nombreCarpeta() {

		if (argumentos[0].contains(MODO_SALIDA)) {
			return argumentos[0].split("=")[1];
		}
		if (nombreArchivo.contains(".md")) {
			return nombreArchivo.substring(0, nombreArchivo.length() - 3);
		}
		return nombreArchivo;
	}

	public boolean esModoSalida() {
		return modoSalida;
	}
}
