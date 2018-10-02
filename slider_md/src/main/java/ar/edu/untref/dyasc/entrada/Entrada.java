package ar.edu.untref.dyasc.entrada;

public class Entrada {

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
}
