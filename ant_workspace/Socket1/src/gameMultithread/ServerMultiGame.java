package gameMultithread;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMultiGame {
	
	public static void main(String[] args) throws Exception
	{
		ServerSocket server = new ServerSocket(6666);
		
		int numero = 0;
		Cassa c = new Cassa();
		
		while(true)
		{
			numero++;
			Socket client = server.accept();
			new GestoreMultiGame(client,numero,c).start();
//			System.out.println(numero);
			System.out.println("Cassa: " + c.getMoney());
		}
	}

}
