package esperimenti;

public class SommaFattorialiCifreNumero {

	public static void main(String[] args) {

		final int[] fact = {1,1,2,6,24,120,720,5040,40320,362880};
		final int LIMIT = 1000000;
		boolean found = false;
		int m, n, sum;

		for(n=12; !found || (n<LIMIT); n++)
		{
			for(m=n, sum=0; m>0; m/=10)
			{
				int r = m-(m/10)*10;
				sum += fact[r];
			}
			if(sum == n)
			{
				found = true;
				System.out.println("Found: n="+n+", sum="+sum+" (LIMIT: "+LIMIT+")");
			}
		}
	}
}

