package entities;

import java.util.HashMap;

public class Hash2 
{
	
	public static void main(String[] args) 
	{

		HashMap<String,Integer> freq
		= new HashMap<String,Integer>();
		
		String messaggio =
		"ARCO ARCO ARTE ARCO ARCO ARNO CONO CATTIVO DOLORE";

		String[] parti = messaggio.split(" ");
		
		for(String p:parti)
			if(freq.get(p)==null)
				freq.put(p, 1);
			else
				freq.put(p, freq.get(p)+1);
		
		System.out.println(freq);
		
		
	}

}
