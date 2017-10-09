package gameMultithread;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientMultiGame {
	
	static int CASH = 100;

	public static void main(String[] args) throws Exception
	{
		Scanner kb = new Scanner(System.in);

		Socket socket = new Socket("localhost", 6666);
		System.out.println("Ciao, sono un client");
		DataInputStream in =
				new DataInputStream(socket.getInputStream());
		DataOutputStream out =
				new DataOutputStream(socket.getOutputStream());
		
		System.out.println(in.readUTF()); // ricevo "a cosa vuoi giocare?"
		String action = kb.nextLine().toLowerCase(); // scrivo
		out.writeUTF(action); // invio la mia scelta
		
		// FIXME: non ha senso chiedere la scommessa se ho scelto "quit" ...
		if(!action.equals("quit"))
		{
			System.out.println(in.readUTF()); // mi chiede quanto scommetto
			int bid = Integer.parseInt(kb.nextLine()); // setto la scommessa
			out.writeInt(bid); // invio la scommessa
			
			switch(action)
			{
				case "bj":
					out.writeUTF(action);
					
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
						cmd = kb.nextLine();
	
						out.writeUTF(cmd);
					}
					while(cmd.equalsIgnoreCase("si"));
					
					System.out.println(in.readUTF());
					break;
					
				case "coin":
					out.writeUTF(action);
					System.out.println(in.readUTF()); // Ricevo "Testa o Croce?"
					cmd = kb.nextLine(); // chiedo testa o croce
					out.writeUTF(cmd); // invio
					System.out.println(in.readUTF()); // Ricevo ESITO				
					break;
					
				case "dice":
					out.writeUTF(action);
					System.out.println(in.readUTF()); // Ricevo ESITO (scarno)
					break;
					
				default:
					System.out.println("Invalid action");
			}
		}
		
		// TODO: implementare CICLO
		socket.close();
		in.close();
		out.close();
	}
}

