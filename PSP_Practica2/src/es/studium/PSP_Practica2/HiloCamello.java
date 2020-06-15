package es.studium.PSP_Practica2;

import java.util.Random;

public class HiloCamello implements Runnable {

	private Camello camello;
	private int nombre;
	private static int listaCamellos[] = new int[Principal.numCamellos];
	private static boolean finalCarrera = false;
	private boolean ganador = false;
	
	public HiloCamello(int n, Camello c)
	{
		nombre = n;
		camello = c;
	}

	public void run() 
	{
		while(finalCarrera == false)
		{
			muestraCarrera();
		}
		if(finalCarrera && ganador == false)
		{
			System.out.println("El Camello " + nombre + " a " + (Principal.recorrido - camello.getPosicionCamello()) + " posiciones.");
			Thread.interrupted();
		}
	}

	// Genera la tirada y el avance de los camellos
	public static int tirada()
	{
		int avance = 0;
		Random rd = new Random();
		int numTirada = rd.nextInt(100);
		// Calcula el 30% de probabilidad de caer en el agujero blanco
		if(numTirada >= 0 && numTirada <= 29)
		{
			avance = 0;
		}
		// Calcula el 40% de probabilidad de caer en el agujero amarillo
		else if(numTirada >= 30 & numTirada <= 70)
		{
			avance = 1;
		}
		// Calcula el 20% de probabilidad de caer en el agujero azul
		else if(numTirada >= 70 & numTirada <= 90)
		{
			avance = 2;
		}
		// Un 10% restante de probabilidad de caer en el agujero azul
		else
		{
			avance = 3;
		}

		return avance;
	}
	
	// Obtiene el avance de los Camellos y también lo actualiza en setPosicionCamello
	public int avanceCamello(int avance)
	{
		int variablePosicion = camello.getPosicionCamello();
		int variableAvanceCamello = variablePosicion + avance;
		camello.setPosicionCamello(variableAvanceCamello);
		return variableAvanceCamello;
	}
	
	// Obtiene el camello que va en primera posición
	public int camelloPrimero()
	{
		int lider = 0;
		for(int i=0; i<listaCamellos.length; i++)
		{
			if(listaCamellos[i] > lider)
			{
				lider = listaCamellos[i];
			}
		}
		return lider;
	}

	// Muestra el avance de la carrera
	public synchronized void muestraCarrera()
	{
		int mov = tirada();
		listaCamellos[nombre - 1] = avanceCamello(mov);
		System.out.println("El Camello " + nombre + " avanza " + mov + " posiciones y lleva " + camello.getPosicionCamello() + " posiciones, y va a " + (camelloPrimero() - camello.getPosicionCamello()) + " posiciones del líder.");
		if(camello.getPosicionCamello() >= Principal.recorrido)
		{					
			finalCarrera = true;
			ganador = true;
			try 
			{			
				Thread.sleep(500);			
				System.out.println("\nLLEGADA A META");
				System.out.println("El Camello " + nombre + " ha ganado la carrera.");
				System.out.println("\nEl ranking ha quedado del siguiente modo:");				
				Thread.interrupted();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}			
		}
		try 
		{
			Thread.sleep(1000);							
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
