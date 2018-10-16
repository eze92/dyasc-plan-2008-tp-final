package ar.edu.untref.dyasc.dominio;

public abstract class Componente {

	private static Contexto contexto;

	public Componente(Componente siguienteComponente) {
	}

	abstract void parsearMarkdown();

	public void setContexto(Contexto contexto) {
		Componente.contexto = contexto;
	}
	
	public Contexto getContexto() {
		return contexto;
	}
}
