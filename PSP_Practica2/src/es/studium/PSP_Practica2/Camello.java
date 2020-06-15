package es.studium.PSP_Practica2;

public class Camello {
	
	private int nombre;
	private int posicionCamello;


	public Camello()
	{
		nombre = 0;
		posicionCamello = 0;
	}

	public Camello(int n, int pc)
	{
		nombre = n;
		posicionCamello = pc;
	}

	public int getNombreCamello()
	{
		return nombre;
	}

	public void setNombreCamello(int nc)
	{
		nombre = nc;
	}

	public int getPosicionCamello()
	{
		return posicionCamello;
	}

	public void setPosicionCamello(int posCam)
	{
		posicionCamello = posCam;
	}
}