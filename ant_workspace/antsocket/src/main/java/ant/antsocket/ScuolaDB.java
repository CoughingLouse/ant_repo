package ant.antsocket;

import java.sql.*;

public class ScuolaDB {

	protected Connection db;
	
	public ScuolaDB(String percorso)
	{
	  db = null;
	  try 
	  {
		  Class.forName("com.mysql.jdbc.Driver");
		  db = DriverManager.getConnection(percorso);
	  } 
	  catch(Exception e) 
	  {
		  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		  System.exit(0);
	  }
				
	}
	
	//Si usa per leggere un insieme di dati
	public ResultSet leggiDati(String sql) 
	{
		try
		{
			Statement stmt 	= 	db.createStatement();
			return 	stmt.executeQuery(sql);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	// Si usa per leggere e GRAFICARE un insieme i dati
	// Un premio a chi lo capisce.
	public String formattaDati(String sql, String riga, String[] campi)
	{
		ResultSet rs = null;
		String ris = "";
		try
		{
			Statement stmt 	= 	db.createStatement();
			rs 	=	stmt.executeQuery(sql);
			while(rs.next())
			{
				ris+=riga;
				for(int i=0;i<campi.length;i++) ris=ris.replace("["+campi[i]+"]", rs.getString(campi[i]));
			}
		}
		catch(Exception e)
		{
			ris="ERRORE PER LA QUERY:"+sql;
		}
		return ris;
		
	}
	
	public String vista(String sql, String riga, String[] campi)
	{
		return formattaDati(sql,riga,campi);
	}
	
	
	//Si usa per leggere UN solo dato. ad esempio il risultato di una funzione
	public String leggiDato(String sql)
	{
		String ris="";
		try
		{
			Statement stmt 	= 	db.createStatement();
			ResultSet rs =	stmt.executeQuery(sql);
			//Il primo campo, il campo di indice 1
			if(rs.next()) ris=rs.getString(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ris="";
		}
		return ris;
	}

	public boolean esegui(String sql)
	{
		boolean ris = true;
		try
		{
			Statement s = db.createStatement();
			s.execute(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ris = false;
		}
		return ris;
		
	}
	
		
	
}
