package entities;

import java.util.HashMap;
import java.util.ArrayList;

public abstract class Product 
{

	private int id;
	private String type, description;
	private ArrayList<Review> reviews = new ArrayList<Review>();
	
	public abstract double getPrice();
	public abstract double getMargin();

	public double getRating()
	{
		int sum = 0;
		
		for(Review review : reviews)
			sum += review.getRating();
		
		return sum/reviews.size();
	}

	public int getId() 
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	public String toXML()
	{
		return
			"<id>"+id+"</id>"+
			"<type>"+type+"<type>"+
			"<description>"+description+"<description>";
	}
	
	public HashMap<String,String> toMap()
	{
		HashMap<String,String> rtn = new HashMap<String,String>();
		
		rtn.put("id", id+"");
		rtn.put("type", type);
		rtn.put("description", description);
		
		return rtn;
	}
	
}
