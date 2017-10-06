import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	
	final static String HERE = "[Server2] ";
	
	public static String primiEntro(int n)
	{
		String s = "";
		
		for(int i=3; i<n; i+=2)
		{
		  boolean primo = true;
		  for(int k=3; k < (i/2); k+=2)
		  {
		    if(i%k==0)
		    {
		      primo = false;
		      break;
		    }
		  }
		  if(primo)
			s += i + " ";
		}
		
		return s;
	}

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(6667);
		System.out.println(HERE + "in attesa");
		Socket socket = server.accept();
		DataOutputStream uscita =
				new DataOutputStream(socket.getOutputStream());
		DataInputStream entrata =
				new DataInputStream(socket.getInputStream());

		int n = entrata.readInt();
		
		String res = primiEntro(n);
		System.out.println(HERE + "sysout >> " + res);
		
		uscita.writeUTF(res);
		
		socket.close();		
		server.close();
	}

}
