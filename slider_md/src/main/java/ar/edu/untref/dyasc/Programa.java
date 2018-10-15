package ar.edu.untref.dyasc;

import ar.edu.untref.dyasc.dominio.Contexto;
import ar.edu.untref.dyasc.dominio.ServicioPrograma;
import ar.edu.untref.dyasc.entrada.Entrada;
import ar.edu.untref.dyasc.entrada.LectorArchivos;
import ar.edu.untref.dyasc.salida.CopiadoDeCarpeta;
import ar.edu.untref.dyasc.salida.SalidaPantalla;

public class Programa {

    public static void main(String[] args) {
    
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
			
				CopiadoDeCarpeta copiadoDeCarpeta = new CopiadoDeCarpeta();
				copiadoDeCarpeta.copiarArchivos(directorioOrigen, directorioDestino);
				
				/*
				 * if(esModoDefault()) {
				 * 	carpeta = nombreArchivo();
				 * } else {
				 * 	carpeta = nombreCarpeta();
				 * }
				 *  SalidaArchivo.escribir(carpeta + "/" + nombreArchivo, contenidoSalida);
				 */
				
			} else {
				SalidaPantalla pantalla = new SalidaPantalla();
				pantalla.imprimir(contenidoSalida);
			}
		}
    }
}
