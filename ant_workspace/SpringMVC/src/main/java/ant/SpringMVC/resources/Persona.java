package ant.SpringMVC.resources;

public class Persona {

	public String nome;
	public String cognome;
	
	public String getNome()
	{
		return nome;
	}

	public String getCognome()
	{
		return cognome;
	}

	
	public Persona(String nome, String cognome) 
	{
		this.nome = nome;
		this.cognome = cognome;
	}
	
	
	
}
