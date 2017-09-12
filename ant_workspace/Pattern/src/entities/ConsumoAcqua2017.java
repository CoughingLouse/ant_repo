package entities;

public class ConsumoAcqua2017
{
	int li;
	int ci;
	ConsumoAcqua c = new ConsumoAcqua();
	
	public ConsumoAcqua2017(int li, int ci) 
	{
		this.li = li;
		this.ci = ci;
	}
	
	public int sollevato()
	{
		c.li = li;
		c.ci = ci;
		c.lsca = (int) (li*0.02);
		c.csca = 1;
		return c.sollevato();
	}
	
	public int venduto()
	{
		return (int)(c.sollevato()*0.95);
	}
	
	
	
	
}
