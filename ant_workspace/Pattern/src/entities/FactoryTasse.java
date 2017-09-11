package entities;

public class FactoryTasse 
{
	public static ITasse crea(String tipo)
	{
		ITasse ris = null;
		switch(tipo)
		{
		case "ITALIA":
			ris = new TasseItaliane();
			break;
		case "USA":
			ris = new TasseUsa();
			break;
		
		}
		return ris;
	}
	
}
