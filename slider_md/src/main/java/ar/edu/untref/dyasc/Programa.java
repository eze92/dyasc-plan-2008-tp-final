package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.dominio.Contexto;
import ar.edu.untref.dyasc.dominio.ServicioPrograma;
import ar.edu.untref.dyasc.entrada.Entrada;
import ar.edu.untref.dyasc.entrada.ExepcionArchivoNoEncontrado;
import ar.edu.untref.dyasc.entrada.LectorArchivos;

public class Programa {

    public static void main(String[] args) throws ExepcionArchivoNoEncontrado {
    
    	Entrada entrada = new Entrada(args);

		if (entrada.nombreValido()) {

			// Lectura
			LectorArchivos lectorArchivos = new LectorArchivos();
			String documento = lectorArchivos.leer(entrada.nombreArchivo());

			// Parseo
			Contexto contexto = new Contexto();
			ServicioPrograma servicioPrograma = new ServicioPrograma(contexto);
			servicioPrograma.crearContenido(documento);

			String contenidoSalida = servicioPrograma.obtenerSalida();

			// Salida
			if (entrada.esModoSalida()) {
			
				/*
				 * if(esModoDefault()) {
				 * 	carpeta = nombreArchivo();
				 * } else {
				 * 	carpeta = nombreCarpeta();
				 * }
				 *  SalidaArchivo.escribir(carpeta + "/" + nombreArchivo, contenidoSalida);
				 */
				
			} else {
				
				// Imprime por pantalla "contenidoSalida"
			}
		}
    }
}
