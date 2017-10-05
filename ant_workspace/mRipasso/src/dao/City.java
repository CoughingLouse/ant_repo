package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entities.Hobby;
import entities.Person;
import utils.Utils;

// DAO (Data Access Object) //

public class City {
	
	private ArrayList<Person> people = new ArrayList<Person>();
	private Connection db;
	
	private final static String ALLPEOPLE = "select * from people";
	private final static String LOADHOBBIES =
			"select * from peopledo inner join hobbies on peopledo.idhobby "
			+ "= hobbies.id where peopledo.idperson = ?";
	private final static String INSERTPERSON =
			"insert into people (name,age,profession) values (?,?,?)";
	private final static String INSERTHOBBY =
			"insert into hobbies (name) values (?)";
	private final static String DELETEPERSON =
			"delete from people where id = ?";
	//<!-- DELETE FROM `city`.`hobbies` WHERE `id`='492'; -->
	
	public City(String dbpath)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			db = DriverManager.getConnection(dbpath);
			load(); // caricherà tutte le persone dal db alla List<Person>
		}
		catch(Exception e)
		{
			System.out.println("No DB.Terminating...");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void load() // modifica lo stato dell'oggetto, quindi void
	{
		people.clear(); // metodo svuota List
		try
		{
			PreparedStatement p = db.prepareStatement(ALLPEOPLE);
			ResultSet rs = p.executeQuery(); // tabella ritornata da esecuzione query
			while(rs.next())
			{
				ArrayList<Hobby> hobby = new ArrayList<Hobby>();
				PreparedStatement p1 = db.prepareStatement(LOADHOBBIES);
				p1.setInt(1, rs.getInt("id")); // preparedStatement parte da 1 sostotuendo i "?"
				ResultSet rs1 = p1.executeQuery();
				while(rs1.next())
				{
					hobby.add(new Hobby(	rs1.getInt("hobbies.id"),
											rs1.getString("hobbies.name")
										)
							);
				}
				
				Person per = new Person();
				per.setName(rs.getString("name"))
					.setId(rs.getInt("id"))
					.setAge(rs.getInt("age"))
					.setProfession(rs.getString("profession"))
					.setHobbies(hobby);
				
				people.add(per);
			}
		}
		catch(Exception e)
		{
			System.out.println("Errors in load()");
		}
		
	}
	
	public ArrayList<Person> getPeople()
	{
		return people;
	}
	
	public boolean insert(Person p)
	{
		boolean ris = false;
		try
		{
			PreparedStatement ps = db.prepareStatement(INSERTPERSON);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getProfession());
			ps.executeUpdate();
			
			for(Hobby h:p.getHobbies())
			{
				ArrayList<Hobby> list = loadHobbies();
				boolean manca = true;
				for(Hobby hob:list)
				{
					if(h.getNome().equalsIgnoreCase(hob.getNome()))
					{
						manca = false;
						break;
					}
				}
				if(manca)
					salvaHobby(h);
			}
			
			PreparedStatement ps2 = db.prepareStatement("insert into peopledo (idperson, idhobby) values (?,?)");
			
			int ultimo = ultimapersona();
			ArrayList<Hobby> lista = loadHobbies();
			
			for(Hobby h:p.getHobbies())
			{
				ps2.setInt(1, ultimo);
				
				for(Hobby j:lista)
				{
					if(j.getNome().equalsIgnoreCase(h.getNome()))
					{
						ps2.setInt(2, j.getId());
						break;
					}
				}
				ps2.executeUpdate();
			}
			
			ris = true;
			load();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ris;
	}

	public boolean insertHobby(String newHobby)
	{
		boolean ris = false;
		try
		{
			PreparedStatement ps = db.prepareStatement(INSERTHOBBY);
			ps.setString(1, Utils.capitalize(newHobby));
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ris;
	}
	
	// TODO: deletePerson()
	public boolean deletePerson(int personid)
	{
		boolean ris = false;
		try
		{
			PreparedStatement ps = db.prepareStatement(DELETEPERSON);
			ps.setInt(1, personid);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ris;
	}
	
	public ArrayList<Hobby> loadHobbies()
	{
		ArrayList<Hobby> ris = new ArrayList<Hobby>();
		
		try
		{
			PreparedStatement ps = db.prepareStatement("select * from hobbies");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ris.add(new Hobby(rs.getInt("id"), rs.getString("name")));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return ris;
	}
	
	public boolean salvaHobby(Hobby b)
	{
		boolean ris = false;
		try
		{
			String sql = "insert into hobbies (name) values (?)";
			PreparedStatement ps = db.prepareStatement(sql);
			ps.setString(1, Utils.capitalize(b.getNome()));
			ps.executeUpdate();
			ris = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ris;
	}
	
	public int ultimapersona()
	{
		int ris = 0;
		try
		{
			PreparedStatement ps = db.prepareStatement("select max(id) as id from people");
			ResultSet rs = ps.executeQuery();

				while(rs.next())
					ris = rs.getInt("id");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ris;
	}
	
	public String toJSON() // City ha un ArrayList<Person> people
	{
		String s = "{\"people\":["; // incomprensibile: replace() non sostituisce questi apici ?!?
		
		for(Person p:this.people)
			s += p.toJSON() + ",";
		
		if(this.people.size() > 0)
			s = s.substring(0, s.length()-1);
		
		s += "]}";
		s.replace("'", "\"");
		
		return s;
	}
	
	public String hobbyJSON()
	{
		ArrayList<Hobby> hobbies = loadHobbies();
		
		String s = "{\"hobbies\":["; // incomprensibile: replace() non sostituisce questi apici ?!?
		
		for(Hobby h:hobbies)
			s += h.toJSON() + ",";
		
		if(this.people.size() > 0)
			s = s.substring(0, s.length()-1);
		
		s += "]}";
		s.replace("'", "\"");
		
		return s;
	}
}
