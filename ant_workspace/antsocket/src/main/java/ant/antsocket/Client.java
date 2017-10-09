package ant.antsocket;

import java.net.Socket;

import java.io.DataOutputStream;
import java.io.DataInputStream;

import java.util.Scanner;
public class Client {

	
	public static void main(String[] args) throws Exception
	{
		Scanner tastiera = new Scanner(System.in);
		Socket s = new Socket("localhost", 6666);
		DataOutputStream o = new DataOutputStream(s.getOutputStream());
		DataInputStream dalui = new DataInputStream(s.getInputStream());
    	
		System.out.println("Mi sono connesso e ho lo stream. Scrivi un messaggio");
		String messaggio ="";
		
		while(!messaggio.equals("QUIT"))
		{
			messaggio = tastiera.nextLine();
			o.writeUTF(messaggio);
			System.out.println(dalui.readUTF());
		}
		
		
	}

}
