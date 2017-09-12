package entities;

import java.util.HashMap;

public class Hash1 
{

	
	
	public static void main(String[] args) 
	{

		HashMap<String,Double> record
		= new HashMap<String,Double>();
		
		record.put("calciovolante", 180.0);
		record.put("pugnisecondo", 3.0);
		record.put("sollevamento", 80.5);
		System.out.println(record.get("calciovolante"));
		System.out.println(record.get("corsapiana"));
	}

}
