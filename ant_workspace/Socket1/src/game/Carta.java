package game;

public class Carta {
	
	String valore;
	String seme;
	
	public Carta(String v, String s)
	{
		valore = v;
		seme = s;
	}
	
	public int getValore()
	{
		try
		{
			return Integer.parseInt(valore);
		}
		catch(Exception e)
		{
			return 10;
		}
	}
}
