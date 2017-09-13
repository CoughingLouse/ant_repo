package entities;
import java.util.ArrayList;
import java.util.HashMap;

public class PC extends Product
{
	private final static double PREMIUMPRICE = 0.1;
	
	ArrayList<Component> components = new ArrayList<Component>();
		
	@Override
	public double getPrice() 
	{
		double cost = 0;
		
		for(Component component : components)
			cost += component.getCost();
		
		return  getMargin() * cost;
	}

	@Override
	public double getMargin() 
	{
		double rtn = 0;
		
		for(Component component : components)
			rtn = rtn > component.getMargin() ? rtn : component.getMargin();
		
		return rtn + (getType().equalsIgnoreCase("GAMING") || getType().equalsIgnoreCase("WORKSTATION") ? PREMIUMPRICE : 0);
	}
	
	public HashMap<String,String> toMap()
	{
		return super.toMap();
	}
	
}
