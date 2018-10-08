package ar.edu.untref.dyasc.salida;

public class SalidaArchivo implements Salida {

	private String archivoSalida;

	public SalidaArchivo(String unArchivo) {
		this.archivoSalida = unArchivo;
	}

	@Override
	public void mostrar(String unMensaje) {
		System.out.print(unMensaje);
	}
}
