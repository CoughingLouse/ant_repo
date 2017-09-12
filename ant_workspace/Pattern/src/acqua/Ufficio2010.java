package acqua;

public class Ufficio2010 {

	public static void main(String[] args) 
	{
		ILettura2010 l = new Lettura2010();
		System.out.println(l.sollevato(1000,1));
		System.out.println(l.venduto(1000, 1));
	}

}
