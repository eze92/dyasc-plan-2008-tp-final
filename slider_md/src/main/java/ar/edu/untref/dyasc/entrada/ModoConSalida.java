package ar.edu.untref.dyasc.entrada;

public class ModoConSalida implements IEntrada {

	private static final String MODO_CON_SALIDA = "--output";

	private IEntrada iEntrada;
	private boolean archivoPresente = false;

	public ModoConSalida(IEntrada iEntrada, boolean archivoPresente) {
		this.iEntrada = iEntrada;
		this.archivoPresente = archivoPresente;
	}

	@Override
	public String procesar(String comando) {
		if (comando.contains(MODO_CON_SALIDA) && archivoPresente) {
			return "Modo con salida: procesando..";
		} else {
			return this.iEntrada.procesar(comando);
		}
	}
}
