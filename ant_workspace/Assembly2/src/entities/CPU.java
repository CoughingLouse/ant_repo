package entities;

import java.util.HashMap;

public class CPU extends Component 
{
	private static final int CPUMINSIZE=4; 
	private static final double MINPRICECPU = 0.2;
	private static final double MINPRICECORE = 0.1;
	
	private int cores;
	private double clockSpeed;
	
	public int getCores()
	{
		return cores;
	}

	public void setCores(int cores) 
	{
		this.cores = cores;
	}

	public double getClockSpeed() 
	{
		return clockSpeed;
	}

	public void setClockSpeed(double clockSpeed) 
	{
		this.clockSpeed = clockSpeed;
	}
	
	public double getMargin()
	{
		return
				1 
				+ 
				(
					(getType().equalsIgnoreCase("I9") || getType().equalsIgnoreCase("I7")) 
					?
						Taxes.SALESTAXES + MINPRICECPU 
					: 
						Taxes.SALESTAXES
				)
				+ 
					(cores > CPUMINSIZE ? Taxes.SALESTAXES + MINPRICECORE : Taxes.SALESTAXES);  
	}

	@Override
	public double getRating()
	{
		return 0;
	}

	@Override
	public String toXML()
	{
		return
			super.toXML()+
			"<cores>"+cores+"</cores>"+
			"<clockspeed>"+clockSpeed+"</clockspeed>";
	}
	
	@Override
	public HashMap<String,String> toMap()
	{
		HashMap<String,String> rtn = super.toMap();
		
		rtn.put("cores", cores+"");
		rtn.put("clockspeed", clockSpeed+"");
		
		return rtn;
	}

}
