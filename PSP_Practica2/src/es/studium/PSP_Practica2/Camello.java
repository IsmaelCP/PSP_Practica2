package es.studium.PSP_Practica2;

import java.util.Random;

public class Camello implements Runnable {

	private static int numero;
	private static int posicion = 0;
	private static int recorrido = 0;
	private static boolean fin = false;
	private static int posLider = 0;
	private static int ganador = 1;

	public Camello()
	{
		numero = 0;
	}

	public Camello(int n)
	{
		numero = n;
	}

	public static int getNumeroCamello()
	{
		return numero;
	}

	public void setNumeroCamello(int nc)
	{
		numero = nc;
	}

	public static int getPosicionCamello()
	{
		return posicion;
	}

	public static void setPosicion(int posCam)
	{
		posicion = posCam;
	}

	public void run() 
	{
		while(fin == false)
		{
			muestraCarrera();
			try 
			{
				Thread.sleep(500);
			} 
			catch (InterruptedException ex) 
			{
				ex.printStackTrace();
			}

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

	// Realiza el avance de los camellos
	public static int avanza() 
	{
		int mov = tirada();
		int nuevaPos = getPosicionCamello() + mov;
		setPosicion(nuevaPos);

		return mov;
	}

	// Guarda en la variable posLider el camello que va en primera posición
	public static void camelloPrimero()
	{
		if(getPosicionCamello() > posLider)
		{
			posLider = getPosicionCamello();
		}
	}

	// Comprueba el fin de la carrera
	public static void finCarrera()
	{
		if(getPosicionCamello() >= recorrido)
		{
			if(ganador == 1)
			{
				ganador = getNumeroCamello();
			}
		}
	}

	// Muestra el avance de la carrera
	public static synchronized void muestraCarrera()
	{
		int avance = avanza();
		String carrera = "";

		while(fin == false)
		{
			carrera = "Camello " + getNumeroCamello() + " avanza " + avance + " posiciones, y lleva " + getPosicionCamello() + " posiciones, y va";
			if(getPosicionCamello() == posLider)
			{
				carrera = carrera + " en primera posición.";
			}
			else 
			{
				carrera = carrera + " a " + (posLider - getPosicionCamello() + " posiciones.");
			}
			System.out.println(carrera);
		}
		if(ganador == getNumeroCamello())
		{
			fin = true;
			System.out.println("El Camello " + getNumeroCamello() + " ha ganado la carrera.");
		}
	}

}