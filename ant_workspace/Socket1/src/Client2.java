import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

	public static void main(String[] args) throws Exception {
		
		Socket socket = new Socket("localhost", 6667);
		System.out.println("[Client2] Ready");
		DataInputStream in =
				new DataInputStream(socket.getInputStream());
		DataOutputStream out =
				new DataOutputStream(socket.getOutputStream());
		
		// user input
		Scanner kb = new Scanner(System.in);
		System.out.println("[Client2] Numero: ");
		int n = kb.nextInt();
		
		out.writeInt(n);
		in.readUTF();
		
		socket.close();
	}

}
