package couples;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerCouples
{
	final static String HERE = "[GameServer] ";
	
	static String stampa(List<Carta> giocatore)
	{
		String ris="";
		for(Carta c:giocatore)
			ris += c.valore + c.seme + " ";
		return ris;
	}
	
	static int valore(List<Carta> carte)
	{
		int ris = 0;
		for(Carta c:carte)
			ris += c.getValore();
		return ris;
	}
	
	static boolean check(List<Carta> carte)
	{
		for(int i=0; i<carte.size()-1; i++)
			for(int k=i+1; k<carte.size(); k++)
				if(carte.get(i) == carte.get(k))
					return true;
		
		return false;			
	}
	
	public static void main(String[] args) throws Exception
	{
		ServerSocket server = new ServerSocket(8888);
		System.out.println(HERE + "Giochiamo a Couples!");
		Socket socket = server.accept();
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		DataInputStream in = new DataInputStream(socket.getInputStream());

		Mazzo m = new Mazzo();
		List<Carta> player = new ArrayList<Carta>();
		List<Carta> cpu = new ArrayList<Carta>();
		
		// doppia estrazione è il minimo per vedere chi vince
		player.add(m.estrai());
		cpu.add(m.estrai());
		player.add(m.estrai());
		cpu.add(m.estrai());
		
		boolean quit = false;
		int esito = 0;
		String ris = "";
		
		do
		{			
			esito = (check(player) && check(cpu)) ? 3 : check(player) ? 2 : check(cpu) ? 1 : 0;
			
			switch(esito)
			{
				case 3:
					ris = "PAREGGIO";
					quit = true;
					break;
				case 2:
					ris = "GIOCATORE VINCE";
					quit = true;
					break;
				case 1:
					ris = "CPU VINCE";
					quit = true;
				case 0:
					player.add(m.estrai());
					cpu.add(m.estrai());
					break;
			}
		}
		while(!quit);
		
		out.writeUTF(ris);


		socket.close();		
		server.close();		
	}
}
