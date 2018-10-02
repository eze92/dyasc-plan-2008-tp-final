package ar.edu.untref.dyasc.entrada;

public class Entrada {

	private static final String MODO_SALIDA = "--output";

	private String[] argumentos;
	private String nombreArchivo;

	public Entrada(String[] argumentos) {
		this.argumentos = argumentos;
		this.nombreArchivo = argumentos[argumentos.length - 1];
	}

	public boolean nombreValido() {
		if (nombreArchivo.matches("[a-z.A-Z_-]+")) {
			return true;
		} else {
			return false;
		}
	}

	public String nombreArchivo() {
		return nombreArchivo;
	}

	public String modo() {
		if (argumentos[0].contains(MODO_SALIDA)) {
			return MODO_SALIDA;
		}
		return argumentos[0];
	}

	public String nombreCarpeta() {

		if (nombreArchivo.contains(".md")) {
			return nombreArchivo.substring(0, nombreArchivo.length() - 3);
		}
		if (argumentos[0].contains(MODO_SALIDA)) {
			return argumentos[0].split("=")[1];
		}
		return nombreArchivo;
	}
}
