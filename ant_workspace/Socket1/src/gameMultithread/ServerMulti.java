package gameMultithread;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerMulti {
	
	public static void main(String[] args) throws Exception
	{
		ServerSocket server = new ServerSocket(6666);
		
		// pcYari on 10.10.20.124
		int numero = 0;
		while(true)
		{
			numero++;
			Socket client = server.accept();
			new Gestore(client,numero).start();
			System.out.println(numero);
		}
	}

}
