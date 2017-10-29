package vettori;

import java.util.HashMap;

public class Persona implements IFiltrabile
{
	String nome;
	String cognome;
	String citta;
	int eta;
	
	public Persona(String nome, String cognome, String citta, int eta) 
	{
		this.nome = nome;
		this.cognome = cognome;
		this.citta = citta;
		this.eta = eta;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", citta=" + citta + ", eta=" + eta + "]";
	}

	@Override
	public boolean valido(String campo, String valore)
	{
		boolean ris = true;
		if(campo.equalsIgnoreCase("nome"))
			ris &= nome.equals(valore);
		if(campo.equalsIgnoreCase("cognome"))
			ris &= cognome.equals(valore);
		if(campo.equalsIgnoreCase("citta"))
			ris &= citta.equals(valore);
		
		return ris;		
	}
}
