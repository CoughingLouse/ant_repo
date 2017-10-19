package ant.SpringMVC.res;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAO 
{
	
	public List<Indumento> felpe = new ArrayList<Indumento>();
	public List<Scarpa> scarpe = new ArrayList<Scarpa>();
	public List<Pantalone> pantaloni = new ArrayList<Pantalone>();
	
	private Connection db  = null;
	// TODO: completare queries testuali
	private static final String ALLINDUMENTI = "SELECT * FROM javestito.indumenti;";
	private static final String ALLSCARPE = "SELECT * FROM javestito.scarpe;";
	private static final String ALLPANTALONI = "SELECT * FROM javestito.pantaloni;";
	private static final String ALLFELPE = "SELECT * FROM javestito.felpe;";
	
	// TODO: NEWINDUMENTO, vedere come definire il tipo per decidere la tabella
	private static final String NEWINDUMENTO =
			"INSERT INTO javestito. () VALUES (?,?);";
		
	
	public DAO(String dbpath)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			db = DriverManager.getConnection(dbpath);
			// TODO: metodi di load from DB
			loadScarpe();
			loadPantaloni();
			loadFelpe();
		}
		catch(Exception e)
		{
			System.out.println("No DB. Terminating...");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void loadScarpe()
	{
		scarpe.clear();
		try
		{
			PreparedStatement d = db.prepareStatement(ALLSCARPE);
			ResultSet rs = d.executeQuery();
			while(rs.next())
			{
				scarpe.add(new Scarpa(	
											rs.getInt("id"),
											rs.getString("marca"),
											rs.getString("modello"),
											rs.getString("colore"),
											rs.getInt("quantita")
										)
							);
			}
		}
		catch(Exception e)
		{
			System.out.println("404 SCARPE not found");
		}
	}
	
	public void loadPantaloni()
	{
		pantaloni.clear();
		try
		{
			PreparedStatement d = db.prepareStatement(ALLPANTALONI);
			ResultSet rs = d.executeQuery();
			while(rs.next())
			{
				pantaloni.add(new Pantalone(	
											rs.getInt("id"),
											rs.getString("marca"),
											rs.getString("colore"),
											rs.getInt("taglia"),
											rs.getInt("quantita")
										)
							);
			}
		}
		catch(Exception e)
		{
			System.out.println("404 PANTALONE not found");
		}
	}
	
	public void loadFelpe()
	{
		felpe.clear();
		try
		{
			PreparedStatement d = db.prepareStatement(ALLFELPE);
			ResultSet rs = d.executeQuery();
			while(rs.next())
			{
				felpe.add(new Felpa(	
											rs.getInt("id"),
											rs.getString("marca"),
											rs.getString("colore"),
											rs.getString("taglia"),
											rs.getInt("quantita")
										)
							);
			}
		}
		catch(Exception e)
		{
			System.out.println("404 SCARPE not found");
		}
	}
	
//	public boolean newIndumento(Indumento ind)
//	{
//		boolean ris = false;
//		try
//		{
//			PreparedStatement n = db.prepareStatement(NEWINDUMENTO);
//			n.setString(1, ind.getNome());
//			n.setInt(2, g.getAnno());
//			n.executeUpdate();		
//			ris = true;
//			loadGames();
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			System.out.println("Error in insert, please check");
//		}
//		return ris;
//	}
//	//otiene l'ultimo id di developer
//	public int ultimoDev()
//	{
//		int ris = 0;
//		try
//		{
//			PreparedStatement p = db.prepareStatement("select max(id) as id from developer");
//			ResultSet rs = p.executeQuery();
//			while(rs.next())
//				ris = rs.getInt("id");
//		}
//		catch(Exception e){}
//		return ris;
//	}
	

}
