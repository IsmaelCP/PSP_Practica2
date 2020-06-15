package es.studium.PSP_Practica2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {

	public static int numCamellos, recorrido = 0;

	public static void main(String[] args) throws IOException 
	{	
		// Pregunta el número de camellos y el recorrido de la carrera
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Indique el número de camellos que van a competir:");
		numCamellos = Integer.parseInt(br.readLine());
		System.out.println("Indique la distancia del recorrido:");
		recorrido = Integer.parseInt(br.readLine());
		// Crea los hilos de los camellos participantes
		for(int i=0; i<numCamellos; i++) 
		{	
			new Thread(new HiloCamello(i+1, new Camello())).start();
		}
		br.close();
	}
}
