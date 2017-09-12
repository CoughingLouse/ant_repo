package entities;

public class Cerchio implements IForma
{

	int r;
	
	public Cerchio(int r)
	{
		this.r = r;
	}
	
	//Newton perdonami
	public double perimetro()
	{
		return 2*r*3.1456;
	}

	
}
