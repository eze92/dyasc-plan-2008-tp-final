package ar.edu.untref.dyasc.entrada;

public class ModoConSalida implements IComandosEntrada {

	private static final String MODO_CON_SALIDA = "--output";

	private IComandosEntrada iEntrada;
	private boolean archivoPresente = false;

	public ModoConSalida(IComandosEntrada iEntrada, boolean archivoPresente) {
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
