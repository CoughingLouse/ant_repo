package acqua;

// Siamo nel 2007. Tutti i pozzi hanno dei contatori
public class Lettura implements ILettura
{
	final static double PRUDENZIALE = 1.2;

	@Override
	public int sollevato(int li, int ci, int lsca, int csca) 
	{
		return (int)( (li*ci + lsca*csca) * PRUDENZIALE);
	}

}
