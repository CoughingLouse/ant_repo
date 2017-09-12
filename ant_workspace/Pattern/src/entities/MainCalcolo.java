package entities;

public class MainCalcolo {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		ICalcolo c = new CalcoloProxy();
		
		System.out.println(c.massimoPrimo(60000));
		System.out.println(c.massimoPrimo(60000));
		System.out.println(c.massimoPrimo(59000));
		System.out.println(c.massimoPrimo(60000));
		System.out.println(c.massimoPrimo(59000));
		
		
	}

}
