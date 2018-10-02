package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.entrada.ModoConSalida;
import ar.edu.untref.dyasc.entrada.ModoPredeterminado;
import ar.edu.untref.dyasc.entrada.ModoSinSalida;

public class EntradaValidaDebe {

	private static final String MODO_PREDETERMINADO = "--mode=default";
	private static final String MODO_SIN_SALIDA = "--mode=no-output";
	private static final String MODO_CON_SALIDA = "--output";
	private static final String VACIO = "";

	private ModoSinSalida modoSinSalida;
	private ModoConSalida modoConSalida;
	private ModoPredeterminado modoPredeterminado;

	@Before
	public void inicializar() {
		modoSinSalida = new ModoSinSalida();
		modoConSalida = new ModoConSalida(modoSinSalida, true);
		modoPredeterminado = new ModoPredeterminado(modoConSalida);
	}

	@Test
	public void llamar_al_modo_predeterminado_cuando_el_comando_es_default() {

		String obtenido = modoPredeterminado.procesar(MODO_PREDETERMINADO);

		String esperado = "Modo predeterminado: procesando..";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void llamar_al_modo_predeterminado_cuando_el_comando_es_vacio() {

		String obtenido = modoPredeterminado.procesar(VACIO);

		String esperado = "Modo predeterminado: procesando..";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void llamar_al_modo_sin_salida_cuando_el_comando_es_no_output() {

		String obtenido = modoPredeterminado.procesar(MODO_SIN_SALIDA);

		String esperado = "Modo sin salida: procesando..";
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void llamar_al_modo_con_salida_cuando_el_comando_es_output_y_llama_a_un_archivo() {

		String obtenido = modoPredeterminado.procesar(MODO_CON_SALIDA);

		String esperado = "Modo con salida: procesando..";
		Assert.assertEquals(esperado, obtenido);
	}
}
