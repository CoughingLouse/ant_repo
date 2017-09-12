package entities;

public class Calcolo implements ICalcolo 
{

	public boolean isPrime(int n)
	{
		boolean ris = true;
		for(int i=2;i<n/2;i++)
			if(n % i == 0)
				ris = false;
		return ris;
	}
	
	@Override
	public int massimoPrimo(int n) 
	{
		int max = 1;
		
		for(int i=1;i<=n;i++)
			if(isPrime(i))
				max = i;
		return max;
	}

	
}
