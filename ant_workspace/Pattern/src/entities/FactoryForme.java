package entities;

// Una fabbrica di forme
public class FactoryForme 
{
	public static IForma crea(String tipo, int v)
	{
		IForma ris = null;
		switch(tipo)
		{
			case "Q":
				ris =  new Quadrato(v);
				break;
			case "C":
				ris =  new Cerchio(v);
				break;
		}
		return ris;
	}
	
	
}
