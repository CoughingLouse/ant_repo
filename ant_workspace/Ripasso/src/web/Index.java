package web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.City;
import entities.Person;

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
		String path = "/Users/rjko/_ant/ant_repo/ant_workspace/Ripasso/WebContent/views/".replaceAll("/","//");
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
		if(command == null)
			command = "home";
		
		String ris = "";
		
		switch(command)
		{
			case "home":
				ris = leggi("home");
				break;
			case "list":
				for(Person p:c.getPeople())
				{
					/*
					String hobbies = "";
					for(String h:p.getHobbies())
					{
						hobbies += h + ", ";
					}
					hobbies = hobbies.substring(0, hobbies.length()-2);
					*/
					
					// new in Java 8
					String hobbies = String.join(", ", p.getHobbies());
					
					ris += leggi("list")
							.replace("[name]", p.getName()+": ")
							.replace("[age]", p.getAge()+"")
							.replace("[profession]", p.getProfession())
							.replace("[hobbies]", hobbies);
				}
				break;
			case "forminsertperson":
				ris = leggi("forminsertperson"); // serve per passare dal menu alla form
				break;
			case "insertperson":
				ArrayList<String> hob = new ArrayList<String>(
						Arrays.asList(request.getParameter("hobbies").split(",")));
				
				Person q = new Person();
				q.setName(request.getParameter("name"))
				.setAge(Integer.parseInt(request.getParameter("age")))
				.setProfession(request.getParameter("profession"))
				.setHobbies(hob);
				
				ris = c.insert(q) ? "Well done!" : "666 DEATH INCOMING 666";
				break;
			default:
				ris = "404 PAGE NOT FOUND";
		}
		
		response.getWriter().append(leggi("menu")).append(ris); // scrive nella pagina web ris
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
