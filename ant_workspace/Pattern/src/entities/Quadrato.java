package entities;

public class Quadrato implements IForma
{
	int l;
	
	public Quadrato(int l)
	{
		this.l = l;
	}
	
	public double perimetro()
	{
		return l*4;
	}
	
	public double area()
	{
		return l*l;
	}
	
	
}
