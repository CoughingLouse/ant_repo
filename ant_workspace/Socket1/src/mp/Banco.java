package mp;

import java.util.ArrayList;
import java.util.List;

public class Banco
{
	List<Gestore> players = new ArrayList<Gestore>();
	Mazzo mazzo = new Mazzo();
	int finiti = 0;

	public void avvia()
	{
		for(Gestore g:players)
		{
			g.start();
		}

		while(true){} // risolve l'IllegalThreadStateException
	}
	
	public synchronized void finito()
	{
		finiti++;
		System.out.println(finiti + " " + players.size());
		System.out.println(finiti == players.size());
		if(finiti == players.size())
			System.out.println("HANNO FINITO TUTTI VINCE YARI");
	}

}
