package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Product;
import store.IStore;
import store.StoreFactory;
import view.View;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	IStore store = 
			StoreFactory.create("PROXY", "jdbc:mysql://localhost/JavaStore?user=root&password=toor");
	
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		View v = new View();
		v.folder = "//Users//rjko//_ant//ant_repo//ant_workspace//Assembly2//WebContent//template";
		
		String comando = request.getParameter("item");
		String ris = "";
		ArrayList<Product> p = null;
		
		if(comando == null) comando="";
		
		switch(comando)
		{
//			case "listacpu":
//				p = store.listProduct("cpu");
//				for(Product prod:p)
//					ris += prod.toString()+"<br>";
//				break;
			case "cpu":
				p = store.listProduct("cpu");
				break;
			case "ram":
				p = store.listProduct("ram");
				break;
			case "memory":
				p = store.listProduct("memory");
				break;
			case "display":
				p = store.listProduct("display");
				break;
			case "pc":
				p = store.listProduct("pc");
				break;
			default:
				ris = v.fileContent("index.html");
				break;
		}
		
		response.getWriter()
				.append(v.productList(p));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
