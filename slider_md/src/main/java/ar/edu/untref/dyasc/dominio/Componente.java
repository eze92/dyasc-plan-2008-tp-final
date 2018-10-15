package ar.edu.untref.dyasc.dominio;

public abstract class Componente {

	public Componente(Componente siguienteComponente, String componenteActual, Contexto contexto) {}

	abstract void parsearMarkdown();
}
