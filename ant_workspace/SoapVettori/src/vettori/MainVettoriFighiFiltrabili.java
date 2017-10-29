package vettori;

public class MainVettoriFighiFiltrabili 
{

	public static void main(String[] args)
	{

		//Funziona solo perch� Persona implementa filtrabile.
		Vettore<Persona> persone = new Vettore<Persona>
		(
			new Persona[] 
			{
				new Persona("Ferdinando", "Primerano", "Monza",37),	
				new Persona("MiaEx", "InfernoPrendaIlSuoNome", "Milano",30),
				new Persona("MiaExEx", "AncheLei", "Milano",26),
				new Persona("Ferdinando", "Magellano", "Monza",26),
				new Persona("Ermanno", "Magellano", "Monza",26),		
			}
		);

		//Fare funzionare questo codice senza aggiungere nuove classi
		for(
			Persona p:persone
					.filtra("citta","Monza")
					.filtra("nome","Ferdinando")
					.toList()
			)
			System.out.println(p);
		
		
	}

}
