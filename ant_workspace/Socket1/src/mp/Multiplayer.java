package mp;

import java.net.ServerSocket;
import java.net.Socket;

public class Multiplayer {
	
	final static int MAXPLAYERS = 3;
	
	public static synchronized void collegati(ServerSocket server, Banco banco) throws Exception
	{
		Socket player = server.accept();
		Gestore g = new Gestore(player, banco);
		banco.players.add(g);
	}
	
	public static void main(String[] args) throws Exception
	{
		ServerSocket server = new ServerSocket(6666);
		Banco banco = new Banco();

		while(true) // per non far spegnere il server
		{
			while(banco.players.size()<MAXPLAYERS) // per ripetere fino a TOT giocatori
				collegati(server, banco);
			
			banco.avvia();
		}
	}

}
