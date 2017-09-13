package view;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Product;

public class View
{

	public String folder;
	
	public String fileContent(String file)
	{
		String rtn = "";
		Scanner s = null;
		try
		{
			s = new Scanner(new File(folder+"//"+file));
			while(s.hasNextLine())
				rtn+=s.nextLine();
			//System.out.println("Ce l'ho fatta");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			rtn = "TEMPLATE NOT FOUND";
		}
		finally
		{
			s.close();
		}
		return rtn;
	}
	
//	public String compile(String body)
//	{
//		return 
//			fileContent("menu.html")+
//			fileContent(body)+
//			fileContent("footer.html");
//	}
	
	public String productList(ArrayList<Product> products)
	{
		String productList ="";
		String rtn = fileContent("index.html");
		
		if(products!=null)
		{
			for(Product prod:products)
			{
				if(prod!=null) productList += prod.getId() + " " + prod.getType() + "<br>";
			}
		}
		
		rtn = rtn.replace("[lista_prodotti]", productList);
		
		return render(rtn);
	}

	public String render(String html)
	{
		return html.replace("[menu]", fileContent("menu.html"))
				.replace("[footer]", fileContent("footer.html"));
	}
	
}
