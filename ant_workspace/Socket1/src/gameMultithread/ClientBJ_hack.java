package gameMultithread;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientBJ_hack {

	public static void main(String[] args) throws Exception
	{
		Scanner kb = new Scanner(System.in);
		Socket socket = null;
		
		while(true)
		{
			socket = new Socket("10.10.20.124", 6666);
			System.out.println("Ciao, sono un client");
			DataInputStream in =
					new DataInputStream(socket.getInputStream());
			DataOutputStream out =
					new DataOutputStream(socket.getOutputStream());
			
			String cmd = "si";
			int punteggio = 0;
			do
			{
				punteggio = in.readInt();
				if(punteggio>21)
				{
					System.out.println(in.readUTF());
					break;
				}
				System.out.println(in.readUTF());
//				cmd = kb.nextLine();
				cmd = "si";
				out.writeUTF(cmd);
			}
			while(cmd.equalsIgnoreCase("si"));
			
			System.out.println(in.readUTF());
			
			socket.close();
			in.close();
			out.close();
		}
	}

}
