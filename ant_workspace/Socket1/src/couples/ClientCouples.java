package couples;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientCouples {

	public static void main(String[] args) throws Exception
	{
		Scanner kb = new Scanner(System.in);
		Socket socket = new Socket("localhost", 8888);
		System.out.println("Ciao, sono un client");
		DataInputStream in = new DataInputStream(socket.getInputStream());
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		
		
		
//		System.out.println(in.readUTF());
		
		socket.close();
		in.close();
		out.close();
	}

}
