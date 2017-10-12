package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Viaggio;

/**
 * Servlet implementation class Viaggi
 */
@WebServlet("/Viaggi")
public class Viaggi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ArrayList<Viaggio> viaggi;
    public Viaggi()
    {
    	viaggi = (ArrayList<Viaggio>) Arrays.asList
    			(new Viaggio[]
    			{
					new Viaggio("Alberta",5,1000,false),
					new Viaggio("Berlino",10,500,false),
					new Viaggio("Caracas",15,1000,true),
					new Viaggio("Denver",20,1000,false),
					new Viaggio("Empoli",25,1000,false),
					new Viaggio("Francoforte",30,1000,true)
    			});
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String cmd = request.getParameter("cmd");
//		response.setContentType("text/html");
		
		if(cmd == null)
			cmd = "home";
		
		String ris = "";
		switch(cmd)
		{
			case "home":
				ris = "{[";
				for(int i=0; i<viaggi.size(); i++)
				{
					ris += viaggi.get(i).toJSON(i) + ",";
				}
				ris += "]}";
				break;
			case "mostra":
				ris = "";
				break;
			case "prenota":
				ris = "";
				break;
			default:
				ris = "404 PAGE NOT FOUND";
		}
		
		System.out.println(ris);
		response.getWriter().append(ris);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
