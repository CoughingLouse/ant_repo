package entities;

import java.util.ArrayList;
import java.util.List;

public class Negozio {
	
	public List<PC> pcs = new ArrayList<PC>();
	
	public Negozio(){}
	
	public Negozio addPC(PC pc)
	{
		pcs.add(pc);
		return this;
	}
	
	

}
