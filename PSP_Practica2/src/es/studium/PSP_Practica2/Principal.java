package es.studium.PSP_Practica2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {

	public static Camello[] listaCamellos;
	private static int numCammellos, recorrido = 0;

	public static void main(String[] args) throws IOException 
	{	
		// Pregunta el número de camellos y el recorrido de la carrera
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Indique el número de camellos que van a competir:");
		numCammellos = Integer.parseInt(br.readLine());
		System.out.println("Indique la distancia del recorrido:");
		recorrido = Integer.parseInt(br.readLine());

		// Crea los hilos de los camellos participantes
		listaCamellos = new Camello[numCammellos];
		for(int i=0; i<numCammellos; i++) 
		{	
			listaCamellos[i] = new Camello(i+1);
		}
		for(Camello hilos : listaCamellos) 
		{	
			new Thread(hilos).start();
		}
		// Control 
		
		listaCamellos[i].getPosicionCamello()args==recorrido --> FIN i
				// Cammello X está a tanto del lider
	}
}
