package ar.edu.untref.dyasc.dominio;

import org.junit.Assert;
import org.junit.Test;

public class ComponenteImagenDebe {

	private static final String COMPONENTE_IMAGEN = "i:imagen.png";

	private Imagen componenteImagen;

	@Test
	public void metodo() {

		componenteImagen = new Imagen(null, COMPONENTE_IMAGEN);
		componenteImagen.parsearMarkdown();

		String obtenido = componenteImagen.getNuevoContenido();

		String esperado = "<img src=\"imagen.png\"/>";
		Assert.assertEquals(esperado, obtenido);
	}
}
