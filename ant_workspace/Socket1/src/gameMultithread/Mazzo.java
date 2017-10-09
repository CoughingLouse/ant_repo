package gameMultithread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mazzo {

	final int NUMEROCARTE = 52;
	List<Carta> mazzo = new ArrayList<Carta>();
	Random rand = new Random();
	
//	Mazzo m;
//	public Mazzo getInstance()
//	{
//		if(m == null)
//			return new Mazzo();
//		else
//			return m;	
//	}
//	private Mazzo()
	public Mazzo()
	{
		String valori[] = "1,2,3,4,5,6,7,8,9,10,J,Q,K".split(",");
		String semi[] = "C,Q,F,P".split(",");
		
		for(String seme:semi)
			for(String valore:valori)
				mazzo.add(new Carta(valore, seme));
	}
	
	public Carta estrai()
	{
//		int i = rand.nextInt(NUMEROCARTE);
		int i = (int)(Math.random()*mazzo.size());
		Carta c = mazzo.get(i);
		mazzo.remove(i);
		return c;
	}
}
