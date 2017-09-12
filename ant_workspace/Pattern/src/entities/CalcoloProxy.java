package entities;
import java.util.ArrayList;
import java.util.HashMap;

public class CalcoloProxy implements ICalcolo 
{
	
	HashMap<Integer,Integer> cache
	= new HashMap<Integer,Integer>();
	
	private Calcolo c = new Calcolo();

	@Override
	public int massimoPrimo(int n) 
	{
		int ris = 0;
		if(cache.get(n)!=null)
			ris = cache.get(n);
		else
		{
			ris = c.massimoPrimo(n);
			cache.put(n, ris);
		}
		return ris;
	}
	
	
	
}
