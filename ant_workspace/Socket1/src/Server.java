import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{

	public static void main(String[] args) throws Exception
	{
		// tutto questo è TCP liscio, niente di niente tranne che stream di bytes
		ServerSocket server = new ServerSocket(6666); // una porta
		System.out.println("Ciao, sono il server e sto aspettando che qualcuno mi chiami");
		Socket socket = server.accept(); // la porta è ancora chiusa; è il collegamento col client
		DataOutputStream uscita =
				new DataOutputStream(socket.getOutputStream()); // preparo il canale di uscita
		DataInputStream entrata =
				new DataInputStream(socket.getInputStream());

		// SIAMO SUL SERVER
		// entrata viene dal cliente
		int n1 = entrata.readInt();
		int n2 = entrata.readInt();
		uscita.writeInt(n1+n2);
		
//		System.out.println("Non è di mio gusto");
//		uscita.writeUTF("SIAMO CHIUSI, RIPASSA\n");
//		System.out.println("Ho risposto male a un tizio, ciao");
		socket.close();		
		server.close();
		
	}
}
