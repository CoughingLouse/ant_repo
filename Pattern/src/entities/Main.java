package entities;

public class Main {

	public static void main(String[] args)
	{
	
		//Una prima factory, non ottimale
		IForma f = FactoryForme.crea("Q", 4);
		//Il modo GIUSTO di usarla
		System.out.println(f.perimetro());
		// Sarebbe meglio evitare...
		// Dipendenza fra Main e Quadrato
		System.out.println(((Quadrato)f).area());
		
	}

}
