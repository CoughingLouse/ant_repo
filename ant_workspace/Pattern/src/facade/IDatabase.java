package facade;
import java.util.HashMap;
import java.util.List;

public interface IDatabase 
{
	default public HashMap<String, String> row(String sql) 
	{
		return rows(sql).get(0);		
	}
	
	public List<HashMap<String,String>> rows(String sql);
	
	default HashMap<String, String> row(String table, int id) 
	{
		return row("select * from "+table+" where id="+id);
	}

	
	default String singleResult(String sql) 
	{
		String ris = "";
		HashMap<String,String> riga = row(sql);
		for(String chiave:riga.keySet())
			ris = riga.get(chiave);
	    return ris;
	}
	
	default public int singleIntResult(String sql)
	{
		return Integer.parseInt(singleResult(sql));
	}
	
	default public double singleDoubleResult(String sql)
	{
		return Double.parseDouble(singleResult(sql));
	}
	
}


