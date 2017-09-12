package facade;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.sql.*;

public class Database implements IDatabase
{
	Connection connection = null;
	
	public Database(String path)
	{
		try
		{
		    Class.forName("com.mysql.jdbc.Driver");
		    connection = DriverManager
                 .getConnection(path);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	

	
	@Override
	public List<HashMap<String, String>> rows(String sql) 
	{
		ArrayList<HashMap<String,String>> ris = new ArrayList<HashMap<String,String>>();
		ResultSet rs = null;
		try
		{
			Statement s = connection.createStatement();
			rs = s.executeQuery(sql);
			
			while(rs.next())
			{
				HashMap<String,String> riga = new HashMap<String,String>();
				for(int ncampo=1;ncampo<=rs.getMetaData().getColumnCount();ncampo++)
					riga.put(
							rs.getMetaData().getColumnName(ncampo), 
							rs.getString(ncampo)
							);
				ris.add(riga);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ris;

	
	
	}
	
	
}
