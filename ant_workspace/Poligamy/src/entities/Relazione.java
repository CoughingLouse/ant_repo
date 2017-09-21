package entities;

public class Relazione 
{

	int p1;
	int p2;
	String tipo;
	int da;
	int a;

	public Relazione(int p1, int p2, String tipo, int da, int a) 
	{
		this.p1 = p1;
		this.p2 = p2;
		this.tipo = tipo;
		this.da = da;
		this.a = a;
	}
}
