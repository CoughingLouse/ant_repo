package entities;

public class MainTasse {

	public static void main(String[] args)
	{
	
		ITasse t = FactoryTasse.crea("USA");
		
		t.setGuadagni(100000);
		t.setSpeseSanitarie(4000);
		t.setFigli(0);
		
		System.out.println(t.calcola());
		
	}

}
