package ar.edu.untref.dyasc.entrada;

public class ExepcionNombreInvalido extends Exception {

	private static final long serialVersionUID = 1L;

	private static String mensaje = "El nombre contiene caractéres no válidos.";

	public ExepcionNombreInvalido() {
		super(mensaje);
		System.out.println(mensaje);
	}
}
