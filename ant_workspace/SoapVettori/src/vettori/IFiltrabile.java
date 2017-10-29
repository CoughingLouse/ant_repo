package vettori;
import java.util.HashMap;

public interface IFiltrabile 
{
	default boolean valido(HashMap<String,String> condizioni)
	{
		boolean ris = true;
		for(String chiave:condizioni.keySet())
			ris &= valido(chiave, condizioni.get(chiave));
		return ris;
	}
	
	boolean valido(String campo, String valore);
}
