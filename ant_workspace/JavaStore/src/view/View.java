package view;
import java.util.Scanner;
import java.io.*;
import entities.*;
import java.util.ArrayList;

public class View
{

	public String folder;
	
	public String fileContent(String file)
	{
		String rtn = "";
		Scanner s = null;
		try
		{
			s = new Scanner(new File(folder+"\\"+file));
			while(s.hasNextLine())
				rtn+=s.nextLine();
		}
		catch(FileNotFoundException e)
		{
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
		String ramList ="";
		String rtn = fileContent("index.html");
		
		for(Product prod:products)
		{
			if(prod!=null) ramList += prod.getId() + " " + prod.getType() + "<br>";
		}
		
		rtn = rtn.replace("[ramlist]", ramList);
		
		return rtn;
	}
	
}
