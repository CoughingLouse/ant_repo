package entities;

import java.util.HashMap;

public class RAM extends Component
{
	private final static double MINPRICEGB = 0.01;
	private final static double MINPRICEDDR = 0.08;
	private final static double PREMIUMDDR = 0.1;
	private int gb;
	
	public int getGb()
	{
		return gb;
	}

	public void setGb(int gb)
	{
		this.gb = gb;
	}

	@Override
	public double getMargin()
	{
		return 1 + Taxes.SALESTAXES + MINPRICEGB*gb + 
				(
					getType().equalsIgnoreCase("DDR4")
					||
					getType().equalsIgnoreCase("DDR3")
					?
						MINPRICEDDR
					:
						PREMIUMDDR
				);
	}

	@Override
	public String toXML()
	{
		return
			super.toXML()+
			"<gb>"+gb+"</gb>";
	}
	
	@Override
	public HashMap<String,String> toMap()
	{
		HashMap<String,String> rtn = super.toMap();
		
		rtn.put("gb", gb+"");
		
		return rtn;
	}

}
