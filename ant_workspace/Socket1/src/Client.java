import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("localhost", 6666);
		System.out.println("Ciao, sono un client");
		DataInputStream in =
				new DataInputStream(s.getInputStream());
		DataOutputStream out =
				new DataOutputStream(s.getOutputStream());
		
		out.writeInt(7);
		out.writeInt(15);
		int res = in.readInt();
		System.out.println("sysout >> Risultato della somma = " + res);
		
		s.close();
	}

}
