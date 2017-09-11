package entities;
import java.util.ArrayList;

public class CalcoloProxy implements ICalcolo 
{
	
	ArrayList<ChiamataCalcolo> cache
	= new ArrayList<ChiamataCalcolo>();
	
	private Calcolo c = new Calcolo();

	@Override
	public int massimoPrimo(int n) 
	{
		int ris = 0;
		boolean trovato = false;
		for(ChiamataCalcolo c:cache)
			if(c.n==n)
			{
				ris = c.r;
				trovato = true;
			}
		if(!trovato) 
		{
			ris= c.massimoPrimo(n);
			cache.add(new ChiamataCalcolo(n,ris));
		}
		return ris;
	}
	
	
	
}
