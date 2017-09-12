package entities;

public class ConsumoAcqua
{
	
	final static double PRUDENZIALE = 1.2;

	public String data;
	public int li;
	public int ci;
	public int lsca;
	public int csca;
	
	
	public int sollevato()
	{
		return (int)( (li*ci + lsca*csca) * PRUDENZIALE);
	}
	
}
