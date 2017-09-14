package store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import database.Database;
import entities.*;


// non avrà jdbc perchè fa schifo e vogliamo usare una facade, Database
public class StoreIdeale implements IStore {
	
	//Facade per l'accesso ai dati
	Database database;
	
	public StoreIdeale(String path)
	{
		//Delego alla facade la gestione del DB, ovvero prende il posto di JDBC
		database = new Database(path);
	}
	
	//public List<HashMap<String,String>> 
	
	public ArrayList<Product> listProduct(String type)
	{
		// devo trasformare le HashMap in oggetti di dominio
		List<HashMap<String,String>>
		righe = database.rows("select * from product where kind='"+type+"'");
		
		ArrayList<Product> ris = new ArrayList<Product>();
		
		for(HashMap<String,String> riga:righe)
		{
			if(type.equalsIgnoreCase("cpu"))
			{
				Product p = new CPU();
				p.setId(Integer.parseInt(riga.get("id")));
				p.setDescription(riga.get("description"));
				p.setType(riga.get("type"));
				ris.add(p);
			}
			if(type.equalsIgnoreCase("ram"))
			{
				Product p = new RAM();
				p.setId(Integer.parseInt(riga.get("id")));
				p.setDescription(riga.get("description"));
				p.setType(riga.get("type"));
				ris.add(p);
			}
			if(type.equalsIgnoreCase("display"))
			{
				Product p = new Display();
				p.setId(Integer.parseInt(riga.get("id")));
				p.setDescription(riga.get("description"));
				p.setType(riga.get("type"));
				ris.add(p);
			}
			if(type.equalsIgnoreCase("memory"))
			{
				Product p = new Memory();
				p.setId(Integer.parseInt(riga.get("id")));
				p.setDescription(riga.get("description"));
				p.setType(riga.get("type"));
				ris.add(p);
			}
			if(type.equalsIgnoreCase("pc"))
			{
				Product p = new PC();
				p.setId(Integer.parseInt(riga.get("id")));
				p.setDescription(riga.get("description"));
				p.setType(riga.get("type"));
				ris.add(p);
			}
		}
		return ris;

	}

}
