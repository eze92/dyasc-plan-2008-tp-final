package ar.edu.untref.dyasc.salida;

import java.io.IOException;

public abstract class Salida {

	public abstract void imprimir(String contenidoSalida) throws IOException, NoExisteDirectorioException;
}
