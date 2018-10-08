package ar.edu.untref.dyasc.dominio;

public class TituloH1 extends Componente {

	public TituloH1(String componenteActual) {
		super(componenteActual);
	}

	@Override
	Componente siguiente(Componente componente) {
		return null;
	}

	@Override
	String parsearMarkdown() {
		return "<h1>Texto h1</h1>";
	}
}
