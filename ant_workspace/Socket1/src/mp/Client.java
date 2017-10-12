package mp;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception
	{
		Scanner kb = new Scanner(System.in);
//		Socket socket = new Socket("10.10.20.120", 6666);
		Socket socket = new Socket("localhost", 6666);
		System.out.println("Ciao, sono un client");
		DataInputStream in = new DataInputStream(socket.getInputStream());
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		

		System.out.println(in.readUTF()); // richiesta nickname
		String nickname = kb.nextLine();
		out.writeUTF(nickname); // invio nickname
		System.out.println(in.readUTF()); // ricevo mano
		
		String continua = "si";
		int sommamano = 0;
		do
		{
			System.out.println(in.readUTF()); // ricevo la proposta di continuare
			continua = kb.nextLine().toLowerCase();
			out.writeUTF(continua); // invio si/no
			System.out.println(in.readUTF()); // ricevo l'esito (messaggi composto)
			sommamano = in.readInt(); // ricevo punteggio
		}
		while(continua.equals("si") && sommamano<21);

		
//		socket.close();
//		in.close();
//		out.close();
	}

}
