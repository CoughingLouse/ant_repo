package web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.City;
import entities.Hobby;
import entities.Person;
import utils.Utils;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	City c;
	
	static String leggi(String nomefile)
	{
		String ris = "";
		String path = "/Users/rjko/_ant/ant_repo/ant_workspace/mRipasso/WebContent/views/".replace("/","//");
		String filepath = path + nomefile + ".html";
		
		//System.out.println(filepath);
		
		try
		{
			Scanner dati = new Scanner(new File(filepath));
			
			while(dati.hasNextLine())
				ris += dati.nextLine();
			
			dati.close();
		}
		catch(Exception e)
		{
			ris = "";
		}
		
		return ris;				
	}

    public Index()
    {
        c = new City("jdbc:mysql://localhost:3306/city?user=root&password=toor"); // percorso del db
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String command = request.getParameter("command"); // legge dall'URL il param "command", null se non c'è
		response.setContentType("text/html");
		
		if(command == null)
			command = "home";
		
		String ris = "";
		
		switch(command)
		{
			case "home":
				ris = leggi("home");
				break;
//			case "list":
//				for(Person p:c.getPeople())
//				{
//					
//					String hobbies = "";
//					for(Hobby h:p.getHobbies())
//					{
//						hobbies += h.getNome() + ", ";
//					}
//					if(hobbies.length()>2)
//						hobbies = hobbies.substring(0, hobbies.length()-2);
//					
//					// new in Java8
//					//String hobbies = String.join(", ", p.getHobbies());
//					
//					ris += leggi("list")
//							.replace("[name]", p.getName()+": ")
//							.replace("[age]", p.getAge()+"")
//							.replace("[profession]", p.getProfession())
//							.replace("[hobbies]", hobbies);
//					
//					//System.out.println(p.toJSON());
//				}
//				break;
//			case "forminsertperson":
//				ris = leggi("forminsertperson"); // serve per passare dal menu alla form
//				break;
			case "insertperson":
				ArrayList<Hobby> hob = new ArrayList<Hobby>();
				String[] hobbyArrivati = request.getParameter("hobbies").split(",");
				for(String s:hobbyArrivati)
					hob.add(new Hobby(Utils.capitalize(s)));
				
				Person q = new Person();
				q.setName(Utils.capitalize(request.getParameter("name")))
				.setAge(Integer.parseInt(request.getParameter("age")))
				.setProfession(Utils.capitalize(request.getParameter("profession")))
				.setHobbies(hob);
				
//				Person q = new Person(
//						Utils.capitalize(request.getParameter("name")),
//						Integer.parseInt(request.getParameter("age")),
//						Utils.capitalize(request.getParameter("profession")),
//						hob);
				
				ris = c.insert(q) ? "Well done!" : "666 DEATH INCOMING 666";
				break;
			case "inserthobby":
				ris = c.insertHobby(Utils.capitalize(request.getParameter("name"))) ? "Well done!" : "SOMETHING WRONG";
				break;
			case "peoplejson":
				response.setContentType("application/json");
				response.getWriter().write(c.toJSON());
				break;
			case "hobbyjson":
				response.setContentType("application/json");
				response.getWriter().write(c.hobbyJSON());
				break;
			default:
				ris = "404 PAGE NOT FOUND";
		}
		
//		if(!command.equals("peoplejson"))
//			response.getWriter().append(leggi("menu")); // scrive nella pagina web ris
//		System.out.println(response.getContentType());
		if(response.getContentType().equals("text/html"))
				response.getWriter().append(leggi("menu"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
