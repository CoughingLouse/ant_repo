package entities;

import java.util.HashMap;


public abstract class Component extends Product
{
	//prezzo pagato per ogni componente
	private double cost;
	
	public double getCost()
	{
		return cost;
	}

	public void setCost(double cost)
	{
		this.cost = cost;
	}
	
	@Override
	public double getPrice()
	{
		return getMargin() * cost;
	}
	
	@Override
	public String toXML()
	{
		return
			super.toXML()+
			"<cost>"+cost+"</cost>";
	}
	
	@Override
	public HashMap<String,String> toMap()
	{
		HashMap<String,String> rtn = super.toMap();
		
		rtn.put("cost", cost+"");
		
		return rtn;
	}

}
