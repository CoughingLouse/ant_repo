package store;

import java.sql.Connection;
import java.util.HashMap;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.*;

public class StoreProxy implements IStore
{
	private ArrayList<Product> products = new ArrayList<Product>();
	private Connection db = null;
	private IStore storeReale;
	
	//CACHE
	HashMap<String, ArrayList<Product>>
	cache = new HashMap<String, ArrayList<Product>>();
	
	//Metodo che permette la connessione con il database
	public StoreProxy(String path)
	{
		storeReale = StoreFactory.create("IDEALE", path);
	}
	
	public Connection getConnection()
	{
		return db;		
	}
	
	//Metodo che restituisce un ResultSet, il db esegue la query che gli passiamo come parametro
	public ResultSet read(String sql)
	{
		ResultSet rtn = null;
		
		try
		{
			Statement s = db.createStatement();
			rtn = s.executeQuery(sql);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rtn;		
	}
	
	//Metodo che restituisce un boolean, quando esegue la query (passata come parametro) restituisce true altrimenti false
	public boolean execute(String sql)
	{
		boolean rtn = false;
		
		try
		{
			Statement s = db.createStatement();
			//Quando io NON devo fare una query
			//Uso EXECUTE, non EXECUTEQUERY
			s.execute(sql);
			rtn = true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rtn;
	}
	

	
	public ArrayList<Product> listProduct(String type)
	{
		ArrayList<Product> rtn;
		
		
		if(!(type.equals("CPU"))||(type.equals("RAM"))||(type.equals("Memory"))||(type.equals("Display")))
			return null;
		
		if(cache.get(type)!=null)
		{
			System.out.println("Sto usando la cache...");
			rtn = cache.get(type);
		}
		else
		{
			rtn = storeReale.listProduct(type);
			cache.put(type,rtn);
		}
		
			return rtn;
	}
}
