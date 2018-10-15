package ar.edu.untref.dyasc.dominio;

public abstract class Componente {

	public Componente(Componente siguienteComponente, Contexto contexto) {
	}

	abstract void parsearMarkdown();
}
