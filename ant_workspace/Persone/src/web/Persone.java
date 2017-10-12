package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Persona;

/**
 * Servlet implementation class Persone
 */
@WebServlet("/Persone")
public class Persone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ArrayList<Persona> persone;
	
    public Persone()
    {
    	persone = (ArrayList<Persona>) Arrays.asList
    			(new Persona[]
    			{
    					new  Persona("Ferdinando", 37),
    					new  Persona("Yari", 21),
    					new  Persona("Fabio", 23),
    					new  Persona("Marina", 30)
    			});
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET è per LEGGERE
		int id = Integer.parseInt(request.getParameter("id"));
		response.getWriter().append(persone.get(id).toJSON());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST è per AGGIORNARE
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = (request.getParameter("nome"));
		int eta = Integer.parseInt(request.getParameter("eta"));
		
		// FIXME: cambiando da vettore ad ArrayList<> casino! Cmq serve creare una persona
		persone.get(id).add(nome);
		persone.add(eta);
		
		response.getWriter().append(persone[id].toJSON());
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// PUT è per AGGIUNGERE
		int id = Integer.parseInt(request.getParameter("id"));
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DELETE è per CANCELLARE
	}

}
