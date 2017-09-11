package store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.*;

public class Store implements IStore
{
	private ArrayList<Product> products = new ArrayList<Product>();
	private Connection db = null;

	//Metodo che permette la connessione con il database
	public Store(String path)
	{
		try
		{
		    Class.forName("com.mysql.jdbc.Driver");
		    db = DriverManager
                 .getConnection(path);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("CONNECTION ERROR");
			System.exit(-1);
		}	
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
		ArrayList<Product> rtn = new ArrayList<Product>();
		ResultSet rs = null;
		Product p = null;
		try
		{
			Statement s = db.createStatement();
			rs = s.executeQuery("select * from product where kind = '"+type+"'");
			while (rs.next())
			{
				if(type.equalsIgnoreCase("RAM"))
				{
					p = new RAM();
					p.setId(rs.getInt(1));
					p.setDescription(rs.getString(2));
					p.setType(rs.getString(4));	
				}
				if(type.equalsIgnoreCase("CPU"))
				{
					p = new CPU();
					p.setId(rs.getInt(1));
					p.setDescription(rs.getString(2));
					p.setType(rs.getString(4));	
				}
				if(type.equalsIgnoreCase("Display"))
				{
					p = new CPU();
					p.setId(rs.getInt(1));
					p.setDescription(rs.getString(2));
					p.setType(rs.getString(4));	
				}
				if(p!=null)
					rtn.add(p);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return rtn;
	}
}
