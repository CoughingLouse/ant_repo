import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientNegozio {

	final static String HERE = "[ClientNegozio] ";
	
	public static void main(String[] args) throws Exception
	{
		Scanner kb = new Scanner(System.in);
		Socket socket = new Socket("localhost", 7777);
		DataInputStream in =
				new DataInputStream(socket.getInputStream());
		DataOutputStream out =
				new DataOutputStream(socket.getOutputStream());
		
		String cmd = "";
		do
		{
			System.out.println(HERE + in.readUTF());
			cmd = kb.nextLine();
			out.writeUTF(cmd);
			String req = in.readUTF();
			
			if(req.equals("qualemarca"))
			{
				System.out.println(HERE + "Inserire marca: ");
				cmd = kb.next();
				out.writeUTF(cmd);
				
			}
			else
				System.out.println(req);
				
		}
		while(!cmd.equals("esci"));
		
		
		socket.close();
		in.close();
		out.close();
	}
}
