package entities;

import java.util.HashMap;

public class Display extends Component
{
	
	private static final int MINSIZE=5; 		//dimensione minima di uno schermo. Serve per calcolare il prezzo 
	private static final double INCHPRICE=0.1; 	//bonus percentuale per ogni inch sopra il minimo
	private static final double PREMIUMFHD=0.1;	//bonus per il FHD
		
	private int inch;
	
	@Override
	public double getMargin() 
	{
		return 
			1
			+
			(inch-MINSIZE) * INCHPRICE 
			+ 
			(getType().equalsIgnoreCase("FHD") ? Taxes.SALESTAXES+PREMIUMFHD : Taxes.SALESTAXES);
	}

	@Override
	public String toXML()
	{
		return
			super.toXML()+
			"<inch>"+inch+"</inch>";
	}

	@Override
	public HashMap<String,String> toMap()
	{
		HashMap<String,String> rtn = super.toMap();
		
		rtn.put("inch", inch+"");
		
		return rtn;
	}
}
