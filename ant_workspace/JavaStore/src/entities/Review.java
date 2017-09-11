package entities;

import java.util.HashMap;

public class Review 
{

	private String author, text;
	private int productid;
	private int rating; // da 1 a 5 stelle
	
	public String getAuthor() 
	{
		return author;
	}
	
	public void setAuthor(String author) 
	{
		this.author = author;
	}
	
	public String getText() 
	{
		return text;
	}
	
	public void setText(String text) 
	{
		this.text = text;
	}
	
	public int getRating() 
	{
		return rating;
	}
	
	public void setRating(int rating) 
	{
		this.rating = rating;
	}
	
	public int getProductid() 
	{
		return productid;
	}
	
	public void setProductid(int productid) 
	{
		this.productid = productid;
	}
	
	public String toXML()
	{
		return
			"<author>"+author+"</author>"+
			"<productid>"+productid+"</productid>"+
			"<rating>"+rating+"</rating>"+
			"<text>"+text+"</text>";
	}
	
	public HashMap<String,String> toMap()
	{
		HashMap<String,String> rtn = new HashMap<String,String>();
		
		rtn.put("author", author);
		rtn.put("productid", productid+"");
		rtn.put("rating", rating+"");
		rtn.put("text", text);
		
		return rtn;
	}
}
