package entities;

import java.util.HashMap;

public class Memory extends Component
{
	private final static double PREMIUMSSD = 0.1;
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
		return 1 + (getType().equalsIgnoreCase("SSD") ? (Taxes.SALESTAXES+PREMIUMSSD )*gb : Taxes.SALESTAXES*gb);
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
