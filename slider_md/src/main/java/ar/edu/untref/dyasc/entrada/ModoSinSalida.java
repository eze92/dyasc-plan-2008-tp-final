package ar.edu.untref.dyasc.entrada;

public class ModoSinSalida implements IComandosEntrada {

	private static final String MODO_SIN_SALIDA = "--mode=no-output";

	@Override
	public String procesar(String comando) {
		if (comando == MODO_SIN_SALIDA) {
			return "Modo sin salida: procesando..";
		}
		return "Opcion no valida.";
	}
}
