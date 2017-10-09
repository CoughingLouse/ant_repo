package twoPlayers;

import java.net.ServerSocket;
import java.net.Socket;

import gameMultithread.Gestore;

public class ServerTP {
	
	public static void main(String[] args) throws Exception
	{
		ServerSocket server = new ServerSocket(6666);

		while(true)
		{
			Socket g1 = server.accept();
			Socket g2 = server.accept();
			new Gestore(g1,g2).start();
		}
	}

}
