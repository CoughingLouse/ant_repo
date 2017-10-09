package twoPlayers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GestoreTP extends Thread
{
	Socket g1 = null;
	Socket g2 = null;
	
	public GestoreTP(Socket g1, Socket g2)
	{
		this.g1 = g1;
		this.g2 = g2;
	}
	
	public void run()
	{
		try
		{
			DataOutputStream out =
					new DataOutputStream(socket.getOutputStream());
			DataInputStream in =
					new DataInputStream(socket.getInputStream());

			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
