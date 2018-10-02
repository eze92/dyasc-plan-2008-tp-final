package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.untref.dyasc.entrada.ModoPredeterminado;
import ar.edu.untref.dyasc.entrada.ModoSinSalida;

public class EntradaDebe {

	private static final String MODO_PREDETERMINADO = "--mode=default";
	private static final String VACIO = "";

	private ModoSinSalida modoSinSalida;
	private ModoPredeterminado modoPredeterminado;

	@Before
	public void inicializar() {
		modoSinSalida = new ModoSinSalida();
		modoPredeterminado = new ModoPredeterminado(modoSinSalida);
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
}
