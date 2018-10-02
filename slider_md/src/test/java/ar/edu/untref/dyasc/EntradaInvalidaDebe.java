package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.entrada.ModoConSalida;
import ar.edu.untref.dyasc.entrada.ModoPredeterminado;
import ar.edu.untref.dyasc.entrada.ModoSinSalida;

public class EntradaInvalidaDebe {

	private static final String OPCION_INVALIDA = "--mode=opcion_invalida";
	private static final String MODO_CON_SALIDA = "--output";

	private ModoSinSalida modoSinSalida;
	private ModoConSalida modoConSalida;
	private ModoPredeterminado modoPredeterminado;

	@Before
	public void inicializar() {
		modoSinSalida = new ModoSinSalida();
		modoConSalida = new ModoConSalida(modoSinSalida, false);
		modoPredeterminado = new ModoPredeterminado(modoConSalida);
	}

	@Test
	public void devolver_un_mensaje_de_opcion_no_valida_cuando_el_comando_es_output_y_no_hay_un_archivo_presente() {

		String obtenido = modoPredeterminado.procesar(MODO_CON_SALIDA);

		String esperado = "Opcion no valida.";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void devolver_un_mensaje_cuando_la_opcion_no_es_valida() {

		String obtenido = modoPredeterminado.procesar(OPCION_INVALIDA);

		String esperado = "Opcion no valida.";
		Assert.assertEquals(esperado, obtenido);
	}

}
