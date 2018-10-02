package ar.edu.untref.dyasc.entrada;

public class ModoPredeterminado implements IComandosEntrada {

	private static final String COMANDO_PREDETERMINADO = "--mode=default";
	private static final String VACIO = "";

	private IComandosEntrada iEntrada;

	public ModoPredeterminado(IComandosEntrada iEntrada) {
		this.iEntrada = iEntrada;
	}

	@Override
	public String procesar(String comando) {
		if (comando == COMANDO_PREDETERMINADO || comando == VACIO) {
			return "Modo predeterminado: procesando..";
		} else {
			return this.iEntrada.procesar(comando);
		}
	}
}
